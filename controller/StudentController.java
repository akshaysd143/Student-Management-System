package controller;

import java.util.Scanner;

import adapter.StudentServiceAdapter;
import model.Student;
import service.StudentService;

public class StudentController {
	static StudentService service=new StudentServiceAdapter();

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		boolean systemExit=false;
		while(!systemExit) {
			System.out.println("Select from below available operations");
			System.out.println("1.CREATE STUDENT");
			System.out.println("2.VIEW STUDENT");
			System.out.println("3.UPDATE STUDENT DETAILS");
			System.out.println("4.DELETE STUDENT DETAILS");
			System.out.println("5.EXIT");
			int action=sc.nextInt();

			switch(action) {
			case 1:
				System.out.println("Enabling create Student option");
				
				System.out.println("Enter Student name");
				String name=sc.next();
				System.out.println("Enter Student Stream");
				String stream=sc.next();
				Student s=new Student(0, name, stream);
				service.createStudent(s);
				break;

			case 2:
				service.viewStudent();
				break;

			case 3:
				System.out.println("Enter the student id to perform update option");
				int id=sc.nextInt();
				service.updateStudent(id);
				break;

			case 4:
				System.out.println("Enter the student id to perform delete option");
				int deleteActionId=sc.nextInt();
				service.deleteStudent(deleteActionId);
				break;

			case 5:
				System.exit(0);
				break;
			
			default:
				System.out.println("Wrong Input");
				break;
			}
		}
		
	}

}
