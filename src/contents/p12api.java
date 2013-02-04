package contents;

import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p12api implements PageFactory {
    Node duke;
    Rotate rotate;

    @Override
    public Page create() {
        Page page = new Page("resources/p12api.svg");

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

        return page;
    }
}