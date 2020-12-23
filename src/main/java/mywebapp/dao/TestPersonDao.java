package mywebapp.dao;

import java.sql.SQLException;

public class TestPersonDao {
    public static void main(String[] args) throws SQLException {
        PersonDao dao = new PersonDao();
//        System.out.println(dao.findPersons());
//        dao.createSchema();

        System.out.println(dao.findPersons());
        System.out.println(dao.findPersonById(22L));
    }
}
