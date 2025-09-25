package br.com.biblioteca.repository;

import br.com.biblioteca.connection.ConnectionFactory;
import br.com.biblioteca.dominio.Editora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EditoraRepository {
    public static void save(Editora editora){
        String sql = "INSERT INTO editora (nome) VALUES (?);";
        try(Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, editora.getName());
            ps.executeUpdate();
            System.out.println("Editora '" + editora.getName() + "' inserida com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
