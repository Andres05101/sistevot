package com.solucionesvirtual.sistevoto.controller;
import com.solucionesvirtual.sistevoto.domain.*;
import com.solucionesvirtual.sistevoto.model.ObtenerDatos;
import com.solucionesvirtual.sistevoto.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class UserController {
    private final PreguntaService preguntaService;
    private final VotoServices votoServices;
    private final AsambleaService asambleaService;
    private final RespuestaService respuestaService;
    private final TemaService temaService;
    private final DocumentoService documentoService;
    private final Asam_coproService asamCoproService;
    private ObtenerDatos obtenerDatos;

    @GetMapping("/usuario")
    public String inicioUsuario(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String copropiedad = userDetails.getUsername();
        model.addAttribute("user", copropiedad);
        model.addAttribute("fecha", LocalDateTime.now());
        Integer asambleaId = obtenerDatos.asambleaHoy();
        if (asambleaId == 0){
            model.addAttribute("noAsamblea",true);
        }else {
            List<Tema> temas = temaService.getTemaPorAsamblea(asambleaId);
            model.addAttribute("temas", temas);
            model.addAttribute("noAsamblea",false);
            model.addAttribute("registro",asamCoproService.registroAsambleaHoy(asambleaId,copropiedad));

        }
        List<Documento> documentos = documentoService.getDocumentoPorAsamblea(asambleaId);
        model.addAttribute("documentos", documentos);
        return "usuario";
    }
    @GetMapping("/preguntaEnDesarrollo")
    public String obtenerPreguntas(Model model) {
        List<Pregunta> preguntas = preguntaService.getPregunta();
        LocalDateTime ahora = LocalDateTime.now();
        preguntas = preguntas.stream()
                .filter(pregunta -> pregunta.getFechahora().isAfter(ahora))
                .collect(Collectors.toList());
        model.addAttribute("questions", preguntas);
        return "preguntaEnDesarrollo";
    }

    @GetMapping("/pregunta/{id}")
    public String mostrarPreguntaDisponible(@PathVariable("id") Integer id, Model model) {
        Pregunta pregunta = preguntaService.getPreguntaPorId(id);
        List<Respuesta> respuestas = respuestaService.listarRespuestas(id);
        model.addAttribute("respuestas", respuestas);
        model.addAttribute("pregunta", pregunta);
        return "respuesta";
    }

    @PostMapping("/voto")
    public String vote(@RequestParam("preguntaId") Integer preguntaId,
                       @RequestParam("respuetaId") Integer respuestaId,
                       @AuthenticationPrincipal UserDetails userDetails,Model model) {
        Voto voto = new Voto();
        voto.setPregunta(preguntaId);
        voto.setRespuesta(respuestaId);
        String copropiedad = userDetails.getUsername();
        voto.setPropiedad(copropiedad);
        votoServices.RegistrarVoto(voto);
        return "redirect:/usuario";
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> descargaDocumentos(@PathVariable Integer id) {
        // Buscar el documento en la base de datos
        Documento documento = documentoService.findById((long) id);

        // Crear encabezados HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("documento.pdf").build());

        // Devolver el documento como una respuesta HTTP
        return new ResponseEntity<>(documento.getContenido(), headers, HttpStatus.OK);
    }
    @GetMapping("/asistencia")
    public String asistencia (Model model,@RequestParam("copropiedad") String copropiedad) {
        Integer asambleaId = obtenerDatos.asambleaHoy();
        Asamblea_copropiedad asamblea_copropiedad = new Asamblea_copropiedad();
        asamblea_copropiedad.setAsamblea(asambleaId);
        asamblea_copropiedad.setCopropiedad(copropiedad);
        asamCoproService.registrarAsistencia(asamblea_copropiedad);
        model.addAttribute("asistenciaRegistrada", true);
        return "redirect:/usuario";

    }
}