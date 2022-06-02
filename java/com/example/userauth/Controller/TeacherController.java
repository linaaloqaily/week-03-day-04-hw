package com.example.userauth.Controller;

import com.example.userauth.DTO.API;
import com.example.userauth.Model.Teacher;
import com.example.userauth.Service.TeacherService;
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
@RequestMapping("api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    Logger logger = LoggerFactory.getLogger(TeacherController.class);


    @GetMapping("/getTeacher")
    public ResponseEntity<List<Teacher>> getTeachers(){
        logger.info("Get Teachers");
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    @PostMapping("/addTeacher")
    public ResponseEntity<API> addTeacher(@RequestBody @Valid Teacher teacher) throws IllegalAccessException{
        teacherService.addTeacher(teacher);
        logger.info("Add Teacher");
        return ResponseEntity.status(201).body(new API("New teacher added !",201));
    }

//    @GetMapping("/checkTeacher/{id}")
//    public ResponseEntity<String> checkTeacherIsValid(@PathVariable Integer id){
//        Integer teacherStatus=teacherService.checkTeacher(id);
//        switch (teacherStatus){
//            case -1:
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid id");
//            case 1:
//                return ResponseEntity.status(HttpStatus.OK).body("Valid teacher");
//            default:
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SERVER ERROR");
//
//        }
//    }

    @GetMapping("/checkTeacher/{id}")
    public ResponseEntity<API> checkTeacherIsValid(@PathVariable Integer id){
        teacherService.checkTeacher(id);
        logger.info("Get One Teacher");
        return ResponseEntity.status(HttpStatus.OK).body(new API("Valid teacher",200));
    }
}
