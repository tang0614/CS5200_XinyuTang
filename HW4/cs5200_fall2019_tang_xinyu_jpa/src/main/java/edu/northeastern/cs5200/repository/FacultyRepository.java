package edu.northeastern.cs5200.repository;
import edu.northeastern.cs5200.entity.Faculty;
import edu.northeastern.cs5200.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
    public Faculty findFacultyByUsername(@Param("name") String name);
}