package fernandez.marco.dam.mp09.uf01.pr2.seguretat.view.console;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import fernandez.marco.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;
import fernandez.marco.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedicaLog;

public class VisitaMedicaView {

    public VisitaMedica getVisitaMedica() {
        VisitaMedica visita = new VisitaMedica();
        Scanner scanner = new Scanner(System.in);

        // Peticions de dades
        showMissatge("Introdueixi l'ID de la visita: ", false);
        visita.setIdVisita(scanner.nextInt());
        
        showMissatge("Introdueixi el nom del pacient: ", false);
        visita.setNomPacient(scanner.next());

        showMissatge("Introdueixi el nom del metge: ", false);
        visita.setNomMetge(scanner.next());

		showMissatge("Introdueixi la data de la visita (format: yyyy-mm-dd): ", false);
		String dataEntrada = scanner.next(); // Captura la data com a String
		visita.setData(LocalDate.parse(dataEntrada)); // Converteix a LocalDate

        
        showMissatge("Introdueixi el diagnòstic: ", false);
        visita.setDiagnostic(scanner.next());

        return visita;
    }

    public void showVisitaMedica(VisitaMedica visita) {
        System.out.println(visita.toString());
    }

    public void showMissatge(String missatge, boolean esError) {
        if (esError) {
            System.err.println(missatge);
        } else {
            System.out.println(missatge);
        }
    }

    public boolean demanarMesDades() {
        boolean result = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Desitja demanar més dades? (true/false): ");
        result = scanner.nextBoolean();
        return result;
    }

    public void mostraLogs(ArrayList<VisitaMedicaLog> logs) {
        System.out.println(" ==== Llistat de visites (LOG)");
        if (logs != null && logs.size() > 0) {
            for (VisitaMedicaLog v : logs) {
                System.out.println(v.toString());
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
