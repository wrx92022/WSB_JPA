package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PatientTOTest {

    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientMapper patientMapper;

    @Test
    public void testFindPatientById_ReturnsCorrectPatientTO() {
        // Arrange
        MockitoAnnotations.initMocks(this);
        Long patientId = 1L;
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientId);
        patientEntity.setFirstName("Jan");
        patientEntity.setLastName("Nowak");
        patientEntity.setDateOfBirth(LocalDate.of(1990, 5, 15));

        PatientTO expectedPatientTO = new PatientTO();
        expectedPatientTO.setId(patientId);
        expectedPatientTO.setFirstName("Jan");
        expectedPatientTO.setLastName("Nowak");
        expectedPatientTO.setDateOfBirth(LocalDate.of(1990, 5, 15));

        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patientEntity));
        when(patientMapper.mapToTO(patientEntity)).thenReturn(expectedPatientTO);

        // Act
        PatientTO actualPatientTO = patientService.findById(patientId);

        // Assert
        assertEquals(expectedPatientTO.getId(), actualPatientTO.getId());
        assertEquals(expectedPatientTO.getFirstName(), actualPatientTO.getFirstName());
        assertEquals(expectedPatientTO.getLastName(), actualPatientTO.getLastName());
        assertEquals(expectedPatientTO.getDateOfBirth(), actualPatientTO.getDateOfBirth());
    }
}
