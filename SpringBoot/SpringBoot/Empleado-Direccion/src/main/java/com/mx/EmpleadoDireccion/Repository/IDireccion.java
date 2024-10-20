package com.mx.EmpleadoDireccion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.EmpleadoDireccion.Entity.Direccion;

@Repository
public interface IDireccion extends JpaRepository<Direccion, Integer>{

}
