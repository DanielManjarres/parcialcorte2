package org.example.aplication;

import org.example.aplication.service.LicorService;
import org.example.aplication.service.LicorServiceImpl;
import org.example.domain.Licor;
import org.example.infraestructure.repository.LicorRepositoryImpl;
import org.example.interfaces.LicorRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    LicorRepository licorRepositorio = new LicorRepositoryImpl();
    LicorService licorService = new LicorServiceImpl(licorRepositorio);
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        LicorRepository licorRepositorio = new LicorRepositoryImpl();
        LicorService licorService = new LicorServiceImpl(licorRepositorio);
        int opcion;
        Licor nuevoLicor = new Licor(1,"Tequila","botella",29);
        licorService.crearLicor(nuevoLicor);

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    crearLicor();
                    break;
                case 2:
                    actualizarLicor();
                    break;
                case 3:
                    eliminarLicor();
                    break;
                case 4:
                    obtenerLicor();
                    break;
                case 5:
                    obtenerTodosLosLicores();
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú de Licores");
        System.out.println("1. Crear licor");
        System.out.println("2. Actualizar licor");
        System.out.println("3. Eliminar licor");
        System.out.println("4. Obtener licor por ID");
        System.out.println("5. Obtener todos los licores");
        System.out.println("6. Salir");
        System.out.print("Ingrese una opción: ");
    }

    private static void crearLicor() {

        System.out.print("Ingrese el ID del licor: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el nombre del licor: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la presentación del licor: ");
        String presentacion = scanner.nextLine();
        System.out.print("Ingrese el valor del licor: ");
        double valor = scanner.nextDouble();
        Licor nuevoLicor = new Licor(id,nombre,presentacion,valor);
        licorService.crearLicor(nuevoLicor);
        System.out.println("Licor creado exitosamente.");
    }

    private static void actualizarLicor() {
        System.out.print("Ingrese el ID del licor a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el nuevo nombre del licor: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la nueva presentación del licor: ");
        String presentacion = scanner.nextLine();
        System.out.print("Ingrese el nuevo valor del licor: ");
        double valor = scanner.nextDouble();

        Licor licorActualizado = new Licor(id, nombre, presentacion, valor);
        actualizarLicor();
        System.out.println("Licor actualizado exitosamente.");
    }

    private static void eliminarLicor() {
        System.out.print("Ingrese el ID del licor a eliminar: ");
        int id = scanner.nextInt();
        licorService.eliminarLicor(id);
        System.out.println("Licor eliminado exitosamente.");
    }

    private static void obtenerLicor() {
        System.out.print("Ingrese el ID del licor a obtener: ");
        int id = scanner.nextInt();
        Licor licor = obtenerLicor(id);
        if (licor != null) {
            System.out.println("Licor encontrado:");
            System.out.println(licor);
        } else {
            System.out.println("No se encontró ningún licor con ese ID.");
        }
    }

    private static void obtenerTodosLosLicores() {
        List<Licor> licores = obtenerTodosLosLicores();
        if (licores.isEmpty()) {
            System.out.println("No hay licores registrados.");
        } else {
            System.out.println("Licores registrados:");
            for (Licor licor : licores) {
                System.out.println(licor);
            }
        }
    }
}
