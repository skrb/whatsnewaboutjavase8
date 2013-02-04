package net.javainthebox.caraibe.pagetransition;

import javafx.animation.Animation;
import net.javainthebox.caraibe.Page;

public interface PageTransition {
    Animation getAnimation(Page presentPage, Page nextPage);
}
