/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roleta;

import Populacao.Caminho;
import Populacao.Populacao;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Daniel
 */

abstract class GeraPopulacao {

    Populacao populacao;

    public GeraPopulacao(Populacao populacao) {
        this.populacao = populacao;

        // ordena pela funcao fitness em ordem crescente
        // entao os melhores serao os primeiros
        CrossOver.GreaterThan funOrdenacao = new CrossOver.GreaterThan();
        Collections.sort(this.populacao.caminhos, funOrdenacao);
    }

    public void setPopulacao(Populacao populacao) {
        this.populacao = populacao;
    }

    // tenta pegar os primeiros na populacao
    public Caminho getPai(){
        
    }

    public abstract Populacao getNovaPopulacao();
}