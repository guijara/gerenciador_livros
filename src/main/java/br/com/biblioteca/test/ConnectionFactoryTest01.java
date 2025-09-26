package br.com.biblioteca.test;

import br.com.biblioteca.dominio.Editora;
import br.com.biblioteca.repository.EditoraRepository;
import br.com.biblioteca.service.EditoraService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ConnectionFactoryTest01 {
    private static final Logger log = LogManager.getLogger(ConnectionFactoryTest01.class);

    public static void main(String[] args) {
        Editora editora = Editora.EditoraBuilder.anEditora().id(2).name("Cerrado").build();
        List<Editora> editoras = EditoraService.findAll();
        log.info(editoras);
    }
}
