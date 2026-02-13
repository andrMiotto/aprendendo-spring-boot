package com.weg.exemplo1.service;

import com.weg.exemplo1.model.User;
import com.weg.exemplo1.repository.userRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    userRepository userRepository = new userRepository();


    public User criarUser(User user) throws SQLException {
        return userRepository.criarUsuario(user);
    }

    public List<User> listarTodos() throws SQLException {
        return userRepository.listarUsuarios();
    }


    public void deletarUsuario(int id) throws SQLException {
        userRepository.deletarUser(id);

    }


    public User atualizarUsuario(int id, User user) throws SQLException {
        user.setId(id);
        userRepository.atualizarUsuario(user);
        return user;
    }

}
