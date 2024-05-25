package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@OneToMany(mappedBy = "visit")
	private List<MedicalTreatmentEntity> medicalTreatments;		//relacja jeden do wielu (rodzic)

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private DoctorEntity doctor;	// relacja wielu do jednego (dziecko)

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;	// relacja wielu do jednego (dziecko)

	public VisitEntity() {
	}

	public VisitEntity(String description, LocalDateTime time, PatientEntity patient, DoctorEntity doctor) {
		this.description = description;
		this.time = time;
		this.patient = patient;
		this.doctor = doctor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public PatientEntity getPatient() {return patient;}

	public void setPatient(PatientEntity patient) {this.patient = patient;}

	public DoctorEntity getDoctor() {return doctor;}

	public void setDoctor(DoctorEntity doctor) { this.doctor = doctor; }

}
