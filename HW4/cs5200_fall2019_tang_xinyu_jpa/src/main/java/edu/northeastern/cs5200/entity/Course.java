package edu.northeastern.cs5200.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne()
	@JsonIgnore
	private Faculty teacher;

	@OneToMany(mappedBy="course")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Section> section;

	private String lable;
    public Course(){}
    
    public int getId() {
        return this.id;
    }
    
    public Course(String lable) {
        this.lable = lable;
    }

    public void includeSection(Section section)
    {
        this.section.add(section);
        if(section.getCourse() != this) {
            section.setCourse(this);
        }
    }

    public List<Section> getSection() {
        return section;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }

    public Faculty getAuthor() {
        return teacher;
    }

    
    // set author 
    public void setAuthor(Faculty teacher) {
        this.teacher = teacher;

        if(!teacher.getAuthoredCourses().contains(this)) {
        	teacher.getAuthoredCourses().add(this);
        }
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }
}