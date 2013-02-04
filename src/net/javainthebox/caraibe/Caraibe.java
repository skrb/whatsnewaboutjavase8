package net.javainthebox.caraibe;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Caraibe extends Application {
    private Stage stage;
    
    @Override
    public void start(Stage stage) {
        configuration();
        
        Constants constants = Constants.getInstance();
        
        this.stage = stage;
        
        Group root = new Group();
        Scene scene = new Scene(root, constants.getWidth(), constants.getHeight());
        scene.setCamera(new PerspectiveCamera());
        scene.setFill(null);
        stage.setScene(scene);
        
        try {
            root.getChildren().add(new Binder(this, constants.getFactories()));
        } catch (IOException ex) {
            root.getChildren().add(new Label("IOError"));
        }

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
    
    private void configuration() {
        Map<String, String> params = getParameters().getNamed();
        String configName = params.get("configuration");
        if (configName == null || configName.isEmpty()) {
            System.err.println("No Configuration Parameter.");
            Logger.getLogger(Caraibe.class.getName()).log(Level.SEVERE, "No Configuration Parameter.");
            Platform.exit();
        }
        try {
            Class configClass = Class.forName(configName);
            Configuration config = (Configuration) configClass.newInstance();
            Constants constants = Constants.getInstance();
            constants.init(config);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            System.err.println("Illegal Configuration Class");
            Logger.getLogger(Caraibe.class.getName()).log(Level.SEVERE, "Illegal Configuration Class", ex);
            Platform.exit();
        }
    }

    public void minimize() {
        stage.setIconified(true);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
