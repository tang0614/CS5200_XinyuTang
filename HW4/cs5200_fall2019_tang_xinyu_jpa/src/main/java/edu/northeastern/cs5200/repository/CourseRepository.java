package edu.northeastern.cs5200.repository;
import edu.northeastern.cs5200.entity.Course;
import edu.northeastern.cs5200.entity.Section;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {

    public Course findCourseByLabel(@Param("label") String label);
    public List<Course> findCourseByAuthorId(@Param("authorId") int authorId);

}