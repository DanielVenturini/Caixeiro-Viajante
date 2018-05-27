/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Populacao;

import caxeiro.viajante.Reader;
import java.util.Collections;
import java.util.LinkedList;
import java.io.IOException;
import Roleta.Ordena;

/**
 *
 * @author a1724487
 */
public class OperacoesPopulacao {

    public static Populacao inicializaPopulacao(String nomeFile, int k) throws IOException {

        Reader reader = new Reader();
        // le do arquivo
        LinkedList<No> caminhoOriginal = reader.processarArquivo(nomeFile);
        // aqui ficara guardada a nova populacao
        Populacao populacao = new Populacao();

        LinkedList<No> nos;
        for (int i = 0; i < k; i++) {

            nos = clone(caminhoOriginal);       // clona o caminho original
            Collections.shuffle(nos);           // embaralha o caminho

            Caminho caminho = new Caminho(nos); // cria a classe caminho com seu valor fitness
            caminho.setValorFitness();          // calcula o seu valor de fitness
            populacao.adicionarCaminho(caminho);// adiciona na populacao
        }

        // ordenando pelo valor fitness
        // o melhor fica sempre no final da lista
        // pois eh inversamento proporcional
        Collections.sort(populacao.caminhos, new Ordena());
        /*Collections.sort(populacao.caminhos, new Comparator<Caminho>(){
            @Override
            public int compare(Caminho c, Caminho c1) {
                return c.getValorFitness() < c1.getValorFitness()? 1 : -1;
            }
        });*/

        return populacao;
    }

    // alem de clonar a lista, precisa clonar os nos individualmente
    private static LinkedList<No> clone(LinkedList<No> caminhoOriginal){
        LinkedList<No> clone = new LinkedList<>();
        for(No n : caminhoOriginal){
            No no = new No(n.getLabel(), n.getLatitude(), n.getLongitude());
            clone.add(no);
        }

        return clone;
    }
}
