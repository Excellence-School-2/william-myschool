package it.nttdata.myschool.repository;

import org.springframework.data.repository.CrudRepository;

import it.nttdata.myschool.entity.Classroom;

public interface ClassroomRepository extends CrudRepository<Classroom, Long> {
    
}
