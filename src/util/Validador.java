package util;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import dao.*;

public class Validador {

    private static Scanner sc = new Scanner(System.in);

    
    /**
     * La función "pedir" toma una expresión regular y un mensaje como entrada, solicita la entrada al
     * usuario hasta que la entrada coincida con la expresión regular y devuelve la entrada válida.
     * 
     * @param regex El patrón de expresión regular con el que debe coincidir la entrada.
     * @param mensaje El parámetro "mensaje" es una cadena que representa el mensaje que se mostrará
     * cuando el usuario ingresa una entrada no válida.
     * @return El método devuelve un valor de cadena.
     */
    private static String pedir(String regex, String mensaje) {

        String entrada;

        boolean terminado = false;
        while (!terminado) {

            entrada = sc.next();

            if (entrada.matches(regex)) {
                terminado = true;
                return entrada;
            } else {
                System.out.println(mensaje);
            }
        }
        return null;
    }
    
    public static String pedirNumeroRegional() {

        return pedir("^\\d{5,8}$", "El formato no es valido, pruebe de nuevo:");
        
    }

    public static String pedirDni() {

        String dni;

        boolean terminado = false;
        while (!terminado) {

            dni = sc.next();

            if (dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
                int numero = Integer.parseInt(dni.substring(0, 8));
                char letraCalculada = calcularLetraDNI(numero);
                char letraIntroducida = dni.charAt(8);

                if (letraCalculada == letraIntroducida) {
                    return dni;
                } else {
                    System.out
                            .println("La letra que has introducido no corresponde a el DNI.\nLa que le corresponde es "
                                    + letraCalculada);
                }
            } else {
                System.out.println("El formato no es valido, pruebe de nuevo:");
            }
        }
        return null;
    }

    public static char calcularLetraDNI(int numero) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = numero % 23;
        return letras.charAt(indice);
    }

    public static String pedirCp() {

        CodigopostalDAO cpDao = new CodigopostalDAO(); 
        String cp;

        boolean terminado = false;
        while (!terminado) {

            cp = sc.next();

            if (cp.matches("\\b\\d{5}\\b") && cpDao.exist(cp)) {
                terminado = true;
                return cp;
            } else {
                System.out.println("El formato no es valido, pruebe de nuevo:");
            }
        }
        return null;
    }
    
    public static int pedirNumeroInt() {
        int numero;
        boolean terminado = false;

        while (!terminado) {
            try {
                numero = sc.nextInt();

                if (numero >= 0 && numero<= 30) {
                    terminado = true;
                    return numero;
                } else {
                    System.out.println("El número debe estar en el rango de 0 a 30. Intentelo de nuevo:");
                }
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Por favor, ingrese un número entero válido:");
            }
        }
        return 0; 
    }
}
