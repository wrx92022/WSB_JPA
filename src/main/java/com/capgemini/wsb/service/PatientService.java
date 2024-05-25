package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Autowired
    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public void deleteById(Long id) {
        Optional<PatientEntity> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            patientRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Pacjent z ID:  " + id + " nie znaleziony.");
        }
    }

    public PatientTO findById(Long id) {
        Optional<PatientEntity> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            return patientMapper.mapToTO(patientOptional.get());
        } else {
            throw new IllegalArgumentException("Pacjent z ID:  " + id + " nie znaleziony.");
        }
    }

    private EntityManager entityManager;

    public List<PatientEntity> findAllPatients() {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p", PatientEntity.class);
        return query.getResultList();
    }
}
