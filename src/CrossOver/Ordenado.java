/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrossOver;

import Populacao.Caminho;
import java.util.Collections;
import java.util.LinkedList;
import Populacao.No;
import Populacao.OperacoesPopulacao;
import java.util.Random;

/**
 *
 * @author Daniel
 */
public class Ordenado implements CrossOver{

    @Override
    public Caminho geraFilho(Caminho p1, Caminho p2, int k) {

        LinkedList<No> pai1 = p1.getCaminho();
        LinkedList<No> pai2 = p2.getCaminho();

        // para o filho clona o primeir pai
        LinkedList<No> filho = (LinkedList<No>) pai1.clone();

        // lista da posicao de k elementos aleatorios em ordem
        int[] p = geraElementos(k, pai1.size());

        // subconjunto com os k elementos de p1 correspondentes as posicoes na lista p
        LinkedList<No> s = getElementosPelaPosicao(p, k, pai1);

        // indices dos elementos de s ordenados em relacao a suas posicoes em p2
        int[] p_ord = getElementosEmRelacao(s, k, pai2);

        // para cada indice i dos elementos de s:
        // r[p[i]] = s[p_ord[i]]
        for (int i = 0; i < k; i++) {
            No nr = filho.get(p[i]);
            No ns = s.get(p_ord[i] - 1);

            nr.setLabel(ns.getLabel());
            nr.setLatitude(ns.getLatitude());
            nr.setLongitude(ns.getLongitude());
        }

        // print(p, p_ord, s, filho);
        // retorna o caminho filho com sua funcao fitness
        return new Caminho(filho, OperacoesPopulacao.fitness(filho));
    }

    private static int[] getElementosEmRelacao(LinkedList<No> s, int k, LinkedList<No> pai2) {
        int[] p_ord = new int[k];

        int ordem = 1;
        for (No npai2 : pai2) {

            // verifica se ele esta na lista s
            int j = 0;
            for (No ns : s) {

                if (npai2.getLabel() == ns.getLabel()) {
                    // em sua posicao seta sua ordem
                    p_ord[j] = ordem++;
                }

                j++;
            }

            // se ordem for maior que k, entao ja foi todos os elementos de k
            // entao pode retornar, nao precisa continuar percorrendo, pois nao ha mais o que fazer
            if (ordem > k) {
                return p_ord;
            }
        }

        return p_ord;
    }

    private static LinkedList<No> getElementosPelaPosicao(int[] p, int k, LinkedList<No> pai1) {
        LinkedList<No> s = new LinkedList<>();

        // para cada elemento de p
        for (int i = 0; i < k; i++) {
            // para cada elemento de p, obtem o elemento em pai que corresponde esta posicao

            // tem que criar um novo para nao gerar inconsistencia depois
            No n = pai1.get(p[i]);
            No novo = new No(n.getLabel(), n.getLatitude(), n.getLongitude());
            s.add(novo);
        }

        GreaterThan funOrdenacao = new GreaterThan();
        Collections.sort(s, funOrdenacao);
        return s;
    }

    private static int[] geraElementos(int k, int max) {

        int[] v = new int[k];
        Random gerador = new Random();

        // gera k valores aleatorios
        for (int i = 0; i < k; i++) {
            // valores e 0 até max
            int gerado = gerador.nextInt(max);
            // se for repetido tem que refazer o for
            if(contains(gerado, v, i)){
                i --;
                continue;
            }

            v[i] = gerado;
            sort(v, i + 1);
        }

        return v;
    }

    private static boolean contains(int gerado, int[] v, int max){
        for(int i = 0; i < max; i ++){
            if(v[i] == gerado){
                return true;
            }
        }

        return false;
    }

    private static void sort(int[] v, int size) {

        int i = size - 1;
        // enquanto o anterior for maior, troca os valores
        // quando o anterior nao for maior, jah esta ordenado
        while (i > 0 && v[i - 1] > v[i]) {
            int aux = v[i - 1];
            v[i - 1] = v[i];
            v[i] = aux;

            i--;
        }
    }

    private static void print(int[] p, int[] p_ord, LinkedList<No> s, LinkedList<No> filho) {
        System.out.print("\nLista P: ");
        for (int i : p) {
            System.out.print(i + "|");
        }

        System.out.print("\nList S: ");
        for (No n : s) {
            System.out.print(n.getLabel() + "|");
        }

        System.out.print("\nLista p_ord: ");
        for (int i : p_ord) {
            System.out.print(i + "|");
        }

        System.out.print("\nFilho: ");
        for (No n : filho) {
            System.out.print(n.getLabel() + "|");
        }

        System.out.println("");
    }
}
