package net.javainthebox.caraibe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import net.javainthebox.caraibe.pagetransition.PageTransition;

class Binder extends Group {
    private Caraibe caraibe;
    private List<PageFactory> factories = new ArrayList<>();
    private int pageIndex = 0;
    private Page presentPage;
    private Page nextPage;
    private boolean inAction = false;
    private ContextMenu menu;

    public Binder(Caraibe caraibe, String[] factorylist) throws IOException {
        this.caraibe = caraibe;
        for (String factoryname : factorylist) {
            factoryname = factoryname.trim();
            if (!factoryname.isEmpty()) {
                try {
                    Class clss = Class.forName(factoryname);
                    PageFactory factory = (PageFactory) clss.newInstance();
                    factories.add(factory);
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }

        initPopupMenu();

        addEventHandler(MouseEvent.MOUSE_RELEASED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (!inAction) {
                            if (event.getButton() == MouseButton.PRIMARY) {
                                boolean result = presentPage.action();
                                if (!result) {
                                    forwardPage();
                                }
                            }
                        }
                    }
                });

        addEventHandler(MouseEvent.MOUSE_RELEASED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (!inAction) {
                            if (event.getButton() == MouseButton.SECONDARY) {
                                menu.show(Binder.this, event.getScreenX(), event.getScreenY());
                            }
                        }
                    }
                });

        loadInitialPage();
    }

    private void loadInitialPage() {
        presentPage = factories.get(pageIndex).create();
        presentPage.setClip(new Rectangle(0, 0, Constants.getInstance().getWidth(), Constants.getInstance().getHeight()));
        getChildren().add(presentPage);
        presentPage.doPreEnteringAction();
        presentPage.doPostEnteringAction();
    }

    private void initPopupMenu() {
        menu = new ContextMenu();
        MenuItem forward = new MenuItem("Forward");
        forward.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                forwardPage();
            }
        });
        menu.getItems().add(forward);

        MenuItem backward = new MenuItem("Backward");
        backward.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                backwardPage();
            }
        });
        menu.getItems().add(backward);

        MenuItem minimize = new MenuItem("Minimize");
        minimize.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                caraibe.minimize();
            }
        });
        menu.getItems().add(minimize);

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Platform.exit();
            }
        });
        menu.getItems().add(exit);
    }

    private void forwardPage() {
        pageIndex++;
        if (pageIndex >= factories.size()) {
            pageIndex = 0;
        }

        nextPage = factories.get(pageIndex).create();
        nextPage.setClip(new Rectangle(0, 0, Constants.getInstance().getWidth(), Constants.getInstance().getHeight()));
        getChildren().add(nextPage);
        
        movePage();
    }

    private void backwardPage() {
        pageIndex--;
        if (pageIndex < 0) {
            pageIndex = factories.size() - 1;
        }

        nextPage = factories.get(pageIndex).create();
        nextPage.setClip(new Rectangle(0, 0, Constants.getInstance().getWidth(), Constants.getInstance().getHeight()));
        getChildren().add(nextPage);

        movePage();
    }
    
    private void movePage() {
        Animation animation;
        PageTransition pageTranslator = nextPage.getPageTranslator();
        if (pageTranslator != null) {
            animation = pageTranslator.getAnimation(presentPage, nextPage);
        } else {
            animation = Constants.getInstance().defaultPageTransition().getAnimation(presentPage, nextPage);
        }

        // 終了時のアクションを追加
        animation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                nextPage.doPostEnteringAction();
                getChildren().remove(presentPage);
                presentPage = nextPage;

                inAction = false;
            }
        });

        // アニメーション開始
        presentPage.doPreExitingAction();
        nextPage.doPreEnteringAction();
        inAction = true;
        animation.play();
    }
}
