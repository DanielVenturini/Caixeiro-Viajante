/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caxeiro.viajante;

import Populacao.OperacoesPopulacao;
import Populacao.Populacao;
import CrossOver.CrossOver;
import Populacao.Caminho;
import java.io.IOException;

/**
 *
 * @author Daniel
 */
public class Motor {

    CrossOver crossOver;
    String nomeArquivo;
    final int size;     // tamanho da populacao
    final int k;        // k alteracoes para o crossover ordenado

    public Motor(CrossOver crossOver, String nomeArquivo, int size, int k) {
        this.nomeArquivo = nomeArquivo;
        this.crossOver = crossOver;
        this.size = size;
        this.k = k;
    }

    public Populacao ligar() throws IOException{

        // inicializa a populacao
        Populacao pop = OperacoesPopulacao.inicializaPopulacao(nomeArquivo, size);

        int i = 0;  // controle das geracoes. Porém tem que aplicar um metodo para parar e nao este
        while(i ++ < 100){

            // os individuos ja foram avaliados em OperacoesPopulacao -> fitness

            // selecione os melhores pais para gerar novos indivíduos.
            
            
            
            
        }
        
        
        
        
        return pop;
    }
}
