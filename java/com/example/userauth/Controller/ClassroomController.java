package com.example.userauth.Controller;

import com.example.userauth.DTO.API;
import com.example.userauth.Model.Classroom;
import com.example.userauth.Service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/classroom")
public class ClassroomController {

    private final ClassroomService classroomService;
    Logger logger = LoggerFactory.getLogger(ClassroomController.class);


    @GetMapping("/getClassroom")
    public ResponseEntity<List<Classroom>> getClassrooms(){
        logger.info("Get Classrooms");
        return ResponseEntity.status(200).body(classroomService.getClassrooms());
    }

    @PostMapping("/addClassroom")
    public ResponseEntity<API> addUser(@RequestBody @Valid Classroom classroom) throws IllegalAccessException{
        classroomService.addClassroom(classroom);
        logger.info("Add Classrooms");
        return ResponseEntity.status(201).body(new API("New classroom added !",201));
    }

//    @GetMapping("/checkClassroom/{id}")
//    public ResponseEntity<String> checkClassroomIsValid(@PathVariable Integer id){
//        Integer classroomStatus=classroomService.checkClassroom(id);
//        switch (classroomStatus){
//            case -1:
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid id");
//            case 1:
//                return ResponseEntity.status(HttpStatus.OK).body("Valid classroom");
//            default:
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SERVER ERROR");
//
//        }
//    }

    @GetMapping("/checkClassroom/{id}")
    public ResponseEntity<API> checkClassroomIsValid(@PathVariable Integer id){
        classroomService.checkClassroom(id);
        logger.info("Get One Classroom");
        return ResponseEntity.status(HttpStatus.OK).body(new API("Valid classroom",200));
    }

}
