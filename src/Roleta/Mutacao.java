/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roleta;

import Populacao.Caminho;
import Populacao.No;
import Populacao.Populacao;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class Mutacao {

    Populacao populacao;

    Mutacao(Populacao populacao){
        this.populacao = populacao;
    }

    // na mutacao apenas trocamos o ultimo individuo com o primeiro
    public Populacao mutacao(){
        for(Caminho individuo : populacao.getCaminhos()){

            LinkedList<No> caminho = individuo.getCaminho();
            No n1 = caminho.get(0);
            No nu = caminho.get(caminho.size()-1);

            int label = n1.getLabel();
            float latitude = n1.getLatitude();
            float longitude = n1.getLongitude();

            n1.setLabel(nu.getLabel());
            n1.setLatitude(nu.getLatitude());
            n1.setLongitude(nu.getLongitude());

            nu.setLabel(label);
            nu.setLatitude(latitude);
            nu.setLongitude(longitude);

            // agora sim pode calcular o valor fitness
            individuo.setValorFitness();
        }

    return populacao;
    }
}
