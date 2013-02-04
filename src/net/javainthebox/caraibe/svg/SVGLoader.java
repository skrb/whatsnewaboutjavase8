package net.javainthebox.caraibe.svg;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;

public class SVGLoader {
    public static SVGContent load(String url) {
        SVGContent root = null;

        URL tempUrl = null;
        try {
            tempUrl = new URL(url);
        } catch (MalformedURLException ex) {
            tempUrl = SVGLoader.class.getResource(url);
            if (tempUrl == null) {
                try {
                    tempUrl = new File(url).toURI().toURL();
                } catch (final MalformedURLException ex1) {
                    Logger.getLogger(SVGLoader.class.getName()).log(Level.SEVERE, null, ex1);
                    return root;
                }
            }
        }

        SVGContentBuilder builder = new SVGContentBuilder(tempUrl);
        try {
            root = builder.build();
        } catch (IOException | XMLStreamException ex) {
            Logger.getLogger(SVGLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return root;
    }
}
