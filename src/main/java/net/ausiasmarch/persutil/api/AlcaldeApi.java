package net.ausiasmarch.persutil.api;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.persutil.entity.AlcaldeEntity;
import net.ausiasmarch.persutil.service.AlcaldeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/alcalde")
public class AlcaldeApi {

    @Autowired
    private AlcaldeService oAlcaldeService;

    @GetMapping("")
    public ResponseEntity<Page<AlcaldeEntity>> getPage(Pageable pageable,
            @RequestParam(name = "publicado", required = false) Boolean soloPublicados) {
        return ResponseEntity.ok(oAlcaldeService.getPage(pageable, soloPublicados));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlcaldeEntity> get(@PathVariable Long id) {
        return ResponseEntity.ok(oAlcaldeService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody AlcaldeEntity entidad) {
        return ResponseEntity.ok(oAlcaldeService.create(entidad));
    }

    @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody AlcaldeEntity entidad) {
        return ResponseEntity.ok(oAlcaldeService.update(entidad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(oAlcaldeService.delete(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(oAlcaldeService.count());
    }

    @GetMapping("/selection")
    public ResponseEntity<List<AlcaldeEntity>> selection() {
        return ResponseEntity.ok(oAlcaldeService.getSeleccion());
    }

    @GetMapping("/rellena/{cantidad}")
    public ResponseEntity<Long> rellena(@PathVariable Long cantidad) {
        return ResponseEntity.ok(oAlcaldeService.rellena(cantidad));
    }
}
