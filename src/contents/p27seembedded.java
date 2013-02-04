package contents;

import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p27seembedded implements PageFactory {
    @Override
    public Page create() {
        Page page = new Page("resources/p27seembedded.svg");

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

        // p03-p05
        for (int i = 3; i <= 5; i++) {
            page.addAction(new Action() {
                @Override
                public void action(Page page) {
                    Node node = page.getNode();
                    page.getChildren().add(node);
                    NodeTransitions.fadeIn(node, 1000).play();
                }
            });
        }

        // p06
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node prev = page.getNode(page.getNodeIndex() - 1);

                Node node = page.getNode();
                page.getChildren().add(node);
                new SequentialTransition(
                        NodeTransitions.fade(prev, 500),
                        NodeTransitions.fadeIn(node, 1000)).play();
            }
        });

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
