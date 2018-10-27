package de.awtools.schoolplanner.security;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import de.awtools.schoolplanner.school.Student;
import de.awtools.schoolplanner.school.Teacher;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotNull
    @Column(name = "username")
    private String username;
    
    @NotNull
    @Column(name = "password")
    private String password;

    // TODO User mit verschiedenen Rollen?
    private List<Student> student;
    private List<Teacher> teacher;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
