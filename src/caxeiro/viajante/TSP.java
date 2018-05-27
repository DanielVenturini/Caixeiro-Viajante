/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caxeiro.viajante;

import CrossOver.Alternativo;
import CrossOver.Ordenado;
import Populacao.Caminho;
import Populacao.No;
import Roleta.Elitismo;
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
        Caminho c = new Motor(new Alternativo(), "a280.tsp", 10, 3, new Elitismo(), 110).ligar();

        System.out.println("Valor fitness: " + c.getValorFitness());
        System.out.println("Melhor caminho: ");
        for(No n : c.getCaminho()){
            System.out.print(n.getLabel() + " ");
        }
    }
    
}
