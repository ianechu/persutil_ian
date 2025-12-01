package net.ausiasmarch.persutil.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.ausiasmarch.persutil.entity.SalinasEntity;
import net.ausiasmarch.persutil.service.SalinasService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/receta")
public class SalinasApi {
    
    @Autowired
    SalinasService oSalinasService;
    
    @PostMapping("/populate/{amount}") // <--- ESTO ES LO QUE FALTABA
    public ResponseEntity<Long> populate(@PathVariable Long amount) {
        // Llama al bulkCreate en el servicio
        return ResponseEntity.ok(oSalinasService.bulkCreate(amount));
    }

    // obtener post por id
    @GetMapping("/{id}")
    public ResponseEntity<SalinasEntity> get(@PathVariable Long id) {
        return ResponseEntity.ok(oSalinasService.get(id));
    }

    // crear posts
    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody SalinasEntity salinasEntity) {
        return ResponseEntity.ok(oSalinasService.create(salinasEntity));
    }

    // modificar posts
    @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody SalinasEntity salinasEntity) {
        return ResponseEntity.ok(oSalinasService.update(salinasEntity));
    }

    // borrar posts
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(oSalinasService.delete(id));
    }

    // listado paginado de posts
    @GetMapping("")
    public ResponseEntity<Page<SalinasEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oSalinasService.getPage(oPageable));
        
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(oSalinasService.count()); 
    }


}
