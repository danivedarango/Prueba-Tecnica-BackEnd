package com.mx.EmpleadoDireccion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.EmpleadoDireccion.Entity.Empleado;

@Repository
public interface IEmpleado extends JpaRepository<Empleado, Integer>{

}
