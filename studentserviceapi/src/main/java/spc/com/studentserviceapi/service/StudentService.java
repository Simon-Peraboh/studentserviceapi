package spc.com.studentserviceapi.service;

import spc.com.studentserviceapi.model.Student;

import java.util.List;

public interface StudentService {

    // Create and save student details method
    Student createStudentDetails(Student student);

    // Get All students record in db method
    List<Student> getAllStudent();

    // Get a Single Student by Id method
    Student getStudentById(long id);

    // Update Student record By Id
    Student updateStudent(Student student, long id);

    // Delete Student record by Id
    void deleteStudentById( long id);


}
