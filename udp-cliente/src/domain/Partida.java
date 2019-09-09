/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author gudeck
 */
public class Partida {

    private Integer tentativas;
    private String palavra;
    private String letrasErradas;

    public Partida(String palavra) {
        this.tentativas = palavra.length() / 2 + 1;
        this.palavra = palavra.toUpperCase();
        this.letrasErradas = "";
    }

    public Integer getTentativas() {
        return tentativas;
    }

    public void setTentativas() {
        this.tentativas--;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getLetrasErradas() {
        return letrasErradas;
    }

    public void setLetrasErradas(String letra) {
        if (this.letrasErradas.isEmpty()) {
            this.letrasErradas = letra;
        } else {
            this.letrasErradas = this.letrasErradas.concat(", ".concat(letra));
        }
    }

}
