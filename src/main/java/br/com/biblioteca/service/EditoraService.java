package br.com.biblioteca.service;

import br.com.biblioteca.dominio.Editora;
import br.com.biblioteca.repository.EditoraRepository;

public class EditoraService {

    public static void save(Editora editora){
        EditoraRepository.save(editora);
    }

    public static void delete(Editora editora){
        EditoraRepository.delete(editora);
    }

    public static void update(Editora editora){
        if (editora.getId() >= 0){
            EditoraRepository.update(editora);
        }
    }

}
