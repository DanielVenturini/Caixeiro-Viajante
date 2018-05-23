/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roleta;

import java.util.LinkedList;
import caxeiro.viajante.No;

/**
 *
 * @author venturini
 */
public interface Roleta {

    public abstract void criaRoleta(LinkedList<LinkedList<No>> populacao);
    public abstract LinkedList<No> getPai();

}
