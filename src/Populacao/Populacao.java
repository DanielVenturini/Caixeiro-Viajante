/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Populacao;

import java.util.LinkedList;

/**
 *
 * @author diegohenriquedeabreu
 */
public class Populacao {

    public LinkedList<Caminho> caminhos;

    Populacao() {
        caminhos = new LinkedList<>();
    }

    public LinkedList<Caminho> getCaminhos() {
        return caminhos;
    }

    public int getSize() {
        return caminhos.size();
    }

    public void adicionarCaminho(Caminho caminho){
        this.getCaminhos().add(caminho);
    }
}
