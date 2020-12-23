package mywebapp.dao;

import mywebapp.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

    public List<Person> findPerson() {

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5433/taltech_course",
                        "postgres",
                        "postgres");

                Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(
                    "SELECT id, name, age from person where id = 1");

            List<Person> persons = new ArrayList<>();
            while (rs.next()) {
                Person person = new Person(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("age"));
                persons.add(person);
            }

            return persons;

        } catch (SQLException e) {
            return null;
        }
    }


    public void addPerson() {

            try (
                    Connection conn = DriverManager.getConnection(
                            "jdbc:postgresql://localhost:5433/taltech_course",
                            "postgres",
                            "postgres");
                    Statement stmt = conn.createStatement())
            {
                ResultSet rs = stmt.executeQuery(
                        "INSERT INTO person (name, age) values ('alex', 21)");

                if (!rs.next()) {
                    throw new RuntimeException("error");
                }
            } catch (SQLException e) {

            }
    }

}
