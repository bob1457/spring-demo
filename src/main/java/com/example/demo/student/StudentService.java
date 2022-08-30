package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class StudentService {

    public List<Student> GetStudent()
    {
        return List.of(
                new Student(
                        1L,
                        "Edward",
                        "edy2021@gmail.com",
                        LocalDate.of(1999, Month.MAY, 25),
                        23
                )
        );
    }
}
