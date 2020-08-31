package com.postgresql.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "kisi_Adres")
public class Adres implements Serializable {
    //Veri Baska yerden Alinacak ise GeneratedValue Kullanilir.Bunun icin postgrede Squence kullanilir.
    @Id
    @SequenceGenerator(name = "seq_kisi_adres",allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi_adres",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 200)//Kolonun Ozellikleri Belirlemek icin kullaniliyor.
    private String adres;
    @Enumerated
    private AdresTip adresTip;
    private Boolean aktifMi;

    @ManyToOne
    @JoinColumn(name = "kisi_adres_id")
    private Kisi kisi;
    public enum AdresTip{
        Ev_Adres,
        IsAdres,
        Diger
    }
}
