package com.adaptleap.adapleapv1.services;

import com.adaptleap.adapleapv1.models.Usuarios;
import com.adaptleap.adapleapv1.repositories.UsersRespository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UsersRespository usersRespository;

    public UserService(UsersRespository usersRespository) {
        this.usersRespository = usersRespository;
    }

    public Usuarios registerUser(String name , String username , String email , String password , String telefone){
        Usuarios user = new Usuarios();
        user.setNombreCompleto(name);
        user.setUserName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setTelefone(telefone);
        return usersRespository.save(user);
    }

    public Usuarios loginUser(String email, String password) {

        Usuarios usuario = usersRespository.findByEmail(email);

        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        } else {
            return null;
        }
    }

}
