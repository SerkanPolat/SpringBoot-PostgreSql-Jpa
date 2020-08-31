package com.postgresql.service;

import com.postgresql.Entity.Kisi;
import com.postgresql.dto.KisiDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KisiService {
    KisiDto save(KisiDto kisiDto);
    void Delete(Long id);
    List<KisiDto> getAll();

    Page<Kisi> getAll(Pageable pageable);
}
