package com.postgresql.repository;

import com.postgresql.Entity.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KisiRepository extends JpaRepository<Kisi,Long> {
}
