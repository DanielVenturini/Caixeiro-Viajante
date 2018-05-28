/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caxeiro.viajante;

import java.io.FileNotFoundException;
import CrossOver.Alternativo;
import java.io.IOException;
import Roleta.NaoElitismo;
import CrossOver.Ordenado;
import Populacao.Caminho;
import Roleta.Elitismo;
import Populacao.No;

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
        Caminho c = new Motor(new Alternativo(), "a280.tsp", 101, 5, new Elitismo(), 20, 2).ligar();
        System.out.println("c: " + c.getValorFitness());
    }
    
}
