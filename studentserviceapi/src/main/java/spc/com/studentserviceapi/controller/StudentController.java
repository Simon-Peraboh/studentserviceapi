/**
 * Created By SPC On
 * Date:17/11/2023
 * Time:10:41
 * Project Name:spc.com.studentserviceapi.controller
 */

package spc.com.studentserviceapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spc.com.studentserviceapi.model.Student;
import spc.com.studentserviceapi.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("api/v1/studentServiceAPI")
public class StudentController {

    // Inject Student Service Interface
    private StudentService studentService;

    // Inject Constructor

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //RESTFUL API to create student details
    @PostMapping()
    public ResponseEntity<Student> createDetails(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudentDetails(student), HttpStatus.CREATED);
    }

    //RESTFUL API to Get All student details
    @GetMapping()
    public List<Student> getAll(){
        return studentService.getAllStudent();
    }

    //RESTFUL API to Get single student details
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") long id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    //RESTFUL API to update student details
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") long id){
        return new ResponseEntity<>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    //RESTFUL API to delete student details
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
        studentService.deleteStudentById(id);
        return new ResponseEntity<>("Student Has Been Deleted Successfully", HttpStatus.OK);
    }


}
