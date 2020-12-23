package mywebapp.dao;

import mywebapp.model.Person;

import java.sql.SQLException;

public class TestPersonDao {
    public static void main(String[] args) throws SQLException {
        PersonDao dao = new PersonDao();
//        System.out.println(dao.findPersons());
//        dao.createSchema();

        System.out.println(dao.findPersons());
        System.out.println(dao.findPersonById(2L));

        //Insert new person
        Person person = new Person();
        person.setName("tim");
        person.setAge(55);

        System.out.println(dao.insertPerson(person));
        System.out.println(dao.findPersons());

    }
}
