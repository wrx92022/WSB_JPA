package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.Dao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest
{
    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindById() {
        // given
        // when
        PatientEntity patientEntity = patientDao.findOne(1L);
        // then
        assertThat(patientEntity).isNotNull();
        assertThat(patientEntity.getLastName()).isEqualTo("Wiśniewska");
    }

    @Test
    public void testShouldSavePatient() {
        // given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("Aleksander");
        patientEntity.setLastName("Czech");
        patientEntity.setTelephoneNumber("123123123");
        patientEntity.setEmail("wrx92022@student.merito.wroclaw.pl");
        patientEntity.setPatientNumber("028");
        patientEntity.setDateOfBirth(LocalDate.of(1999,06,28));
        patientEntity.setAge(24);
        long entitiesNumBefore = patientDao.count();

        // when
        final PatientEntity saved = patientDao.save(patientEntity);

        // then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(patientDao.count()).isEqualTo(entitiesNumBefore+1);
    }

    @Transactional
    @Test
    public void testShouldSaveAndRemovePatient() {
        // given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("Aleksander");
        patientEntity.setLastName("Czech");
        patientEntity.setTelephoneNumber("123123123");
        patientEntity.setEmail("wrx92022@student.merito.wroclaw.pl");
        patientEntity.setPatientNumber("028");
        patientEntity.setDateOfBirth(LocalDate.of(1999,06,28));
        patientEntity.setAge(24);

        // when
        final PatientEntity saved = patientDao.save(patientEntity);
        assertThat(saved.getId()).isNotNull();
        final PatientEntity newSaved = patientDao.findOne(saved.getId());
        assertThat(newSaved).isNotNull();

        patientDao.delete(saved.getId());

        // then
        final PatientEntity removed = patientDao.findOne(saved.getId());
        assertThat(removed).isNull();
    }


}
