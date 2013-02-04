package contents;

import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.pagetransition.FlipPageTransition;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p10lambda implements PageFactory {

    @Override
    public Page create() {          
        Page page = new Page("resources/p10lambda.svg");
        
        page.setPageTransition(new FlipPageTransition());
        
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

        // p02
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
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

        // p04,  p02,p03を消す
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node prev = page.getNode(page.getNodeIndex() - 1);
                NodeTransitions.fade(prev, 500).play();

                prev = page.getNode(page.getNodeIndex() - 2);
                
                Node node = page.getNode();
                page.getChildren().add(node);
                new SequentialTransition(
                    NodeTransitions.fade(prev, 500),
                    NodeTransitions.fadeIn(node, 1000)
                ).play();
            }
        });

        // p05-09
        for (int i = 5; i <= 9; i++) {
            page.addAction(new Action() {
                @Override
                public void action(Page page) {
                    Node node = page.getNode();
                    page.getChildren().add(node);
                    NodeTransitions.fadeIn(node, 200).play();
                }
            });
        }

        return page;
    }
}
