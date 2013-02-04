package contents;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import net.javainthebox.caraibe.Action;
import net.javainthebox.caraibe.Page;
import net.javainthebox.caraibe.PageFactory;
import net.javainthebox.caraibe.transition.NodeTransitions;

public class p01title implements PageFactory {
    MediaPlayer player;
    
    @Override
    public Page create() {
        Page page = new Page("resources/p01title.svg");
        
        page.setPostEnteringAction(new Action() {
            @Override
            public void action(Page page) {
                Node node = page.getNode();
                page.getChildren().add(node);
                NodeTransitions.fadeIn(node, 5000).play();
                
                node = page.getNode();
                page.getChildren().add(node);
                new SequentialTransition(
                    new PauseTransition(new Duration(3000)),
                    NodeTransitions.fadeIn(node, 5000) 
                ).play();
            }
        });

        return page;
    }
}
