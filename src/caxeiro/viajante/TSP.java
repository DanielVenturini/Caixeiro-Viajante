/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caxeiro.viajante;

import Population.populacao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

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
        Populacao p  = populacao.inicializaPopulacao("a280.tsp", 10);
    }
    
}
