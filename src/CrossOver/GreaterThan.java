/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrossOver;

import Populacao.No;
import java.util.Comparator;

/**
 *
 * @author Daniel
 */

public class GreaterThan implements Comparator {
    @Override
    public int compare(Object arg0, Object arg1) {
        No n1 = (No) arg0;
        No n2 = (No) arg1;

        int i1 = n1.getLabel();
        int i2 = n2.getLabel();

        if(i1 < i2) {
            return -1;
        } else if(i1 == i2) {
            return 0;
        } else {
            return 1;
        }
    }
}