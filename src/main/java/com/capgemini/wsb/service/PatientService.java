package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;

import java.util.List;

public interface PatientService{
    PatientTO findById(Long id);

    List<PatientTO> findAll();

    PatientTO deleteByID(Long id);

    void deleteById(Long patientId);

    List<PatientTO> findPatientOlderThanX(int age);
}
