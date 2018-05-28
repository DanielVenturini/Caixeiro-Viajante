/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrossOver;

import Populacao.Caminho;

/**
 *
 * @author venturini
 */
public interface CrossOver {

    public abstract Caminho geraFilho(Caminho p1, Caminho p2, int k);
    
}
