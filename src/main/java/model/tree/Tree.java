package model.tree;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tree")
public class Tree<E> {
    @XmlElement
    private TreeNode<E> root;

    private transient TreeNode<E> current;

    public boolean add(E element){
        if (null==root){
            root = new TreeNode<>(element,null);
            current=root;
        } else {
            current.add(element);
        }
        return true;
    }
    public Tree<E> next(int index){
        current=current.next(index);
        return this;
    }
    Tree<E> prev(){
        if (null!=current.prev()){
            current=current.prev();
            return this;
        }
        System.out.println("prev is null, you'll get first node");
        return this;
    }

    public Tree<E> getRoot() {
        current=root;
        return this;
    }

    @Override
    public String toString() {
        TreeNode.resetStr();
        return root.toString();
    }

    public void restoreParents() {
        current=root;
        root.restoreParents(null);
    }
}
