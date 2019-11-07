package edu.northeastern.cs5200.entity;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.util.List;


@Entity
public class Student extends Person {
	@ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name="ENROLLMENT",
            joinColumns=@JoinColumn(name="STUDENT_ID",
                    referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name=
                    "SECTION_ID", referencedColumnName="ID"))
	
    private int grad_year;
    private long scholar;
    private List<Section> enrolledSections;


    public Student(){}

    public Student(int grad_year, long scholar) {
        this.grad_year = grad_year;
        this.scholar = scholar;
    }
    
    public long getScholarship() {
        return scholar;
    }

    public void setScholarship(long scholar) {
        this.scholar = scholar;
    }

    public int getGradYear() {
        return grad_year;
    }

    public void setGradYear(int grad_year) {
        this.grad_year = grad_year;
    }
    
    public void enrollSection(Section section) {
        this.enrolledSections.add(section);
        
    }

    public List<Section> getEnrolledSections() {
        return enrolledSections;
    }

    public void setEnrolledSections(List<Section> enrolledSections) {
        this.enrolledSections = enrolledSections;
    }
    
}
