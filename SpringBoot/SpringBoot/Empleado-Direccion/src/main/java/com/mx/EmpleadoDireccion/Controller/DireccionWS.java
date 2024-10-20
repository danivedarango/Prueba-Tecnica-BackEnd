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

import com.mx.EmpleadoDireccion.Entity.Direccion;
import com.mx.EmpleadoDireccion.Service.DireccionServiceImp;
@RestController
@RequestMapping(path = "Direccion")
@CrossOrigin
public class DireccionWS {
	// URL: http://localhost:8001/Direccion
	@Autowired
	DireccionServiceImp service;

	// listar --> http://localhost:8001/Direccion/listar
	@GetMapping(value = "listar")
	public ResponseEntity<?> listar() { 
										
		List<Direccion> direcciones = service.listar();
		if (direcciones.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay registros");
		} else {
			return ResponseEntity.ok(direcciones);
		}
	}

	// guardar -->http://localhost:8001/Direccion/guardar
	@PostMapping(value = "guardar")
	public ResponseEntity<String> guardar(@RequestBody Direccion direccion) {
		service.guardar(direccion);
		return ResponseEntity.ok("La direccion: " + direccion.getDireccionId() + " se guardó exitosamente");
	}

	// buscar -->http://localhost:8001/Direccion/buscar
	@PostMapping(value = "buscar")
	public ResponseEntity<Direccion> buscar(@RequestBody Direccion direccion) {
		Direccion encontrado = service.buscar(direccion);
		return ResponseEntity.ok(encontrado);
	}

	// editar -->http://localhost:8001/Direccion/editar
	@PutMapping(value = "editar")
	public ResponseEntity<String> editar(@RequestBody Direccion direccion) {
		service.editar(direccion);
		return ResponseEntity.ok("La direccion: " + direccion.getDireccionId() + " se editó correctamente");
	}

	// eliminar -->http://localhost:8001/Direccion/eliminar
	@DeleteMapping(value = "eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Direccion direccion) {
		service.eliminar(direccion);
		return ResponseEntity.ok("La direccion: " + direccion.getDireccionId() + " se eliminó correctamente");
	}
}
