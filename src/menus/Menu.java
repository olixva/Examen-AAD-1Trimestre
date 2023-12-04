package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            menu();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un valor entero valido.");
        } finally {
            sc.close();
        }
    }

    // Menu general
    public static void menu() {
        boolean continuar = true;

        while (continuar) {

            int tabla = getTabla();

            switch (tabla) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    
                    break;

            }
        }
    }

    private static int getTabla() {
        System.out.println("\n-----------MENU-----------");
        System.out.println("1.- Alumno");
        System.out.println("0.- Salir");

        return sc.nextInt();
    }

    // Opciones generales para algunos submenus
    public static int opciones(String tabla) {
        System.out.println("\n---------" + tabla + "---------");

        System.out.println("1.- Listar " + tabla);
        System.out.println("2.- Crear " + tabla);
        System.out.println("3.- Actualizar " + tabla);
        System.out.println("4.- Eliminar " + tabla);
        System.out.println("5.- Volver");

        System.out.print("Elige una opcion: ");
        return sc.nextInt();
    }
}