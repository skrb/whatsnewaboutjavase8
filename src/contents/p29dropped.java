package contents;

import javafx.scene.Node;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Direction;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p29dropped implements PageFactory {
    @Override
    public Page create() {             
        Page page = new Page("resources/p29dropped.svg");
        
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
            }
        });

        // p02-p04
        for (int i = 2; i <= 4; i++) {
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.slideIn(node, 1000, Direction.RIGHT).play();
            }
        });
        }

        // p05
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
