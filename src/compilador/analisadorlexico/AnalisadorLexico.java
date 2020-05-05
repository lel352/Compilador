/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.analisadorlexico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Leandro, Cassio
 *
 * Classe com obejetivo de analisar os tokens
 */
public class AnalisadorLexico {

    private List<Tokens> tokens = new ArrayList<Tokens>();
    private String erros;
    private Integer linhaerro = 0;
    private Map<String, Integer> listTolkens = new HashMap<String, Integer>();

    public AnalisadorLexico() {
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

    public List<Tokens> lerTexto(String texto) { // separar caracter por caracter do texto
        
        
        char quebra = '\n';
        String alfabeto = "abcdefghijklmnopqrstuvwyxz_ABCDEFGHIJKLMNOPQRSTUVWYXZ";
        String numeros = "0123456789";
        String caracter = ";,.+-()*/";
        String compar = ":=<>";
        String inicial, leitura = "", leituracompar = "", auxiliar = "";
        Integer linha = 1, linhabloco = 1;
        Integer auton = -1;
        boolean ident = false;

        //List<Tokens> token = new ArrayList<Tokens>();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == quebra) { // quebra de linha
                ident = false;
                if (!leitura.trim().equals("")) {
                    classificaTolkens(leitura, linha);
                    leitura = "";
                }
                linha++;
                if (auton < 4) {
                    auton = -1;
                }
                continue;
            }
            inicial = String.valueOf(texto.charAt(i));
            
            // tratando o literal
            if (auton == 5) {
                if (inicial.equals("\"")) {
                    leitura = leitura + inicial;
                    classificaTolkens(leitura, linha);
                    leitura = "";
                    auton = -1;
                    continue;
                }
                leitura = leitura + inicial;
                continue;
            }
            // tratando o literal
            if (inicial.equals("\"")) {
                ident = false;
                if ((auton < 3) || (auton > 4)) {
                    if (!leitura.trim().equals("")) {
                        classificaTolkens(leitura, linha);
                        leitura = "";
                    }
                    linhabloco = linha; 
                    leitura = leitura + inicial;
                    auton = 5;
                    continue;
                }
            }
            // tratando bloc de comentario
            if (auton == 4) {
                if (inicial.equals("@")) {
                    auxiliar = inicial;
                    leituracompar = leituracompar + inicial;
                    if (leituracompar.equals("@@")) {
                        leituracompar = "";
                        auton = -1;
                    } else {
                        leituracompar = auxiliar;
                    }
                }
                continue;
            }
            // tratando bloco de comentario
            if ((inicial.equals("@")) || (auton == 3)) {
                ident = false;
                if (!leitura.trim().equals("")) {
                    classificaTolkens(leitura, linha);
                    leitura = "";
                }
                leituracompar = leituracompar + inicial;
                if (leituracompar.equals("@@")) {
                    leituracompar = "";
                    auton = 4;
                    linhabloco = linha;
                } else {
                    auton = 3;
                }
                continue;

            }
            // tratando comentario
            if ((inicial.equals("@")) || (auton >= 3)) {
                ident = false;
                if (!leitura.trim().equals("")) {
                    classificaTolkens(leitura, linha);
                    leitura = "";
                }
                if (leitura.equals("@@")) {
                    leitura = "";
                    auton = 4; //Bloco de 
                } else {
                    auton = 3;
                }
                leitura = leitura + inicial;
                continue;
            }
            
            // tratando sinais de comparação e o sinal de tribuição
            if (compar.indexOf(inicial) > -1) {
                ident = false;
                if (!leitura.trim().equals("")) {
                    if (auton == -1) {
                        if ((leitura.equals(":")) && (inicial.equals("="))) {
                            leitura = leitura + inicial;
                            classificaTolkens(leitura, linha);
                            leitura = "";
                            auton = -1;
                            continue;
                        } else if ((leitura.equals(">")) && (inicial.equals("="))) {
                            leitura = leitura + inicial;
                            classificaTolkens(leitura, linha);
                            leitura = "";
                            auton = -1;
                            continue;
                        } else if ((leitura.equals("<")) && ((inicial.equals("=")) || (inicial.equals(">")))) {
                            leitura = leitura + inicial;
                            classificaTolkens(leitura, linha);
                            leitura = "";
                            auton = -1;
                            continue;
                        } else {
                            classificaTolkens(leitura, linha);
                            leitura = "";
                            leitura = leitura + inicial;
                            auton = -1;
                            continue;
                        }
                    } else {
                        classificaTolkens(leitura, linha);
                        leitura = "";
                        leitura = leitura + inicial;
                        auton = -1;
                        continue;
                    }
                }
                leitura = leitura + inicial;
                auton = -1;
            } else {
                if (alfabeto.indexOf(inicial) > -1) { // indetificadores
                    if (ident == false){
                        if ((auton != 0) && (!leitura.trim().equals(""))) {
                            classificaTolkens(leitura, linha);
                            leitura = "";
                        }
                        ident = true;
                    }

                    leitura = leitura + inicial;
                    auton = 0;
                } else if (numeros.indexOf(inicial) > -1) { // numero inteiro
                    if (ident == false){
                        if ((auton != 1) && (!leitura.trim().equals(""))) {
                            classificaTolkens(leitura, linha);
                            leitura = "";
                        }
                        auton = 1;
                    }

                    leitura = leitura + inicial;
                    
                } else if (caracter.indexOf(inicial) > -1) { // caracteres
                    if ((auton != 2) && (!leitura.trim().equals(""))) {
                        classificaTolkens(leitura, linha);
                        leitura = "";
                    }

                    leitura = leitura + inicial;

                    classificaTolkens(leitura, linha);
                    leitura = "";
                    auton = 2;
                    ident = false;
                } else {
                    if (!leitura.trim().equals("")) {
                        classificaTolkens(leitura, linha);
                        leitura = "";
                    }
                }

                //token.put(new Tolkens(texto, i, i))
            }

        }

        switch(auton) {
            case 4:
                erros = "Erro ao finalizar um bloco de comentarios - linha " + String.valueOf(linhabloco);
                tokens.clear();
                break;
            case 5:
                erros = "Erro ao finalizar apas(\") - linha " + String.valueOf(linhabloco);
                tokens.clear();
                break;
            default:
                if ((auton <= 3) && (!leitura.trim().equals(""))) {
                    classificaTolkens(leitura, linha);
                }
                leitura = "$";
                classificaTolkens(leitura, linha);                
                break;
        }

        return tokens;

    }

    private void classificaTolkens(String valor, Integer linha) { //Classifica os tokens
        Integer regra;
        String carcInici = String.valueOf(valor.charAt(0));
        RegraTokens regraTokens = new RegraTokens();
        if ("\"".equals(carcInici)) {
            regra = regraTokens.regra("literal");
        } else if ("_".equals(carcInici)) {
            regra = regraTokens.regra("ident");
        } else if (("0123456789").indexOf(carcInici) > -1) {
            regra = regraTokens.regra("ninteiro");
        } else {
            regra = regraTokens.regra(valor.toLowerCase());
            if (regra == null) {
                regra = regraTokens.regra("ident");
            }
        }
        /*
         Integer regra;
        String carcInici = String.valueOf(valor.charAt(0));
        if ("\"".equals(carcInici)) {
            regra = listTolkens.get("literal");
        } else if ("_".equals(carcInici)) {
            regra = listTolkens.get("ident");
        } else if (("0123456789").indexOf(carcInici) > -1) {
            regra = listTolkens.get("ninteiro");
        } else {
            regra = listTolkens.get(valor.toLowerCase());
            if (regra == null) {
                regra = listTolkens.get("ident");
            }
        }*/
        tokens.add(new Tokens(valor, linha, regra));
    }

    public String returnerro() {
        return erros;
    }
}
