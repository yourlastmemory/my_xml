package main;

import model.*;
import model.tree.Tree;
import model.xml.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class Main {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {


        Tree<Employee> tree = new Tree<>();

//
//        tree.add(new Employee("Евгений", 35, Sex.MALE));
//        tree.add(new Employee("Марина", 34, Sex.FEMALE));
//        tree.add(new Employee("Кирилл", 14, Sex.MALE));
//        tree.add(new Employee("Елена", 18, Sex.FEMALE));
//        tree.add(new Employee("Андрей", 26, Sex.MALE));
//        tree.next(0).add(new Employee("Алина", 7, Sex.FEMALE));
//        tree.getRoot();

//        XmlTreeWriter<Employee> writer = new JaxbTreeWriter<>();
//        writer.write(tree,"tree.xml", Employee.class);

        InputStream inputStream = new FileInputStream("tree.xml");
//        JaxbTreeReader<Employee> reader = new JaxbTreeReader<>();
//        tree=reader.read(inputStream,tree.getClass(),Employee.class);
//        tree.restoreParents();
//        new JaxbTreeWriter<Employee>().write(tree,"anus.xml");
//        System.out.println(tree.toString());
//        System.out.println(Employee.getUsersCount());
//        reader.read(inputStream,tree.getClass(),Employee.class);
////
//        System.out.println("Все пользователи:");
//        Employee.getAllUsers().forEach(System.out::println);
//        System.out.println("Все пользователи: MALE");
//        Employee.getAllUsers(Sex.MALE).forEach(System.out::println);
//        System.out.println("Все пользователи: FEMALE");
//        Employee.getAllUsers(Sex.FEMALE).forEach(System.out::println);
//        System.out.println("================================================");
//        System.out.println("       всех пользователей: " + Employee.getHowManyUsers());
//        System.out.println("  всех пользователей MALE: " + Employee.getHowManyUsers(Sex.MALE));
//        System.out.println("всех пользователей FEMALE: " + Employee.getHowManyUsers(Sex.FEMALE));
//        System.out.println("================================================");
//        System.out.println("       общий возраст всех пользователей: " + Employee.getAllAgeUsers());
//        System.out.println("  общий возраст всех пользователей MALE: " + Employee.getAllAgeUsers(Sex.MALE));
//        System.out.println("общий возраст всех пользователей FEMALE: " + Employee.getAllAgeUsers(Sex.FEMALE));
//        System.out.println("================================================");
//        System.out.println("       средний возраст всех пользователей: " + Employee.getAverageAgeOfAllUsers());
//        System.out.println("  средний возраст всех пользователей MALE: " + Employee.getAverageAgeOfAllUsers(Sex.MALE));
//        System.out.println("средний возраст всех пользователей FEMALE: " + Employee.getAverageAgeOfAllUsers(Sex.FEMALE));
//        System.out.println("================================================");
//        smth();
    }


    static void smth() throws JAXBException {
        StringWriter writer = new StringWriter();
        Department department =new Department();
        department.setName("dept1");
        department.getEmployees().add(new Employee("Евгений", 35, Sex.MALE));
        department.getEmployees().add(new Employee("Марина", 34, Sex.FEMALE));
        department.getEmployees().add(new Employee("Алина", 7, Sex.FEMALE));
        department.getEmployees().add(new Employee("Кирилл", 14, Sex.MALE));
        department.getEmployees().add(new Employee("Елена", 18, Sex.FEMALE));
        department.getEmployees().add(new Employee("Андрей", 26, Sex.MALE));

        JAXBContext context = JAXBContext.newInstance(Employee.class, Department.class,Sex.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // самосериализация
        marshaller.marshal(department, writer);
        System.out.println(writer.toString());

//        Cat cat = new Cat();
//        cat.setName("Murka");
//        cat.setAge(5);
//        cat.setWeight(4);
//
//        Zoo zoo = new Zoo();
//        zoo.animals.add(cat);
//        zoo.animals.add(cat);
//
//        //писать результат сериализации будем во Writer(StringWriter)
//        StringWriter writer = new StringWriter();
//
//        //создание объекта Marshaller, который выполняет сериализацию
//        JAXBContext context = JAXBContext.newInstance(Cat.class, Zoo.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        // самосериализация
//        marshaller.marshal(zoo, writer);
//
//        //преобразовываем все записанное в StringWriter в строку
//        System.out.println(writer.toString());
    }
}
