package com.clinica.crudclinica.repository;

import com.clinica.crudclinica.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryPatient  extends CrudRepository<Patient, Long> {
}
