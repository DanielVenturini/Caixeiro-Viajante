/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caxeiro.viajante;

import CrossOver.Alternativo;
import CrossOver.CrossOver;
import CrossOver.Ordenado;
import Populacao.Caminho;
import Roleta.Elitismo;
import Roleta.GeraPopulacao;
import Roleta.NaoElitismo;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class teste {

    public static void main(String[] args){
        try{
            Scanner parametros = new Scanner(new FileReader("./src/caxeiro/viajante/parametros"));
            FileOutputStream resultados = new FileOutputStream("./src/caxeiro/viajante/resultados");

            String[] arquivos = new String[6];
            arquivos[0] = "a280.tsp";
            arquivos[1] = "berlin_52.tsp";
            arquivos[2] = "a280.tsp";
            arquivos[3] = "a280.tsp";
            arquivos[4] = "a280.tsp";
            arquivos[5] = "a280.tsp";
            arquivos[5] = "a280.tsp";

            for(String nomeArquivo : arquivos){
                resultados.write((nomeArquivo+"\n").getBytes());

                while(parametros.hasNext()){
                    // le cada linha de parametros
                    String a = parametros.nextLine();
                    System.out.println(a);
                    resultados.write((a + ":\n").getBytes());
                    String[] line = a.split(",");

                    String crossOver = line[0];
                    System.out.println("aqui");
                    int mutacao = Integer.parseInt(line[1]);
                    String roletaString = line[2];
                    int estagnacao = Integer.parseInt(line[3]);

                    CrossOver crossover;
                    GeraPopulacao roleta;
                    Caminho c;
                    for(int i = 0; i < 10; i ++){
                        try{
                            if(crossOver.equals("ordenado")){
                                crossover = new Ordenado();
                            } else {
                                crossover = new Alternativo();
                            }

                            if(roletaString.equals("elitismo")){
                                roleta = new Elitismo();
                            } else {
                                roleta = new NaoElitismo();
                            }

                            c = new Motor(crossover, nomeArquivo, 101, 5, roleta, estagnacao, mutacao).ligar();
                            System.out.println("c: " + c.getValorFitness());
                            resultados.write(("    " + Integer.toString(i)+ " " + String.valueOf(c.getValorFitness()) + "\n").getBytes());
                        } catch (FileNotFoundException ex) {
                            System.out.println("Arquivo nao processado: " + nomeArquivo);
                        }
                    }
                }
                resultados.close();
            }

        } catch (IOException ex) {
            System.out.println("Erro: " + ex);
        }
    }

}
