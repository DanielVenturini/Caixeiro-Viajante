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
public class NaoElitismo extends GeraPopulacao{

    CrossOver crossOver;
    int corte;

    // ponto de corte para o crossOver Alternativo
    // quando no crossOver ordenado, o ponto de corte nao eh usado, apesar de requerido como parametro
    public NaoElitismo(Populacao populacao, CrossOver crossOver, int corte) {
        super(populacao);

        this.crossOver = crossOver;
        this.corte = corte;
    }

    @Override
    // apenas gera uma nova populacao e retorna
    public Populacao getNovaPopulacao() {
        Populacao popNova = new Populacao();
        int size = super.populacao.getSize();

        for(int i = 0; i < size; i ++){
            Caminho pai1 = super.getPai();
            Caminho pai2 = super.getPai();

            Caminho filho = crossOver.geraFilho(pai1, pai2, corte);
            popNova.adicionarCaminho(filho);
        }

        return popNova;
    }
    
}