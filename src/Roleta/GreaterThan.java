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

public class GreaterThan implements Comparator {

    @Override
    public int compare(Object t, Object t1) {
        Caminho caminho1 = (Caminho) t;
        Caminho caminho2 = (Caminho) t1;

        return (caminho1.getValorFitness() < caminho2.getValorFitness()) ? -1 : 0;
    }
}