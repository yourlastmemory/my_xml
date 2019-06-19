package main.command;

import model.tree.Tree;

public class WriteCommand<E> implements Command<E> {
    private XmlParser<E> parser;

    public WriteCommand(XmlParser<E> parser) {
        this.parser = parser;
    }

    @Override
    public Tree<E> execute() {
        return new Tree<>();
    }
}
