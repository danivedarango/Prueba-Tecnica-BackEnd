package com.mx.EmpleadoDireccion.Service;

import java.util.List;

import com.mx.EmpleadoDireccion.Entity.Empleado;

public interface IEmpleadoService {
	
	public void guardar(Empleado empleado);
	
	public void editar(Empleado empleado);
	
	public void eliminar(Empleado empleado);
	
	public Empleado buscar(Empleado empleado);
	
	public List<Empleado> listar();
}
