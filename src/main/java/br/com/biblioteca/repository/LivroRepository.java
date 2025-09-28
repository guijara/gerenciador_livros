package br.com.biblioteca.repository;

import br.com.biblioteca.connection.ConnectionFactory;
import br.com.biblioteca.dominio.Editora;
import br.com.biblioteca.dominio.Livro;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Log4j2
public class LivroRepository {

    public static void save(Livro livro, int id){
        log.info("Preparando para inserir livro...");
        String sql = "INSERT INTO livro (nome, preco, lancamento,editora_id) VALUES (?,?,?,?);";
        try(Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,livro.getNome());
            ps.setDouble(2,livro.getPreço());
            ps.setDate(3,Date.valueOf(livro.getLançamento()));
            ps.setInt(4,id);
            ps.executeUpdate();
            log.info("Livro '{}' adicionado com sucesso!",livro.getNome());
        }catch (SQLException e){
            log.info("Erro ao tentar adicionar o livro '{}'",livro.getNome());
            e.printStackTrace();
        }
    }

    public static List<Livro> findAll(){
        String sql = "SELECT * FROM livro;";
        List<Livro> livros = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                livros.add(Livro.LivroBuilder.aLivro().nome(rs.getString("nome")).lançamento(rs.getDate("lancamento").toLocalDate()).preço(rs.getDouble("preco")).id(rs.getInt("id")).build());
            }
        }catch (SQLException e){
            log.info("Erro ao tentar selecionar Livros!");
            e.printStackTrace();
        }
        return livros;
    }

    public static void delete(int id){
        String sql = "DELETE FROM livro WHERE id = (?);";
        try(Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
            log.info("Livro removido com sucesso!");
        }catch (SQLException e){
            log.error("Erro ao tentar remover o Livro");
            e.printStackTrace();
        }
    }

    public static void update(Livro livro){
        String sql = "UPDATE livro SET nome = (?) WHERE id = (?);";
        try(Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, livro.getNome());
            ps.setInt(2, livro.getId());
            ps.executeUpdate();
            log.info("Livro '{}' atualizado com sucesso!",livro.getNome());
        }catch (SQLException e){
            log.error("Erro ao tentar atualizar o Livro '{}'",livro.getNome());
            e.printStackTrace();
        }
    }

    public static List<Livro> findByName(String nomeLivro){
        log.info("Procurando Livros com nome ",nomeLivro);
        String sql = "SELECT * FROM livro WHERE nome = (?);";
        List<Livro> livros = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,nomeLivro);
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    livros.add(Livro.LivroBuilder.aLivro().nome(rs.getString("nome")).preço(rs.getDouble("preco")).lançamento(rs.getDate("lancamento").toLocalDate()).id(rs.getInt("id")).build());
                }
            }
        }catch (SQLException e){
            log.error("Erro ao tentar selecionar o Livro '{}'",nomeLivro);
            e.printStackTrace();
        }
        return livros;
    }
}
