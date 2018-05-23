/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roleta;

import java.util.LinkedList;
import caxeiro.viajante.No;

/**
 *
 * @author venturini
 */
public class PopulacaoRoleta {

    private LinkedList<No> caminho;
    private int valorFitness;

    public PopulacaoRoleta(LinkedList<No> caminho, int valorFitness) {
        this.caminho = caminho;
        this.valorFitness = valorFitness;
    }

    public LinkedList<No> getCaminho() {
        return caminho;
    }

    public int getValorFitness() {
        return valorFitness;
    }
}
