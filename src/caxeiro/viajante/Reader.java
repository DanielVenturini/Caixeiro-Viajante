/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caxeiro.viajante;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author diegohenriquedeabreu
 */
public class Reader {

    public LinkedList<No> processarArquivo(String nome) throws FileNotFoundException, IOException {
        LinkedList<No> nos = new LinkedList<>();
       
        Scanner in = new Scanner(new FileReader("./src/data/" + nome));
        int dimensao = 0;

        while (in.hasNext()) {
            String a = in.nextLine();
            String[] line = a.split(" ");
            

            if (line[0].equals("DIMENSION:")) {
                dimensao = Integer.parseInt(line[1]);
            }

            if (line[0].equals("NODE_COORD_SECTION")) {
                return getNos(dimensao, in);
            }

           
        }

        return nos;
    }

    public LinkedList<No> getNos(int dimensao, Scanner in) {
        LinkedList<No> nos = new LinkedList<>();
        for (int i = 0; i < dimensao; i++) {
            String [] line = in.nextLine().trim().replaceAll("   ", "  ").replaceAll("  "," ").split(" ");
            No no = new No(Integer.parseInt(line[0]),Float.parseFloat(line[1]),Float.parseFloat(line[2]));
            nos.add(no);
        
        }
        return nos;

    }
}
