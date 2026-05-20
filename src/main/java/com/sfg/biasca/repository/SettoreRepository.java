package com.sfg.biasca.repository;

import com.sfg.biasca.Entity.Settore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettoreRepository extends JpaRepository<Settore, Long> {
    List<Settore> findAllByOrderByNomeAsc();
}