package contents;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Constants;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p18basic implements PageFactory {
    Node duke;
    Rotate rotate;

    @Override
    public Page create() {
        Page page = new Page("resources/p18basic.svg");

        page.setPreEnteringAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                
                Constants constants = Constants.getInstance();
                page.setClip(new Rectangle(0, 0, constants.getWidth(), constants.getHeight()));
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

        // p03, p04
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                duke = page.getNode();
                page.getChildren().add(duke);
                
                Rectangle center = (Rectangle)page.getNode();
                double x = center.getX();
                double y = center.getY();
                rotate = new Rotate(-90, x, y);
                duke.getTransforms().add(rotate);
                
                new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), -90)),
                    new KeyFrame(new Duration(600), new KeyValue(rotate.angleProperty(), 0))
                ).play();
            }
        });

        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), 0)),
                    new KeyFrame(new Duration(1_000), new KeyValue(rotate.angleProperty(), 120))
                ).play();
            }
        });

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