package com.example.demo.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.dto.deckRequestDTO;
import com.example.demo.domain.dto.deckResponseDTO;
import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.model.Deck;
import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.repository.decksRepository;



@Service
public class deckService implements ICRUDService<deckRequestDTO, deckResponseDTO>{
    @Autowired
    private decksRepository GerenciaPratosRespository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<deckResponseDTO> obterTodos() {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("Teste" + usuario);
        List<Deck> GerenciaPratoss = GerenciaPratosRespository.findByUsuario(usuario);
        return GerenciaPratoss.stream()
        .map(GerenciaPratos -> mapper.map(GerenciaPratos, deckResponseDTO.class))
        .collect(Collectors.toList());

    }

    @Override
    public deckResponseDTO obterPorId(Long id) {
        Optional<Deck> optGerenciaPratos = GerenciaPratosRespository.findById(id);
        if(optGerenciaPratos.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível encontrar o título com o id: " + id);
        }
        return mapper.map(optGerenciaPratos.get(), deckResponseDTO.class);
    }

    @Override
    public deckResponseDTO cadastrar(deckRequestDTO dto) {
        Deck GerenciaPratos = mapper.map(dto,Deck.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        GerenciaPratos.setUsuario(usuario);
        GerenciaPratos.setId(null);

        GerenciaPratos = GerenciaPratosRespository.save(GerenciaPratos);
        return mapper.map(GerenciaPratos, deckResponseDTO.class);
    }

    @Override
    public deckResponseDTO atualizar(Long id, deckRequestDTO dto) {
        obterPorId(id);
        Deck GerenciaPratos = mapper.map(dto, Deck.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        GerenciaPratos.setUsuario(usuario);
        GerenciaPratos.setId(id);
        GerenciaPratos = GerenciaPratosRespository.save(GerenciaPratos);
        return mapper.map(GerenciaPratos, deckResponseDTO.class);
    }

    @Override
    public void deletar(Long id) {
        obterPorId(id);
        GerenciaPratosRespository.deleteById(id);
    }


}
