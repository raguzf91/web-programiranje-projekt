package com.woltovo.woltovo.entiteti;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Builder;


@Builder
@AllArgsConstructor
public class Jelo {
    Long id;
    String naziv;
    String opis;
    int brojKalorija;
    String sastojci;
    String kategorija;
    String slika;
    int nutriScore;
    double ocjena;
    int brojOcjena;
    HashMap<String, Integer> makroelementi;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return this.opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getBrojKalorija() {
        return this.brojKalorija;
    }

    public void setBrojKalorija(int brojKalorija) {
        this.brojKalorija = brojKalorija;
    }

    public String getSastojci() {
        return this.sastojci;
    }

    public void setSastojci(String sastojci) {
        this.sastojci = sastojci;
    }

    public String getKategorija() {
        return this.kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getSlika() {
        return this.slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public int getNutriScore() {
        return this.nutriScore;
    }

    public void setNutriScore(int nutriScore) {
        this.nutriScore = nutriScore;
    }

    public double getOcjena() {
        return this.ocjena;
    }

    public void setOcjena(double ocjena) {
        this.ocjena = ocjena;
    }

    public int getBrojOcjena() {
        return this.brojOcjena;
    }

    public void setBrojOcjena(int brojOcjena) {
        this.brojOcjena = brojOcjena;
    }

    public HashMap<String,Integer> getMakroelementi() {
        return this.makroelementi;
    }

    public void setMakroelementi(HashMap<String,Integer> makroelementi) {
        this.makroelementi = makroelementi;
    }

    
}

