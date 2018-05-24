/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roleta;

import Populacao.Caminho;
import Populacao.No;
import Populacao.Populacao;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

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

    protected void setPopulacao(Populacao populacao) {
        this.populacao = populacao;
    }

    /* passos para recuperar um pai:
    /*
    /* [Soma] Calcule a soma dos valores de adequação de todos os cromossomas da população - soma S.
    /* [Seleção] Gere um número aleatório no intervalo (0,S) - r.
    /* [Repetição] Percorra toda a população e some a adequação de 0 - soma s. Quando a soma s for maior que r, pare e retorne o cromossoma atual.
    */
    protected Caminho getPai(){
        Random gerador = new Random();

        int s = adequacao();
        int r = gerador.nextInt(s);

        s = 0;
        for(Caminho caminho : populacao.getCaminhos()){

            s += caminho.getValorFitness();
            if(s > r){
                return caminho;
            }
        }

        // se chegar ate o final, retorna o mais apto
        return populacao.getCaminhos().getFirst();
    }

    private int adequacao(){
        int soma = 0;
        for(Caminho caminho : populacao.getCaminhos()){
            soma += caminho.getValorFitness();
        }

        return soma;
    }

    public abstract Populacao getNovaPopulacao();

    public static void main(String[] args){

        Populacao p = new Populacao();
        

    }
}