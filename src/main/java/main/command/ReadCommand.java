package main.command;

import model.tree.Tree;

public class ReadCommand<E> implements Command {

    private XmlParser<E> parser;

    public ReadCommand(XmlParser<E> parser) {
        this.parser = parser;
    }

    @Override
    public Tree<E> execute() {
        return parser.read();
    }
}
