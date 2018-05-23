/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrossOver;

import java.util.LinkedList;
import caxeiro.viajante.No;

/**
 *
 * @author venturini
 */
public interface CrossOver {

    public abstract LinkedList<No> geraFilho(LinkedList<No> pai1, LinkedList<No> pai2, int k);
    
}
