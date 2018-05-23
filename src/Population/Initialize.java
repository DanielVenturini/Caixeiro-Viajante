/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Population;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import caxeiro.viajante.No;
import caxeiro.viajante.Reader;

/**
 *
 * @author a1724487
 */
public class Initialize {

    public static LinkedList<LinkedList<No>> startPopulation(String nomeFile, int k) throws IOException{

        Reader reader = new Reader();
        // le do arquivo
        LinkedList<No> wayMain = reader.processarArquivo(nomeFile);
        // lista com a populacao
        LinkedList<LinkedList<No>> population = new LinkedList<>();

        LinkedList<No> way;
        for (int i = 0; i < k; i ++) {

            way = (LinkedList<No>) wayMain.clone(); // clona o caminho original
            Collections.shuffle(way);               // embaralha ele
            population.add(way);                    // adiciona na populacao
        }

        return population;
    }
}
