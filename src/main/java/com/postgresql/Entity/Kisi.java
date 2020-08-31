package com.postgresql.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "kisi")
public class Kisi {

    @javax.persistence.Id
    @SequenceGenerator(name = "seq_kisi",allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 50)
    private String ad;
    @Column(length = 50)
    private String soyad;

    String adresler;

}
