/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Populacao;

import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class Caminho {

    private LinkedList<No> caminho;
    private double valorFitness;

    public Caminho(LinkedList<No> caminho) {
        this.caminho = caminho;
    }

    public LinkedList<No> getCaminho() {
        return caminho;
    }

    public void setCaminho(LinkedList<No> caminho) {
        this.caminho = caminho;
    }

    public double getValorFitness() {
        return valorFitness;
    }

    public int getSize(){
        return caminho.size();
    }

    public void setValorFitness() {
        valorFitness = fitness();
    }

    public double fitness() {
        No n1 = null;
        No n2 = caminho.get(0);

        No nUltimo = caminho.get(caminho.size()-1);
        double fitness = getDistancia(n2.getLatitude(), n2.getLongitude(), nUltimo.getLatitude(), nUltimo.getLongitude());

        for (int i = 0; i < caminho.size() - 1; i++) {

            // sempre pegamos duas vezes o mesmo elemento: quando 'i+1', e depois quando 'i'
            // para evitar isso, entao pegamos apenas o proximo. Ai no proximo loop,
            // o que era o proximo vai para o primeiro e pegamos entao o proximo
            n1 = n2;
            n2 = caminho.get(i+1);

            fitness += getDistancia(n1.getLatitude(), n1.getLongitude(), n2.getLatitude(), n2.getLongitude());
        }

        return fitness;
    }

    private static double getDistancia(double lat1, double long1, double lat2, double long2) {
        return Math.sqrt( Math.pow( (lat1 - lat2),2 ) + Math.pow( (long1 - long2),2 ) );
    }
}
