package com.solucionesvirtual.sistevoto.controller;
import com.solucionesvirtual.sistevoto.domain.Copropiedad;
import com.solucionesvirtual.sistevoto.service.CopropiedadService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequiredArgsConstructor
public class CopropietarioController {
    private final CopropiedadService copropiedadService;
    @GetMapping("/")
    public String login() {
        return "login";
    }
    @GetMapping("/paso")
    public String paso(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        String nombre = userDetails.getUsername();
        Copropiedad copropiedad = copropiedadService.buscarCopropiedad(nombre);
        Integer administrador =  copropiedad.getAdministrador();
        if (administrador == 0) {
            return "redirect:/usuario";
        }else {
            return "redirect:/administrador";
        }
    }
    @PostMapping("/logout")
    public String logout(@RequestBody Copropiedad copropiedad){
        return "redirect:/";
    }
    public String error(){
        return "redirect:/";
    }
}