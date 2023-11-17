package spc.com.studentserviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spc.com.studentserviceapi.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Interface to persist student data with db
}
