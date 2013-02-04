package net.javainthebox.caraibe;

import net.javainthebox.caraibe.pagetransition.PageTransition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.Node;
import net.javainthebox.caraibe.svg.SVGContent;
import net.javainthebox.caraibe.svg.SVGLoader;

public class Page extends Group {
    private Action preEnteringAction;
    private Action postEnteringAction;
    private Action preExitingAction;

    private PageTransition pageTranslator;
    
    private List<Action> actions = new ArrayList<Action>();
    private int actionIndex = 0;
    
    private List<Node> nodes = new ArrayList<Node>();
    private int nodeIndex = 0;
    
    private SVGContent svgContent;
    
    public Page(Node... nodes) {
        
        this.nodes.addAll(Arrays.asList(nodes));
    }

    public Page(String fxdfile) {
        svgContent = SVGLoader.load(fxdfile);
        Formatter formatter = new Formatter();
        for (int index = 0;; index++) {
            Node node = svgContent.getNode(String.format("jfx:p%02d", index));
            formatter.flush();
            if (node != null) {
                nodes.add(node);
            } else {
                break;
            }
        }       
    }

    public void setPreEnteringAction(Action action) {
        if (preEnteringAction == null) {
            preEnteringAction = action;
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    public void setPostEnteringAction(Action action) {
        if (postEnteringAction == null) {
            postEnteringAction = action;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setPreExitingAction(Action action) {
        if (preExitingAction == null) {
            preExitingAction = action;
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    public void setPageTransition(PageTransition pageTranslator) {
        if (this.pageTranslator == null) {
            this.pageTranslator = pageTranslator;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public PageTransition getPageTranslator() {
        return pageTranslator;
    }
    
    public void addAction(Action action) {
        if (actionIndex == 0) {
            actions.add(action);
        }
    }
    
    public void addAllAction(Action... actions) {
        if (actionIndex == 0) {
            this.actions.addAll(Arrays.asList(actions));
        }
    }
    
    public Node getNode() {
        if (nodeIndex < nodes.size()) {
            Node node = nodes.get(nodeIndex);
            nodeIndex++;
            return node;
        } else {
            return null;
        }        
    }
    
    public int getNodeIndex() {
        return nodeIndex;
    }
    
    public Node getNode(int index) {
        return nodes.get(index);
    }
    
    public Node getNode(String nodename) {
        if (svgContent != null) {
            Node node = svgContent.getGroup(nodename);
            if (node ==  null) {
                node =  svgContent.getNode(nodename);
            }
            
            return node;
        } else {
            return null;
        }
    }
    
    public void doPreEnteringAction() {
        if (preEnteringAction != null) {
            preEnteringAction.action(this);
        }
    }

    public void doPostEnteringAction() {
        if (postEnteringAction != null) {
            postEnteringAction.action(this);
        }
    }

    public void doPreExitingAction() {
        if (preExitingAction != null) {
            preExitingAction.action(this);
        }
    }
        
    public boolean action() {
        if (actionIndex >= actions.size()) {
            return false;
        } else {
            actions.get(actionIndex).action(this);
            actionIndex++;
            return true;
        }
    }
}
