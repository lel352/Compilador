/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.analisadorlexico;

/**
 *
 * @author  Leandro, Cassio
 * Classe objeto que grava os tokens que foram analisador
 */
public class Tokens {

    protected String token; // tokens
    protected Integer linha; // linha que ele se encontra
    protected Integer regra; // regra

    public Tokens(String token, Integer linha, Integer regra) {
        this.token = token;
        this.linha = linha;
        this.regra = regra;
    }
    
    public String getTolken() {
        return token;
    }

    public void setTolken(String token) {
        this.token = token;
    }

    public Integer getLinha() {
        return linha;
    }
    
    public void setLinha(Integer linha) {
        this.linha = linha;
    }

    public Integer getRegra() {
        return regra;
    }

    public void setRegra(Integer regra) {
        this.regra = regra;
    }
}
