package com.adaptleap.adapleapv1.repositories;

import com.adaptleap.adapleapv1.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRespository extends JpaRepository<Usuarios, Long> {
    public List<Usuarios> findAll();
}
