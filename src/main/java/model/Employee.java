package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@XmlRootElement
public class Employee {
    private transient static AtomicInteger countId=new AtomicInteger(0);
    private String id;
    private String name;
    private int age;
    private Sex sex;
    private String job;
    private transient static Map<String, Employee> allUsers = new HashMap<String, Employee>();

    public Employee() {
    }

    public static int getUsersCount() {
        return countId.intValue();
    }

    @XmlAttribute
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Employee(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.job="Middle developer";

        if (!hasUser()){
            this.id = String.valueOf(countId.incrementAndGet());
            allUsers.put(id, this);
        }
    }

    @XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    private boolean hasUser(){
        for (Employee employee : allUsers.values()){
            if (employee.equals(this) && employee.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }
    public static List<Employee> getAllUsers(){
        return new ArrayList<>(allUsers.values());
    }

    public static List<Employee> getAllUsers(Sex sex){
        List<Employee> listAllEmployees = new ArrayList<>();
        for (Employee employee : allUsers.values()){
            if (employee.sex == sex){
                listAllEmployees.add(employee);
            }
        }
        return listAllEmployees;
    }

    public static int getHowManyUsers(){
        return allUsers.size();
    }

    public static int getHowManyUsers(Sex sex){
        return getAllUsers(sex).size();
    }

    public static int getAllAgeUsers(){
        int countAge = 0;
        for (Employee employee : allUsers.values()){
            countAge += employee.age;
        }
        return countAge;
    }

    public static int getAllAgeUsers(Sex sex){
        int countAge = 0;
        for (Employee employee : getAllUsers(sex)){
            countAge += employee.age;
        }
        return countAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) &&
                sex == employee.sex;
    }


    public static int getAverageAgeOfAllUsers(){
        return getAllAgeUsers() / getHowManyUsers();
    }

    public static int getAverageAgeOfAllUsers(Sex sex){
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
    public static void clearCache(){
        allUsers.clear();
        countId=new AtomicInteger(0);
    }
}
