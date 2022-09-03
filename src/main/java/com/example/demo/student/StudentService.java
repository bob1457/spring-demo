package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> GetStudent()
    {
//        return List.of(
//                new Student(
//                        1L,
//                        "Edward",
//                        "edy2021@gmail.com",
//                        LocalDate.of(1999, Month.MAY, 25),
//                        23
//                )
//        );

        return studentRepository.findAll();
    }
}
