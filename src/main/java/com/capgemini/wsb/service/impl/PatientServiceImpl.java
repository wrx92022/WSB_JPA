package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PatientServiceImpl implements PatientService
{
    private final PatientDao addressDao;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao)
    {
        addressDao = pPatientDao;
    }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity entity = addressDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public List<PatientTO> findAll() {
        return List.of();
    }

    @Override
    public PatientTO deleteByID(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long patientId) {

    }

    @Override
    public List<PatientTO> findPatientOlderThanX(int age) {
        return List.of();
    }
}
