package mywebapp.dao;

public class TestPersonDao {
    public static void main(String[] args) {
        PersonDao dao = new PersonDao();
        System.out.println(dao.findPerson());
    }
}
