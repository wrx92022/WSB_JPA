package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PatientServiceTest {

    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientMapper patientMapper;

    @Test
    public void testDeletePatient_RemovesPatient() {

        MockitoAnnotations.initMocks(this);
        Long patientId = 1L;
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientId);

        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patientEntity));

        patientService.deleteById(patientId);

        verify(patientRepository, times(1)).deleteById(patientId);
    }
}