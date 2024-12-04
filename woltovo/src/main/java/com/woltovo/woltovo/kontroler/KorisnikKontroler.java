package com.woltovo.woltovo.kontroler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/korisnik")
public class KorisnikKontroler {


    @GetMapping("/registracija")
    public String registracija() {
        return "redirect:/register.html";
    }

    @GetMapping("/prijava")
    public String prijava() {
        return "redirect:/login.html";
    }
    
}
