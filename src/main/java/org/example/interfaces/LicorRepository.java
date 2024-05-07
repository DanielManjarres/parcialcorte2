package org.example.interfaces;

import org.example.domain.Licor;

import java.util.List;

public interface LicorRepository {
    void guardar(Licor licor);
    void actualizar(Licor licor);
    void eliminar(int id);
    Licor obtener(int id);
    List<Licor> obtenerTodos();
}
