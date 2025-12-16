import java.util.Scanner;

//Testes pra ler as cores e colocar elas num array


public class decodificadorR{
    static int faixa1 = 0;
    static int faixa2 = 0;
    static int digitosT4 = 0;
    static double faixa3 = 0.0;
    static String faixa4 = "";

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
           
            // if(cores1.length == 4){
            //     int faixa1, faixa2;
            //     if(cores1[0] == "preto"){
            //         faixa1 = 0; 
            //     } else if()

            // }

        
            // if(cores1.length == 4){
               

            //     if(cores1[0].equals("preto")){
            //         faixa1 = 0; 
            //     } else if(cores1[0].equals("marrom")){
            //         faixa1 = 1;
            //     } else if(cores1[0].equals("vermelho")){
            //         faixa1 = 2;
            //     } else if(cores1[0].equals("laranja")){
            //         faixa1 = 3;
            //     } else if(cores1[0].equals("amarelo")){
            //         faixa1 = 4;
            //     } else if(cores1[0].equals("verde")){
            //         faixa1 = 5;
            //     } else if(cores1[0].equals("azul")){
            //         faixa1 = 6;
            //     } else if(cores1[0].equals("roxo")){
            //         faixa1 = 7;
            //     } else if(cores1[0].equals("cinza")){
            //         faixa1 = 8;
            //     } else if(cores1[0].equals("branco")){
            //         faixa1 = 9;
            //     } 

            //     if(cores1[1].equals("preto")){
            //         faixa2 = 0; 
            //     } else if(cores1[1].equals("marrom")){
            //         faixa2 = 1;
            //     } else if(cores1[1].equals("vermelho")){
            //         faixa2 = 2;
            //     } else if(cores1[1].equals("laranja")){
            //         faixa2 = 3;
            //     } else if(cores1[1].equals("amarelo")){
            //         faixa2 = 4;
            //     } else if(cores1[1].equals("verde")){
            //         faixa2 = 5;
            //     } else if(cores1[1].equals("azul")){
            //         faixa2 = 6;
            //     } else if(cores1[1].equals("roxo")){
            //         faixa2 = 7;
            //     } else if(cores1[1].equals("cinza")){
            //         faixa2 = 8;
            //     } else if(cores1[1].equals("branco")){
            //         faixa2 = 9;
            //     } 

            //     if(cores1[2].equals("prata")){
            //         faixa3 = 0.01; 
            //     } else if(cores1[2].equals("amarelo")){
            //         faixa3 = 0.1;
            //     } else if(cores1[2].equals("preto")){
            //         faixa3 = 1;
            //     } else if(cores1[2].equals("marrom")){
            //         faixa3 = 10;
            //     } else if(cores1[2].equals("vermelho")){
            //         faixa3 = 100;
            //     } else if(cores1[2].equals("laranja")){
            //         faixa3 = 1000;
            //     } else if(cores1[2].equals("amarelo")){
            //         faixa3 = 10000;
            //     } else if(cores1[2].equals("verde")){
            //         faixa3 = 100000;
            //     } else if(cores1[2].equals("azul")){
            //         faixa3 = 1000000;
            //     } else if(cores1[2].equals("roxo")){
            //         faixa3 = 10000000;
            //     } 

            //     if(cores1[3].equals("prata")){
            //         faixa4 = "10%"; 
            //     } else if(cores1[3].equals("amarelo")){
            //         faixa4 = "5%";
            //     } else if(cores1[3].equals("marrom")){
            //         faixa4 = "1%";
            //     } else if(cores1[3].equals("vermelho")){
            //         faixa4 = "2%";
            //     } else if(cores1[3].equals("verde")){
            //         faixa4 = "0.5%";
            //     } else if(cores1[3].equals("azul")){
            //         faixa4 = "0.25%";
            //     } else if(cores1[3].equals("roxo")){
            //         faixa4 = "0.1%";
            //     } else if(cores1[3].equals("cinza")){
            //         faixa4 = "0.05%";
            //     } 

            //     digitosT4 = (faixa1 * 10) + faixa2;
            // }

            if(cores1.length == 4){
                valoresQuatroFaixas(cores1);
            }


            //for(int i = 0; i < cores1.length; i++){
                //System.out.println(faixa1 + faixa2);
                
                System.out.printf("%.2f ohms e %s de tolerancia", (digitosT4 * faixa3), faixa4);
                
                //System.out.printf("faixa %d: %s ", i, cores1[i]);
            //}
            
            System.out.println();
        }

    sc.close();

    }

        static void valoresQuatroFaixas(String cores1[]){

                if(cores1[0].equals("preto")){
                    faixa1 = 0; 
                } else if(cores1[0].equals("marrom")){
                    faixa1 = 1;
                } else if(cores1[0].equals("vermelho")){
                    faixa1 = 2;
                } else if(cores1[0].equals("laranja")){
                    faixa1 = 3;
                } else if(cores1[0].equals("amarelo")){
                    faixa1 = 4;
                } else if(cores1[0].equals("verde")){
                    faixa1 = 5;
                } else if(cores1[0].equals("azul")){
                    faixa1 = 6;
                } else if(cores1[0].equals("roxo")){
                    faixa1 = 7;
                } else if(cores1[0].equals("cinza")){
                    faixa1 = 8;
                } else if(cores1[0].equals("branco")){
                    faixa1 = 9;
                } 

                if(cores1[1].equals("preto")){
                    faixa2 = 0; 
                } else if(cores1[1].equals("marrom")){
                    faixa2 = 1;
                } else if(cores1[1].equals("vermelho")){
                    faixa2 = 2;
                } else if(cores1[1].equals("laranja")){
                    faixa2 = 3;
                } else if(cores1[1].equals("amarelo")){
                    faixa2 = 4;
                } else if(cores1[1].equals("verde")){
                    faixa2 = 5;
                } else if(cores1[1].equals("azul")){
                    faixa2 = 6;
                } else if(cores1[1].equals("roxo")){
                    faixa2 = 7;
                } else if(cores1[1].equals("cinza")){
                    faixa2 = 8;
                } else if(cores1[1].equals("branco")){
                    faixa2 = 9;
                } 

                if(cores1[2].equals("prata")){
                    faixa3 = 0.01; 
                } else if(cores1[2].equals("amarelo")){
                    faixa3 = 0.1;
                } else if(cores1[2].equals("preto")){
                    faixa3 = 1;
                } else if(cores1[2].equals("marrom")){
                    faixa3 = 10;
                } else if(cores1[2].equals("vermelho")){
                    faixa3 = 100;
                } else if(cores1[2].equals("laranja")){
                    faixa3 = 1000;
                } else if(cores1[2].equals("amarelo")){
                    faixa3 = 10000;
                } else if(cores1[2].equals("verde")){
                    faixa3 = 100000;
                } else if(cores1[2].equals("azul")){
                    faixa3 = 1000000;
                } else if(cores1[2].equals("roxo")){
                    faixa3 = 10000000;
                } 

                if(cores1[3].equals("prata")){
                    faixa4 = "10%"; 
                } else if(cores1[3].equals("amarelo")){
                    faixa4 = "5%";
                } else if(cores1[3].equals("marrom")){
                    faixa4 = "1%";
                } else if(cores1[3].equals("vermelho")){
                    faixa4 = "2%";
                } else if(cores1[3].equals("verde")){
                    faixa4 = "0.5%";
                } else if(cores1[3].equals("azul")){
                    faixa4 = "0.25%";
                } else if(cores1[3].equals("roxo")){
                    faixa4 = "0.1%";
                } else if(cores1[3].equals("cinza")){
                    faixa4 = "0.05%";
                } 

                digitosT4 = (faixa1 * 10) + faixa2;
            }

            
    }
