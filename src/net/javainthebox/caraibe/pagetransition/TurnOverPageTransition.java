package net.javainthebox.caraibe.pagetransition;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import net.javainthebox.caraibe.Constants;
import net.javainthebox.caraibe.Page;

public class TurnOverPageTransition implements PageTransition {
    @Override
    public Animation getAnimation(Page presentPage, Page nextPage) {
        Constants consts = Constants.getInstance();
        double height = consts.getHeight();
        
        Rotate transform1 = new Rotate(0, 0.0, height, 0.0, new Point3D(1.0, 0.0, 0.0));
        presentPage.getTransforms().add(transform1);
        
        Timeline rotate1 = new Timeline(
            new KeyFrame(new Duration(800L), new KeyValue(transform1.angleProperty(), -120.0, Interpolator.EASE_IN))
        );

        Rotate transform2 = new Rotate(120, 0.0, 0.0, 0.0, new Point3D(1.0, 0.0, 0.0));
        nextPage.getTransforms().add(transform2);
        
        Timeline rotate2 = new Timeline(
            new KeyFrame(new Duration(800L), new KeyValue(transform2.angleProperty(), 0.0, Interpolator.EASE_IN))
        );
        
        ParallelTransition parallel = new ParallelTransition(
            rotate1, 
            new SequentialTransition(new PauseTransition(new Duration(200L)), rotate2)
        );
        
        return parallel;
    }
    
}
