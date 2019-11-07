package edu.northeastern.cs5200.repository;
import edu.northeastern.cs5200.entity.Course;
import edu.northeastern.cs5200.entity.Section;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SectionRepository extends CrudRepository<Section, Integer> {

    public Section findSectionByTitle(@Param("title") String title);
    public List<Section> findSectionByCourseId(@Param("courseId") int courseId);

}