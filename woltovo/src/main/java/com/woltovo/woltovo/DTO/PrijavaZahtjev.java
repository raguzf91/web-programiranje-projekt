package com.woltovo.woltovo.DTO;

import lombok.Builder;

@Builder
public class PrijavaZahtjev {
    
    private String email;
    private String lozinka;


    public PrijavaZahtjev(String email, String lozinka) {
        this.email = email;
        this.lozinka = lozinka;
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

}
