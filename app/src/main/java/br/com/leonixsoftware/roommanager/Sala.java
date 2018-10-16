package br.com.leonixsoftware.roommanager;


import java.io.Serializable;

/**
 * Created by leondenis on 14/10/18.
 */

public class Sala implements Serializable {

    private Long id = -1L;
    private Integer numero = -1;
    private String apelido = null, bloco = null;
    private Integer andar = 0;

    public Sala() {
    }

    public Sala(Integer numero, String apelido, String bloco, Integer andar) {
        this.id = id;
        this.numero = numero;
        this.apelido = apelido;
        this.bloco = bloco;
        this.andar = andar;
    }


    public Sala(Long id, Integer numero, String apelido, String bloco, Integer andar) {
        this.id = id;
        this.numero = numero;
        this.apelido = apelido;
        this.bloco = bloco;
        this.andar = andar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\n" +
                "Apelido: " + this.apelido + "\n" +
                "Número: " + this.numero + "\n" +
                "Bloco: " + this.bloco + "\n" +
                "Andar: " + this.andar;
    }
}
