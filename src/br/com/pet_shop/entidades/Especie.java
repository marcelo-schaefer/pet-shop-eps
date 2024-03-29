package br.com.pet_shop.entidades;

public class Especie {

    private Integer id;

    private String nome;

    public Especie(){
    }

    public Especie(Integer id) {
        this.id = id;
    }

    public Especie(String nome) {
        this.nome = nome;
    }

    public Especie(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
