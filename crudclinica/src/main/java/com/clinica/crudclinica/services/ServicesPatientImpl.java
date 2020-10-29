package com.clinica.crudclinica.services;

import com.clinica.crudclinica.entity.Patient;
import com.clinica.crudclinica.repository.RepositoryPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServicesPatientImpl implements ServicesPatient{

    @Autowired
    private RepositoryPatient repositoryPatient;

    @Override
    public List<Patient> obtainPatient() {
        return (List<Patient>) repositoryPatient.findAll();
    }

    @Override
    public Patient obtainPatientId(Long id) {
        return repositoryPatient.findById(id).get();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Patient createPatient(Patient patient) {
        return repositoryPatient.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return repositoryPatient.save(patient);
    }

    @Override
    public Patient deletePatient(Long id) {
        Patient p = obtainPatientId(id);
        repositoryPatient.delete(p);
        return p;
    }
}
