package principal;

import java.util.Scanner;

public class desafio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // int de variable de dia,mes,año
        int dias, mes, anios;

        // menu de consola
        System.out.println("---Abriendo Consola---");

        // Ingresar día del 01 al 31
        System.out.print("Ingrese el día (01 - 31): ");
        dias = scanner.nextInt();

        // Ingresar mes del 01 al 12
        System.out.print("Ingrese el mes (01 - 12): ");
        mes = scanner.nextInt();

        // Ingresar año dentro del rango permitido (1900-2099)
        System.out.print("Ingrese el año (1900 - 2099): ");
        anios = scanner.nextInt();

        boolean fechaValida = true;
        // if de dia invalido
        if (dias < 1 || dias > 31) {
            fechaValida = false;
            System.out.println("Día inválido.");
        }
        // if y else if de mes o dia invalido en febrero
        if (mes < 1 || mes > 12) {
            fechaValida = false;
            System.out.println("Mes inválido.");
        } else if (mes == 2) {
            if ((esBisiesto(anios) && dias > 29) || (!esBisiesto(anios) && dias > 28)) {
                fechaValida = false;
                System.out.println("Día inválido para febrero.");
            }
        }
        // if de año invalido
        if (anios < 1900 || anios > 2099) {
            fechaValida = false;
            System.out.println("Año inválido.");
        }
        // if de año valido
        if (fechaValida) {
            System.out.println("Fecha válida.");

            // Indicar si el año es bisiesto
            if (esBisiesto(anios)) {
                System.out.println(anios + " es un año bisiesto.");
            } else {
                System.out.println(anios + " no es un año bisiesto.");
            }
        }
        // print de validacion de la fecha,mes, año que ingreso el usuario
        System.out.println("Usted ingreso el dia " + dias + " Del mes " + mes + " del año " + anios);
        scanner.close();
    }

    public static boolean esBisiesto(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
// Thomas Depari :)