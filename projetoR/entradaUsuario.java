import java.util.Scanner;

public class entradaUsuario{
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
            String[] cores = new String[6]; //cria um vetor de strings de tamanho máximo de cores que um resistor pode ter
            
            for (int i = 0; i < cores.length; i++){
                cores[i] = sc.nextLine(); //pega o valor

                if (cores[i].isEmpty()){
                    break;
                    // se o usuário adicionar um valor vazio, acaba o loop
                }
            }
            // se o valor do 5o e 6o valor foram nulos e ou o 2o valor for vazio (enter) ou nulo (enter anterior), da erro
            if (cores[5] == null && cores[4] == null && (cores[3] == null || cores[3].isEmpty())){
                System.out.println("Um resistor tem entre 4 e 6 faixas de cores. Quantidade inválida");
                sc.close();
                return;
            }

            for (String cor: cores) { /// só para validar se o array estava ok
                System.out.printf("valor 1%s%n", cor);
            }




        }
        
        sc.close();
    
    }
}
}
