package net.ausiasmarch.persutil.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("/api/apellidodealumno/tarea")
public class PalomaresApi {

    @Autowired
    private PalomaresService tareaService;

    @GetMapping("/{id}")
    public PalomaresEntity get(@PathVariable Long id) {
        return tareaService.get(id);
    }

    @GetMapping("")
    public Page<PalomaresEntity> getPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return tareaService.getPage(page, size);
    }

    @PostMapping("")
    public PalomaresEntity create(@Valid @RequestBody PalomaresEntity t) {
        return tareaService.create(t);
    }

    @PutMapping("/{id}")
    public PalomaresEntity update(@PathVariable Long id, @Valid @RequestBody PalomaresEntity t) {
        return tareaService.update(id, t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tareaService.delete(id);
    }

    @PostMapping("/populate/{amount}")
    public int populate(@PathVariable int amount) {
        return tareaService.populate(amount);
    }
}
