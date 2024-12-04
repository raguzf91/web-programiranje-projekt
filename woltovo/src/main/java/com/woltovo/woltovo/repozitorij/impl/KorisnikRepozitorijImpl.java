package com.woltovo.woltovo.repozitorij.impl;

import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.woltovo.woltovo.entiteti.Korisnik;
import com.woltovo.woltovo.exceptions.baza.DataException;
import com.woltovo.woltovo.repozitorij.KorisnikRepozitorij;
import com.woltovo.woltovo.mapperi.KorisnikRowMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class KorisnikRepozitorijImpl implements KorisnikRepozitorij {

    
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public KorisnikRepozitorijImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Korisnik kreirajKorisnika(Korisnik korisnik) {
        final String KREIRANJE_KORISNIKA_SQL = """
                INSERT INTO Korisnici (ime, prezime, email, lozinka, hrana_preference, uloga, slika, kratica)
                VALUES (:ime, :prezime, :email, :lozinka, CAST(:preferenca as preference), CAST(:uloga AS uloga_korisnika), :slika, CAST(:kratica AS kratica_korisnika))
                """;
        try {

            if(pronalazakKorisnikaPoEmailu(korisnik.getEmail()) != null) {
                throw new IllegalArgumentException("Korisnik već postoji sa ovim emailom");
            } 
    
            
            if(korisnik.getSlika() == null) {
                korisnik.setSlika("resources/static/korisnik_slika.jpg");
            }
    
            korisnik.setUloga("korisnik");
    
            log.info("Kreiranje korisnika: " + korisnik.getEmail());
    
            KeyHolder idKorisnikaHolder = new GeneratedKeyHolder();
            SqlParameterSource parametriKorisnika = getSqlParameterSource(korisnik);
            
            jdbcTemplate.update(KREIRANJE_KORISNIKA_SQL, parametriKorisnika, idKorisnikaHolder, new String[] {"id"});

            return korisnik;
            
        } catch (DataAccessException e) {
            log.error("Greška prilikom kreiranja korisnika" + e.getCause().toString());
            throw new DataException("Greška prilikom kreiranja korisnika");
        }
        
        
        




        

        
    }

    @Override
    public void updateKorisnika(Long in) {
    }

    @Override
    public Korisnik pronalazakKorisnikaPoEmailu(String email) {
        try {
            final String PRONALAZAK_KORISNIKA_SQL = """
                    SELECT * FROM Korisnici WHERE email = :email
                    """;
            return jdbcTemplate.queryForObject(PRONALAZAK_KORISNIKA_SQL, Map.of("email", email), new KorisnikRowMapper());
            
        } catch (Exception e) {
            log.error("Korisnik ne postoji" + e.getMessage());
            return null;
        }
    }

    private SqlParameterSource getSqlParameterSource(Korisnik korisnik) {
        return new MapSqlParameterSource()
            .addValue("ime", korisnik.getIme())
            .addValue("prezime", korisnik.getPrezime())
            .addValue("lozinka", (korisnik.getLozinka()))
            .addValue("email", korisnik.getEmail())
            .addValue("preferenca", korisnik.getPreferenca().name().toLowerCase()) 
            .addValue("uloga", korisnik.getUloga())
            .addValue("slika", korisnik.getSlika())
            .addValue("kratica", korisnik.getKratica().name().toLowerCase());

    }

}
