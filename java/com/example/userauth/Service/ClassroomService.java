package com.example.userauth.Service;

import com.example.userauth.Exception.InvalidIdException;
import com.example.userauth.Model.Classroom;
import com.example.userauth.Model.Student;
import com.example.userauth.Model.Teacher;
import com.example.userauth.Repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassroomService {

    private final ClassroomRepository classroomRepository;


    public List<Classroom> getClassrooms() {
        return classroomRepository.findAll();
    }

    public void addClassroom(Classroom classroom) throws IllegalAccessException{
        classroomRepository.save(classroom);
    }

//    public Integer checkClassroom(Integer id) {
//        Optional<Classroom> stud=classroomRepository.findById(id);
//
//        if(stud.isEmpty()){
//            return -1; //Invalid id
//        }
//
//        return 1; //Valid classroom
//    }

    public void checkClassroom(Integer id) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(
                        ()->new InvalidIdException("Invalid id"));
    }
}
