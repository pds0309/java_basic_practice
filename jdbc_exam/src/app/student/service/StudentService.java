package app.student.service;

import java.util.List;

import app.student.dto.Student;

public interface StudentService {

	List<Student> selectAll();
	
	List<Student> selectByName(String name);
	
	List<Student> selectByDate(int start , int end);
	
	List<Student> selectByMulStudentNo(String studentNos);
}
