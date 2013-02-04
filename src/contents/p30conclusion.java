package contents;

import javafx.scene.Node;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Direction;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p30conclusion implements PageFactory {
    @Override
    public Page create() {             
        Page page = new Page("resources/p30conclusion.svg");
        
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
                    NodeTransitions.slideIn(node, 1000, Direction.RIGHT).play();
                }
            });
        }
        
        return page;
    }
}
