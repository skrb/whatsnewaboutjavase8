package net.javainthebox.caraibe.svg;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.Group;
import javafx.scene.Node;

public class SVGContent extends Group {
    private Map<String, Node> nodes = new HashMap<>();
    private Map<String, Group> groups = new HashMap<>();
    
    void putNode(String id, Node node) {
        nodes.put(id, node);
    }
    
    public Node getNode(String id) {
        return nodes.get(id);
    }
    
    void putGroup(String id, Group group) {
        groups.put(id, group);
    }

    public Group getGroup(String id) {
        return groups.get(id);
    }
}
