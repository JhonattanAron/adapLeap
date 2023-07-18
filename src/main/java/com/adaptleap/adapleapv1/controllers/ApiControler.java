package com.adaptleap.adapleapv1.controllers;

import com.adaptleap.adapleapv1.models.Articles;
import com.adaptleap.adapleapv1.models.Usuarios;
import com.adaptleap.adapleapv1.repositories.ArticlesRepository;
import com.adaptleap.adapleapv1.repositories.UsersRespository;
import com.adaptleap.adapleapv1.services.ArticlesService;
import com.adaptleap.adapleapv1.services.UserService;
import jakarta.servlet.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiControler {
    private ArticlesRepository articlesRepository;
    private UsersRespository usersRespository;
    private UserService userService;
    private ArticlesService articlesService;

    @Autowired
    public ApiControler(ArticlesRepository articlesRepository , UsersRespository usersRespository , UserService userService , ArticlesService articlesService){
        this.articlesRepository = articlesRepository;
        this.usersRespository = usersRespository;
        this.userService = userService;
        this.articlesService = articlesService;

    }

    @GetMapping("/users")
    public List<Usuarios> getUsersJson(){
        return usersRespository.findAll();
    }
    @GetMapping("/articles")
    public List<Articles> getArticlesJson(){
        return articlesRepository.findAll();
    }


    @CrossOrigin(origins = "http://localhost")
    @PostMapping("/users/register")
    public Usuarios registerUser(@RequestBody Usuarios request){
        String NombreCompleto = "Aron Cachago";
        String username = request.getUserName();
        String email = request.getEmail();
        String password = request.getPassword();
        String telefone = "099999999";

        System.out.println("Received user data:");
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        return  userService.registerUser(NombreCompleto , username , email , password , telefone);
    }


    @CrossOrigin(origins = "http://localhost")
    @PostMapping("/users/login")
    public ResponseEntity<?> loginUser(@RequestBody Usuarios request) {
        String email = request.getEmail();
        String password = request.getPassword();

        System.out.println("Received user data:");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        Usuarios usuarioEncontrado = userService.loginUser(email, password);
        if (usuarioEncontrado != null) {
            return ResponseEntity.ok(usuarioEncontrado); // Usuario encontrado
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado"); // Usuario no encontrado
        }
    }
    @CrossOrigin(origins = "http://localhost")
    @PostMapping("/articles/register")
    public Articles registerArticle(@RequestBody Articles request) {
        System.out.println("Recibiendo Datos......");
        String tittle = request.getTittle();
        String imgUrl = request.getImgUrl();
        String p1 = request.getParagraphOne();
        String p2 = request.getParagraphTwo();
        String footer = request.getFooter();

        System.out.println(" Data recibida con " + tittle);
        return articlesService.registerArticle(tittle , imgUrl , p1 , p2 , footer);
    }




}
