package net.javainthebox.caraibe.pagetransition;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import net.javainthebox.caraibe.Constants;
import net.javainthebox.caraibe.Direction;
import net.javainthebox.caraibe.Page;

public class SlideInOutPageTransition implements PageTransition {
    private Direction direction = Direction.LEFT;

    public SlideInOutPageTransition() {}

    public SlideInOutPageTransition(Direction direction) {
        this.direction = direction;
    }
    
    @Override
    public Animation getAnimation(Page presentPage, Page nextPage) {
        Constants consts = Constants.getInstance();
        double width = consts.getWidth();
        double height = consts.getHeight();

        double fromX = 0.0;
        double fromY = 0.0;
        double toX = 0.0;
        double toY = 0.0;
        
        switch(direction) {
            case LEFT:
                fromX = width;
                toX = -width;
                break;
            case RIGHT:
                fromX = -width;
                toX = width;
                break;
            case TOP:
                fromY = -height;
                toY = height;
                break;
            case BOTTOM:
                fromY = height;
                toY = height;
        }
                
        nextPage.setTranslateX(fromX);
        nextPage.setTranslateY(fromY);

        ParallelTransition transition = new ParallelTransition();

        TranslateTransition nextTranslate = new TranslateTransition(new Duration(2000));
        nextTranslate.setNode(nextPage);
        nextTranslate.setFromX(fromX);
        nextTranslate.setFromY(fromY);
        nextTranslate.setToX(0);
        nextTranslate.setToY(0);
        transition.getChildren().add(nextTranslate);

        TranslateTransition presentTranslate = new TranslateTransition(new Duration(2000));
        presentTranslate.setNode(presentPage);
        presentTranslate.setFromX(0.0);
        presentTranslate.setFromY(0.0);
        presentTranslate.setToX(toX);
        presentTranslate.setToY(toY);
        transition.getChildren().add(presentTranslate);

        return transition;
    }
}
