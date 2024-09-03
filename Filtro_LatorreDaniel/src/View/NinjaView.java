package View;

import Controller.NinjaController;
import Model.Ninja;
import java.math.BigDecimal;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class NinjaView {
    private static final Scanner scanner = new Scanner(System.in);
    private NinjaController ninjaController = new NinjaController();

    public void displayMenu() {
        while (true) {
            System.out.println("Ninjas:D");
            System.out.println("1. Agregar Ninjas");
            System.out.println("2. Listar Ninjas");
            System.out.println("3. Actualizar Ninja");
            System.out.println("4. Eliminar Ninja");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        agregarNinja();
                        break;
                    case 2:
                        listarNinja();
                        break;
                    case 3:
                        actualizarNinja();
                        break;
                    case 4:
                        eliminarNinja();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (SQLException e) {
                System.err.println("Error de base de datos: " + e.getMessage());
            }
        }
    }

    private void agregarNinja() throws SQLException {
        System.out.print("Ingrese el nombre del Ninja: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese el Rango: ");
        String rango = scanner.nextLine();
        System.out.print("Ingrese el Aldea: ");
        String aldea = scanner.nextLine();
        Ninja ninja = new Ninja(0, name, rango, aldea);
        ninjaController.addNinja(ninja);
        System.out.println("Ninja agregado.");
    }

    private void listarNinja() throws SQLException {
        List<Ninja> ninjas = ninjaController.getAllNinjas();
        for (Ninja ninja : ninjas) {
            System.out.println("ID: " + ninja.getId());
            System.out.println("Nombre: " + ninja.getName());
            System.out.println("Rango: " + ninja.getElo());
            System.out.println("Aldea:" + ninja.getAldea());
            System.out.println("-----");
        }
    }

    private void actualizarNinja() throws SQLException {
        System.out.print("Ingrese el ID del Ninja a actualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Ninja ninja = ninjaController.getNinja(id);
        if (ninja != null) {
            System.out.print("Ingrese el nuevo nombre: ");
            ninja.setName(scanner.nextLine());
            System.out.print("Ingrese el nuevo rango: ");
            ninja.setRango(scanner.nextLine());
            System.out.print("Ingrese el nuevo Aldea: ");
            ninja.setAldea(scanner.nextLine());
            ninjaController.updateNinja(ninja);
            System.out.println("Ninja actualizado.");
        } else {
            System.out.println("Ninja no encontrado.");
        }
    }

    private void eliminarNinja() throws SQLException {
        System.out.print("Ingrese el ID del Ninja a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());
        ninjaController.deleteNinja(id);
        System.out.println("Restaurante eliminado.");
    }
}
