package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public List<PatientTO> findAll() {
        final List<PatientEntity> entities = patientDao.findAll();
        return entities.stream().map(PatientMapper::mapToTO).collect(Collectors.toList());
    }

    @Override
    public List<VisitTO> findVisitsByPatientId(Long id) {
        return patientDao.findVisitsByPatientId(id).stream().map(VisitMapper::mapToTO).collect(Collectors.toList());
    }

    @Override
    public PatientTO findById(final Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public void deleteById(final Long id) {
        patientDao.delete(id);
    }

}
