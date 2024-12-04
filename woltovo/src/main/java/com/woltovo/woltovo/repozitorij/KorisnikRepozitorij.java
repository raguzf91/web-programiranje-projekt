package com.woltovo.woltovo.repozitorij;

import com.woltovo.woltovo.entiteti.Korisnik;

public interface KorisnikRepozitorij {

    Korisnik kreirajKorisnika(Korisnik Korisnik);
    void updateKorisnika(Long in);
    Korisnik pronalazakKorisnikaPoEmailu(String email);
    
}
