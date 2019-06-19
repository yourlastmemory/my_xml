package model.xml_command;

import model.tree.Tree;

public interface Command<E> {
    Tree<E> execute(Tree<E> tree, String file, Class eClass);
}
