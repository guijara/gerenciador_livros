package br.com.biblioteca.service;

import br.com.biblioteca.dominio.Editora;
import br.com.biblioteca.dominio.Livro;
import br.com.biblioteca.repository.EditoraRepository;
import br.com.biblioteca.repository.LivroRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LivroService {
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
        System.out.println("Digite o nome do Livro:");
        String nome = scanner.nextLine();
        System.out.println("Digite o preço do Livro:");
        String preço = scanner.nextLine();
        System.out.println("Digite a data de Lançamento do Livro:");
        System.out.print("Ano (AAAA): ");
        int ano = scanner.nextInt();
        System.out.print("Mês (1-12): ");
        int mes = scanner.nextInt();
        System.out.print("Dia (1-31): ");
        int dia = scanner.nextInt();
        scanner.nextLine();
        LocalDate lancamento = LocalDate.of(ano, mes, dia);
        System.out.println("Qual editora ele pertence?");
        EditoraService.findByName();
        System.out.println("Digite o ID da editora que quer escolher: ");
        int idEditora = scanner.nextInt();
        br.com.biblioteca.dominio.Livro livro = Livro.LivroBuilder.aLivro().nome(nome).preço(Double.parseDouble(preço)).lançamento(lancamento).editora(Editora.EditoraBuilder.anEditora().id(idEditora).build()).build();
        LivroRepository.save(livro,idEditora);
    }

    public static void delete(){
        System.out.println("Digite o ID do Livro que deseja remover:");
        int idLivro = scanner.nextInt();
        LivroRepository.delete(idLivro);
    }

    public static void update(){
        System.out.println("Digite o ID do Livro que deseja alterar:");
        int idLivro = scanner.nextInt();
        System.out.println("Digite o novo nome que deseja inserir no Livro:");
        String nome = scanner.nextLine();
        Livro livro = Livro.LivroBuilder.aLivro().id(idLivro).nome(nome).build();
    }

    public static void findAll(){
        List<Livro> livros = LivroRepository.findAll();
        for (int i = 0;i < livros.size();i++){
            System.out.println(i+" - "+livros.get(i).getNome());
        }
    }

    public static void findByName(){
        System.out.println("Qual o nome do Livro que deseja procurar?: ");
        String nomeLivro = scanner.nextLine();
        List<Livro>livros = LivroRepository.findByName(nomeLivro);
        for (int i = 0; i < livros.size();i++){
            System.out.println(i+" - "+livros.get(i).getNome());
        }
    }
}
