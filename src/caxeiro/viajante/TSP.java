/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caxeiro.viajante;

import CrossOver.Alternativo;
import CrossOver.Ordenado;
import Populacao.Caminho;
import Roleta.NaoElitismo;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author diegohenriquedeabreu
 */
public class TSP {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Caminho c = new Motor(new Alternativo(), "berlin52.tsp", 10, 3, new NaoElitismo(), 5).ligar();

        System.out.println("\n\nValor fitness: " + c.getValorFitness());
        for(int i = 0; i < c.getSize(); i ++){
            for(int k = i+1; k < c.getSize(); k ++){
                if(c.getCaminho().get(i).getLabel() == c.getCaminho().get(k).getLabel()){
                    System.out.println("RETORNOU AQUI: " + c.getCaminho().get(i).getLabel() + " com " + c.getCaminho().get(k).getLabel());
                }
            }
        }
    }
    
}
