package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

import java.util.Collections;
import java.util.stream.Collectors;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


public final class DoctorMapper {


    public static DoctorTO mapToTO(final DoctorEntity doctorEntity)
    {

        final DoctorTO doctorTO = new DoctorTO();

        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTO.setSpecialization(doctorEntity.getSpecialization());

        final Collection<AddressTO> addresses = new ArrayList<>(Collections.emptyList());

        if (doctorEntity.getAddresses() != null)
        {
            addresses.addAll(doctorEntity.getAddresses().stream()
                    .map(AddressMapper::mapToTO)
                    .collect(Collectors.toList()));
        }
        doctorTO.setAddresses(addresses);


        final Collection<VisitTO> visits = new ArrayList<>(Collections.emptyList());

        if (doctorEntity.getVisits() != null)
        {
            visits.addAll(doctorEntity.getVisits().stream()
                    .map(VisitMapper::mapToTO)
                    .collect(Collectors.toList()));
        }
        doctorTO.setVisits(visits);

        return doctorTO;
    }

}