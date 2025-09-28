package br.com.biblioteca.repository;

import br.com.biblioteca.connection.ConnectionFactory;
import br.com.biblioteca.dominio.Editora;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static void delete(int id){
        String sql = "DELETE FROM editora WHERE id = (?);";
        try(Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
            log.info("Editora removida com sucesso!");
        }catch (SQLException e){
            log.error("Erro ao tentar remover a editora");
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

    public static List<Editora> findAll(){
        log.info("Procurando todas as editoras...");
        String sql = "SELECT id,nome FROM editora;";
        List<Editora> editoras = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            while(rs.next()){
                editoras.add(Editora.EditoraBuilder.anEditora().name(rs.getString("nome")).id(rs.getInt("id")).build());
            }
        }catch (SQLException e){
            log.error("Erro ao tentar selecionar as editoras");
            e.printStackTrace();
        }
        return editoras;
    }

    public static List<Editora> findByName(String nomeEditora){
        log.info("Procurando editoras com nome ",nomeEditora);
        String sql = "SELECT * FROM editora WHERE nome = (?);";
        List<Editora> editoras = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,nomeEditora);
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    editoras.add(Editora.EditoraBuilder.anEditora().name(rs.getString("nome")).id(rs.getInt("id")).build());
                }
            }
        }catch (SQLException e){
            log.error("Erro ao tentar selecionar a editora '{}'",nomeEditora);
            e.printStackTrace();
        }
        return editoras;
    }

    public static void mostraEditora(){
        log.info("Mostrando metadados de editoras:");
        String sql = "SELECT * FROM editora;";
        try(Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                ResultSetMetaData rsmt = rs.getMetaData();
                rs.next();
//                log.info("Nome da Editora: '{}'",rsmt.get);
                for(int i = 1; i <= rsmt.getColumnCount();i++){
                    log.info("Nome da coluna: '{}'",rsmt.getColumnName(i));
                    log.info("Tipo de dado da coluna: '{}'",rsmt.getColumnTypeName(i));
                    log.info("Catalog Name da coluna: '{}'",rsmt.getCatalogName(i));
                }
            }
        }catch (SQLException e){
            log.error("Erro ao tentar mostrar metadados");
            e.printStackTrace();
        }
    }
}
