package org.example.aplication.service;

import org.example.domain.Licor;

import java.util.List;

public interface LicorService {
    void crearLicor(Licor licor);
    void actualizarLicor(Licor licor);
    void eliminarLicor(int id);
    Licor obtenerLicor(int id);
    List<Licor> obtenerTodosLosLicores();
}
