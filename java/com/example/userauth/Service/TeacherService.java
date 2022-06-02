package com.example.userauth.Service;


import com.example.userauth.Exception.InvalidIdException;
import com.example.userauth.Model.Student;
import com.example.userauth.Model.Teacher;
import com.example.userauth.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;


    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) throws IllegalAccessException{
        teacherRepository.save(teacher);
    }

//    public Integer checkTeacher(Integer id) {
//        Optional<Teacher> tech=teacherRepository.findById(id);
//
//        if(tech.isEmpty()){
//            return -1; //Invalid id
//        }
//
//        return 1; //Valid teacher
//    }

    public void checkTeacher(Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(
                        ()->new InvalidIdException("Invalid id"));
    }
}
