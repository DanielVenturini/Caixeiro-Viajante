/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roleta;

import java.util.Collections;
import CrossOver.CrossOver;
import Populacao.Populacao;
import Populacao.Caminho;
import java.util.Random;

/**
 *
 * @author Daniel
 */

public abstract class GeraPopulacao {

    protected Populacao populacao;
    protected int adequacao = 0;  // valor de adequacao

    public void setPopulacao(Populacao populacao) {
        this.populacao = populacao;
        // ordenando pelo fitness
        /*Collections.sort(this.populacao.caminhos, new Comparator<Caminho>(){
            @Override
            public int compare(Caminho t, Caminho t1) {
                return (t.getValorFitness() < t1.getValorFitness()) ? 1 : -1;
            }
        });*/

        //Collections.sort(this.populacao.caminhos, new Ordena());
        adequacao = adequacao();
    }

    /* passos para recuperar um pai:
    /*
    /* [Soma] Calcule a soma dos valores de adequação de todos os cromossomas da população - soma S.
    /* [Seleção] Gere um número aleatório no intervalo (0,S) - r.
    /* [Repetição] Percorra toda a população e some a adequação de 0 - soma s. Quando a soma s for maior que r, pare e retorne o cromossoma atual.

    Inicio
        T = soma dos valores de aptidão de todos os indivíduos da população
        Repita N vezes para selecionar n indivíduos
            r = valor aleatório entre 0 e T

            Percorra sequencialmente os indivíduos da população, acumulando
            em S o valor de aptidão dos indivíduos já percorridos
                Se S >= r então
                    Selecione o indivíduo corrente
                Fim se
        Fim Repita
    Fim
    */
    protected Caminho getPai(){
        Random gerador = new Random();

        int s = 0;
        int r = gerador.nextInt(adequacao);
        for(int i = 0; i < populacao.getSize(); i ++){

            Caminho caminho = populacao.getCaminhos().get(i);
            s += caminho.getValorFitness();
            if(s > r){
                return populacao.getCaminhos().get(populacao.getSize()-i-1);
            }
        }

        // se chegar ate o final, retorna o mais apto
        return populacao.getCaminhos().getLast();
    }

    private int adequacao(){
        int soma = 0;
        for(Caminho caminho : populacao.getCaminhos()){
            soma += caminho.getValorFitness();
        }

        return soma;
    }

    public abstract Populacao getNovaPopulacao(CrossOver crossOver, int corte, int mutacao);
}