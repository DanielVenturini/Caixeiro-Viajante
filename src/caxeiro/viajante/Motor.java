/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caxeiro.viajante;

import Populacao.OperacoesPopulacao;
import Roleta.GeraPopulacao;
import Populacao.Populacao;
import CrossOver.CrossOver;
import java.io.IOException;
import Populacao.Caminho;
import Populacao.No;
import Roleta.Ordena;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class Motor {

    GeraPopulacao geradorPop;
    CrossOver crossOver;
    String nomeArquivo;
    int estagnacao;
    final int size;     // tamanho da populacao
    final int k;        // k alteracoes para o crossover ordenado

    public Motor(CrossOver crossOver, String nomeArquivo, int size, int k, GeraPopulacao geradorPop, int estagnacao) {
        this.nomeArquivo = nomeArquivo;
        this.estagnacao = estagnacao;
        this.geradorPop = geradorPop;
        this.crossOver = crossOver;
        this.size = size;
        this.k = k;
    }

    public Caminho ligar() throws IOException{

        // inicializa a populacao
        // para cada individuo ja foi calculado o fitness
        Populacao pop = OperacoesPopulacao.inicializaPopulacao(nomeArquivo, size);
        // o ultimo é sempre o melhor dos caminhos
        Caminho melhorCaminho = pop.getCaminhos().get(pop.getCaminhos().size()-1);

        int b = 0;
        int i = estagnacao;
        while(i >= 0){

            // adiciona a populacao para calcular a nova
            geradorPop.setPopulacao(pop);
            // gera a nova populacao com o crossover escolhido
            // se for o alternativo, sera necessario o valor do k, senao, o valor sera inutilizavel
            pop = geradorPop.getNovaPopulacao(crossOver, k);
            Collections.sort(pop.caminhos, new Ordena());

            if(b ++ == 8){
                for(Caminho c : pop.getCaminhos()){
                    System.out.println(c.getValorFitness() + " ");
                }

                System.out.println("Melhor fitness desta: " + pop.getCaminhos().get(pop.getCaminhos().size()-1).getValorFitness());
            }
            // pegando o melhor da nova populacao
            Caminho melhorCaminhoAtual = pop.getCaminhos().get(pop.getCaminhos().size()-1);
            // se gerou um caminho melhor
            if(melhorCaminho.getValorFitness() > melhorCaminhoAtual.getValorFitness()){
                melhorCaminho = melhorCaminhoAtual;
                i = estagnacao;
            } else {
                i --;
            }
        }

        /*
        System.out.println("Melhor caminho para " + nomeArquivo);
        for(No n : melhorCaminho.getCaminho()){
            System.out.println(n.getLabel());
        }*/

        return melhorCaminho;
    }
}
