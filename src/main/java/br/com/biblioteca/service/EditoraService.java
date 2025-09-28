package br.com.biblioteca.service;

import br.com.biblioteca.dominio.Editora;
import br.com.biblioteca.repository.EditoraRepository;

import java.util.List;
import java.util.Scanner;

public class EditoraService {
    static Scanner scanner = new Scanner(System.in);
    public static void menuCrud(int option){
            switch (option){
                case 0:
                    System.out.printf("Saindo...");
                    break;
                case 1:
                    findAll();
                    break;
                case 2:
                    findByName();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    save();
                    break;
                default:
                    break;
            }
    }

    public static void save(){
        System.out.println("Digite o nome da Editora:");
        String nome = scanner.nextLine();
        Editora editora = Editora.EditoraBuilder.anEditora().name(nome).build();
        EditoraRepository.save(editora);
    }

    public static void delete(){
        System.out.println("Digite o ID da Editora que deseja remover:");
        int idEditora = scanner.nextInt();
        EditoraRepository.delete(idEditora);
    }

    public static void update(){
        System.out.println("Digite o ID da Editora que deseja alterar:");
        int idEditora = scanner.nextInt();
        System.out.println("Digite o novo nome que deseja inserir na Editora:");
        String nome = scanner.nextLine();
        Editora editora = Editora.EditoraBuilder.anEditora().id(idEditora).name(nome).build();
    }

    public static void findAll(){
        List<Editora> editoras = EditoraRepository.findAll();
        for (int i = 0;i < editoras.size();i++){
            System.out.println(i+" - "+editoras.get(i).getName());
        }
    }

    public static void findByName(){
        System.out.println("Qual o nome da Editora que deseja procurar?: ");
        String nomeEditora = scanner.nextLine();
        List<Editora>editoras = EditoraRepository.findByName(nomeEditora);
        for (int i = 0; i < editoras.size();i++){
            System.out.println(i+" - "+editoras.get(i).getName());
        }
    }

}
