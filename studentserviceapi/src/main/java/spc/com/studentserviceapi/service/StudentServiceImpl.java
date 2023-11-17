/**
 * Created By SPC On
 * Date:17/11/2023
 * Time:10:10
 * Project Name:spc.com.studentserviceapi.service
 */

package spc.com.studentserviceapi.service;

import org.springframework.stereotype.Service;
import spc.com.studentserviceapi.model.Student;
import spc.com.studentserviceapi.repository.StudentRepository;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{

    // Inject Repository for db interaction
    private StudentRepository studentRepository;

    // Constructor to initialize repository

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudentDetails(Student student) {
        // Implementing createStudentDetails method
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        // Implementing getAllStudent method
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        //Using lambda expression to check if student exist before attempting
        return studentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Student With" + id + "Doesn't Exist"));
    }

    @Override
    public Student updateStudent(Student student, long id) {
        //Using lambda expression to check if student exist before attempting update
        Student existing = studentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Student With" + id + "Doesn't Exist"));
        existing.setFirstname(student.getFirstname());
        existing.setLastname(student.getLastname());
        existing.setEmail(student.getEmail());

        //save updated record to db
        return studentRepository.save(existing);
    }

    @Override
    public void deleteStudentById(long id) {
        //Using lambda expression to check if student exist before attempting delete
        studentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Student With" + id + "Doesn't Exist"));
        studentRepository.deleteById(id);

    }
}
