package model.xml;

import model.tree.Tree;

import java.io.Closeable;

public interface XmlTreeWriter<E> {
    Tree<E> write(Tree<E> tree, String file, Class eClass);
}
