package contents;

import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.pagetransition.FlipPageTransition;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p28compactprofile implements PageFactory {
    @Override
    public Page create() {
        Page page = new Page("resources/p28compactprofile.svg");
        
        page.setPageTransition(new FlipPageTransition());
        
        // p00, p01, p02
        page.setPreEnteringAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                node = page.getNode();
                page.getChildren().add(node);
                node = page.getNode();
                page.getChildren().add(node);
            }
        });

        // p03
        page.setPostEnteringAction(new Action() {
            @Override
            public void action(Page page) {
                Node prev = page.getNode(page.getNodeIndex() - 1);
                NodeTransitions.fade(prev, 100);
                
                Node node = page.getNode();
                page.getChildren().add(node);
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
                NodeTransitions.zoomIn(node, 1000).play();
            }
        });

        // p06
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node prev = page.getNode(page.getNodeIndex() - 2);
                NodeTransitions.fade(prev, 500).play();

                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000).play();
            }
        });

        // p07
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node prev = page.getNode(page.getNodeIndex() - 2);
                NodeTransitions.fade(prev, 500).play();
                
                prev = page.getNode(page.getNodeIndex() - 1);

                Node node = page.getNode();
                page.getChildren().add(node);
                new SequentialTransition(NodeTransitions.fade(prev, 500),
                                         NodeTransitions.fadeIn(node, 1000)).play();
            }
        });

        // p08
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
