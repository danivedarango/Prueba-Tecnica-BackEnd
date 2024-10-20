package com.mx.EmpleadoDireccion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Direccion {
	@Id
	private int direccionId;
	private String calle;
    private String noExterior;
    private String noInterior;
    private String colonia;
    private String municipio;
    private String estado;
    private String pais;
    
    // Relación One-to-One con Empleado
    @OneToOne(mappedBy = "direccion")
    private Empleado empleado;
}
