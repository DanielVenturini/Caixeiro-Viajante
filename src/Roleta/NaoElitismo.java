/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roleta;

import caxeiro.viajante.No;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author venturini
 */
public class NaoElitismo implements Roleta {

    private LinkedList<PopulacaoRoleta> populacaoRoleta;

    // construtor
    NaoElitismo(LinkedList<LinkedList<No>> populacao){
        populacaoRoleta = new LinkedList<>();
        // apenas converte a populacao em uma populacaoroleta
        criaRoleta(populacao);
    }

    @Override
    public void criaRoleta(LinkedList<LinkedList<No>> populacao) {

        for(LinkedList<No> l : populacao){
            // apenas insere na populacaoroleta com a funcao fitness 0
            // pois no nao elitismo nao vamos precisar da funcao fitness
            PopulacaoRoleta pr = new PopulacaoRoleta(l, 0);
            populacaoRoleta.add(pr);
            // na verdade nem precisaria fazer isto ...
        }
    }

    @Override
    public LinkedList<No> getPai() {
        // retorna um pai aleatorio da roleta
        return populacaoRoleta.get(new Random().nextInt(populacaoRoleta.size())).getCaminho();
    }
    
}
