package com.woltovo.woltovo.mapperi;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.woltovo.woltovo.entiteti.Korisnik;
import com.woltovo.woltovo.enums.Kratica;
import com.woltovo.woltovo.enums.Preference;

public class KorisnikRowMapper implements RowMapper<Korisnik> {

    @Override
    public Korisnik mapRow(ResultSet resultSet, int arg1) throws SQLException {
        return Korisnik.builder()
                .id(resultSet.getLong("id"))
                .ime(resultSet.getString("ime"))
                .prezime(resultSet.getString("prezime"))
                .email(resultSet.getString("email"))
                .lozinka(resultSet.getString("lozinka"))
                .preferenca(Preference.valueOf(resultSet.getString("hrana_preference").toUpperCase()))
                .uloga(resultSet.getString("uloga"))
                .slika(resultSet.getString("slika"))
                .kratica(Kratica.valueOf(resultSet.getString("kratica").toUpperCase()))
                .build();
    }
    
    
}
