package service;

import model.Student;

public interface StudentService {
	
	void createStudent(Student s);
	void viewStudent();
	void updateStudent(int id);
	void deleteStudent(int id);
	

}
