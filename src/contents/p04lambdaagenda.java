package contents;

import javafx.scene.Node;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Direction;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p04lambdaagenda implements PageFactory {

    @Override
    public Page create() {
        Page page = new Page("resources/p04lambdaagenda.svg");

        page.setPreEnteringAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);

                node = page.getNode();
                page.getChildren().add(node);
            }
        });

        for (int i = 2; i <= 4; i++) {
            page.addAction(new Action() {
                @Override
                public void action(Page page) {
                    Node node = page.getNode();
                    page.getChildren().add(node);
                    NodeTransitions.fadeIn(node, 1000).play();
                }
            });
        }

        return page;
    }
}
