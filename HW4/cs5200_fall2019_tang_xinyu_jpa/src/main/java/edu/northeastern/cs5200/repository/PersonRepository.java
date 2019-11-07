package edu.northeastern.cs5200.repository;
import edu.northeastern.cs5200.entity.Faculty;
import edu.northeastern.cs5200.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    public Person findPersonByUsername(@Param("name") String name);
}