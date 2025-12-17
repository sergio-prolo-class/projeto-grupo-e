import java.text.DecimalFormat;
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
        else if (argumento.equalsIgnoreCase("I")) {
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
                if (cor != null && !cor.isEmpty())
                    tamanhoResistor++;
           } 
           
           //Se o resistor for menor que 4, é invalido
           if (tamanhoResistor<4){
                System.out.println("Tamanho de resistor inválido. Este deve conter entre 4 e 6 cores");
                sc.close();
                return;
           }

           if (tamanhoResistor >= 4 && tamanhoResistor <= 6) {
               int numDigits = (tamanhoResistor == 4) ? 2 : 3; //resistor tem 4 cores? Se sim ele tem 2 digitos. Senão, todos os outros em 3 digitos

               double[] digitos = new double[numDigits]; // array do tamanho da quantidade de digitos, 2 ou 3.
               boolean invalido = false;

               for(int i = 0; i < numDigits; i++){ // loop que converte as cores em valores
                   digitos[i] = encontrarValorDigitos(coresResistor[i]);

                   if(digitos[i] < 0 || Double.isNaN(digitos[i])){
                       invalido = true; // valida se o valor é valido
                   }
               }


               if(invalido){ //se for invalido
                   System.out.println("Nome de cor inválido para dígitos. Tente preto, marrom, vermelho, laranja, amarelo, verde, azul, violeta, cinza ou branco");
                   sc.close();
                   return; //acaba
               }

               double multiplicador = encontrarValorDigitos(coresResistor[numDigits]);
               if(Double.isNaN(multiplicador)){
                   System.out.println("Nome de cor inválido para multiplicador"); //ajuda a especificar melhor a cor que deu erro
                   sc.close();
                   return;
               }

               // acessa calculoTolerancia para já converter cor em valor
               double tolerancia = calculoTolerancia(coresResistor[numDigits + 1]); // acessa a cor do multiplicador, independente do tamanho do resistor
               if(Double.isNaN(tolerancia)){//se for valor vazio
                   System.out.println("Nome de cor inválido para tolerância");
                   sc.close();
                   return; 
               }

                /*Sobre o for a seguir:
                funciona se tem 2 ou 3 digitos, pois tem como base o número de digitos.
                pega o primeiro valor, multiplicado por 10 elevado a quantidade - 1 - o iterador
                Digamos que os digitos sejam 1, 2 e 3. 
                Se tivermos dois digitos, 1*10^(2-1-0) -> 1*10^1 -> 10
                Em seguida o segundo digito, 2*10^(2-1-1) -> 2*10^0 = 2*1 = o próprio 2
        
                Se tiver tres digitos, seria 1*10^(3-1-0) (a quantidade de digitos, faz o que seria 10 virar 100)
                depois 2*10^(3-1-1), mesma coisa, o que era 2 vira 20
                E aqui, o 3 fica três mesmo
                */


               double valor = 0;
               for(int i = 0; i < numDigits; i++){
                   valor += digitos[i] * Math.pow(10, numDigits - 1 - i);
               }

               //O valor do multiplicador não passa do expoente, de uma notação científica
               valor *= Math.pow(10, multiplicador);


               System.out.printf("Seu resistor tem: %s Ohms (+- %.2f%%)\n", formatarNumero(valor), tolerancia);

               //Se o resistor tem 6 cores, ele tem um coeficiente de temperatura
               if(tamanhoResistor == 6){
                   double coefTemp = coeficienteDeTemperatura(coresResistor[5]);
                   if(!Double.isNaN(coefTemp)){
                       System.out.printf("Coeficiente de temperatura: %.0f ppm/K\n", coefTemp);
                   } else {
                       System.out.println("Nome de cor inválido para coeficiente de temperatura");
                   }
               }
           } else { //Se não tiver entre 4 e 6
               System.out.println("Tamanho de resistor inválido. Este deve conter entre 4 e 6 cores");
               sc.close();
               return;
           }
        }

// F -> ler de arquivo (cada linha:  4, 5 ou 6 cores separadas por espaço)
    else if (argumento.equalsIgnoreCase("F")){
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line. isEmpty()) {
                continue;
            }

            String[] cores = line.split("\\s+");
            
            // Validar quantidade de faixas (4, 5 ou 6)
            if (cores.length < 4 || cores.length > 6) {
                System.out.println("Número inválido de faixas");
                continue;
            }

            // Determinar número de dígitos baseado na quantidade de faixas
            int numDigits = (cores.length == 4) ? 2 : 3;

            // Validar e extrair dígitos
            double[] digitos = new double[numDigits];
            boolean invalido = false;
            for (int i = 0; i < numDigits; i++) {
                digitos[i] = encontrarValorDigitos(cores[i]);
                if (Double.isNaN(digitos[i])) {
                    invalido = true;
                    break;
                }
            }

            if (invalido) {
                System.out.println("Cor Inválida");
                continue;
            }

            // Extrair multiplicador
            double multiplicador = encontrarValorDigitos(cores[numDigits]);
            if (Double. isNaN(multiplicador)) {
                System.out.println("Cor Inválida");
                continue;
            }

            // Extrair tolerância
            double tolerancia = calculoTolerancia(cores[numDigits + 1]);
            if (Double.isNaN(tolerancia)) {
                System. out.println("Cor Inválida");
                continue;
            }

            // Calcular valor do resistor
            double valor = 0;
            for (int i = 0; i < numDigits; i++) {
                valor += digitos[i] * Math.pow(10, numDigits - 1 - i);
            }
            valor *= Math.pow(10, multiplicador);

            // Formata a tolerância para string (ex: "5%", "0.5%")
            String tolStr = formatarTolerancia(tolerancia);

            // Se tiver 6 faixas, extrair coeficiente de temperatura
            if (cores.length == 6) {
                double coefTemp = coeficienteDeTemperatura(cores[5]);
                if (Double.isNaN(coefTemp)) {
                    System. out.println("Cor Inválida");
                    continue;
                }
                // Saída para 6 faixas
                System.out.printf("%.2f ohms, %s de tolerancia e %.0fppm/K de coeficiente de temperatura\n", 
                    valor, tolStr, coefTemp);
            } else {
                // Saída para 4 ou 5 faixas
                System.out.printf("%.2f ohms e %s de tolerancia\n", valor, tolStr);
            }
        }
    }
    
    sc.close();

}


    static double encontrarValorDigitos (String cor) {
        switch (cor.trim().toUpperCase()) { // funciona escrevendo vermelho ou VERMELHO
            case "PRATEADO":
            case "PRATA":
                return -2;
            case "DOURADO":
            case "OURO" : 
                return -1; 
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
            case "PRATEADO" : 
            case "PRATA": 
                return 10;
            case "DOURADO" : 
            case "OURO":
                return 5;  
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

    static String formatarNumero (double valor) {
        String numString;

        // Se o valor for da casa dos milhões (M)
        if (valor >= 1_000_000) {
            valor = valor / 1_000_000.0;
            if (Math.abs(valor - Math.round(valor)) < 1e-9) { //Se o valor absoluto de valor - valor arredondado (o que fica atrás da vírgula) for menor que 0.0000000001
                numString = String.format("%.0fM", valor); // converte para String, sem número após a vírgula
            } else { //senão, ou seja, tem número depois da vírgula
                numString = String.format("%.1fM", valor); // Printa com um número depois da vírgula
            }
            return numString;
        } 
        //Se o valor for da casa dos milhares (k)
        else if (valor >= 1_000) {
            valor = valor / 1_000.0;
            if (Math.abs(valor - Math.round(valor)) < 1e-9) {
                numString = String.format("%.0fk", valor);
            } else {
                numString = String.format("%.1fk", valor);
            }
            return numString;
        } else {
            if (Math.abs(valor - Math.round(valor)) < 1e-9) {
                numString = String.format("%.0f", valor);
            } else {
                numString = String.format("%.1f", valor);
            }
            return numString;
        }
    }

    // Formata tolerância para string sem zeros desnecessários (ex: "5%" ou "0.5%")
    static String formatarTolerancia(double tolerancia) {
        if (Double.isNaN(tolerancia)) return "Cor Inválida";
        if (Math.abs(tolerancia - Math.round(tolerancia)) < 1e-9) {
        // inteiro
            return String.format("%.0f%%", tolerancia);
        } 
        else {
        // com casas decimais (até 2 casas)
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(tolerancia) + "%";
        }
    }
}

