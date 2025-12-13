import java.util.Scanner;

//Testes pra ler as cores e colocar elas num array


public class decodificadorR{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        /* 


        // cores recebe a linha inteira
        String cores = sc.nextLine();
        //o array cores1 recebe os valores digitados em cores já separados, trampo do "cores.split(" ")" que dividiu por espaços na entrada do usuario 
        String[] cores1 = cores.split(" ");
        if(cores1.length == 4){
            if(cores1[3] == "laranja "){
        System.out.printf("%s %n", cores1);
            }
        }
        
        if(cores1.length == 4){
            if(cores1[3] == "laranja" || cores1[3] == "marrom"){
                System.out.printf("A cor da faixa (%s), não é válida para sua posição %n", cores1[3]);
            }
        } 
            

        */

        
        while(sc.hasNextLine()){
            // le a linha inteira
            String cores = sc.nextLine();
            // divide as cores por espaço e bota no array cores1
            String[] cores1 = cores.split(" ");


        
        for(int i = 0; i < cores1.length; i++){
            //numera e lista as cores da linha atual
            System.out.printf("faixa %d: %s ", i, cores1[i]);
            }
            //quebra a linha, e se tiver mais uma linha o programa começa de novo
            System.out.println();
        }

        
    }
}