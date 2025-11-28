package net.ausiasmarch.persutil.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import jakarta.validation.Valid;
import net.ausiasmarch.persutil.entity.PalomaresEntity;
import net.ausiasmarch.persutil.service.PalomaresService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Ian")
public class PalomaresApi {

    @Autowired
    private PalomaresService palomaresService;

    @GetMapping("/{id}")
    public ResponseEntity<PalomaresEntity> get(@PathVariable Long id) {
        return ResponseEntity.ok(palomaresService.get(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<PalomaresEntity>> getPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(palomaresService.getPage(page, size));
    }

    @PostMapping("")
    public ResponseEntity<PalomaresEntity> create(@Valid @RequestBody PalomaresEntity t) {
        return ResponseEntity.ok(palomaresService.create(t));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PalomaresEntity> update(@PathVariable Long id, @Valid @RequestBody PalomaresEntity t) {
        return ResponseEntity.ok(palomaresService.update(id, t));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        palomaresService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/populate/{amount}")
    public ResponseEntity<Integer> populate(@PathVariable int amount) {
        return ResponseEntity.ok(palomaresService.populate(amount));
    }

    @GetMapping("/saludar")
    public ResponseEntity<String> saludar() {
        return new ResponseEntity<>("\"Hola desde el blog\"", HttpStatus.OK);
    }

    @GetMapping("/rellena/{numTareas}")
    public ResponseEntity<Integer> rellenaTareas(@PathVariable int numTareas) {
        return ResponseEntity.ok(palomaresService.populate(numTareas));
    }

    @GetMapping("/estadisticas")
    public ResponseEntity<String> obtenerEstadisticas() {
        long totalTareas = palomaresService.getPage(0, Integer.MAX_VALUE).getTotalElements();
        return ResponseEntity.ok("Total de tareas en la base de datos: " + totalTareas);
    }
}
