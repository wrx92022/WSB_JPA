package com.capgemini.wsb.persistance.dao;


import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;


    @Transactional
    @Test
    public void testFindPatientByLastName() {

        // when
        List<PatientEntity> patientEntity = patientDao.findByLastName("Wiśniewska");

        // then
        assertThat(patientEntity.size()).isEqualTo(1);
    }

    @Transactional
    @Test
    public void testFindPatientsByGreaterCounterVisits() {

        // When
        List<PatientEntity> patientEntity = patientDao.findByVisitsCountGreaterThan(0L);

        // Then
        assertThat(patientEntity.size()).isEqualTo(3);

    }

    @Transactional
    @Test
    public void testFindPatientsByAgeGreaterThan() {

        // when
        List<PatientEntity> patientEntity = patientDao.findByAgeCountGreaterThan(23);

        // then
        assertThat(patientEntity.size()).isEqualTo(2);
    }

}
