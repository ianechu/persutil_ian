package net.ausiasmarch.persutil.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.persutil.entity.AlcaldeEntity;

public interface AlcaldeRepository extends JpaRepository<AlcaldeEntity, Long> {

    Page<AlcaldeEntity> findByPublicadoTrue(Pageable pageable);

    List<AlcaldeEntity> findTop6ByPublicadoTrueAndDestacadoTrueOrderByValoracionDesc();

}
