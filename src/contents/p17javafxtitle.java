package contents;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.util.Duration;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p17javafxtitle implements PageFactory {
    @Override
    public Page create() {
        Page page = new Page("resources/p17javafxtitle.svg");

        page.setPreEnteringAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
            }
        });

        page.setPostEnteringAction(new Action() {
            @Override
            public void action(final Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000).play();
            }
        });

        page.addAction(new Action() {
            @Override
            public void action(final Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.slideIn(node, 1_000).play();

                node = page.getNode();
                page.getChildren().add(node);
                new SequentialTransition(
                    new PauseTransition(new Duration(500)),
                    NodeTransitions.slideIn(node, 1_000)).play();
            }
        });

        return page;
    }
}
