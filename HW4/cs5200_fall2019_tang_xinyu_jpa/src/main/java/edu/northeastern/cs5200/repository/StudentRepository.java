package edu.northeastern.cs5200.repository;
import edu.northeastern.cs5200.entity.Person;
import edu.northeastern.cs5200.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    public Student findStudentByUsername(@Param("name") String name);
}