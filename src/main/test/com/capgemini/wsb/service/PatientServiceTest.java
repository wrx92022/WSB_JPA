package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.repository.PatientRepository;
import com.capgemini.wsb.persistence.repository.VisitRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    private PatientEntity patient;

    @BeforeEach
    public void setUp() {
        patient = new PatientEntity("Jan", "Kowalski", "123456789", "jan.kowalski@example.com", "123", LocalDate.of(1990, 1, 1), 30);
        patientRepository.save(patient);

        VisitEntity visit = new VisitEntity();
        visit.setDescription("Kontrola");
        visit.setTime(LocalDateTime.now());
        visit.setPatient(patient);
        visitRepository.save(visit);
    }

    @Test
    @Transactional
    public void testDeletePatientById() {
        Long patientId = patient.getId();
        Assertions.assertTrue(patientRepository.existsById(patientId));

        patientService.deleteById(patientId);

        Assertions.assertFalse(patientRepository.existsById(patientId));
        Assertions.assertTrue(visitRepository.findAll().isEmpty());
    }

    @Test
    @Transactional
    public void testFindById() {
        Long patientId = patient.getId();
        PatientTO patientTO = patientService.findById(patientId);
        Assertions.assertNotNull(patientTO);

        Assertions.assertEquals("Jan", patientTO.getFirstName());
        Assertions.assertEquals(30, patientTO.getAge());
    }
}
