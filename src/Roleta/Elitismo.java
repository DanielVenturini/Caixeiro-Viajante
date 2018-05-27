/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roleta;

import CrossOver.CrossOver;
import Populacao.Caminho;
import Populacao.Populacao;

/**
 *
 * @author Daniel
 */
public class Elitismo extends GeraPopulacao{

    public void setPopulacao(Populacao populacao){
        super.setPopulacao(populacao);
    }

    @Override
    // gera a nova populacao adicionando o primeiro pai que foi usado para gerar um filho
    public Populacao getNovaPopulacao(CrossOver crossOver, int corte) {
        Populacao popNova = new Populacao();
        int size = super.populacao.getSize();

        for(int i = 0; i < size; i ++){
            Caminho pai1 = super.getPai();
            Caminho pai2 = super.getPai();

            Caminho filho = crossOver.geraFilho(pai1, pai2, corte);
            popNova.adicionarCaminho(filho);
            i ++;

            // adiciona o pai se ainda tiver espaco
            if(i < size){
                popNova.adicionarCaminho(pai1);
            } else {
                return popNova;
            }
        }

        return new Mutacao(popNova).mutacao();
    }
}
