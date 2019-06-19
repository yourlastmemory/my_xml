package model.tree;


import javax.xml.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@XmlType(name = "node")
@XmlAccessorType(XmlAccessType.FIELD)
public class TreeNode<E> {

    @XmlElement
    private E element;

    @XmlElementWrapper(name = "nodes")
    @XmlElement(name = "node_value")
    private List<TreeNode<E>> nodeList = new LinkedList<>();

    private static transient String str="";

    private transient TreeNode<E> parent;


    public TreeNode(E element, TreeNode<E> parent) {
        this.element=element;
        this.parent = parent;
    }
    public TreeNode(){}

    TreeNode<E> prev(){
        return parent;
    }

    TreeNode<E> next(int index){
        return nodeList.get(index);
    }
    boolean add(E element){
        return nodeList.add(new TreeNode<>(element,this));
    }

    @Override
    public String toString() {
        return "element=" + element.toString() +
                "\nnodesCount="+nodeList.size()+'\n';
    }

    public String totalStr(){
        str+= "\nelement=" + element.toString() +
                "\nnodeCount=" + nodeList.size() +
                '\n';
        nodeList.forEach((x)->str+=x.toString());
        return str;
    }
    static void resetStr(){
        str="";
    }

    public void restoreParents(TreeNode<E> parent) {
        this.parent=parent;
        nodeList.forEach(x->x.restoreParents(this));
    }
}
