package mywebapp.dao;

import mywebapp.model.Person;
import mywebapp.utils.FileUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

    public List<Person> findPersons() {

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5433/taltech_course",
                        "postgres",
                        "postgres");

                Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(
                    "SELECT id, name, age from person where id > 0");

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

    public Person findPersonById(Long id) throws SQLException {

        String sql = "SELECT id, name, age from person where id = ?";

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5433/taltech_course",
                        "postgres",
                        "postgres");
                PreparedStatement ps = conn.prepareStatement(sql))

        {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            Person person = new Person();

            while (rs.next()) {
                        person.setId(rs.getLong("id"));
                        person.setName(rs.getString("name"));
                        person.setAge(rs.getInt("age"));
            }
            return person;

        } catch (SQLException e) {
            return null;
        }
    }


    public void addPerson() {

        String sql = "INSERT INTO person (name, age) values ('alex', 21)";
            try (
                    Connection conn = DriverManager.getConnection(
                            "jdbc:postgresql://localhost:5433/taltech_course",
                            "postgres",
                            "postgres");
                    Statement stmt = conn.createStatement())
            {
                ResultSet rs = stmt.executeQuery(sql);

                if (!rs.next()) {
                    throw new RuntimeException("error");
                }
            } catch (SQLException e) {

            }
    }

    public void createSchema() {

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5433/taltech_course",
                        "postgres",
                        "postgres");
                Statement stmt = conn.createStatement())

        {
            String schemaSql = FileUtil.readFileFromClasspath("schema.sql");
            String dataSql = FileUtil.readFileFromClasspath("data.sql");

            stmt.executeUpdate(schemaSql);
            stmt.executeUpdate(dataSql);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
