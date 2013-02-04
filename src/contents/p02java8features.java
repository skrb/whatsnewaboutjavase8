package contents;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Direction;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p02java8features implements PageFactory {

    @Override
    public Page create() {
        Page page = new Page("resources/p02java8features.svg");

        page.setPreEnteringAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
            }
        });

        page.setPostEnteringAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000).play();
            }
        });

        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                for (int i = 0; i < 4; i++) {
                    Node node = page.getNode();
                    page.getChildren().add(node);
                    NodeTransitions.fadeIn(node, 1000).play();
                }
            }
        });

        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode(page.getNodeIndex() - 4);
                DropShadow shadow = new DropShadow(0, Color.web("#f8981d")); 
                node.setEffect(shadow);
                
                new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(shadow.radiusProperty(), 0), 
                                                    new KeyValue(shadow.spreadProperty(), 0)),
                        new KeyFrame(new Duration(1000), new KeyValue(shadow.radiusProperty(), 20),
                                                         new KeyValue(shadow.spreadProperty(), 0.7))
                ).play();
            }
        });

        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node prev = page.getNode(page.getNodeIndex() - 4);
                DropShadow prevShadow = (DropShadow)prev.getEffect();
                
                Node node = page.getNode(page.getNodeIndex() - 3);
                DropShadow shadow = new DropShadow(0, Color.web("#f8981d")); 
                node.setEffect(shadow);
                
                new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(shadow.radiusProperty(), 0), 
                                                    new KeyValue(shadow.spreadProperty(), 0),
                                                    new KeyValue(prevShadow.radiusProperty(), 20), 
                                                    new KeyValue(prevShadow.spreadProperty(), 0.7)),
                        new KeyFrame(new Duration(1000), new KeyValue(shadow.radiusProperty(), 20),
                                                         new KeyValue(shadow.spreadProperty(), 0.7),
                                                         new KeyValue(prevShadow.radiusProperty(), 0), 
                                                         new KeyValue(prevShadow.spreadProperty(), 0))
                ).play();
            }
        });

        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node prev = page.getNode(page.getNodeIndex() - 3);
                DropShadow prevShadow = (DropShadow)prev.getEffect();
                
                Node node = page.getNode(page.getNodeIndex() - 2);
                DropShadow shadow = new DropShadow(0, Color.web("#f8981d")); 
                node.setEffect(shadow);
                
                new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(shadow.radiusProperty(), 0), 
                                                    new KeyValue(shadow.spreadProperty(), 0),
                                                    new KeyValue(prevShadow.radiusProperty(), 20), 
                                                    new KeyValue(prevShadow.spreadProperty(), 0.7)),
                        new KeyFrame(new Duration(1000), new KeyValue(shadow.radiusProperty(), 20),
                                                         new KeyValue(shadow.spreadProperty(), 0.7),
                                                         new KeyValue(prevShadow.radiusProperty(), 0), 
                                                         new KeyValue(prevShadow.spreadProperty(), 0))
                ).play();
            }
        });

        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                for (int i = 1; i <= 4; i++) {
                    Node prev = page.getNode(page.getNodeIndex() - i);
                    NodeTransitions.fade(prev, 1000).play();
                }
                
                Node node = page.getNode();
                page.getChildren().add(node);
                new SequentialTransition(
                    new PauseTransition(Duration.millis(500)),
                    NodeTransitions.slideIn(node, 1000, Direction.BOTTOM)
                ).play();
            }
        });

        return page;
    }
}
