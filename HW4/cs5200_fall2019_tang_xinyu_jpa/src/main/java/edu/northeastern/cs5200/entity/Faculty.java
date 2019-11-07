package edu.northeastern.cs5200.entity;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Faculty extends Person{

    @OneToMany(mappedBy="teacher", fetch = FetchType.EAGER)
    
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Course> teacherCourses;

    private String office;
    private boolean tenured;
    public Faculty(){}
    
  

    public Faculty(String office, boolean tenured) {
        this.office = office;
        this.tenured = tenured;
    }
    
  

    public Faculty(Person person, String office, boolean tenured) {
        this.office = office;
        this.tenured = tenured;
        super.setFirstName(person.getFirstName());
        super.setLastName(person.getLastName());
        super.setUsername(person.getFirstName());
        super.setPassword(person.getPassword());
    }

   
    public void teacherCourses(Course course)
    {
        this.teacherCourses.add(course);
        if(course.getAuthor() != this) { 
            course.setAuthor(this);
        }
    }


    public List<Course> getAuthoredCourses() {
        return teacherCourses;
    }

    public void setAuthoredCourses(List<Course> teacherCourses) {
        this.teacherCourses = teacherCourses;
    }


    public boolean getTenured() {
        return tenured;
    }

    public void setTenured(boolean tenured) {
        this.tenured = tenured;
    }
    
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }



	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}