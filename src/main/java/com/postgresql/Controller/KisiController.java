package com.postgresql.Controller;

import com.postgresql.dto.KisiDto;
import com.postgresql.service.KisiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kisi")
public class KisiController {

    private final KisiService kisiService;

    public KisiController(KisiService kisiService) {
        this.kisiService = kisiService;
    }


    @PostMapping
    public ResponseEntity<KisiDto> KisiEkle(@RequestBody KisiDto kisiDto){
        System.out.println(kisiDto.getAd());
        return ResponseEntity.ok((kisiService.save(kisiDto)));
    }
    @GetMapping()
    public ResponseEntity<List<KisiDto>> Listele(){

        return ResponseEntity.ok((kisiService.getAll()));
    }

}
