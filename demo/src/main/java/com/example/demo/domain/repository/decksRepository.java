package com.example.demo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.model.Deck;
import com.example.demo.domain.model.Usuario;




public interface decksRepository extends JpaRepository<Deck, Long>{
    
    List<Deck> findByUsuario(Usuario usuario);
}
