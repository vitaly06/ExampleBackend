package ru.sadikov.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.sadikov.springcourse.models.Person;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgressql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Person> index(){
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Person show(int id){
        //return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id, Person updatePerson){
        //Person personToBeUpdated = show(id);
        //personToBeUpdated.setName(updatePerson.getName());

    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
