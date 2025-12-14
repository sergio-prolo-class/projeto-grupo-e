import java.util.Scanner;

public class teste {
    public static void main (String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, forneça um argumento (A ou B)");
            return;
        }
        
        String argumento = args[0];
        
        if (argumento.equals("A")) {
            System.out.println("acorda, acorda cara, acorda. Já tamo na porra da ditadura já. Já começo");
        } else if (argumento.equals("B")) {
            System.out.println("EEhhhrmmmm discordo");
        } else {
            System.out.println("Argumento inválido. Use 'A' ou 'B'");
        }
    }
}