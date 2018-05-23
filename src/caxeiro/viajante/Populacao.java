/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caxeiro.viajante;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author diegohenriquedeabreu
 */
public class Populacao {

    int size;
    public ArrayList<LinkedList<No>> caminhos;

    public Populacao(int size) {
        this.size = size;
        caminhos = new ArrayList<>();
    }

    public ArrayList<LinkedList<No>> getCaminhos() {
        return caminhos;
    }

    public void setCaminhos(ArrayList<LinkedList<No>> caminhos) {
        this.caminhos = caminhos;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
