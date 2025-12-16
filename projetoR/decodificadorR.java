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
            } else {
                System.out.printf("Numero de faixas invalido");
            }

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
                    faixa4 = 0.01; 
                } else if(cores1[2].equals("ouro")){
                    faixa4 = 0.1;
                } else if(cores1[2].equals("preto")){
                    faixa4 = 1;
                } else if(cores1[2].equals("marrom")){
                    faixa4 = 10;
                } else if(cores1[2].equals("vermelho")){
                    faixa4 = 100;
                } else if(cores1[2].equals("laranja")){
                    faixa4 = 1000;
                } else if(cores1[2].equals("amarelo")){
                    faixa4 = 10000;
                } else if(cores1[2].equals("verde")){
                    faixa4 = 100000;
                } else if(cores1[2].equals("azul")){
                    faixa4 = 1000000;
                } else if(cores1[2].equals("roxo")){
                    faixa4 = 10000000;
                } 

                if(cores1[3].equals("prata")){
                    faixa5 = "10%"; 
                } else if(cores1[3].equals("amarelo")){
                    faixa5 = "5%";
                } else if(cores1[3].equals("marrom")){
                    faixa5 = "1%";
                } else if(cores1[3].equals("vermelho")){
                    faixa5 = "2%";
                } else if(cores1[3].equals("verde")){
                    faixa5 = "0.5%";
                } else if(cores1[3].equals("azul")){
                    faixa5 = "0.25%";
                } else if(cores1[3].equals("roxo")){
                    faixa5 = "0.1%";
                } else if(cores1[3].equals("cinza")){
                    faixa5 = "0.05%";
                } 

                digitosT4 = (faixa1 * 10) + faixa2;
            }



            static void valoresCincoFaixas(String cores1[]){

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

                if(cores1[2].equals("preto")){
                    faixa3 = 0; 
                } else if(cores1[2].equals("marrom")){
                    faixa3 = 1;
                } else if(cores1[2].equals("vermelho")){
                    faixa3 = 2;
                } else if(cores1[2].equals("laranja")){
                    faixa3 = 3;
                } else if(cores1[2].equals("amarelo")){
                    faixa3 = 4;
                } else if(cores1[2].equals("verde")){
                    faixa3 = 5;
                } else if(cores1[2].equals("azul")){
                    faixa3 = 6;
                } else if(cores1[2].equals("roxo")){
                    faixa3 = 7;
                } else if(cores1[2].equals("cinza")){
                    faixa3 = 8;
                } else if(cores1[2].equals("branco")){
                    faixa3 = 9;
                } 

                if(cores1[3].equals("prata")){
                    faixa4 = 0.01; 
                } else if(cores1[3].equals("ouro")){
                    faixa4 = 0.1;
                } else if(cores1[3].equals("preto")){
                    faixa4 = 1;
                } else if(cores1[3].equals("marrom")){
                    faixa4 = 10;
                } else if(cores1[3].equals("vermelho")){
                    faixa4 = 100;
                } else if(cores1[3].equals("laranja")){
                    faixa4 = 1000;
                } else if(cores1[3].equals("amarelo")){
                    faixa4 = 10000;
                } else if(cores1[3].equals("verde")){
                    faixa4 = 100000;
                } else if(cores1[3].equals("azul")){
                    faixa4 = 1000000;
                } else if(cores1[3].equals("roxo")){
                    faixa4 = 10000000;
                } 

                if(cores1[4].equals("prata")){
                    faixa5 = "10%"; 
                } else if(cores1[4].equals("ouro")){
                    faixa5 = "5%";
                } else if(cores1[4].equals("marrom")){
                    faixa5 = "1%";
                } else if(cores1[4].equals("vermelho")){
                    faixa5 = "4%";
                } else if(cores1[4].equals("verde")){
                    faixa5 = "0.5%";
                } else if(cores1[4].equals("azul")){
                    faixa5 = "0.25%";
                } else if(cores1[4].equals("roxo")){
                    faixa5 = "0.1%";
                } else if(cores1[4].equals("cinza")){
                    faixa5 = "0.05%";
                } 

                digitosT5 = (faixa1 * 100) + (faixa2 * 10) + faixa3;
            }


            static void valoresSeisFaixas(String cores1[]){

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

                if(cores1[2].equals("preto")){
                    faixa3 = 0; 
                } else if(cores1[2].equals("marrom")){
                    faixa3 = 1;
                } else if(cores1[2].equals("vermelho")){
                    faixa3 = 2;
                } else if(cores1[2].equals("laranja")){
                    faixa3 = 3;
                } else if(cores1[2].equals("amarelo")){
                    faixa3 = 4;
                } else if(cores1[2].equals("verde")){
                    faixa3 = 5;
                } else if(cores1[2].equals("azul")){
                    faixa3 = 6;
                } else if(cores1[2].equals("roxo")){
                    faixa3 = 7;
                } else if(cores1[2].equals("cinza")){
                    faixa3 = 8;
                } else if(cores1[2].equals("branco")){
                    faixa3 = 9;
                } 

                if(cores1[3].equals("prata")){
                    faixa4 = 0.01; 
                } else if(cores1[3].equals("ouro")){
                    faixa4 = 0.1;
                } else if(cores1[3].equals("preto")){
                    faixa4 = 1;
                } else if(cores1[3].equals("marrom")){
                    faixa4 = 10;
                } else if(cores1[3].equals("vermelho")){
                    faixa4 = 100;
                } else if(cores1[3].equals("laranja")){
                    faixa4 = 1000;
                } else if(cores1[3].equals("amarelo")){
                    faixa4 = 10000;
                } else if(cores1[3].equals("verde")){
                    faixa4 = 100000;
                } else if(cores1[3].equals("azul")){
                    faixa4 = 1000000;
                } else if(cores1[3].equals("roxo")){
                    faixa4 = 10000000;
                } 

                if(cores1[4].equals("prata")){
                    faixa5 = "10%"; 
                } else if(cores1[4].equals("ouro")){
                    faixa5 = "5%";
                } else if(cores1[4].equals("marrom")){
                    faixa5 = "1%";
                } else if(cores1[4].equals("vermelho")){
                    faixa5 = "4%";
                } else if(cores1[4].equals("verde")){
                    faixa5 = "0.5%";
                } else if(cores1[4].equals("azul")){
                    faixa5 = "0.25%";
                } else if(cores1[4].equals("roxo")){
                    faixa5 = "0.1%";
                } else if(cores1[4].equals("cinza")){
                    faixa5 = "0.05%";
                } 

                if(cores1[5].equals("marrom")){
                    faixa6 = "100ppm/K"; 
                } else if(cores1[5].equals("vermelho")){
                    faixa6 = "50ppm/K";
                } else if(cores1[5].equals("laranja")){
                    faixa6 = "15ppm/K";
                } else if(cores1[5].equals("amarelo")){
                    faixa6 = "25ppm/K";
                }

                digitosT5 = (faixa1 * 100) + (faixa2 * 10) + faixa3;
            }

            
        }
