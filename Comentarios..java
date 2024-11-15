package GestionStock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comentarios {
    static List<String[]> dataEntries = new ArrayList<>();

    public static void IngresarComentarios(String[] args) {
       // List<String[]> dataEntries = new ArrayList<>();
        Scanner scannerc = new Scanner(System.in);

        while (true) {
            String[] data = new String[3]; // [FechaHora, Legajo, Comentario]
            data[0] = LocalDateTime.now().toString();
            
            System.out.print("Ingrese legajo: ");
            data[1] = scannerc.nextLine();
            
            System.out.print("Ingrese comentario: ");
            data[2] = scannerc.nextLine();
            
            dataEntries.add(data);
            
            System.out.print("¿Desea ingresar otro dato? (s/n): ");
            String continuar = scannerc.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
            	break;            }
        }
    }
    public static void ListarComentarios() {

        System.out.println("Listado de datos ingresados:");
        for (String[] entry : dataEntries) {
            System.out.println("Fecha y Hora: " + entry[0]);
            System.out.println("Legajo: " + entry[1]);
            System.out.println("Comentario: " + entry[2]);
            System.out.println();
        }
    }
}
