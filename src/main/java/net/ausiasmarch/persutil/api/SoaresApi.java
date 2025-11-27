package net.ausiasmarch.persutil.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.persutil.entity.SoaresEntity;
import net.ausiasmarch.persutil.service.SoaresService;

@RestController
@RequestMapping("/soares")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SoaresApi {

    @Autowired
    SoaresService oSoaresService;

    // ADMIN & USER: Obtener una pregunta por ID
    @GetMapping("/{id}")
    public ResponseEntity<SoaresEntity> get(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<SoaresEntity>(oSoaresService.get(id), HttpStatus.OK);
    }

    // ADMIN: Crear una nueva pregunta (puede ser usada por el admin para crear o por el usuario para proponer)
    @PostMapping("/")
    public ResponseEntity<Long> create(@RequestBody SoaresEntity oSoaresEntity) {
        return new ResponseEntity<Long>(oSoaresService.create(oSoaresEntity), HttpStatus.OK);
    }

    // ADMIN: Actualizar una pregunta (incluye la aprobación/publicación)
    @PutMapping("/")
    public ResponseEntity<SoaresEntity> update(@RequestBody SoaresEntity oSoaresEntity) {
        return new ResponseEntity<SoaresEntity>(oSoaresService.update(oSoaresEntity), HttpStatus.OK);
    }

    // ADMIN: Eliminar una pregunta
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<Long>(oSoaresService.delete(id), HttpStatus.OK);
    }

    // ADMIN: Listado paginado de todas las preguntas (para mantenimiento)
    @GetMapping("/admin")
    public ResponseEntity<Page<SoaresEntity>> getPageAdmin(Pageable oPageable, @RequestParam(name = "filter", required = false) String filter) {
        return new ResponseEntity<Page<SoaresEntity>>(oSoaresService.getPage(oPageable, filter), HttpStatus.OK);
    }

    // USER: Listado paginado de preguntas publicadas (para el foro público)
    @GetMapping("/user")
    public ResponseEntity<Page<SoaresEntity>> getPageUser(Pageable oPageable, @RequestParam(name = "filter", required = false) String filter) {
        return new ResponseEntity<Page<SoaresEntity>>(oSoaresService.getPageByPublicacion(oPageable, filter), HttpStatus.OK);
    }

    // ADMIN: Creación masiva de preguntas (populate)
    @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable(value = "amount") int amount) {
        return new ResponseEntity<Long>(oSoaresService.populate(amount), HttpStatus.OK);
    }

    // ADMIN: Vaciar la tabla de preguntas (empty)
    @DeleteMapping("/empty")
    public ResponseEntity<Long> empty() {
        return new ResponseEntity<Long>(oSoaresService.empty(), HttpStatus.OK);
    }

}
