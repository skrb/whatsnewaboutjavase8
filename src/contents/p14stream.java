package contents;

import javafx.scene.Node;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Direction;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.pagetransition.FlipPageTransition;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p14stream implements PageFactory {

    @Override
    public Page create() {
        Page page = new Page("resources/p14stream.svg");
        
        page.setPageTransition(new FlipPageTransition());

        // p00
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
                NodeTransitions.slideIn(node, 1000, Direction.LEFT).play();
            }
        });

        // p04
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000).play();
            }
        });

        // p05
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 200).play();
            }
        });

        // p06
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node prev = page.getNode(page.getNodeIndex() - 1);
                NodeTransitions.fade(prev, 200).play();

                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 200).play();
            }
        });

        // p07
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 200).play();
            }
        });

        // p08
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 200).play();
            }
        });

        // p09
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 200).play();
            }
        });

        return page;
    }
}
