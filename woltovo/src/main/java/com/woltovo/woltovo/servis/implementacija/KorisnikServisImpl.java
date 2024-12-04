package com.woltovo.woltovo.servis.implementacija;

import org.springframework.stereotype.Service;

import com.woltovo.woltovo.entiteti.Korisnik;
import com.woltovo.woltovo.repozitorij.KorisnikRepozitorij;
import com.woltovo.woltovo.servis.KorisnikServis;

@Service
public class KorisnikServisImpl implements KorisnikServis {

    private final KorisnikRepozitorij korisnikRepozitorij;

    public KorisnikServisImpl(KorisnikRepozitorij korisnikRepozitorij) {
        this.korisnikRepozitorij = korisnikRepozitorij;
    }
    @Override
    public Korisnik kreirajKorisnika(Korisnik korisnik) {
        return korisnikRepozitorij.kreirajKorisnika(korisnik);
    }

    @Override
    public Korisnik pronalazakKorisnikaPoEmailu(String email) {
        return korisnikRepozitorij.pronalazakKorisnikaPoEmailu(email);
    }

    @Override
    public void updateKorisnika(Long in) {
        
    }
    @Override
    public Korisnik prijava(String email, String lozinka) {
        Korisnik korisnik = korisnikRepozitorij.pronalazakKorisnikaPoEmailu(email);
        if(korisnik == null) {
            throw new IllegalArgumentException("Korisnik ne postoji. Pokušajte ponovno");
        } else {
            if(korisnik.getLozinka().equals(lozinka)) {
                return korisnik;
            } else {
                throw new IllegalArgumentException("Pogrešna lozinka. Pokušajte ponovno");
            }
        }
    }
    
}
