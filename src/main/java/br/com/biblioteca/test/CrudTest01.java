package br.com.biblioteca.test;

import br.com.biblioteca.service.EditoraService;
import br.com.biblioteca.service.LivroService;

import java.util.Scanner;

public class CrudTest01 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int option1 = -1;
        while(option1 != 0){
            option1 = filtraMenuPrincipal();
            int option2 = -1;
            if (option1 == 1){
                while (option2 != 0){
                    option2 = filtraOpção1();
                    EditoraService.menuCrud(option2);
                }
            } else if (option1 == 2) {
                while (option2 != 0){
                    option2 = filtraOpção2();
                    LivroService.menuCrud(option2);
                }
            }
        }
    }

    private static void menuEditora(){
        System.out.println("Selecione a operação que deseja realizar:");
        System.out.println("1 - Buscar todas as editoras");
        System.out.println("2 - Buscar editora por nome");
        System.out.println("3 - Alterar dados de uma Editora");
        System.out.println("4 - Remover dados de uma Editora");
        System.out.println("5 - Inserir uma Editora");
        System.out.println("0 - Sair");
    }

    private static void menuLivro(){
        System.out.println("Selecione a operação que deseja realizar:");
        System.out.println("1 - Buscar todos os livros");
        System.out.println("2 - Buscar livros por nome");
        System.out.println("3 - Alterar dados de um Livro");
        System.out.println("4 - Remover dados de um Livro");
        System.out.println("5 - Inserir um livro");
        System.out.println("0 - Sair");
    }

    private static void menuPrincipal(){
        System.out.println("O que deseja navegar:");
        System.out.println("1 - Editoras");
        System.out.println("2 - Livros");
        System.out.println("0 - Sair");
    }

    private static int filtraMenuPrincipal(){
        menuPrincipal();
        int option = scanner.nextInt();
        while (true){
            if (option < 0 || option > 2){
                System.out.println("Deve escolher entre 0 e 2!");
                menuPrincipal();
                option = scanner.nextInt();
            }
            break;
        }
        return option;
    }

    private static int filtraOpção1(){
        menuEditora();
        int option = scanner.nextInt();
        while (true){
            if (option < 0 || option > 5){
                System.out.printf("O número deve ser de 0 à 5!");
                menuEditora();
                option = scanner.nextInt();
            }
            break;
        }
        return option;
    }

    private static int filtraOpção2(){
        menuLivro();
        int option = scanner.nextInt();
        while (true){
            if (option < 0 || option > 5){
                System.out.printf("O número deve ser de 0 à 5!");
                menuLivro();
                option = scanner.nextInt();
            }
            break;
        }
        return option;
    }

}
