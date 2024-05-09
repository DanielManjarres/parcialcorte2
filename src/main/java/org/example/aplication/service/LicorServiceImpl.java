package org.example.aplication.service;

import org.example.domain.Licor;
import org.example.interfaces.LicorRepository;

import java.util.List;

public class LicorServiceImpl implements LicorService{
    private LicorRepository licorRepository;

    public LicorServiceImpl(LicorRepository licorRepositorio) {
        this.licorRepository = licorRepositorio;
    }

    @Override
    public void crearLicor(Licor licor) {
        licorRepository.guardar(licor);
    }

    @Override
    public void actualizarLicor(Licor licor) {
        licorRepository.actualizar(licor);
    }

    @Override
    public void eliminarLicor(int id) {
        licorRepository.eliminar(id);
    }

    @Override
    public Licor obtenerLicor(int id) {
        return licorRepository.obtener(id);
    }

    @Override
    public List<Licor> obtenerTodosLosLicores() {
        return licorRepository.obtenerTodos();
    }
}
