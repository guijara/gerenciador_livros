package br.com.biblioteca.dominio;

import java.time.LocalDate;

public class Livro {
    private int id;
    private String nome;
    private double preço;
    private LocalDate lançamento;
    Editora editora;


    public static final class LivroBuilder {
        private int id;
        private String nome;
        private double preço;
        private LocalDate lançamento;
        private Editora editora;

        private LivroBuilder() {
        }

        public static LivroBuilder aLivro() {
            return new LivroBuilder();
        }

        public LivroBuilder id(int id) {
            this.id = id;
            return this;
        }

        public LivroBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public LivroBuilder preço(double preço) {
            this.preço = preço;
            return this;
        }

        public LivroBuilder lançamento(LocalDate lançamento) {
            this.lançamento = lançamento;
            return this;
        }

        public LivroBuilder editora(Editora editora) {
            this.editora = editora;
            return this;
        }

        public Livro build() {
            Livro livro = new Livro();
            livro.lançamento = this.lançamento;
            livro.editora = this.editora;
            livro.id = this.id;
            livro.nome = this.nome;
            livro.preço = this.preço;
            return livro;
        }
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreço() {
        return preço;
    }

    public LocalDate getLançamento() {
        return lançamento;
    }
}
