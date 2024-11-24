package org.jiacheng.teo.Q3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        StudentRepository repository = context.getBean(StudentRepository.class);

        // Create students
        repository.createStudent("Alice", "F");
        repository.createStudent("Bob", "M");

        // Find students by name
        List<Student> students = repository.findStudentByName("A");
        for (Student student : students) {
            System.out.println("Name: " + student.name + ", Gender: " + student.gender);
        }

        context.close();
    }
}