package br.com.biblioteca.test;

import br.com.biblioteca.dominio.Editora;
import br.com.biblioteca.service.EditoraService;

import java.util.Scanner;

public class CrudTest01 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int option = -1;
        while(option != 0){
            option = filtraOpção();
            EditoraService.menuCrud(option);
        }
    }

    private static void menu(){
        System.out.println("Selecione a operação que deseja realizar:");
        System.out.println("1 - Buscar todas as editoras");
        System.out.println("2 - Buscar editora por nome");
        System.out.println("3 - Alterar dados de uma Editora");
        System.out.println("4 - Remover dados de uma Editora");
        System.out.println("5 - Inserir uma Editora");
        System.out.println("0 - Sair");
    }

    private static int filtraOpção(){
        menu();
        int option = scanner.nextInt();
        while (true){
            if (option < 0 || option > 5){
                System.out.printf("O número deve ser de 0 à 5!");
                menu();
                scanner.nextInt();
            }
            break;
        }
        return option;
    }

}
