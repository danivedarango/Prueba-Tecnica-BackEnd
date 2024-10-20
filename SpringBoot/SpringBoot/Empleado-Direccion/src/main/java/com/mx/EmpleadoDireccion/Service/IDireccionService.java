package com.mx.EmpleadoDireccion.Service;

import java.util.List;

import com.mx.EmpleadoDireccion.Entity.Direccion;


public interface IDireccionService {
	
	public void guardar(Direccion direccion);
	
	public void editar(Direccion direccion);
	
	public void eliminar(Direccion direccion);
	
	public Direccion buscar(Direccion direccion);
	
	public List<Direccion> listar();
}
