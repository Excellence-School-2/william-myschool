package it.nttdata.myschool.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.nttdata.myschool.entity.Classroom;

public interface ClassroomRepository extends CrudRepository<Classroom, Long> {

    @Query("SELECT s FROM Classroom s WHERE s.section = :section ")
    public Classroom findClassroombySection(@Param("section") String section);
    
}
