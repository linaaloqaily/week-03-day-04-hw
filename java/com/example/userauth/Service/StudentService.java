package com.example.userauth.Service;

import com.example.userauth.Exception.InvalidIdException;
import com.example.userauth.Model.Student;
import com.example.userauth.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) throws IllegalAccessException{
        studentRepository.save(student);
    }

//    public Integer checkStudent(Integer id) {
//        Optional<Student> stud=studentRepository.findById(id);
//
//        if(stud.isEmpty()){
//            return -1; //Invalid id
//        }
//
//        return 1; //Valid student
//    }


    public void checkStudent(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(
                        ()->new InvalidIdException("Invalid id"));
    }
}
