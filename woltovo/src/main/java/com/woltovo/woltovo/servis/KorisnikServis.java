package com.woltovo.woltovo.servis;


import com.woltovo.woltovo.entiteti.Korisnik;

public interface KorisnikServis {
    
    public Korisnik kreirajKorisnika(Korisnik korisnik);
    public void updateKorisnika(Long in);
    public Korisnik pronalazakKorisnikaPoEmailu(String email);
    public Korisnik prijava(String email, String lozinka);
}
