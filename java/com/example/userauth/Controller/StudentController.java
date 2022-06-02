package com.example.userauth.Controller;

import com.example.userauth.DTO.API;
import com.example.userauth.Model.Student;
import com.example.userauth.Service.StudentService;
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
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;
    Logger logger = LoggerFactory.getLogger(StudentController.class);


    @GetMapping("/getStudent")
    public ResponseEntity<List<Student>> getStudents(){
        logger.info("Get Students");
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @PostMapping("/addStudent")
    public ResponseEntity<API> addUser(@RequestBody @Valid Student student) throws IllegalAccessException{
        studentService.addStudent(student);
        logger.info("Add Student");
        return ResponseEntity.status(201).body(new API("New student added !",201));
    }

//    @GetMapping("/checkStudent/{id}")
//    public ResponseEntity<String> checkStudentIsValid(@PathVariable Integer id){
//        Integer studentStatus=studentService.checkStudent(id);
//        switch (studentStatus){
//            case -1:
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid id");
//            case 1:
//                return ResponseEntity.status(HttpStatus.OK).body("Valid student");
//            default:
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SERVER ERROR");
//
//        }
//    }

    @GetMapping("/checkStudent/{id}")
    public ResponseEntity<API> checkStudentIsValid(@PathVariable Integer id){
        studentService.checkStudent(id);
        logger.info("Get One Student");
        return ResponseEntity.status(HttpStatus.OK).body(new API("Valid student",200));
    }


}
