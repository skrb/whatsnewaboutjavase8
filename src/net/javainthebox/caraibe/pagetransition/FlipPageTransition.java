package net.javainthebox.caraibe.pagetransition;

import javafx.animation.*;
import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import net.javainthebox.caraibe.Constants;
import net.javainthebox.caraibe.Page;

public class FlipPageTransition implements PageTransition {
    @Override
    public Animation getAnimation(Page presentPage, Page nextPage) {
        Constants consts = Constants.getInstance();
        double height = consts.getHeight();
                
        Rotate transform1 = new Rotate(0.0, 0.0, height/2.0, 0.0, new Point3D(1.0, 0.0, 0.0));
        presentPage.getTransforms().add(transform1);
        
        Timeline rotate1 = new Timeline(
            new KeyFrame(new Duration(1000L), new KeyValue(transform1.angleProperty(), -90.0))
        );

        Rotate transform2 = new Rotate(90, 0.0, height/2.0, 0.0, new Point3D(1.0, 0.0, 0.0));
        nextPage.getTransforms().add(transform2);
        
        Timeline rotate2 = new Timeline(
            new KeyFrame(new Duration(1000L), new KeyValue(transform2.angleProperty(), 0.0))
        );
        
        ParallelTransition parallel = new ParallelTransition(
            rotate1, 
            new SequentialTransition(new PauseTransition(new Duration(1000L)), rotate2)
        );
        
        return parallel;
    }
}
