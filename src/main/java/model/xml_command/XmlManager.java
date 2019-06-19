package model.xml_command;

import model.tree.Tree;
import model.xml.JaxbTreeReader;
import model.xml.JaxbTreeWriter;

public class XmlManager<E> {
    private JaxbTreeReader<E> reader;
    private JaxbTreeWriter<E> writer;

    public XmlManager(JaxbTreeReader<E> reader, JaxbTreeWriter<E> writer) {
        this.reader = reader;
        this.writer = writer;
    }


    public Tree<E> read(Tree<E> tree, String file, Class eClass){
        return reader.execute(tree, file, eClass);
    }
    public Tree<E> write(Tree<E> tree, String file, Class eClass){
        return writer.execute(tree, file, eClass);
    }
}
