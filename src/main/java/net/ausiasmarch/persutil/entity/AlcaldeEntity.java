package net.ausiasmarch.persutil.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alcalde")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlcaldeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 2, max = 255)
    private String titulo;

    @NotNull
    @Size(min = 2, max = 255)
    private String autor;

    @NotNull
    @Size(min = 2, max = 100)
    private String genero;

    @NotNull
    @Size(min = 10)
    private String reseña;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer valoracion;

    @NotNull
    private Boolean publicado;

    @NotNull
    private Boolean destacado;

    @NotNull
    @Column(name = "fecha_lectura")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate fechaLectura;
}
