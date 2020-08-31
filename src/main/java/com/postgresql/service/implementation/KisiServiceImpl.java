package com.postgresql.service.implementation;

import com.postgresql.Entity.Adres;
import com.postgresql.Entity.Kisi;
import com.postgresql.dto.KisiDto;
import com.postgresql.repository.AdresRepository;
import com.postgresql.repository.KisiRepository;
import com.postgresql.service.KisiService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class KisiServiceImpl implements KisiService {

    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;

    public KisiServiceImpl(KisiRepository kisiRepository, AdresRepository adresRepository) {
        this.kisiRepository = kisiRepository;
        this.adresRepository = adresRepository;
    }

    @Override
    @Transactional //Tum islem yapilir yada geri alinir.
    public KisiDto save(KisiDto kisiDto) {
        //Assert.isNull(kisiDto.getAd(),"Ad Alani Zorunludur");

        Kisi kisi = new Kisi();
        kisi.setAd(kisiDto.getAd());
        kisi.setSoyad(kisiDto.getSoyad());
        kisi.setAdresler(kisiDto.getAdresler());
        final Kisi kisiDb = kisiRepository.save(kisi);
        List<Adres> liste = new ArrayList<Adres>();

            Adres adres = new Adres();
            adres.setAdres("Adres iste");
            adres.setAktifMi(true);
            adres.setAdresTip(Adres.AdresTip.Diger);
            adres.setKisi(kisiDb);
            liste.add(adres);
        adresRepository.saveAll(liste);
        kisiDto.setId(kisiDb.getId());
        return kisiDto;
    }

    @Override
    public void Delete(Long id) {

    }

    @Override
    public List<KisiDto> getAll() {
        List<KisiDto> kisiDtos = new ArrayList<KisiDto>();

        kisiRepository.findAll().forEach(item->{
            KisiDto kisiDto = new KisiDto();
            kisiDto.setId(item.getId());
            kisiDto.setAd(item.getAd());
            kisiDto.setAdresler(item.getAdresler());
            kisiDto.setSoyad(item.getSoyad());
            kisiDtos.add(kisiDto);
        });
        return kisiDtos;
    }

    @Override
    public Page<Kisi> getAll(Pageable pageable) {
        return null;
    }
}
