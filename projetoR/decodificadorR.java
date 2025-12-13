import java.util.Scanner;

//Testes pra ler as cores e colocar elas num array


public class decodificadorR{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // cores recebe a linha inteira
        String infoArq = sc.nextLine();
        //o array cores1 recebe os valores digitados em cores já separados, trampo do "cores.split(" ")" que dividiu por espaços na entrada do usuario 
        String[][] cores = new String[5][1000];
        cores = infoArq.split(" ");
        
        /*
        while(sc.hasNextLine()){
        //lista todas as cores e suas posições no array cores1
        for(int i = 0; i <= cores1.length; i++){
            System.out.println("Cor " + i + ": " + cores1[i]);
        }
            */
        System.out.printf("%s %n", cores[1][2]);
    
    }
}