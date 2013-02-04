package contents;

import java.io.File;
import javafx.scene.Node;
import javafx.scene.media.AudioClip;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p05history implements PageFactory {

    @Override
    public Page create() {
        Page page = new Page("resources/p05history.svg");

        page.setPageTransition(new SpiralPageTransition());
        
        page.setPreEnteringAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                node = page.getNode();
                page.getChildren().add(node);
            }
        });

        // p02-p03
        for (int i = 2; i <= 3; i++) {
            page.addAction(new Action() {
                @Override
                public void action(Page page) {
                    Node node = page.getNode();
                    page.getChildren().add(node);
                    NodeTransitions.fadeIn(node, 200).play();
                }
            });
        }

        // p04
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 200).play();
                
                AudioClip clip = new AudioClip(new File("resources/OMT004_01S007.wav").toURI().toString());
                clip.play();
            }
        });

        for (int i = 5; i <= 6; i++) {
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
