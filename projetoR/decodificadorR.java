import java.util.Scanner;

//Testes pra ler as cores e colocar elas num array


public class decodificadorR{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // cores recebe a linha inteira
        String cores = sc.nextLine();
        //o array cores1 recebe os valores digitados em cores já separados, trampo do "cores.split(" ")" que dividiu por espaços na entrada do usuario 
        String[] cores1 = cores.split(" ");
        

        //tentativa de validador de cores em posições inválidas(nao deu certo ainda)
        if(cores1.length == 4){
            if(cores1[4] == "laranja" || cores1[4] == "marrom"){
                System.out.printf("A cor da faixa (%s), não é válida para sua posição %n", cores1[4]);
            }
        } 

        while(sc.hasNextLine()){
        //lista todas as cores e suas posições no array cores1
        for(int i = 0; i <= cores1.length; i++){
            System.out.println("Cor " + i + ": " + cores1[i]);
            }
        }

        System.out.println(cores1.length);
    }
}