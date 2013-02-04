package contents;

import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Slider;
import javafx.scene.effect.Reflection;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p22features implements PageFactory {

    WebView view;
    AreaChart<Number, Number> ac;

    @Override
    public Page create() {
        Page page = new Page("resources/p22features.svg");

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

        // p03
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000).play();
            }
        });

        // WebView
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                view = new WebView();
                WebEngine engine = view.getEngine();
                engine.load("http://google.co.jp/");
                view.setPrefSize(550, 540);
                view.setTranslateX(450);
                view.setTranslateY(180);
                page.getChildren().add(view);
                NodeTransitions.fadeIn(view, 1000).play();
            }
        });

        // p4
        page.addAction(new Action() {
            @Override
            public void action(final Page page) {
                Animation animation = NodeTransitions.fade(view, 500);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        page.getChildren().remove(view);
                    }
                });
                animation.play();

                Node node = page.getNode();
                page.getChildren().add(node);
                new SequentialTransition(
                    new PauseTransition(new Duration(500)),
                    NodeTransitions.fadeIn(node, 1000)).play();
            }
        });

        // p05
        page.addAction(new Action() {
            @Override
            public void action(final Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                new SequentialTransition(
                    new PauseTransition(new Duration(500)),
                    NodeTransitions.fadeIn(node, 1000)).play();
            }
        });
        
        // chart
        page.addAction(new Action() {
            @Override
            public void action(final Page page) {
                NumberAxis xAxis = new NumberAxis(1, 31, 1);
                NumberAxis yAxis = new NumberAxis();
                
                ac = new AreaChart<>(xAxis, yAxis);
                ac.setTitle("Temperature Monitoring (in Degrees C)");

                XYChart.Series seriesApril = new XYChart.Series();
                seriesApril.setName("April");
                seriesApril.getData().add(new XYChart.Data(1, 4));
                seriesApril.getData().add(new XYChart.Data(3, 10));
                seriesApril.getData().add(new XYChart.Data(6, 15));
                seriesApril.getData().add(new XYChart.Data(9, 8));
                seriesApril.getData().add(new XYChart.Data(12, 5));
                seriesApril.getData().add(new XYChart.Data(15, 18));
                seriesApril.getData().add(new XYChart.Data(18, 15));
                seriesApril.getData().add(new XYChart.Data(21, 13));
                seriesApril.getData().add(new XYChart.Data(24, 19));
                seriesApril.getData().add(new XYChart.Data(27, 21));
                seriesApril.getData().add(new XYChart.Data(30, 21));

                XYChart.Series seriesMay = new XYChart.Series();
                seriesMay.setName("May");
                seriesMay.getData().add(new XYChart.Data(1, 20));
                seriesMay.getData().add(new XYChart.Data(3, 15));
                seriesMay.getData().add(new XYChart.Data(6, 13));
                seriesMay.getData().add(new XYChart.Data(9, 12));
                seriesMay.getData().add(new XYChart.Data(12, 14));
                seriesMay.getData().add(new XYChart.Data(15, 18));
                seriesMay.getData().add(new XYChart.Data(18, 25));
                seriesMay.getData().add(new XYChart.Data(21, 25));
                seriesMay.getData().add(new XYChart.Data(24, 23));
                seriesMay.getData().add(new XYChart.Data(27, 26));
                seriesMay.getData().add(new XYChart.Data(30, 26));

                ac.getData().addAll(seriesApril, seriesMay);
                ac.setPrefSize(400, 300);
                ac.setTranslateX(500);
                ac.setTranslateY(300);

                page.getChildren().add(ac);
                
            }
        });

                
        // p06
        page.addAction(new Action() {
            @Override
            public void action(final Page page) {
                Animation animation = NodeTransitions.fade(ac, 500);
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        page.getChildren().remove(ac);
                    }
                });
                animation.play();

                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000).play();
            }
        });
         
        // p07
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000).play();

                node.setEffect(new Reflection());
            }
        });

        // p08
        page.addAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 1000).play();
                
                Slider slider = new Slider(0, 400, 0);
                slider.setTranslateX(350);
                slider.setTranslateY(700);
                slider.setPrefSize(400, 20);
                node.translateXProperty().bind(slider.valueProperty());
                page.getChildren().add(slider);
                NodeTransitions.fadeIn(slider, 1000).play();
            }
        });

        return page;
    }
}
