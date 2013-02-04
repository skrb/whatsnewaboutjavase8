package contents;

import net.javainthebox.caraibe.pagetransition.*;
import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import net.javainthebox.caraibe.Constants;
import net.javainthebox.caraibe.Page;

public class SpiralPageTransition implements PageTransition {
    private SVGPath nextPath = new SVGPath();
    private SVGPath presentPath = new SVGPath();

    public SpiralPageTransition() {
        nextPath.setContent("M1175,1035c-267,21-698.51-211.686-829.378-363.564"
                        + "C240.929,549.934,256.65,368.95,376.057,261.871"
                        + "C434,209.909,529.231,196.091,566,248"
                        + "c34,48,11.779,109.402-54,136");
        presentPath.setContent("M512,384C428,746-4,984-350,1006");
    }
    
    public Shape getNextPath() {
        return nextPath;
    }

    public Shape getPresentPath() {
        return presentPath;
    }
    
    @Override
    public Animation getAnimation(Page presentPage, Page nextPage) {
        Constants consts = Constants.getInstance();
        double width = consts.getWidth();
        double height = consts.getHeight();

        nextPage.setTranslateX(width);
        nextPage.setTranslateY(height * 0.7);
        nextPage.setScaleX(0.2);
        nextPage.setScaleY(0.2);

        ParallelTransition transition = new ParallelTransition();

        PathTransition nextTranslate = new PathTransition(new Duration(2000), nextPath);
        nextTranslate.setNode(nextPage);
        transition.getChildren().add(nextTranslate);

        ScaleTransition nextScale = new ScaleTransition(new Duration(2000));
        nextScale.setNode(nextPage);
        nextScale.setFromX(0.2);
        nextScale.setFromY(0.2);
        nextScale.setToX(1);
        nextScale.setToY(1);
        transition.getChildren().add(nextScale);
        
        PathTransition presentTranslate = new PathTransition(new Duration(2000), presentPath);
        presentTranslate.setNode(presentPage);
        transition.getChildren().add(presentTranslate);

        ScaleTransition presentScale = new ScaleTransition(new Duration(2000));
        presentScale.setNode(presentPage);
        presentScale.setFromX(1);
        presentScale.setFromY(1);
        presentScale.setToX(0.2);
        presentScale.setToY(0.2);
        transition.getChildren().add(presentScale);

        return transition;
    }
}
