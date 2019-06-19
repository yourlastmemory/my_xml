package model.xml;

import model.Employee;
import model.tree.Tree;
import model.xml_command.Command;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class JaxbTreeReader<E>  implements XmlTreeReader<E> {


    @Deprecated
    public  <E> E unmarshal(InputStream file, Class<E> unmarshalClass) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(unmarshalClass, Employee.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        E object = (E) jaxbUnmarshaller.unmarshal(file);
        return object;
    }

    @Override
    public <E1> E1 read(InputStream file, Class<E1> container, Class param) throws JAXBException {
        return null;
    }
//
//    @Override
//    public Tree<E> execute(Tree<E> tree, String file, Class eClass) {
//        try {
//            InputStream is=new FileInputStream(file);
//            return read(is,tree.getClass(),eClass);
//        } catch (FileNotFoundException | JAXBException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
