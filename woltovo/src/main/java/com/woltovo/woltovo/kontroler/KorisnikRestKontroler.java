package com.woltovo.woltovo.kontroler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woltovo.woltovo.DTO.KorisnikDTO;
import com.woltovo.woltovo.DTO.PrijavaZahtjev;
import com.woltovo.woltovo.entiteti.Korisnik;
import com.woltovo.woltovo.servis.KorisnikServis;

@RestController
@RequestMapping("/korisnik")
public class KorisnikRestKontroler {
    
    private final KorisnikServis korisnikServis;

    public KorisnikRestKontroler(KorisnikServis korisnikServis) {
        this.korisnikServis = korisnikServis;
    }

    @PostMapping("/registracija")
    public ResponseEntity<KorisnikDTO> registracija(@RequestBody Korisnik zahtjev) {
        Korisnik korisnik = korisnikServis.kreirajKorisnika(zahtjev);
        KorisnikDTO korisnikDTO = KorisnikDTO.izKorisnika(korisnik);
        return ResponseEntity.ok(korisnikDTO);

    }

    @PostMapping("/prijava")
    public ResponseEntity<KorisnikDTO> prijava(@RequestBody PrijavaZahtjev zahtjev) {
        Korisnik korisnik = korisnikServis.prijava(zahtjev.getEmail(), zahtjev.getLozinka());
        KorisnikDTO korisnikDTO = KorisnikDTO.izKorisnika(korisnik);
        return ResponseEntity.ok(korisnikDTO);
    }

    
    


}
