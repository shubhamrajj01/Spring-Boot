package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.dao.StudentDAOImpl;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner ->  {
			// createStudent(studentDAO);

			createMultipleStudent(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			// deleteAllStudent(studentDAO);

		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting All student");
		int numRowDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row cont: " + numRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting Student Id: " + studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on id: primary key
		int studentId = 1;
		System.out.println("Getting the student id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change the first name to "Shubham"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Shubham");
		myStudent.setLastName("Raj");
		myStudent.setEmail("shubhraj510@gmail.com");

		// update the student
		studentDAO.update(myStudent);

		// display the student
		System.out.println("Updated student" + myStudent);
	}

	private void queryForStudents(StudentDAO studentDAO){
		// get a list of student
		List<Student> theStudents= studentDAO.findAll();

		// display list of the students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Arpreet", "Mahal", "123@gamil.com");

		// save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generation Id: "+ theId);

		// retrieve student based on id: primary key
		System.out.println("Retrieving student with id: " +theId);

		Student myStudent = studentDAO.findById(theId);
		// display student
		System.out.println("Found the student: " + myStudent);

	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// creating student's object
		System.out.println("Creating student object");
		Student tempStudent1 = new Student("Shubham", "Raj", "email1@email.com");
		Student tempStudent2 = new Student("Rahul", "Pandey", "email2@email.com");
		Student tempStudent3 = new Student("Kundan", "Kumar", "email3@email.com");

		//saving the student info to my database
		System.out.println("Saving the student details");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO){
		//create the student object
		Student tempStudent = new Student("Shubham", "Raj", "thisismygamil@gamil.com");

		// save the student object
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Student Detail Inserted. Generation Id: " + tempStudent.getId());
	}
}
