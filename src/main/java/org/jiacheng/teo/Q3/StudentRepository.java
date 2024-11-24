package org.jiacheng.teo.Q3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.util.List;

class Student {
	public String name;
	public String gender;

	public Student(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}
}

@Repository
public class StudentRepository {
	@Autowired
	private JdbcTemplate template;

	@PostConstruct
	public void createTable() {
		System.out.println("Creating table");
		template.execute("CREATE TABLE student(id bigint AUTO_INCREMENT primary key, name VARCHAR(50), gender VARCHAR(1))");
		System.out.println("Table created");
	}

	public void createStudent(String name, String gender) {
		System.out.println("Creating student: " + name + ", " + gender);
		template.update("INSERT INTO student(name, gender) VALUES (?,?)", name, gender);
		System.out.println("Student created");
	}

	public List<Student> findStudentByName(String nameStartsWith) {
		// Write your code here
		return template.query("SELECT * FROM student where name like ?",
			new Object[]{nameStartsWith + "%"},
			(ResultSet rs, int rowNum) -> new Student(rs.getString("name"), rs.getString("gender"))
		);
	}
}