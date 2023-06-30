package com.adaptleap.adapleapv1.repositories;
import com.adaptleap.adapleapv1.models.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Long> {
    public List<Articles> findAll();
    public Articles findByTittle(String tittle);
}
