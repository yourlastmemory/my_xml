package main.command;

import model.tree.Tree;

public interface Command<E> {
    Tree<E> execute();
}
