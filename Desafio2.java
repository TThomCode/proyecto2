package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Alumno {
    String nombre;
    String apellido;
    int numeroExamen;
    double nota;

    Alumno(String nombre, String apellido, int numeroExamen, double nota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroExamen = numeroExamen;
        this.nota = nota;
    }
}

public class Desafio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // menu alumnos
        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = scanner.nextInt();
        scanner.nextLine(); // Consume el salto de línea pendiente

        Alumno[] alumnos = new Alumno[cantidadAlumnos];

        for (int i = 0; i < cantidadAlumnos; i++) {
            // ingresar datos alumnos
            System.out.println("Ingrese los datos del alumno " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Número de examen: ");
            int numeroExamen = scanner.nextInt();
            System.out.print("Nota: ");
            double nota = scanner.nextDouble();
            scanner.nextLine(); // Consume el salto de línea pendiente

            alumnos[i] = new Alumno(nombre, apellido, numeroExamen, nota);
        }

        // Variables de notas
        Alumno mejorNota = null;
        Alumno peorNota = null;
        int cantidadPromocionados = 0;
        int cantidadRecursantes = 0;
        List<Alumno> alumnosCalifBaja = new ArrayList<>();
        List<Alumno> alumnosMejorNota = new ArrayList<>();
        double notaMejor = Double.MIN_VALUE;

        // Ciclo de repetición
        for (Alumno alumno : alumnos) {

            if (mejorNota == null || alumno.nota > mejorNota.nota) {
                mejorNota = alumno;
            }

            if (peorNota == null || alumno.nota < peorNota.nota) {
                peorNota = alumno;
            }

            if (alumno.nota >= 7) {
                cantidadPromocionados++;
            } else {
                cantidadRecursantes++;
                alumnosCalifBaja.add(alumno);
            }
        }

        // Mostrar resultados
        System.out.println("\nResultados:");
        // calificacion mas alta
        System.out.print("Alumno/s con la calificación más alta: ");

        for (Alumno alumno : alumnos) {
            if (alumno.nota > notaMejor) {
                notaMejor = alumno.nota;
                alumnosMejorNota.add(alumno);
            } else if (alumno.nota == notaMejor || alumno.nota >= 7) {
                alumnosMejorNota.add(alumno);
            }
        }

        if (alumnosMejorNota.isEmpty()) {
            System.out.println("Ninguno");
        } else {
            for (Alumno alumno : alumnosMejorNota) {
                System.out.print(alumno.nombre + " " + alumno.apellido + ", ");
            }
            System.out.println();
        }
        // calificacion mas baja
        System.out.print("Alumno/s con la calificación más baja: ");
        if (alumnosCalifBaja.isEmpty()) {
            System.out.println("Ninguno");
        } else {
            for (Alumno alumno : alumnosCalifBaja) {
                System.out.print(alumno.nombre + " " + alumno.apellido + ", ");
            }
            System.out.println();
        }
        // promocion de alumnos
        System.out.println("Cantidad de alumnos que promocionan: " + cantidadPromocionados);
        // alumnos recursados
        System.out.println("Cantidad de alumnos que deben recursar: " + cantidadRecursantes);

        // Mostrar listado de alumnos y sus notas
        System.out.println("\nListado de alumnos y sus notas:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.nombre + " " + alumno.apellido + ": " + alumno.nota);
        }

        // Cerrar scanner
        scanner.close();

    }
}
// Thomas Depari:)
