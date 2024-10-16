package org.example;

import java.util.Scanner;

public class LigaAcb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el nombre de la clasificacion:");
        String str = sc.nextLine();
        Clasificacion clasificacion = new Clasificacion(str);
        ClasificacionFileDao clasificacionDAO = new ClasificacionFileDao("./");



        while (true) {
            System.out.println("1. Añadir equipo");
            System.out.println("2. Mostrar clasificación");
            System.out.println("3. Guardar clasificación");
            System.out.println("4. Cargar clasificación");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del equipo: ");
                    String nombre = sc.nextLine();
                    System.out.print("Victorias: ");
                    int victorias = sc.nextInt();
                    System.out.print("Derrotas: ");
                    int derrotas = sc.nextInt();
                    System.out.print("Puntos a favor: ");
                    int puntosAfavor = sc.nextInt();
                    System.out.print("Puntos en contra: ");
                    int puntosEnContra = sc.nextInt();

                    Equipo equipo = new Equipo(nombre, victorias, derrotas, puntosAfavor, puntosEnContra);
                    clasificacion.addEquipo(equipo);
                    break;

                case 2:
                    System.out.println(clasificacion);
                    break;

                case 3:
                    System.out.println();
                    System.out.println();
                    clasificacionDAO.save(clasificacion);
                    System.out.println("Clasificación guardada.");
                    System.out.println();
                    System.out.println();
                    break;

                case 4:
                    System.out.println();
                    System.out.println();
                    clasificacion = clasificacionDAO.get(clasificacion.getCompeticion());
                    System.out.println("Clasificación cargada.");
                    System.out.println();
                    System.out.println();
                    break;

                case 5:
                    System.out.println("¿Está seguro de que quiere salir? (s/n)");
                    String confirmacion = sc.nextLine();
                    if (confirmacion.equalsIgnoreCase("s")) {
                        System.exit(0);
                    }
                    break;

                default:
                    System.out.println();
                    System.out.println();
                    System.out.println("Opción no válida.");
                    System.out.println();
                    System.out.println();
            }
        }
    }
}



