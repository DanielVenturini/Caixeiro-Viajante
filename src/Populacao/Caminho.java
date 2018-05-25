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
        this.valorFitness = fitness();
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

    public void setValorFitness(double valorFitness) {
        this.valorFitness = valorFitness;
    }

    public double fitness() {
        double fitness = 0;
        for (int i = 0; i < caminho.size() - 1; i++) {
            No n1 = caminho.get(i);
            No n2 = caminho.get(i + 1);

            fitness += getDistancia(n1.getLatitude(), n1.getLongitude(), n2.getLatitude(), n2.getLongitude());
        }

        No nPrimeiro = caminho.get(0);
        No nUltimo = caminho.get(caminho.size()-1);

        fitness += getDistancia(nPrimeiro.getLatitude(), nPrimeiro.getLongitude(), nUltimo.getLatitude(), nUltimo.getLongitude());
        return fitness;
    }

    private static double getDistancia(double lat1, double long1, double lat2, double long2) {
        return Math.sqrt( Math.pow( (lat1 - lat2),2 ) + Math.pow( (long1 - long2),2 ) );
    }
}
