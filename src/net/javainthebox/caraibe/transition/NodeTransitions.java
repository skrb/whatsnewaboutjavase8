package net.javainthebox.caraibe.transition;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;
import net.javainthebox.caraibe.Constants;
import net.javainthebox.caraibe.Direction;

public class NodeTransitions {

    public static Animation fadeIn(Node node, long duration) {
        return fadeIn(node, duration, 1.0, 0);
    }

    public static Animation fadeIn(Node node, long duration, double toValue) {
        return fadeIn(node, duration, toValue, 0);
    }

    public static Animation fadeIn(Node node, long duration, double toValue, long delay) {
        node.setOpacity(0.0);

        FadeTransition fadein = new FadeTransition(new Duration(duration), node);
        fadein.setFromValue(0.0);
        fadein.setToValue(toValue);

        Animation animation = fadein;
        if (delay > 0) {
            animation = new SequentialTransition(
                    new PauseTransition(new Duration(delay)),
                    fadein);
        }

        return animation;
    }

    public static Animation fade(Node node, long duration) {
        return fade(node, duration, 0.0, 0);
    }

    public static Animation fade(Node node, long duration, double toValue) {
        return fade(node, duration, toValue, 0);
    }

    public static Animation fade(Node node, long duration, double toValue, long delay) {
        FadeTransition fadein = new FadeTransition(new Duration(duration), node);
        fadein.setToValue(toValue);

        Animation animation = fadein;
        if (delay > 0) {
            animation = new SequentialTransition(
                    new PauseTransition(new Duration(delay)),
                    fadein);
        }

        return animation;
    }

    public static Animation slideIn(Node node, long duration) {
        return slideIn(node, duration, Direction.LEFT, 0);
    }

    public static Animation slideIn(Node node, long duration, Direction direction) {
        return slideIn(node, duration, direction, 0);
    }

    public static Animation slideIn(Node node, long duration, Direction direction, long delay) {
        Constants consts = Constants.getInstance();
        double width = consts.getWidth();
        double height = consts.getHeight();

        TranslateTransition slidein = new TranslateTransition(new Duration(duration), node);
        slidein.setToX(0.0);
        slidein.setToY(0.0);

        switch (direction) {
            case LEFT:
                node.setTranslateX(-width);
                break;
            case RIGHT:
                node.setTranslateX(width);
                break;
            case TOP:
                node.setTranslateY(-height);
                break;
            case BOTTOM:
                node.setTranslateY(height);
                break;
        }

        Animation animation = slidein;
        if (delay > 0) {
            animation = new SequentialTransition(
                    new PauseTransition(new Duration(delay)),
                    slidein);
        }

        return animation;
    }

    public static Animation slideOut(Node node, long duration) {
        return slideOut(node, duration, Direction.RIGHT, 0);
    }

    public static Animation slideOut(Node node, long duration, Direction direction) {
        return slideOut(node, duration, direction, 0);
    }

    public static Animation slideOut(Node node, long duration, Direction direction, long delay) {
        Constants consts = Constants.getInstance();
        double width = consts.getWidth();
        double height = consts.getHeight();

        TranslateTransition slideout = new TranslateTransition(new Duration(duration), node);

        switch (direction) {
            case LEFT:
                slideout.setToX(width);
                slideout.setToY(0.0);
                break;
            case RIGHT:
                slideout.setToX(-width);
                slideout.setToY(0.0);
                break;
            case TOP:
                slideout.setToX(0.0);
                slideout.setToY(-height);
                break;
            case BOTTOM:
                slideout.setToX(0.0);
                slideout.setToY(height);
                break;
        }

        Animation animation = slideout;
        if (delay > 0) {
            animation = new SequentialTransition(
                    new PauseTransition(new Duration(delay)),
                    slideout);
        }

        return animation;
    }
    
    public static Animation zoomIn(Node node, long duration) {
        return zoomIn(node, duration, 0.01, 1.0, 0);
    }
    
    public static Animation zoomIn(Node node, long duration, double fromValue) {
        return zoomIn(node, duration, fromValue, 1.0, 0);
    }
    
    public static Animation zoomIn(Node node, long duration, double fromValue, double toValue) {
        return zoomIn(node, duration, fromValue, toValue, 0);
    }
    
    public static Animation zoomIn(Node node, long duration, double fromValue, double toValue, long delay) {
        node.setScaleX(fromValue);
        node.setScaleY(fromValue);
        
        ScaleTransition zoomIn = new ScaleTransition(new Duration(duration), node);
        zoomIn.setToX(toValue);
        zoomIn.setToY(toValue);
        
        Animation animation = zoomIn;
        if (delay > 0) {
            animation = new SequentialTransition(
                    new PauseTransition(new Duration(delay)),
                    zoomIn);
        }

        return animation;
    }

    public static Animation zoomOut(Node node, long duration) {
        return zoomOut(node, duration, 0.01, 0);
    }
    
    public static Animation zoomOut(Node node, long duration, double toValue) {
        return zoomOut(node, duration, toValue, 0);
    }
    
    public static Animation zoomOut(Node node, long duration, double toValue, long delay) {
        ScaleTransition zoomOut = new ScaleTransition(new Duration(duration), node);
        zoomOut.setToX(toValue);
        zoomOut.setToY(toValue);
        
        Animation animation = zoomOut;
        if (delay > 0) {
            animation = new SequentialTransition(
                new PauseTransition(new Duration(delay)),
                zoomOut);
        }

        return animation;
    }
}
