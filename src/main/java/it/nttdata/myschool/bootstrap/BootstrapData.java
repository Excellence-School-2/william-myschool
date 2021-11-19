package it.nttdata.myschool.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.nttdata.myschool.entity.Classroom;
import it.nttdata.myschool.entity.Student;
import it.nttdata.myschool.repository.ClassroomRepository;
import it.nttdata.myschool.repository.StudentRepository;



@Component
public class BootstrapData implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final ClassroomRepository classroomRepository;

    

    public BootstrapData(StudentRepository studentRepository, ClassroomRepository classroomRepository) {
        this.studentRepository = studentRepository;
        this.classroomRepository = classroomRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        Classroom classroom1 = new Classroom("1A");
        Classroom classroom2 = new Classroom("1B");
        Classroom classroom3 = new Classroom("1C");

        Student student1 = new Student("Mario", "Rossi", 14);
        Student student2 = new Student("Luca", "Bianchi", 14);
        Student student3 = new Student("Paolo", "Gialli", 14);
        Student student4 = new Student("Francesco", "Marrone", 14);
        Student student5 = new Student("Giulio", "Azzurro", 14);
        Student student6 = new Student("Giuseppe", "Verdi", 14);

        student1.setClassroom(classroom1);
        student2.setClassroom(classroom1);

        student3.setClassroom(classroom2);
        student4.setClassroom(classroom2);

        student5.setClassroom(classroom3);
        student6.setClassroom(classroom3);

        classroomRepository.save(classroom1);
        classroomRepository.save(classroom2);
        classroomRepository.save(classroom3);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);

        

        
        
    }
    
    
}
