package entrega_cristian;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class principal {

    public static void main(String[] args) {
        ArrayList<String> ListaProfesores = new ArrayList<>();
        ArrayList<ArrayList<String>> ListageneralEstudiantes = new ArrayList<>();

        while (true) {
            String opcion = JOptionPane.showInputDialog("Seleccione una opción:\n"
                + "1. Registrar profesores\n"
                + "2. Registrar estudiantes\n"
                + "3. Consultar listas\n"
                + "4. Salir");

            switch (opcion) {
                case "1":
                    
                    while (true) {
                        String nombreProfesor = JOptionPane.showInputDialog("Ingrese el nombre del profesor (o 'salir' para terminar):");
                        if (nombreProfesor.equalsIgnoreCase("salir")) {
                            break;
                        }
                        if (ListaProfesores.contains(nombreProfesor)) {
                            JOptionPane.showMessageDialog(null, "El profesor ya está registrado.");
                        } else {
                            ListaProfesores.add(nombreProfesor);
                        }
                    }
                    break;

                case "2":
                    if (ListaProfesores.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Primero debe registrar profesores.");
                        break;
                    }

                    for (String profesor : ListaProfesores) {
                        JOptionPane.showMessageDialog(null, "Ingrese los estudiantes para el profesor " + profesor);
                        ArrayList<String> ListEstudiantes = new ArrayList<>();
                        int cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de estudiantes"));

                        for (int j = 0; j < cant; j++) {
                            while (true) {
                                String nombreEst = JOptionPane.showInputDialog("Nombre del estudiante " + (j + 1));
                                if (ListEstudiantes.contains(nombreEst)) {
                                    JOptionPane.showMessageDialog(null, "El estudiante ya está registrado para este profesor.");
                                } else {
                                    ListEstudiantes.add(nombreEst);
                                    break;
                                }
                            }
                        }

                        ListageneralEstudiantes.add(ListEstudiantes);
                    }
                    break;

                case "3":
                    if (ListageneralEstudiantes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Primero debe registrar estudiantes.");
                        break;
                    }

                    for (int i = 0; i < ListageneralEstudiantes.size(); i++) {
                        ArrayList<String> listaTemporal = ListageneralEstudiantes.get(i);
                        System.out.print("Profesor: " + ListaProfesores.get(i) + " = ");
                        System.out.print("[");
                        for (int j = 0; j < listaTemporal.size(); j++) {
                            System.out.print(listaTemporal.get(j) + (j < listaTemporal.size() - 1 ? ", " : ""));
                        }
                        System.out.print("]\n");
                    }
                    break;

                case "4":
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}