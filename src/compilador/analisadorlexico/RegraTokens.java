/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.analisadorlexico;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Leandro
 */
public class RegraTokens {
    private Map<String, Integer> listTolkens = new HashMap<String, Integer>();
    
    public RegraTokens() {
        gerarlistatokens();
    }
    
    public void gerarlistatokens() { //Criar a lista  de tokens


        listTolkens.put("var", 1);
        listTolkens.put("senao", 2);
        listTolkens.put("se", 3);
        listTolkens.put("repita", 4);
        listTolkens.put("procedure", 5);
        listTolkens.put("or", 6);
        listTolkens.put("of", 7);
        listTolkens.put("ninteiro", 8);
        listTolkens.put("nao", 9);
        listTolkens.put("literal", 10);
        listTolkens.put("le", 11);
        listTolkens.put("integer", 12);
        listTolkens.put("inicio", 13);
        listTolkens.put("ident", 14);
        listTolkens.put("î", 15);
        listTolkens.put("fim", 16);
        listTolkens.put("faca", 17);
        listTolkens.put("escreve", 18);
        listTolkens.put("entao", 19);
        listTolkens.put("enquanto", 20);
        listTolkens.put("chama", 21);
        listTolkens.put("caso", 22);
        listTolkens.put("begin", 23);
        listTolkens.put("ate", 24);
        listTolkens.put("and", 25);
        listTolkens.put(">=", 26);
        listTolkens.put(">", 27);
        listTolkens.put("=", 28);
        listTolkens.put("<>", 29);
        listTolkens.put("<=", 30);
        listTolkens.put("<", 31);
        listTolkens.put("+", 32);
        listTolkens.put(";", 33);
        listTolkens.put(":=", 34);
        listTolkens.put(":", 35);
        listTolkens.put("/", 36);
        listTolkens.put(".", 37);
        listTolkens.put(",", 38);
        listTolkens.put("*", 39);
        listTolkens.put(")", 40);
        listTolkens.put("(", 41);
        listTolkens.put("$", 42);
        listTolkens.put("-", 43);
    }
    
    public Integer regra(String busca){
        return listTolkens.get(busca);
    }    
    
}
