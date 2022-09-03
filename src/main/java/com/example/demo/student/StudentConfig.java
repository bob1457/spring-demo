package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository
    ) {
        return  args -> {
            Student edward = new Student(
                        "Edward",
                        "edy2021@gmail.com",
                        LocalDate.of(1999, Month.MAY, 25),
                        23
                );
            Student victor =  new Student(
                    "Victor",
                    "vy@gmail.com",
                    LocalDate.of(1996, Month.NOVEMBER, 6),
                    26
            );
            Student bob = new Student(
                    "Bob",
                    "bob.h.yuan@gmail.com",
                    LocalDate.of(1957, Month.MAY, 15),
                    64
            );
            Student sophia = new Student(
                    "Sophia",
                    "sophiayuan77@gmail.com",
                    LocalDate.of(2007, Month.JANUARY, 7),
                    23
            );
            Student michelle = new Student(
                    "Michell",
                    "rentppt@gmail.com",
                    LocalDate.of(1968, Month.JULY, 22),
                    54
            );

            studentRepository.saveAll(
                    List.of(edward, victor, bob, sophia, michelle)
            );
        };
    }
}
