package com.GuilhermeBrito.bookstore.service;

import com.GuilhermeBrito.bookstore.domain.Categoria;
import com.GuilhermeBrito.bookstore.dtos.CategoriaDTO;
import com.GuilhermeBrito.bookstore.repositories.CategoriaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import com.GuilhermeBrito.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDto) {
        Categoria obj = findById(id);
        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescricao());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.GuilhermeBrito.bookstore.service.exceptions.DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados");
        }
    }
}
