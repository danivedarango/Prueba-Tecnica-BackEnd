package com.mx.EmpleadoDireccion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.EmpleadoDireccion.Entity.Empleado;
import com.mx.EmpleadoDireccion.Repository.IEmpleado;

@Service
public class EmpleadoServiceImp implements IEmpleadoService {

    @Autowired
    private IEmpleado dao;


    @Override
    public void guardar(Empleado empleado) {
        // Generar clave única basada en los primeros 10 caracteres de la CURP más 2 dígitos extra
        String claveUnica = generarClaveUnica(empleado.getCurp());
        empleado.setClaveUnica(claveUnica);

        // Manejo de puesto opcional (si no se proporciona, se asigna null)
        if (empleado.getPuesto() == null || empleado.getPuesto().isEmpty()) {
            empleado.setPuesto(null);
        }

        // Manejo de jefe inmediato (si no se proporciona, se asigna null)
        if (empleado.getJefeInmediatoId() == null) {
            empleado.setJefeInmediatoId(null);
        }

        dao.save(empleado);
    }


    @Override
    public void editar(Empleado empleado) {
        Empleado empleadoExistente = dao.findById(empleado.getEmployeeId()).orElse(null);
        if (empleadoExistente != null) {
            // Actualizar solo los campos que necesitas modificar
            empleadoExistente.setFirstName(empleado.getFirstName());
            empleadoExistente.setLastName(empleado.getLastName());
            empleadoExistente.setPuesto(empleado.getPuesto()); // Permite modificar el puesto
            empleadoExistente.setJefeInmediatoId(empleado.getJefeInmediatoId()); // Permite modificar el jefe inmediato
            dao.save(empleadoExistente);
        }
    }

    @Override
    public void eliminar(Empleado empleado) {
        dao.delete(empleado);
    }

    @Override
    public Empleado buscar(Empleado empleado) {
        return dao.findById(empleado.getEmployeeId()).orElse(null);
    }

    @Override
    public List<Empleado> listar() {
        return dao.findAll();
    }

    // Método para generar la clave única basada en CURP
    private String generarClaveUnica(String curp) {
        if (curp.length() >= 10) {
            String primeros10 = curp.substring(0, 10);
            int digitosExtra = (int) (Math.random() * 100);
            return primeros10 + String.format("%02d", digitosExtra);
        } else {
            throw new IllegalArgumentException("La CURP debe tener al menos 10 caracteres");
        }
    }


	public Empleado findById(int employeeId) {
		return dao.findById(employeeId).orElse(null);
	}
    
    
}

