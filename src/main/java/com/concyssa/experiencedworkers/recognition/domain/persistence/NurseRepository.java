package com.concyssa.experiencedworkers.recognition.domain.persistence;


import com.concyssa.experiencedworkers.recognition.domain.model.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {



    @Query(value = "SELECT n FROM Nurse n WHERE n.name LIKE %:filter%")
    List<Nurse> findAllNursesWithFilterName(@Param("filter") String filter);

}
