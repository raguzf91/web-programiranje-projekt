package com.woltovo.woltovo.DTO;

import com.woltovo.woltovo.entiteti.Korisnik;
import com.woltovo.woltovo.enums.Kratica;
import com.woltovo.woltovo.enums.Preference;

import lombok.Builder;

@Builder
public class KorisnikDTO {

    private String ime;
    private String prezime;
    private String email;
    private String preferenca;
    private String uloga;
    private String slika;
    private String kratica;

    
    public KorisnikDTO() {

    }

    public KorisnikDTO(String ime, String prezime, String email, String preferenca, String uloga, String slika, String kratica) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.preferenca = preferenca;
        this.uloga = uloga;
        this.slika = slika;
        this.kratica = kratica;
    }

    public static KorisnikDTO izKorisnika(Korisnik korisnik) {
            return KorisnikDTO.builder()
                .ime(korisnik.getIme())
                .prezime(korisnik.getPrezime())
                .email(korisnik.getEmail())
                .preferenca(korisnik.getPreferenca().name().toLowerCase())
                .uloga(korisnik.getUloga())
                .slika(korisnik.getSlika())
                .kratica(korisnik.getKratica().name().toLowerCase())
                .build();
    }

    public static Korisnik uKorisnika(KorisnikDTO korisnikDTO) {
        return Korisnik.builder()
            .ime(korisnikDTO.getIme())
            .prezime(korisnikDTO.getPrezime())
            .email(korisnikDTO.getEmail())
            .preferenca(Preference.valueOf(korisnikDTO.getPreferenca().toUpperCase()))
            .uloga(korisnikDTO.getUloga())
            .slika(korisnikDTO.getSlika())
            .kratica(Kratica.valueOf(korisnikDTO.getKratica().toUpperCase()))
            .build();
    }


    public String getIme() {
        return this.ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return this.prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPreferenca() {
        return this.preferenca;
    }

    public void setPreferenca(String preferenca) {
        this.preferenca = preferenca;
    }

    public String getUloga() {
        return this.uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public String getSlika() {
        return this.slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getKratica() {
        return this.kratica;
    }

    public void setKratica(String kratica) {
        this.kratica = kratica;
    }



    
}
