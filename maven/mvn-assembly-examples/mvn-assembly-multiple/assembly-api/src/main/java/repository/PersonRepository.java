package repository;

import domain.Person;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: adilfulara
 * Date: 2/1/14
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PersonRepository {

    public List<Person> getAllPersons();

    public List<Person> findPersonsWithName(String name);

}
