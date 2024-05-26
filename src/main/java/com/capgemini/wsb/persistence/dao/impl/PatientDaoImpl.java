package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public List<PatientEntity> findByVisitsCountGreaterThan(Long visitsCount) {
        return entityManager.createQuery("select distinct pat from PatientEntity pat " +
                        " join pat.visits vis" +
                        " group by pat having count(vis) > :visitsCount", PatientEntity.class)
                .setParameter("visitsCount", visitsCount)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findByHeightGreaterThan(Integer height) {
        return entityManager.createQuery("select pat from PatientEntity pat" +
                        " where pat.height > :height", PatientEntity.class)
                .setParameter("height", height)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery("select pat from PatientEntity pat where pat.lastName like :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<VisitEntity> findVisitsByPatientId(Long id) {
        return entityManager.createQuery("select vis from VisitEntity vis where vis.patient.id = :id", VisitEntity.class)
                .setParameter("id", id)
                .getResultList();
    }
}