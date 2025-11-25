package net.ausiasmarch.persutil.service;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.ausiasmarch.persutil.entity.PalomaresEntity;
import net.ausiasmarch.persutil.repository.PalomaresRepository;

@Service
public class PalomaresService {

    @Autowired
    private PalomaresRepository tareaRepository;

    public PalomaresEntity get(Long id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    public Page<PalomaresEntity> getPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("fechaCreacion").descending());
        return tareaRepository.findAll(pageable);
    }

    public PalomaresEntity create(PalomaresEntity t) {
        t.setId(null);
        return tareaRepository.save(t);
    }

    public PalomaresEntity update(Long id, PalomaresEntity t) {
        PalomaresEntity existing = get(id);
        existing.setTitulo(t.getTitulo());
        existing.setDescripcion(t.getDescripcion());
        existing.setCategoria(t.getCategoria());
        existing.setCompletada(t.getCompletada());
        existing.setPublicado(t.getPublicado());
        return tareaRepository.save(existing);
    }

    public void delete(Long id) {
        tareaRepository.deleteById(id);
    }

    public int populate(int amount) {
        Random rnd = new Random();

        String[] categorias = {"Trabajo", "Casa", "Estudios", "Deporte", "Compras"};

        for (int i = 0; i < amount; i++) {
            PalomaresEntity t = new PalomaresEntity();
            t.setTitulo("Tarea de ejemplo " + (i + 1));
            t.setDescripcion("Descripción ficticia de la tarea " + (i + 1));
            t.setCategoria(categorias[rnd.nextInt(categorias.length)]);
            t.setCompletada(rnd.nextBoolean());
            t.setPublicado(true);
            tareaRepository.save(t);
        }
        return amount;
    }
}

