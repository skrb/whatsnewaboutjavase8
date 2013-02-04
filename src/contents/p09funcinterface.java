package contents;

import java.io.File;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.scene.media.AudioClip;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p09funcinterface implements PageFactory {

    @Override
    public Page create() {
        Page page = new Page("resources/p09funcinterface.svg");
        
        page.setPageTransition(new SpiralPageTransition());

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
                Node prev = page.getNode(page.getNodeIndex() - 1);

                Node node = page.getNode();
                page.getChildren().add(node);
                new SequentialTransition(
                    NodeTransitions.fade(prev, 500),
                    NodeTransitions.fadeIn(node, 1000)
                ).play();
            }
        });

        // p04
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 200).play();

                AudioClip clip = new AudioClip(new File("resources/OMT001_05S002.wav").toURI().toString());
                clip.play();
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
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 200).play();

                AudioClip clip = new AudioClip(new File("resources/OMT001_05S014.wav").toURI().toString());
                clip.play();
            }
        });

        return page;
    }
}
