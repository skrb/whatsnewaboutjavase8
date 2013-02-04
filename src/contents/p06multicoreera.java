package contents;

import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p06multicoreera implements PageFactory {
    @Override
    public Page create() {
        Page page = new Page("resources/p06multicoreera.svg");

        page.setPageTransition(new SpiralPageTransition());
        
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

        // p02
        page.addAction(new Action() {
            @Override
            public void action(final Page page) {
                Node prev = page.getNode(page.getNodeIndex() - 1);

                Node node = page.getNode();
                page.getChildren().add(node);
                new SequentialTransition (
                    NodeTransitions.fade(prev, 500L),
                    NodeTransitions.fadeIn(node, 1000L)
                ).play();
            }
        });

        // p03
        page.addAction(new Action() {
            @Override
            public void action(final Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000L).play();
            }
        });

        // p04
        page.addAction(new Action() {
            @Override
            public void action(final Page page) {
                Node prev = page.getNode(page.getNodeIndex() - 2);
                NodeTransitions.fade(prev, 500L).play();
                
                prev = page.getNode(page.getNodeIndex() - 1);

                Node node = page.getNode();
                page.getChildren().add(node);
                new SequentialTransition (
                    NodeTransitions.fade(prev, 500L),
                    NodeTransitions.fadeIn(node, 1000L)
                ).play();
            }
        });

        // p05
        page.addAction(new Action() {
            @Override
            public void action(final Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000L).play();
            }
        });

        return page;
    }
}
