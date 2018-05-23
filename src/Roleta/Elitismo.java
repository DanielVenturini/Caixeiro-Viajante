/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roleta;

import java.util.LinkedList;
import java.util.Random;
import caxeiro.viajante.No;

/**
 *
 * @author venturini
 */
public class Elitismo implements Roleta{

    private LinkedList<PopulacaoRoleta> populacaoRoleta;

    Elitismo(LinkedList<LinkedList<No>> populacao){
        populacaoRoleta = new LinkedList<>();
        criaRoleta(populacao);
    }

    @Override
    public void criaRoleta(LinkedList<LinkedList<No>> populacao) {

        for(LinkedList<No> l : populacao){
            PopulacaoRoleta pr = new PopulacaoRoleta(l, funcaoFitness(l));
            populacaoRoleta.add(pr);
        }
    }

    @Override
    public LinkedList<No> getPai() {
        return populacaoRoleta.get(rodarRoleta()).getCaminho();
    }

    private int funcaoFitness(LinkedList<No> caminho){

        int valorFitness = 0;

        for(int i = 0; i < caminho.size()-1; i ++){
            No n1 = caminho.get(i);
            No n2 = caminho.get(i+1);

            valorFitness += distancia(n1, n2);
        }

        valorFitness += distancia(caminho.getLast(), caminho.getFirst());
        return valorFitness;
    }

    private int distancia(No n1, No n2){
        return 1+1;
    }

    private static int rodarRoleta(){

        // sorteia um numero de 0 ate o tamanho da populacao
        // depois outro de 0 ate a metade do tamanho da populacao
        // soma e retorna
        //int size = populacaoRoleta.size();
        int size = 280;
        Random gerador = new Random();

        int num1 = gerador.nextInt(size-1);
        int num2 = gerador.nextInt(size*1/2);
        
        System.out.println("Um: " + num1 + " dois: " + num2);

        int posFinal = num1+num2;
        if(posFinal > size){
            posFinal /= 1.1;
        }

        return posFinal;        
    }

    public static void main(String[] args){
        System.out.println("Roleta: " + rodarRoleta());
    }
}
