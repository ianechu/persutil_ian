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
import net.ausiasmarch.persutil.service.AleatorioService;
import net.ausiasmarch.persutil.service.PalomaresService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Ian")
public class PalomaresApi {

    @Autowired
    private PalomaresService palomaresService;

    @Autowired
    private AleatorioService aleatorioService;

    @GetMapping("/{id}")
    public PalomaresEntity get(@PathVariable Long id) {
        return palomaresService.get(id);
    }

    @GetMapping("")
    public Page<PalomaresEntity> getPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return palomaresService.getPage(page, size);
    }

    @PostMapping("")
    public PalomaresEntity create(@Valid @RequestBody PalomaresEntity t) {
        return palomaresService.create(t);
    }

    @PutMapping("/{id}")
    public PalomaresEntity update(@PathVariable Long id, @Valid @RequestBody PalomaresEntity t) {
        return palomaresService.update(id, t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        palomaresService.delete(id);
    }

    @PostMapping("/populate/{amount}")
    public int populate(@PathVariable int amount) {
        return palomaresService.populate(amount);
    }
    @GetMapping("/saludar")
    public ResponseEntity<String> saludar() {
        return new ResponseEntity<>("\"Hola desde el blog\"", HttpStatus.OK);
    }
    
    @GetMapping("/aleatorio/service/{min}/{max}")
    public ResponseEntity<Integer> aleatorioUsandoServiceEnRango(
            @PathVariable int min,
            @PathVariable int max) {
        return ResponseEntity.ok(
                aleatorioService.GenerarNumeroAleatorioEnteroEnRango(min, max)
        );
    }
    
    @GetMapping("/rellena/{numTareas}")
    public ResponseEntity<Long> rellenaTareas(
            @PathVariable Long numTareas
    ) {
        long resultado = palomaresService.populate(numTareas.intValue());
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/generar-aleatorio/{cantidad}")
    public ResponseEntity<String> generarTareasAleatorias(@PathVariable int cantidad) {
        if (cantidad <= 0 || cantidad > 1000) {
            return ResponseEntity.badRequest()
                .body("La cantidad debe estar entre 1 y 1000");
        }
        
        int tareasCreadas = palomaresService.populate(cantidad);
        return ResponseEntity.ok("Se han creado " + tareasCreadas + " tareas aleatorias en la base de datos");
    }

    @GetMapping("/estadisticas")
    public ResponseEntity<String> obtenerEstadisticas() {
        long totalTareas = palomaresService.getPage(0, Integer.MAX_VALUE).getTotalElements();
        return ResponseEntity.ok("Total de tareas en la base de datos: " + totalTareas);
    }
}
