import domain.Person;
import repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: adilfulara
 * Date: 2/1/14
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class InMemoryRepository implements PersonRepository {

    private static final List<Person> persons = new ArrayList<Person> (){
        {
          add(new Person("John Doe", "Los Angeles"));
          add(new Person("Jane Doe", "Los Angeles"));
        }

    };

    @Override
    public List<Person> getAllPersons() {
        return persons;
    }

    @Override
    public List<Person> findPersonsWithName(String name) {
        List<Person> result = new ArrayList<Person>();
        for(Person p : persons) {
            if ( p.getName().contains(name))
                result.add(p);
        }
        return result;
    }
}
