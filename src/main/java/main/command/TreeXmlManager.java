package main.command;

import model.tree.Tree;

public class TreeXmlManager<E> {
    private Command<E> read;
    private Command<E> write;

    public TreeXmlManager(Command<E> read, Command<E> write) {
        this.read = read;
        this.write = write;
    }
    public Tree<E> readTree(){
        return read.execute();
    }
    public Tree<E> writeTree(){
        return write.execute();
    }
}
