import java.util.Scanner;

//Testes pra ler as cores e colocar elas num array


public class decodificadorR{
    static int faixa1 = 0;
    static int faixa2 = 0;
    static int faixa3 = 0;
    static int digitosT4 = 0;
    static int digitosT5 = 0;
    static double faixa4 = 0.0;
    static String faixa5 = "";
    static String faixa6 = "";

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        
        while(sc.hasNextLine()){
            // le a linha inteira
            String cores = sc.nextLine();
            // divide as cores por espaço e bota no array cores1
            String[] cores1 = cores.split(" ");

            if(cores1.length == 4){
                valoresQuatroFaixas(cores1);
                System.out.printf("%.2f ohms e %s de tolerancia", (digitosT4 * faixa4), faixa5);
            } else if (cores1.length == 5){
                valoresCincoFaixas(cores1);
                System.out.printf("%.2f ohms e %s de tolerancia", (digitosT5 * faixa4), faixa5);
            } else if (cores1.length == 6){
                valoresSeisFaixas(cores1);
                System.out.printf("%.2f ohms, %s de tolerancia e %s de coeficiente de temperatura", (digitosT5 * faixa4), faixa5, faixa6);
            } else if (faixa1 == 99 || faixa2 == 99 || faixa3 == 99 || faixa4 == 99 || faixa5.equals("Cor Inválida para a posição") || faixa6.equals("Cor Inválida para a posição")){
                System.out.print("Cor Inválida para a posição");
            } else {
                System.out.print("Número inválido de faixas");
            }
            if (cores.trim().isEmpty()) continue;
            System.out.println();
        }

    sc.close();

    }

    static int getValorCor(String cor) {
        return switch(cor) {
            case "preto" -> 0;
            case "marrom" -> 1;
            case "vermelho" -> 2;
            case "laranja" -> 3;
            case "amarelo" -> 4;
            case "verde" -> 5;
            case "azul" -> 6;
            case "roxo" -> 7;
            case "cinza" -> 8;
            case "branco" -> 9;
            default -> 99;
        };
    }

    static double getValorMultiplicador(String cor) {
        return switch(cor) {
            case "prata" -> 0.01;
            case "ouro" -> 0.1;
            case "preto" -> 1;
            case "marrom" -> 10;
            case "vermelho" -> 100;
            case "laranja" -> 1000;
            case "amarelo" -> 10000;
            case "verde" -> 100000;
            case "azul" -> 1000000;
            case "roxo" -> 10000000;
            default -> 99;
        };
    }

    static String getValorTolerancia4Faixas(String cor) {
        return switch(cor) {
            case "prata" -> "10%";
            case "amarelo" -> "5%";
            case "marrom" -> "1%";
            case "vermelho" -> "2%";
            case "verde" -> "0.5%";
            case "azul" -> "0.25%";
            case "roxo" -> "0.1%";
            case "cinza" -> "0.05%";
            default -> "Cor Inválida para a posição";
        };
    }

    static String getValorTolerancia5e6Faixas(String cor) {
        return switch(cor) {
            case "prata" -> "10%";
            case "ouro" -> "5%";
            case "marrom" -> "1%";
            case "vermelho" -> "4%";
            case "verde" -> "0.5%";
            case "azul" -> "0.25%";
            case "roxo" -> "0.1%";
            case "cinza" -> "0.05%";
            default -> "Cor Inválida para a posição";
        };
    }

    static String getValorTemperatura(String cor) {
        return switch(cor) {
            case "marrom" -> "100ppm/K";
            case "vermelho" -> "50ppm/K";
            case "laranja" -> "15ppm/K";
            case "amarelo" -> "25ppm/K";
            default -> "Cor Inválida para a posição";
        };
    }

    static void valoresQuatroFaixas(String cores1[]){
        faixa1 = getValorCor(cores1[0]);
        faixa2 = getValorCor(cores1[1]);
        faixa4 = getValorMultiplicador(cores1[2]);
        faixa5 = getValorTolerancia4Faixas(cores1[3]);
        digitosT4 = (faixa1 * 10) + faixa2;
    }

    static void valoresCincoFaixas(String cores1[]){
        faixa1 = getValorCor(cores1[0]);
        faixa2 = getValorCor(cores1[1]);
        faixa3 = getValorCor(cores1[2]);
        faixa4 = getValorMultiplicador(cores1[3]);
        faixa5 = getValorTolerancia5e6Faixas(cores1[4]);
        digitosT5 = (faixa1 * 100) + (faixa2 * 10) + faixa3;
    }

    static void valoresSeisFaixas(String cores1[]){
        faixa1 = getValorCor(cores1[0]);
        faixa2 = getValorCor(cores1[1]);
        faixa3 = getValorCor(cores1[2]);
        faixa4 = getValorMultiplicador(cores1[3]);
        faixa5 = getValorTolerancia5e6Faixas(cores1[4]);
        faixa6 = getValorTemperatura(cores1[5]);
        digitosT5 = (faixa1 * 100) + (faixa2 * 10) + faixa3;
    }
}
