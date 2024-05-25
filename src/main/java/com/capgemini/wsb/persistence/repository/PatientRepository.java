package com.capgemini.wsb.persistence.repository;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    /*

    @Query("SELECT PatientEntity FROM PatientEntity WHERE PatientEntity.lastName = :lastname")
    List<PatientEntity> findPatientsByLastName(String lastname);

    @Query("SELECT PatientEntity FROM PatientEntity WHERE (SELECT COUNT(VisitEntity) FROM VisitEntity WHERE VisitEntity.patient.id = PatientEntity .id) > :numberOfVisits")
    List<PatientEntity> findPatientsWithMoreThanXVisits(Long numberOfVisits);

    @Query(value = "SELECT first_name, last_name FROM Patient WHERE age > 32", nativeQuery = true)
    List<PatientEntity> findPatientsOlderThanX();


    */
}