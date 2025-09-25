package br.com.biblioteca.repository;

import br.com.biblioteca.connection.ConnectionFactory;
import br.com.biblioteca.dominio.Editora;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class EditoraRepository {

    public static void save(Editora editora){
        String sql = "INSERT INTO editora (nome) VALUES (?);";
        try(Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, editora.getName());
            ps.executeUpdate();
            log.info("Editora '{}' inserida com sucesso!",editora.getName());
        }catch (SQLException e){
            log.error("Erro ao tentar inserir a editora '{}'",editora.getName());
            e.printStackTrace();
        }
    }

    public static void delete(Editora editora){
        String sql = "DELETE FROM editora WHERE nome = (?);";
        try(Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, editora.getName());
            ps.executeUpdate();
            log.info("Editora '{}' removida com sucesso!",editora.getName());
        }catch (SQLException e){
            log.error("Erro ao tentar remover a editora '{}'",editora.getName());
            e.printStackTrace();
        }
    }

    public static void update(Editora editora){
        String sql = "UPDATE editora SET nome = (?) WHERE id = (?);";
        try(Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, editora.getName());
            ps.setInt(2, editora.getId());
            ps.executeUpdate();
            log.info("Editora '{}' atualizada com sucesso!",editora.getName());
        }catch (SQLException e){
            log.error("Erro ao tentar atualizar a editora '{}'",editora.getName());
            e.printStackTrace();
        }
    }
}
