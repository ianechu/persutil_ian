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
    private PalomaresRepository palomaresRepository;


// Removed duplicate simple populate; the more complete populate(int) implementation further below is used.


    public PalomaresEntity get(Long id) {
        return palomaresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    public Page<PalomaresEntity> getPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("fechaCreacion").descending());
        return palomaresRepository.findAll(pageable);
    }

    public PalomaresEntity create(PalomaresEntity t) {
        t.setId(null);
        return palomaresRepository.save(t);
    }

    public PalomaresEntity update(Long id, PalomaresEntity t) {
        PalomaresEntity existing = get(id);
        existing.setTitulo(t.getTitulo());
        existing.setDescripcion(t.getDescripcion());
        existing.setCategoria(t.getCategoria());
        existing.setCompletada(t.getCompletada());
        existing.setPublicado(t.getPublicado());
        return palomaresRepository.save(existing);
    }

    public void delete(Long id) {
        palomaresRepository.deleteById(id);
    }

    public int populate(int amount) {
        Random rnd = new Random();

        String[] categorias = {"Trabajo", "Casa", "Estudios", "Deporte", "Compras", "Salud", "Familia", "Viajes", "Tecnología", "Hobby"};
        String[] titulosPrefijos = {
            "Terminar proyecto de", "Comprar", "Organizar", "Planificar", "Revisar", 
            "Estudiar", "Leer sobre", "Hacer ejercicio en", "Llamar a", "Limpiar",
            "Preparar", "Actualizar", "Configurar", "Aprender", "Practicar"
        };
        String[] objetivos = {
            "presentación", "informe", "reunión", "entrenamiento", "cita médica",
            "documentación", "sistema", "aplicación", "curso", "examen",
            "casa", "oficina", "proyecto", "presupuesto", "calendario",
            "curriculum", "portfolio", "base de datos", "servidor", "equipo"
        };

        for (int i = 0; i < amount; i++) {
            PalomaresEntity t = new PalomaresEntity();
            
            // Generar títulos más variados
            String prefijo = titulosPrefijos[rnd.nextInt(titulosPrefijos.length)];
            String objetivo = objetivos[rnd.nextInt(objetivos.length)];
            t.setTitulo(prefijo + " " + objetivo + " #" + (i + 1));
            
            // Generar descripciones más detalladas
            String[] descripciones = {
                "Esta es una tarea importante que requiere atención inmediata.",
                "Tarea programada para completar durante esta semana.",
                "Actividad de seguimiento que debe realizarse periódicamente.",
                "Proyecto a largo plazo que necesita planificación detallada.",
                "Tarea urgente con alta prioridad de ejecución.",
                "Actividad opcional pero recomendable para el desarrollo personal.",
                "Tarea colaborativa que involucra a varios miembros del equipo.",
                "Proyecto individual que requiere concentración y dedicación."
            };
            t.setDescripcion(descripciones[rnd.nextInt(descripciones.length)] + " Generada automáticamente el " + java.time.LocalDateTime.now().toString().substring(0, 19));
            
            // Asignar categoría aleatoria
            t.setCategoria(categorias[rnd.nextInt(categorias.length)]);
            
            // Estado aleatorio con mayor probabilidad de estar pendiente
            t.setCompletada(rnd.nextInt(100) < 30); // 30% de probabilidad de estar completada
            
            // Todas las tareas serán públicas
            t.setPublicado(true);
            
            palomaresRepository.save(t);
        }
        return amount;
    }
}

