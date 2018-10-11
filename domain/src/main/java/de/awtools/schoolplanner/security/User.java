package de.awtools.schoolplanner.security;

import java.util.List;

import de.awtools.schoolplanner.school.Student;
import de.awtools.schoolplanner.school.Teacher;

public class User {

    private String username;
    private String password;

    // TODO User mit verschiedenen Rollen?
    private List<Student> student;
    private List<Teacher> teacher;
    
}
