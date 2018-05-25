/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roleta;

import CrossOver.CrossOver;
import Populacao.Populacao;

/**
 *
 * @author Daniel
 */
public class Elitismo extends GeraPopulacao{

    public void setPopulacao(Populacao populacao){
        super.setPopulacao(populacao);
    }

    @Override
    public Populacao getNovaPopulacao(CrossOver crossOver, int corte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
