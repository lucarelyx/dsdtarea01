package com.clinica.crudclinica.facade;

import com.clinica.crudclinica.entity.Patient;

import java.util.List;

public interface FacadePatient {
    List<Patient> obtainPatient();
    Patient obtainPatientId(Long id);
    Patient createPatient(Patient patient);
    Patient updatePatient(Patient patient);
    Patient deletePatient(Long id);
}
