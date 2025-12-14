import java.util.Scanner;

public class DecodificadorResistor{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String argumento = args[0]; 

        //funcionamento para cada argumento
        if (args.length == 0){
            System.out.println("Nenhum argumento fornecido. use 'java entradaUsuario help'");
        }
        //comando help. Funciona em lower e up case
        if (argumento.equalsIgnoreCase("HELP")){
            System.out.println("HELP");
            System.out.println("java decodificador.java [arg] < [file.archive]");
            System.out.println("");
            System.out.println("ARGUMENTOS [arg] or [ARG]");
            System.out.println("I       - recebe valores escritos pelo usuário no terminal, com um resistor por leitura");
            System.out.println("F       - recebe valor predefinidos em um arquivo de texto, de quantidade indeterminada de resistores");
        }

        //I. Recebe valor do usuário no terminal
        else if (argumento.equalsIgnoreCase("I")){ {
            System.out.println("Digite as cores presentes no seu resistor");
            String[] coresResistor = new String[6]; //cria um vetor de strings de tamanho máximo de cores que um resistor pode ter
            
            for (int i = 0; i < coresResistor.length; i++){
                coresResistor[i] = sc.nextLine(); //pega o valor e coloca na array

                if (coresResistor[i].isEmpty()){
                    break;
                    // se o usuário adicionar um valor vazio, acaba o loop. Completa o resistor
                }
            }

            //define tamanho do resistor
            int tamanhoResistor = 0;
            for (String cor: coresResistor) {
            if (cor != null || cor.isEmpty())
                tamanhoResistor++;
           } 
           
           //Se o resistor for menor que 4, é invalido
           if (tamanhoResistor<4){
                System.out.println("Tamanho de resistor inválido. Este deve conter entre 4 e 6 cores");
                return;
           }

           if (tamanhoResistor==4) {
                double digito1 = encontrarValorDigitos(coresResistor[0]); // chama a função que converte nome da cor em numero inteiro
                double digito2 = encontrarValorDigitos(coresResistor[1]); // chama a função que converte nome da cor em numero inteiro
                double multiplicador = Math.pow(10, (encontrarValorDigitos(coresResistor[2])));
                double tolerancia = calculoTolerancia(coresResistor[3]); // chama função específica para tolerância

                //Dá erro se o valor de digito1 ou digito2 for inválido
                if (digito1 < 0 || Double.isNaN(digito1) || digito2 < 0 || Double.isNaN(digito2)){
                    System.out.println("Nome de cor inválido. Tente preto, marrom, vermelho, laranja, amarelo, verde, azul, violeta, cinza ou branco");
                    sc.close();
                    return;
                }
           }
           }
        }
        
        sc.close();
    
        }

    static double encontrarValorDigitos (String cor) {
        switch (cor.trim().toUpperCase()) { // funciona escrevendo vermelho ou VERMELHO
            case "PRATEADO" : return -2;
            case "DOURADO" : return -1; 
            case "PRETO" : return 0; 
            case "MARROM" : return 1;
            case "VERMELHO" : return 2;
            case "LARANJA" : return 3;
            case "AMARELO": return 4;
            case "VERDE" : return 5;
            case "AZUL" : return 6;
            case "VIOLETA" : return 7;
            case "CINZA" : return 8;
            case "BRANCO" : return 9;
            default: return Double.NaN; // valor inválido
        }
    
    }

    static double calculoTolerancia (String cor) {
        switch (cor.trim().toUpperCase()) { // funciona escrevendo vermelho ou VERMELHO
            case "PRATEADO" : return 10;
            case "DOURADO" : return 5;  
            case "MARROM" : return 1;
            case "VERMELHO" : return 2;
            case "VERDE" : return 0.5;
            case "AZUL" : return 0.25;
            case "VIOLETA" : return 0.1;
            case "CINZA" : return 0.5;
            default: return Double.NaN; // valor inválido
        }
    }

    static double coeficienteDeTemperatura (String cor) {
        switch (cor.trim().toUpperCase()) { // funciona escrevendo vermelho ou VERMELHO
            case "MARROM" : return 100;
            case "VERMELHO" : return 50;
            case "LARANJA" : return 15;
            case "AMARELO": return 25;
            default: return Double.NaN; // valor inválido
        }
    
    }
}

