package com.mx.EmpleadoDireccion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.EmpleadoDireccion.Entity.Empleado;
import com.mx.EmpleadoDireccion.Service.EmpleadoServiceImp;

@RestController
@RequestMapping(path = "Empleado")
@CrossOrigin
public class EmpleadoWS {
	// URL: http://localhost:8001/Empleado
	@Autowired
	EmpleadoServiceImp service;

	// listar --> http://localhost:8001/Empleado/listar
	@GetMapping(value = "listar")
	public ResponseEntity<?> listar() { 
										
		List<Empleado> empleados = service.listar();
		if (empleados.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay registros");
		} else {
			return ResponseEntity.ok(empleados);
		}
	}

	// guardar -->http://localhost:8001/Empleado/guardar
	@PostMapping(value = "guardar")
	public ResponseEntity<String> guardar(@RequestBody Empleado empleado) {
	    service.guardar(empleado);
	    return ResponseEntity.ok("El empleado: " + empleado.getFirstName() + " se guardó exitosamente");
	}

	// buscar -->http://localhost:8001/Empleado/buscar
	@PostMapping(value = "buscar")
	public ResponseEntity<Empleado> buscar(@RequestBody Empleado empleado) {
		Empleado encontrado = service.buscar(empleado);
		return ResponseEntity.ok(encontrado);
	}

	// editar -->http://localhost:8001/Empleado/editar
	@PutMapping(value = "editar")
	public ResponseEntity<String> editar(@RequestBody Empleado empleado) {
		service.editar(empleado);
		return ResponseEntity.ok("El empleado: " + empleado.getFirstName() + " se editó correctamente");
	}

	// eliminar -->http://localhost:8001/Empleado/eliminar
	@DeleteMapping(value = "eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Empleado empleado) {
		service.eliminar(empleado);
		return ResponseEntity.ok("El empleado: " + empleado.getFirstName() + " se eliminó correctamente");
	}

}
