package com.mx.EmpleadoDireccion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.EmpleadoDireccion.Entity.Direccion;
import com.mx.EmpleadoDireccion.Repository.IDireccion;

@Service
public class DireccionServiceImp implements IDireccionService{
	@Autowired
	private IDireccion dao;

	@Override
	public void guardar(Direccion direccion) {
		dao.save(direccion);
		
	}

	@Override
	public void editar(Direccion direccion) {
		dao.save(direccion);
		
	}

	@Override
	public void eliminar(Direccion direccion) {
		dao.delete(direccion);
		
	}

	@Override
	public Direccion buscar(Direccion direccion) {
		return dao.findById(direccion.getDireccionId()).orElse(null);
	}

	@Override
	public List<Direccion> listar() {
		return dao.findAll();
	}

}
