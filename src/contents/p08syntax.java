package contents;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p08syntax implements PageFactory {
    Node duke;
    Rotate rotate;

    @Override
    public Page create() {
        Page page = new Page("resources/p08syntax.svg");

        page.setPageTransition(new SpiralPageTransition());

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
                NodeTransitions.fadeIn(node, 1000).play();
            }
        });

        // p02
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node prev = page.getNode(page.getNodeIndex() - 1);
                NodeTransitions.fade(prev, 500).play();
                                
                Node node = page.getNode();
                page.getChildren().add(node);
                new SequentialTransition(
                    new PauseTransition(new Duration(500)),
                    NodeTransitions.fadeIn(node, 1000)).play();
            }
        });

        return page;
    }
}