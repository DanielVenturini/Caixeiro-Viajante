/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrossOver;

import Populacao.Caminho;
import java.util.Comparator;

/**
 *
 * @author Daniel
 */

public class GreaterThan implements Comparator {
    // ordena em ordem decrescente
    @Override
    public int compare(Object arg0, Object arg1) {
        Caminho caminho0 = (Caminho) arg0;
        Caminho caminho1 = (Caminho) arg1;

        double i0 = caminho0.getValorFitness();
        double i1 = caminho1.getValorFitness();

        if(i0 < i1) {
            return 1;
        } else if(i0 == i1) {
            return 0;
        } else {
            return -1;
        }
    }
}