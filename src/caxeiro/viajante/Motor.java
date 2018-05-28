/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caxeiro.viajante;

import Populacao.OperacoesPopulacao;
import java.util.Collections;
import Roleta.GeraPopulacao;
import Populacao.Populacao;
import CrossOver.CrossOver;
import java.io.IOException;
import Populacao.Caminho;
import Populacao.No;
import Roleta.Ordena;

/**
 *
 * @author Daniel
 */
public class Motor {

    GeraPopulacao geradorPop;
    CrossOver crossOver;
    String nomeArquivo;
    final int mutacao;
    int estagnacao;
    final int size;     // tamanho da populacao
    final int k;        // k alteracoes para o crossover ordenado

    public Motor(CrossOver crossOver, String nomeArquivo, int size, int k, GeraPopulacao geradorPop, int estagnacao, int mutacao) {
        this.nomeArquivo = nomeArquivo;
        this.estagnacao = estagnacao;
        this.geradorPop = geradorPop;
        this.crossOver = crossOver;
        this.mutacao = mutacao;
        this.size = size;
        this.k = k;
    }

    public Caminho ligar() throws IOException{

        // inicializa a populacao
        // para cada individuo ja foi calculado o fitness
        Populacao popMelhor = OperacoesPopulacao.inicializaPopulacao(nomeArquivo, size);
        // o ultimo é sempre o melhor dos caminhos
        Caminho melhorCaminho = popMelhor.getCaminhos().get(popMelhor.getCaminhos().size()-1);

        int i = estagnacao;
        while(i >= 0){

            // adiciona a populacao para calcular a nova
            geradorPop.setPopulacao(popMelhor);
            // gera a nova populacao com o crossover escolhido
            // se for o alternativo, sera necessario o valor do k, senao, o valor sera inutilizavel
            Populacao popAtual = geradorPop.getNovaPopulacao(crossOver, k, mutacao);
            Collections.sort(popAtual.caminhos, new Ordena());

            // pegando o melhor da nova populacao
            Caminho melhorCaminhoAtual = popAtual.getCaminhos().get(popAtual.getCaminhos().size()-1);
            // se gerou um caminho melhor
            if(melhorCaminho.getValorFitness() > melhorCaminhoAtual.getValorFitness()){
                melhorCaminho = melhorCaminhoAtual;
                popMelhor = popAtual;
                i = estagnacao;
            } else {
                i --;
            }
        }

        return melhorCaminho;
    }
}
