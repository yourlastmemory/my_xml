package model;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class EmployeeTest {

    private static Employee employee;
    private static Employee employee1;
    private static Employee employee2;

    @BeforeAll
    static void setUp(){

        employee = new Employee("Евгений", 35, Sex.MALE);
        employee1 = new Employee("Марина", 34, Sex.FEMALE);
        employee2 = new Employee("Алина", 7, Sex.FEMALE);
    }

    @Test
    void getAllUsers() {
        //создаем список expected и заполняем его данными нашего метода
        List<Employee> expected = Employee.getAllUsers();

        //создаем список actual в него помещаем данные для сравнения
        //то что мы предпологиаем метод должен вернуть
        List<Employee> actual = new ArrayList<>();
        actual.add(employee);
        actual.add(employee1);
        actual.add(employee2);

        //запускаем тест, в случае если список expected и actual не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        assertEquals(expected, actual);
    }

    @Test
    void getAllUsers_NO_NULL() {
        //добавим проверку на null
        List<Employee> expected = Employee.getAllUsers();
        assertNotNull(expected);
    }

    @Test
    void getAllUsers_MALE() {

        List<Employee> expected = Employee.getAllUsers(Sex.MALE);

        List<Employee> actual = new ArrayList<>();
        actual.add(employee);

        assertEquals(expected, actual);
    }

    @Test
    void getAllUsers_MALE_NO_NULL() {
        //добавим проверку на null
        List<Employee> expected = Employee.getAllUsers(Sex.MALE);
        assertNotNull(expected);
    }

    @Test
    void getAllUsers_FEMALE() {

        List<Employee> expected = Employee.getAllUsers(Sex.FEMALE);

        List<Employee> actual = new ArrayList<>();
        actual.add(employee1);
        actual.add(employee2);

        assertEquals(expected, actual);
    }

    @Test
    void getAllUsers_FEMALE_NO_NULL() {
        //добавим проверку на null
        List<Employee> expected = Employee.getAllUsers(Sex.FEMALE);
        assertNotNull(expected);
    }

    @Test
    void getHowManyUsers() {

        int expected = Employee.getHowManyUsers();

        int actual = 3;

        assertEquals(expected, actual);
    }

    @Test
    void getHowManyUsers_MALE() {

        int expected = Employee.getHowManyUsers(Sex.MALE);

        int actual = 1;

        assertEquals(expected, actual);
    }

    @Test
    void getHowManyUsers_FEMALE() {

        int expected = Employee.getHowManyUsers(Sex.FEMALE);

        int actual = 2;

        assertEquals(expected, actual);
    }

    @Test
    void getAllAgeUsers() {

        int expected = Employee.getAllAgeUsers();

        int actual = 35 + 34 + 7;

        assertEquals(expected, actual);
    }

    @Test
    void getAllAgeUsers_MALE() {

        int expected = Employee.getAllAgeUsers(Sex.MALE);

        int actual = 35;

        assertEquals(expected, actual);
    }

    @Test
    void getAllAgeUsers_FEMALE() {

        int expected = Employee.getAllAgeUsers(Sex.FEMALE);

        int actual = 34 + 7;

        assertEquals(expected, actual);
    }
}