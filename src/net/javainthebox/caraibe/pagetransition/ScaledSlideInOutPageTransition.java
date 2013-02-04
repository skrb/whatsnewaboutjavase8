package net.javainthebox.caraibe.pagetransition;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import net.javainthebox.caraibe.Constants;
import net.javainthebox.caraibe.Page;

public class ScaledSlideInOutPageTransition implements PageTransition {
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

        TranslateTransition nextTranslate = new TranslateTransition(new Duration(2000));
        nextTranslate.setNode(nextPage);
        nextTranslate.setFromX(width);
        nextTranslate.setFromY(height * 0.7);
        nextTranslate.setToX(0);
        nextTranslate.setToY(0);
        transition.getChildren().add(nextTranslate);

        ScaleTransition nextScale = new ScaleTransition(new Duration(2000));
        nextScale.setNode(nextPage);
        nextScale.setFromX(0.2);
        nextScale.setFromY(0.2);
        nextScale.setToX(1);
        nextScale.setToY(1);
        transition.getChildren().add(nextScale);

        TranslateTransition presentTranslate = new TranslateTransition(new Duration(2000));
        presentTranslate.setNode(presentPage);
        presentTranslate.setFromX(0);
        presentTranslate.setFromY(0);
        presentTranslate.setToX(-width);
        presentTranslate.setToY(height * 0.7);
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
