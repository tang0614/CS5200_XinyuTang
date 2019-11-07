package dao;

import edu.northeastern.cs5200.entity.*;
import edu.northeastern.cs5200.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class UniversityDao {

    @Autowired FacultyRepository facultyRepository;
    @Autowired StudentRepository studentRepository;
    @Autowired SectionRepository sectionRepository;
    @Autowired CourseRepository courseRepository;
    @Autowired PersonRepository personRepository;
   



    public Faculty createFaculty(Faculty teacher) {
        return facultyRepository.save(teacher);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Course creatCourse(Course course) {
        return courseRepository.save(course);
    }

    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

   
    public Course addSectionToCourse(Section section, Course course) {
        section.setCourse(course);
        sectionRepository.save(section);

        return course;
    }

    public Course setAuthorForCourse(Faculty teacher, Course course) {
        course.setAuthor(teacher);
        courseRepository.save(course);
        return course;
    }
    
    public void truncateDatabase() {
    	courseRepository.deleteAll();
        facultyRepository.deleteAll();
        studentRepository.deleteAll();
        sectionRepository.deleteAll();
       
    }

    public boolean enrollStudentInSection(Student student, Section section) {
      
        int restSeats = section.getSeats();
        if (restSeats == 0) {
            return false;
        }
      
        return true;
    }

   
    public Course findCourseByLabel(String label) {
        return courseRepository.findCourseByLabel(label);
    }

    public Section findSectionByTitle(String title) {
        return sectionRepository.findSectionByTitle(title);
    }
    
    public Faculty findFacultyByUsername(String name) {
        return facultyRepository.findFacultyByUsername(name);
    }

    public Student findStudentByUsername(String name) {
        return studentRepository.findStudentByUsername(name);
    }



    public List<Person> findAllUsers() {
        List<Person> users = new ArrayList<>();
        for (Person p :personRepository.findAll()) {
            users.add(p);
        }

        return users;
    }

    public List<Faculty> findAllFaculties() {
        List<Faculty> faculties = new ArrayList<>();
        for (Faculty f : facultyRepository.findAll()) {
            faculties.add(f);
        }

        return faculties;
    }

    public List<Course> findAllCourses() {
        List<Course> courses = new ArrayList<>();
        for (Course c : courseRepository.findAll()) {
            courses.add(c);
        }

        return courses;
    }
    
    public List<Student> findAllStudents() {
        List<Student> students = new ArrayList<>();
        for (Student s : studentRepository.findAll()) {
            students.add(s);
        }

        return students;
    }

    public List<Section> findAllSections() {
        List<Section> sections = new ArrayList<>();
        for (Section s : sectionRepository.findAll()) {
            sections.add(s);
        }

        return sections;
    }

    public List<Course> findCoursesForAuthor(Faculty teacher) {
        List<Course> courses = new ArrayList<>();
        for (Course c : courseRepository.findCourseByAuthorId(teacher.getId())) {
            courses.add(c);
        }

        return courses;
    }

    public List<Section> findSectionForCourse(Course course) {
        return sectionRepository.findSectionByCourseId(course.getId());
    }

    public List<Student> findStudentsInSection(Section section) {
        return section.getEnrolledStudents();
    }

    public List<Section> findSectionsForStudent(Student student) {
        return student.getEnrolledSections();
    }
}