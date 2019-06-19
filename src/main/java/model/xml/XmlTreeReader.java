package model.xml;

import model.tree.Tree;

import javax.xml.bind.JAXBException;
import java.io.Closeable;
import java.io.InputStream;

public interface XmlTreeReader<E> {
    <E> E read(InputStream file, Class<E> container, Class param) throws JAXBException;
}
