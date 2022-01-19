package adapter;

import java.sql.*;
import java.util.Scanner;

import model.Student;
import service.StudentService;
import utility.ConnectionUtil;

public class StudentServiceAdapter implements StudentService {

	public Student[] studentArray=new Student[100];
	int studentCount=0;

	@Override
	public void createStudent(Student s) {
		try {
			// TODO Auto-generated method stub
			s.setId(studentCount);
			String sql="insert into student values(?,?,?)";
			Connection con=ConnectionUtil.getDBConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, studentCount);
			ps.setString(2, s.getName());
			ps.setString(3, s.getStream());
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("Data Inserted");
			}
			else {
				System.out.println("Some Error");
			}
			studentArray[studentCount]=s;
			studentCount++;
			con.close();
			System.out.println("Student Added Successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewStudent() {
		// TODO Auto-generated method stub
		System.out.println("Below are the Student Details");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akshay" ,"root","");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the id which you want to view");
			int id=sc.nextInt();
			String sql="select * from student where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				
			}
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void updateStudent(int id) {
//		// TODO Auto-generated method stub
//		boolean flag=false;
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter New/Old Name");
//		String name=sc.next();
//		System.out.println("Enter New/Old Stream");
//		String stream=sc.next();
//		Student s=new Student(id,name,stream);
//		for(int i=0; i<studentArray.length; i++) {
//			if(studentArray[i].getId()==id) {
//				flag=true;
//				studentArray[i]=s;
//				break;
//			}
//		}
//
//		if(flag) {
//			System.out.println("Succesfully updated");
//		}
//		else {
//			System.out.println("Student not found");
//		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akshay" ,"root","");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the name which you want to add");
			String name=sc.next();
			System.out.println("Enter the stream which you want to add");
			String stream=sc.next();
//			System.out.println("Enter the id which you want to view");
	//		int id=sc.nextInt();
			String sql="update student set name=?, stream=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, stream);
			ps.setInt(3, id);
			
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("Updated");
			}
			else {
				System.out.println("Error");
			}
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
//		boolean deletedflag=false;
//		for(int i=0; i<=studentCount; i++) {
//			Student s=studentArray[i];
//			if(s.getId()==id) {
//				studentArray[i]=null;
//				deletedflag=true;
//				break;
//			}
//		}
//		if(deletedflag) {
//			System.out.println("Success");
//		}
//		else {
//			System.out.println("Not Found");
//		}
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akshay" ,"root","");
			Connection con=ConnectionUtil.getDBConnection();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the id which you want to delete");
//			int id=sc.nextInt();
			String sql="delete from student where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("Data Deleted");
			}
			else {
				System.out.println("Error");
			}
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
