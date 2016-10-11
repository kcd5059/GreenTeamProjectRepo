package com.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssa.dao.IMemberDAO;
import com.ssa.entity.Student;

@Service
public class MemberService implements IMemberService {
	
	@Autowired
	private IMemberDAO studentDAO;

	@Override
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentDAO.getStudentById(studentId);
	}

	@Override
	public boolean addStudent(Student student) {
		return studentDAO.addStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	public void deleteStudent(Student student) {
		studentDAO.deleteStudent(student);
		
	}

}
