package br.com.biblioteca.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/gerenciador_livros_db";
        String username = "postgres";
        String password = "root";
        return DriverManager.getConnection(url,username,password);
    }
}
