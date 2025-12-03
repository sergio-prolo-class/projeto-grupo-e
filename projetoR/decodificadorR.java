import java.util.Scanner;

//Testes pra ler as cores e colocar elas num array(não deu certo mas é uma ideia, só me falta saber oq tem fazer pra isso)
/* decodificadorR.java:9: error: incompatible types: String cannot be converted to String[]
        cores = sc.nextLine();
                           ^
1 error */
public class decodificadorR{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] cores = new String[6];
        cores = sc.nextLine();

        for(int i = 0; i < cores.length; i++){
            System.out.println("Cor " + i + ": " + cores[i]);
        }
    }
}