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

        LinkedList<No> filho = clone(pai1);
        Random gerador = new Random();

        // se gerar zero, recupera outro ponto de corte
        while((corte = gerador.nextInt(pai1.size())) == 0);

        for(int i = 0; corte < pai2.size(); i ++){

            No no1 = filho.get(corte);
            No no2 = pai2.get(i);
            if(notin(no2, filho, corte)){
                no1.setLabel(no2.getLabel());
                no1.setLatitude(no2.getLatitude());
                no1.setLongitude(no2.getLongitude());
                corte ++;
            }
        }

        return new Caminho(filho);
    }

    // alem de clonar a lista, precisa clonar os nos individualmente
    private static LinkedList<No> clone(LinkedList<No> pai){
        LinkedList<No> filho = new LinkedList<>();
        for(No n : pai){
            No no = new No(n.getLabel(), n.getLatitude(), n.getLongitude());
            filho.add(no);
        }

        return filho;
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
