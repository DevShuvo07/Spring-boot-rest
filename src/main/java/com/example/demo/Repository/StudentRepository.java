package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
