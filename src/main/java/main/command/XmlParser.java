package main.command;

import model.tree.Tree;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;

public class XmlParser<E> {

    private String file;
    private Tree<E> tree;
    private Class contentClass;

    public XmlParser(String file, Tree<E> tree, Class contentClass) {
        this.file = file;
        this.tree = tree;
        this.contentClass = contentClass;
    }

        public Tree<E> read(String file, Tree<E> container, Class param) throws JAXBException {
            JAXBContext jaxbContext = JAXBContext.newInstance( container.getClass(), param);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            container = (Tree<E>) jaxbUnmarshaller.unmarshal(new File(file));
//            object.restoreParents();
            return container;
        }

    Tree<E> write(){
        try {
            StringWriter writer =new StringWriter();
            JAXBContext context = JAXBContext.newInstance(tree.getClass(),contentClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(tree, new File(file));
            marshaller.marshal(tree,writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return tree;
    }
}
