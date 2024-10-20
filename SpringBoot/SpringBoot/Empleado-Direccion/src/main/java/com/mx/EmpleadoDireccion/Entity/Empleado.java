package com.mx.EmpleadoDireccion.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Empleado {
	@Id

	private int employeeId;
	private String firstName;
	private String lastName;
	private String curp;
	private String puesto;
	private String claveUnica;

	
    // Relación Many-to-One con la entidad Empleado para manejar el jefe inmediato
    @ManyToOne
    @JoinColumn(name = "jefe_inmediato_id")
    private Empleado jefeInmediatoId;

    // Relación One-to-Many para tener una lista de subordinados
    @OneToMany(mappedBy = "jefeInmediatoId")
    private List<Empleado> subordinados = new ArrayList<>();

    // Relación One-to-One con Direccion
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;
    

}
 