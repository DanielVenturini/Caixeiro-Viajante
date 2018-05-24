/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Populacao;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import caxeiro.viajante.Reader;

/**
 *
 * @author a1724487
 */
public class OperacoesPopulacao {

    public static Populacao inicializaPopulacao(String nomeFile, int k) throws IOException{

        Reader reader = new Reader();
        // le do arquivo
        LinkedList<No> caminhoOriginal = reader.processarArquivo(nomeFile);
        // aqui ficara guardada a nova populacao
        Populacao populacao = new Populacao();

        LinkedList<No> nos;
        for (int i = 0; i < k; i ++) {

            nos = (LinkedList<No>) caminhoOriginal.clone();     // clona o caminho original
            Collections.shuffle(nos);                           // embaralha o caminho

            Caminho caminho = new Caminho(nos, fitness(nos));   // cria a classe caminho com seu valor fitness
            populacao.adicionarCaminho(caminho);                // adiciona na populacao
        }

        return populacao;
    }

    public static int fitness(LinkedList<No> caminho){
        return 10;
    }

    public static Populacao geraNovaPopulacao(Populacao popAtual){

        Populacao popNova = new Populacao();

        return popNova;
    }
}
