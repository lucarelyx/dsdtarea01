package com.clinica.crudclinica.facade;

import com.clinica.crudclinica.entity.Patient;
import com.clinica.crudclinica.services.ServicesPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/home")
public class FacadePatientImpl implements FacadePatient{

    @Autowired
    private ServicesPatient servicesPatient;

    @GetMapping("/patients")
    public List<Patient> obtainPatient() {
        List<Patient> p = null;
        try {
            p = servicesPatient.obtainPatient();
            if(!p.isEmpty()){
                p = servicesPatient.obtainPatient();
            }else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No hay datos para mostrar");
            }
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al listar");
        }
        return p;
    }

    @GetMapping("/patient/{id}")
    public Patient obtainPatientId(@PathVariable(value = "id") Long id) {
        Patient p = null;
        try {
            p = servicesPatient.obtainPatientId(id);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Id inexistente");
        }
        return p;
    }

    @PostMapping("/patient")
    public Patient createPatient(@RequestBody Patient patient) {
        Patient p = null;
        try {
            p = servicesPatient.createPatient(patient);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede crear");
        }
        return p;
    }

    @PutMapping("/patient")
    public Patient updatePatient(@RequestBody Patient patient) {
        Patient p = null;
        try {
            Patient a = servicesPatient.obtainPatientId(patient.getId());
            p = servicesPatient.updatePatient(patient);

        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede actualizar id inexistente");
        }
        return p;

    }

    @DeleteMapping("/patient/{id}")
    public Patient deletePatient(@PathVariable(value = "id") Long id) {
        Patient p = null;
        try {
            Patient a = servicesPatient.obtainPatientId(id);
            p = servicesPatient.deletePatient(id);

        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede eliminar id inexistente");
        }
        return p;
    }
}
