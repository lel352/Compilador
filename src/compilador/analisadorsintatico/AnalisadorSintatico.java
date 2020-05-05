/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.analisadorsintatico;

import compilador.analisadorlexico.Tokens;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Leandro
 */
public class AnalisadorSintatico {

    private LinkedList<Integer> pilha = new LinkedList<Integer>();
    private int linha;
    private String nomeToken;
    
    public String returnErro(){
        return "Erro na linha "+linha+ " no token: "+nomeToken;
    }    
    
    public AnalisadorSintatico() {
        pilha.addFirst(42);
        pilha.addFirst(44);
     /*   RegrasGramatica regrasGramatica = new RegrasGramatica();
        String regras[] = regrasGramatica.getGramatica(1);
        for (int i = (regras.length - 1); i >= 0; i--) {
            pilha.addFirst(Integer.valueOf(regras[i]));
        }*/
    }

    public Integer Analisar(List<Tokens> tokens) {
        for (int i=0;i<tokens.size();i++){
            Tokens token = tokens.get(i);
            int resu = Analisador(token.getRegra());
            if (resu == 2){ 
                linha = token.getLinha();
                nomeToken =  token.getTolken();
                return 2;
            }    
        }
        return 0;
    }

    public Integer Analisador(Integer sEntrada) { //0 - fim , 1- sai sem erros 2-sai comerro
        Integer topPilha;
        Integer simboloEntrada;

        topPilha = pilha.getFirst(); //X recebe o topo da pilha
        simboloEntrada = sEntrada;   //“a”  recebe o símbolo da entrada

        do {
            if (topPilha == 15) {
                pilha.removeFirst(); //Retire o elemento do topo da pilha
                topPilha = pilha.getFirst();   //X recebe o topo da pilha 
            } else if ((topPilha >= 1) && (topPilha <= 43)) { //Se X é terminal então
                if (topPilha == simboloEntrada) {//Se X=a então
                    pilha.removeFirst();//Retire o elemento do topo da pilha
                    return 1; //Sai do Repita // 
                } else {
                    return 2; //Encerra o programa  	
                }
            } else if ((topPilha >= 44) && (topPilha <= 72)) { //Senão (* X é não-terminal*)
                TabelaParsing tabelaParsing = new TabelaParsing();
                Integer regra = tabelaParsing.regra(topPilha, simboloEntrada);
                if (regra != 0) { //Se M(X,a) <> ∅ então (existe uma regra)
                    pilha.removeFirst();//Retire o elemento do topo da pilha 
                    //Coloque o conteúdo da regra na pilha
                    RegrasGramatica regrasGramatica = new RegrasGramatica();
                    String regras[] = regrasGramatica.getGramatica(regra);
                    for (int i = (regras.length - 1); i >= 0; i--) {
                        pilha.addFirst(Integer.valueOf(regras[i]));
                    }
                    topPilha = pilha.getFirst(); //X recebe o topo da pilha
                } else {
                    return 2; //Encerra o programa  	
                }
            }
        } while (topPilha != 42);
        return 0;
        /*
         Início
         X recebe o topo da pilha
         “a”  recebe o símbolo da entrada
         Repita
         Se X=î então
         Retire o elemento do topo da pilha
         X recebe o topo da pilha
         Senão
         Se X é terminal então
         Se X=a então
         Retire o elemento do topo da pilha
         Sai do Repita
         Senão
         Erro
         Encerra o programa 		
         Fim Se
         Senão (* X é não-terminal*)
         Se M(X,a) <> ∅ então (existe uma regra)
         Retire o elemento do topo da pilha 
         Coloque o conteúdo da regra na pilha
         X recebe o topo da pilha
         Senão
         Erro
         Encerra o programa
         Fim Se
         Fim Se
         Até X=$ (*pilha vazia, análise concluída*)
         Fim
         */
    }
}
