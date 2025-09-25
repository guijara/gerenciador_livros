package br.com.biblioteca.dominio;

public class Editora {
    private String name;
    private int id;


    public static final class EditoraBuilder {
        private String name;
        private int id;

        private EditoraBuilder() {
        }

        public static EditoraBuilder anEditora() {
            return new EditoraBuilder();
        }

        public EditoraBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EditoraBuilder id(int id) {
            this.id = id;
            return this;
        }

        public Editora build() {
            Editora editora = new Editora();
            editora.id = this.id;
            editora.name = this.name;
            return editora;
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
