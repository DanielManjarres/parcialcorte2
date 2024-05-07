package org.example.infraestructure.repository;

import org.example.domain.Licor;
import org.example.interfaces.LicorRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LicorRepositoryImpl implements LicorRepository {
    private String archivo = "licores.dat";

    @Override
    public void guardar(Licor licor) {
        List<Licor> licores = obtenerTodos();
        licores.add(licor);
        escribirArchivo(licores);
    }

    @Override
    public void actualizar(Licor licor) {
        List<Licor> licores = obtenerTodos();
        for (int i = 0; i < licores.size(); i++) {
            if (licores.get(i).getId() == licor.getId()) {
                licores.set(i, licor);
                break;
            }
        }
        escribirArchivo(licores);
    }

    @Override
    public void eliminar(int id) {
        List<Licor> licores = obtenerTodos();
        licores.removeIf(licor -> licor.getId() == id);
        escribirArchivo(licores);

    }

    @Override
    public Licor obtener(int id) {
        List<Licor> licores = obtenerTodos();
        return licores.stream()
                .filter(licor -> licor.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Licor> obtenerTodos() {
        return leerArchivo();
    }
    private List<Licor> leerArchivo() {
        try {
            FileInputStream fileIn = new FileInputStream(archivo);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            List<Licor> licores = (List<Licor>) in.readObject();
            in.close();
            fileIn.close();
            return licores;
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void escribirArchivo(List<Licor> licores) {
        try {
            FileOutputStream fileOut = new FileOutputStream(archivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(licores);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
