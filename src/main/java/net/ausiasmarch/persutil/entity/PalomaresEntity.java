package net.ausiasmarch.persutil.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tarea")
@Getter
@Setter
public class PalomaresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String titulo;

    @Size(max = 5000)
    private String descripcion;

    @Size(max = 100)
    private String categoria;

    @NotNull
    private Boolean completada = false;

    @NotNull
    private Boolean publicado = true;

@Column(name = "fecha_creacion", updatable = false, insertable = false)
private LocalDateTime fechaCreacion;

@Column(name = "fecha_modificacion", insertable = false, updatable = false)
private LocalDateTime fechaModificacion;


}

