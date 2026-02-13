package com.weg.exemplo1.controller;

import com.weg.exemplo1.model.User;
import com.weg.exemplo1.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;

@RestController
@RequestMapping("/olaMundo")
public class exemploController {
      UserService userService = new UserService();

    @GetMapping("/listar")
    public List<User> listarTodos() throws SQLException {
        return userService.listarTodos();
    }

    @PostMapping
    public User criarUser(@RequestBody User user) throws SQLException {

        try{
            user = userService.criarUser(user);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }


    @DeleteMapping("/{id}")
    public void deletarUser(@PathVariable("id") int id)throws SQLException{
         userService.deletarUsuario(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarUser(@PathVariable("id") int id, @RequestBody User user) throws SQLException{

       try{
           userService.atualizarUsuario(id,user);
           return new  ResponseEntity<>("Certo", HttpStatus.OK);
       }catch (SQLException e){
           return new  ResponseEntity<>("Erro", HttpStatus.INTERNAL_SERVER_ERROR);

       }

    }


}