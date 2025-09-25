package br.com.biblioteca.test;

import br.com.biblioteca.dominio.Editora;
import br.com.biblioteca.repository.EditoraRepository;

public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Editora editora = Editora.EditoraBuilder.anEditora().name("Janina").build();
        EditoraRepository.save(editora);
    }
}
