package com.weg.exemplo1.repository;

import com.weg.exemplo1.model.User;
import com.weg.exemplo1.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userRepository {


    public User criarUsuario(User user) throws SQLException {
        String query = "INSERT INTO users (nome) VALUES (?)";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getNome());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                user.setId(rs.getInt(1));

            }


        }

        return user;

    }

    public List<User> listarUsuarios() throws SQLException {

        String query = "SELECT id, nome FROM users";
        List<User> usuarios = new ArrayList<>();

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                usuarios.add(
                        new User(
                                rs.getInt("id"),
                                rs.getString("nome")
                        )
                );
            }
        }

        return usuarios;
    }


    public void deletarUser(int id) throws SQLException {
        String query = "DELETE FROM users where id = ?";


        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }

    }


    public void atualizarUsuario(User user) throws SQLException{

        String query = "UPDATE users SET nome = ? where id = ?";


        try(Connection connection = Conexao.conectar();
        PreparedStatement stmt = connection.prepareStatement(query)){

            stmt.setLong(1, user.getId());
            stmt.setString(2, user.getNome());
            stmt.executeUpdate();
        }


    }



}