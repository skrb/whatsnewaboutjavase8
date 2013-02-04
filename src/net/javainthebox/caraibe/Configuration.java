package net.javainthebox.caraibe;

import net.javainthebox.caraibe.pagetransition.PageTransition;
import net.javainthebox.caraibe.pagetransition.ScaledSlideInOutPageTransition;

public class Configuration {
    public String[] factories;
    public double width = 1024;
    public double height = 768;
    public PageTransition defaultPageTransition = new ScaledSlideInOutPageTransition();
}
