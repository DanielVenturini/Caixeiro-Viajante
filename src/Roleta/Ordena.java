/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roleta;

import Populacao.Caminho;
import java.util.Comparator;

/**
 *
 * @author Daniel
 */
public class Ordena implements Comparator{
    @Override
    public int compare(Object t, Object t1) {
        Caminho c1 = (Caminho) t;
        Caminho c2 = (Caminho) t1;

        return (c1.getValorFitness() < c2.getValorFitness()) ? 1 : -1;
    }
}
