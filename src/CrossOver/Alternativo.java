/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrossOver;

import java.util.LinkedList;
import Populacao.Caminho;
import java.util.Random;
import Populacao.No;

/**
 *
 * @author venturini
 */
public class Alternativo implements CrossOver {

    @Override
    public Caminho geraFilho(Caminho p1, Caminho p2, int corte) {

        LinkedList<No> pai1 = p1.getCaminho();
        LinkedList<No> pai2 = p2.getCaminho();

        LinkedList<No> filho = (LinkedList<No>) pai1.clone();
        Random gerador = new Random();

        // se gerar zero, recupera outro ponto de corte
        while((corte = gerador.nextInt(pai1.size())) == 0);

        for(int i = corte; i < pai1.size(); i ++){

            No no1 = pai1.get(i);
            No no2 = pai2.get(i);
            // cada elemento de p2 é verificado antes de ser copiado para a solução, de forma que
            // elementos já existentes não sejam duplicados.
            if(notin(no1, pai2, i) && notin(no2, pai1, i)){
                No noFilho = filho.get(i);
                noFilho.setLabel(no2.getLabel());
                noFilho.setLatitude(no2.getLatitude());
                noFilho.setLongitude(no2.getLongitude());
            }
        }

        return new Caminho(filho);
    }

    private static boolean notin(No no, LinkedList<No> pai, int max){
        for(int i = 0; i < max; i ++){
            if(no.getLabel() == pai.get(i).getLabel()){
                return false;
            }
        }

        return true;
    }
}
