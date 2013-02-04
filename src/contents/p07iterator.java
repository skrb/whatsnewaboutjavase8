package contents;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p07iterator implements PageFactory {

    WebView view;

    @Override
    public Page create() {
        Page page = new Page("resources/p07iterator.svg");

        page.setPageTransition(new SpiralPageTransition());

        page.setPreEnteringAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
            }
        });

        // p01, p02
        page.setPostEnteringAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000).play();

                node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000).play();
            }
        });

        // p03
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000).play();
            }
        });

        // p4
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000).play();
            }
        });

        // p5
        page.addAction(new Action() {
            @Override
            public void action(final Page page) {
                Node prev = page.getNode(page.getNodeIndex() - 2);
                TranslateTransition trans = new TranslateTransition(new Duration(1000), prev);
                trans.setToY(400);
                trans.play();
                
                prev = page.getNode(page.getNodeIndex() - 1);
                trans = new TranslateTransition(new Duration(1000), prev);
                trans.setToY(400);
                
                Node node = page.getNode();
                page.getChildren().add(node);
                new SequentialTransition(
                        trans,
                        NodeTransitions.fadeIn(node, 1000)).play();
            }
        });

        // p06
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000).play();
            }
        });

        // p07
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000).play();
            }
        });

        return page;
    }
}
