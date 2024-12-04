
package com.woltovo.woltovo.entiteti;

import com.woltovo.woltovo.enums.Kratica;
import com.woltovo.woltovo.enums.Preference;

import lombok.Builder;

@Builder
public class Korisnik {

    private Long id;
    private String ime;
    private String prezime;
    private String email;
    private String lozinka;
    private Preference preferenca;
    private String uloga;
    private String slika;
    private Kratica kratica;


    public Korisnik() {
    }


    public Korisnik(Long id, String ime, String prezime, String email, String lozinka, Preference preferenca, String uloga, String slika, Kratica kratica) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.preferenca = preferenca;
        this.uloga = uloga;
        this.slika = slika;
        this.kratica = kratica;
    }

    

    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLozinka() {
        return this.lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Preference getPreferenca() {
        return this.preferenca;
    }

    public void setPreferenca(Preference preferenca) {
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

    public Kratica getKratica() {
        return this.kratica;
    }

    public void setKratica(Kratica kratica) {
        this.kratica = kratica;
    }
    
}
