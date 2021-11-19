package it.nttdata.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.nttdata.myschool.entity.Student;
import it.nttdata.myschool.repository.ClassroomRepository;
import it.nttdata.myschool.repository.StudentRepository;

@Controller
public class StudentController {

    private StudentRepository studentRepository;
    private ClassroomRepository classroomRepository;

    public StudentController(StudentRepository studentRepository, ClassroomRepository classroomRepository){
        this.studentRepository = studentRepository;
        this.classroomRepository = classroomRepository;
    }

    @GetMapping("/students")
    public String getStudents(Model model){
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("title", "Lista Studenti My School");
        return "students";
    }

    @GetMapping("/students/{section}")
    public String getStudentsByClass(Model model, @PathVariable String section){
        model.addAttribute("students", studentRepository.findStudentBySection(section));
        model.addAttribute("title", "Lista Studenti My School " + section );
        return "students";
        
    }

    @PostMapping("/addStudents")
    public String addStudent(Student student){
        studentRepository.save(student);
        return "redirect:/students";

    }

    @GetMapping("/addStudents")
    public String getNewStudent(Model model){
        model.addAttribute("classrooms", classroomRepository.findAll());
        return "addStudents";

    }
    
}
