package com.adaptleap.adapleapv1.controllers;

import com.adaptleap.adapleapv1.models.Articles;
import com.adaptleap.adapleapv1.models.Usuarios;
import com.adaptleap.adapleapv1.repositories.ArticlesRepository;
import com.adaptleap.adapleapv1.repositories.UsersRespository;
import com.adaptleap.adapleapv1.services.UserService;
import jakarta.servlet.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiControler {
    private ArticlesRepository articlesRepository;
    private UsersRespository usersRespository;
    private UserService userService;

    @Autowired
    public ApiControler(ArticlesRepository articlesRepository , UsersRespository usersRespository , UserService userService){
        this.articlesRepository = articlesRepository;
        this.usersRespository = usersRespository;
        this.userService = userService;

    }

    @GetMapping("/users")
    public List<Usuarios> getUsersJson(){
        return usersRespository.findAll();
    }
    @GetMapping("/articles")
    public List<Articles> getArticlesJson(){
        return articlesRepository.findAll();
    }

    @PostMapping("/users/register")
    public Usuarios registerUser(@RequestBody Usuarios request){
        String NombreCompleto = "Aron Cachago";
        String username = request.getUserName();
        String email = request.getEmail();
        String password = request.getPassword();
        String telefone = "099999999";

        return  userService.registerUser(NombreCompleto , username , email , password , telefone);
    }

}
