package model.xml;

import model.Employee;
import model.tree.Tree;
import model.xml_command.Command;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;

public class JaxbTreeWriter<E> implements XmlTreeWriter<E>, Command<E> {

    @Deprecated
    public boolean write(Tree<E> tree, String file) {
        try {
            StringWriter writer =new StringWriter();
            JAXBContext context = JAXBContext.newInstance(tree.getClass(), Employee.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(tree, new File(file));
            marshaller.marshal(tree,writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Tree<E> write(Tree<E> tree, String file, Class eClass) {
        try {
            StringWriter writer =new StringWriter();
            JAXBContext context = JAXBContext.newInstance(tree.getClass(),eClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(tree, new File(file));
            marshaller.marshal(tree,writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return tree;
    }

    @Override
    public Tree<E> execute(Tree<E> tree, String file, Class eClass) {
        return write(tree, file, eClass);
    }
}
