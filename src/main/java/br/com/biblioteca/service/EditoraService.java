package br.com.biblioteca.service;

import br.com.biblioteca.dominio.Editora;
import br.com.biblioteca.repository.EditoraRepository;

import java.util.List;

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

    public static List<Editora> findAll(){
        return EditoraRepository.findAll();
    }

    public static List<Editora> findByName(String nomeEditora){
        return EditoraRepository.findByName(nomeEditora);
    }

}
