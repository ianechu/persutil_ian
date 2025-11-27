package net.ausiasmarch.persutil.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.persutil.entity.SoaresEntity;
import net.ausiasmarch.persutil.repository.SoaresRepository;
import net.ausiasmarch.persutil.service.SoaresAleatorioService;

@Service
public class SoaresService {

    @Autowired
    SoaresRepository oSoaresRepository;

    @Autowired
    SoaresAleatorioService oSoaresAleatorioService;

    public SoaresEntity get(Long id) {
        return oSoaresRepository.findById(id).orElse(null);
    }

    public Long create(SoaresEntity oSoaresEntity) {
        oSoaresEntity.setFechaCreacion(LocalDateTime.now());
        oSoaresEntity.setFechaModificacion(LocalDateTime.now());
        // Por defecto, una nueva pregunta no está publicada (requiere aprobación del admin)
        if (oSoaresEntity.getPublicacion() == null) {
            oSoaresEntity.setPublicacion(false);
        }
        return oSoaresRepository.save(oSoaresEntity).getId();
    }

    public SoaresEntity update(SoaresEntity oSoaresEntity) {
        SoaresEntity oSoaresEntityDB = this.get(oSoaresEntity.getId());
        if (oSoaresEntityDB != null) {
            oSoaresEntityDB.setPreguntas(oSoaresEntity.getPreguntas());
            oSoaresEntityDB.setPublicacion(oSoaresEntity.getPublicacion());
            oSoaresEntityDB.setFechaModificacion(LocalDateTime.now());
            return oSoaresRepository.save(oSoaresEntityDB);
        } else {
            return null;
        }
    }

    public Long delete(Long id) {
        oSoaresRepository.deleteById(id);
        return id;
    }

    public Page<SoaresEntity> getPage(Pageable oPageable, String filter) {
        if (filter == null || filter.isEmpty()) {
            return oSoaresRepository.findAll(oPageable);
        } else {
            return oSoaresRepository.findByPreguntasContainingIgnoreCase(filter, oPageable);
        }
    }

    public Page<SoaresEntity> getPageByPublicacion(Pageable oPageable, String filter) {
        if (filter == null || filter.isEmpty()) {
            return oSoaresRepository.findByPublicacionTrue(oPageable);
        } else {
            return oSoaresRepository.findByPublicacionTrueAndPreguntasContainingIgnoreCase(filter, oPageable);
        }
    }

    public Long populate(int amount) {
        List<SoaresEntity> soares = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            SoaresEntity oSoaresEntity = new SoaresEntity();
            oSoaresEntity.setPreguntas(oSoaresAleatorioService.getPreguntaNeuro());
            oSoaresEntity.setFechaCreacion(oSoaresAleatorioService.getFechaCreacion());
            oSoaresEntity.setFechaModificacion(oSoaresAleatorioService.getFechaModificacion(oSoaresEntity.getFechaCreacion()));
            oSoaresEntity.setPublicacion(ThreadLocalRandom.current().nextBoolean());
            soares.add(oSoaresEntity);
        }
        oSoaresRepository.saveAll(soares);
        return oSoaresRepository.count();
    }

    public Long empty() {
        oSoaresRepository.deleteAll();
        oSoaresRepository.flush();
        return oSoaresRepository.count();
    }

}
