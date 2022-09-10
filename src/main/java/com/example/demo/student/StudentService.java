package com.example.demo.student;

import jakarta.transaction.TransactionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void AddNewStudent(Student student)
    {
        Optional<Student> studentOptional =
        studentRepository.findStudentsByEmail(student.getEmail());

        if(studentOptional.isPresent())
        {
            throw  new IllegalArgumentException("The email already taken");
        }

        studentRepository.save(student);

//        System.out.println(student);
    }

    public void deleteStudent(Long studentId)
    {
        boolean exist = studentRepository.existsById(studentId);

        if(!exist)
        {
            throw  new IllegalArgumentException("Student with id " + studentId + "does not exist");
        }

        studentRepository.deleteById(studentId);

    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email)
    {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name))
        {
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email))
        {
            Optional<Student> studentOptional = studentRepository.findStudentsByEmail(email);

            if(studentOptional.isPresent())
            {
                throw new IllegalArgumentException("Email already taken");
            }
            student.setEmail(email);
        }

    }
}
