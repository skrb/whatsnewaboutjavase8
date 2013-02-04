package contents;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.util.Duration;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Direction;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p21howtowrite implements PageFactory {
    @Override
    public Page create() {
        Page page = new Page("resources/p21howtowrite.svg");

        // p00
        page.setPreEnteringAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
            }
        });

        // p01
        page.setPostEnteringAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000L).play();
            }
        });

        // p01
        Action action = new Action() {
            @Override
            public void action(final Page page) {
                Node prev = page.getNode(page.getNodeIndex() - 1);
                new SequentialTransition(
                    new PauseTransition(new Duration(500)),
                    NodeTransitions.fade(prev, 1000L)).play();
                    
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000L).play();
            }
        };
        page.addAction(action);

        // p02
        action = new Action() {
            @Override
            public void action(final Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000L, 1.0, 500L).play();
            }
        };
        page.addAction(action);

        // p03
        action = new Action() {
            @Override
            public void action(final Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000L, 1.0, 500L).play();
            }
        };
        page.addAction(action);

        // p04
        action = new Action() {
            @Override
            public void action(final Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000L).play();
            }
        };
        page.addAction(action);

        // p05, p06
        page.addAction(new Action() {
            @Override
            public void action(final Page page) {
                for (int i = 1; i <= 4; i++) {
                    Node prev = page.getNode(page.getNodeIndex() - i);
                    NodeTransitions.slideOut(prev, 1000L, Direction.BOTTOM).play();
                }
                
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.slideIn(node, 1000L, Direction.TOP).play();

                node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.slideIn(node, 1000L, Direction.TOP).play();
            }
        });

        // p07, p08
        page.addAction(new Action() {
            @Override
            public void action(final Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.slideIn(node, 1000L, Direction.BOTTOM).play();

                node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.slideIn(node, 1000L, Direction.BOTTOM).play();
            }
        });

        // p09
        page.addAction(new Action() {
            @Override
            public void action(final Page page) {
                Node prev = page.getNode(page.getNodeIndex() - 1);
                new SequentialTransition(
                    new PauseTransition(new Duration(800)),
                    NodeTransitions.fade(prev, 200L)).play();

                prev = page.getNode(page.getNodeIndex() - 3);
                new SequentialTransition(
                    new PauseTransition(new Duration(800)),
                    NodeTransitions.fade(prev, 200L)).play();
                
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000L).play();
            }
        });

        return page;
    }
}
