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
    private int valorFitness;

    public Caminho(LinkedList<No> caminho, int valorFitness) {
        this.caminho = caminho;
        this.valorFitness = valorFitness;
    }

    public LinkedList<No> getCaminho() {
        return caminho;
    }

    public void setCaminho(LinkedList<No> caminho) {
        this.caminho = caminho;
    }

    public int getValorFitness() {
        return valorFitness;
    }

    public void setValorFitness(int valorFitness) {
        this.valorFitness = valorFitness;
    }
}
