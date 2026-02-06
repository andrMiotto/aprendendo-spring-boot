package com.weg.exemplo1.controller;

import com.weg.exemplo1.model.User;
import com.weg.exemplo1.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;

@RestController
@RequestMapping("/olaMundo")
public class exemploController {
      UserService userService = new UserService();

    @GetMapping
    public List<User> listarTodos() throws SQLException {
        return userService.listarTodos();
    }

    @PostMapping
    public User criarUser(@RequestBody User user) throws SQLException {
        return userService.criarUser(user);
    }


    @DeleteMapping("/{id}")
    public void deletarUser(@PathVariable("id") int id)throws SQLException{
         userService.deletarUsuario(id);
    }

}