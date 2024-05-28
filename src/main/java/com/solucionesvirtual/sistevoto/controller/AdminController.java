package com.solucionesvirtual.sistevoto.controller;

import com.solucionesvirtual.sistevoto.domain.*;
import com.solucionesvirtual.sistevoto.service.*;
import com.solucionesvirtual.sistevoto.model.ObtenerDatos;
import jakarta.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller

public class AdminController {
    private LocalDate fecha ;
    private final ExcelService excelService;
    private final CopropiedadService copropiedadService;
    private final Asam_coproService asam_coproService;
    private final AsambleaService asambleaService;
    private final PreguntaService preguntaService;
    private final RespuestaService respuestaService;
    private final TemaService temaService;
    private final DocumentoService documentoService;
    private final ObtenerDatos obtenerDatos;
    public AdminController(ExcelService excelService, CopropiedadService copropiedadService, Asam_coproService asamCoproService, AsambleaService asambleaService, PreguntaService preguntaService, RespuestaService respuestaService, TemaService temaService, DocumentoService documentoService, ObtenerDatos obtenerDatos) {
        this.excelService = excelService;
        asam_coproService = asamCoproService;
        this.fecha = LocalDate.now();
        this.copropiedadService = copropiedadService;
        this.asambleaService = asambleaService;
        this.preguntaService = preguntaService;
        this.respuestaService = respuestaService;
        this.temaService = temaService;
        this.documentoService = documentoService;
        this.obtenerDatos = obtenerDatos;
    }

    @GetMapping("/administrador")
    public String getAsamblea(Model model) {
        Optional<Asamblea> asamblea = asambleaService.getAsambleaHoy();
        model.addAttribute("fecha", fecha);
        if (asamblea.isPresent()) {
            model.addAttribute("asamblea", asamblea.get());
        } else {
            model.addAttribute("message", "No hay asamblea para hoy");
        }
        return "administrador";
    }
    @PostMapping("/administrador")
    public String crearAsamblea(@ModelAttribute Asamblea asamblea , @RequestParam List<String> temas) {
        asamblea.setFecha(LocalDate.now());
        asambleaService.crearAsamblea(asamblea);
        for(String textoTema : temas){
            Tema tema = new Tema();
            tema.setTexto_tema(textoTema);
            tema.setAsamblea(asamblea.getAsamblea());
            temaService.crearTema(tema);
        }
        return "redirect:/administrador";
    }

    @GetMapping("/pregunta")
    public String mostrarPreguntas(Model model) {
        Integer asambleaId = obtenerDatos.asambleaHoy();
        model.addAttribute("fecha",fecha);
        model.addAttribute("asambleaId", asambleaId);
        model.addAttribute("pregunta", new Pregunta());
        model.addAttribute("respuestas", new ArrayList<Respuesta>());
        return "pregunta";
    }

    @PostMapping("/pregunta")
    public String crearPregunta(@ModelAttribute Pregunta pregunta, @RequestParam List<String> respuestas, @RequestParam Integer tiempo) {
        Integer asambleaId = obtenerDatos.asambleaHoy();
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime nuevaFechaHora = ahora.plus(tiempo, ChronoUnit.MINUTES);
        pregunta.setFechahora(nuevaFechaHora);
        pregunta.setAsamblea(asambleaId);
        preguntaService.crearPregunta(pregunta);
        for (String textoRespuesta : respuestas) {
            Respuesta respuesta = new Respuesta();
            respuesta.setOpcion(textoRespuesta);
            respuesta.setPregunta(pregunta.getPregunta());
            respuestaService.crearRespuesta(respuesta);
        }
        return "redirect:/administrador";
    }
    @PostMapping("/upload")
    public String subirDocumento(@RequestParam("file") MultipartFile file, Model model) {
        Integer asambleaId = obtenerDatos.asambleaHoy();
        // Obtener el tipo de contenido del archivo
        String contentType = file.getContentType();
        // Lista de tipos de contenido permitidos
        List<String> allowedContentTypes = Arrays.asList(
                "application/pdf", // PDF
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document", // DOCX
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", // XLSX
                "application/vnd.openxmlformats-officedocument.presentationml.presentation", // PPTX
                "text/plain" // TXT
        );
        // Verificar si el tipo de contenido es uno de los permitidos
        if (!allowedContentTypes.contains(contentType)) {
            return "redirect:/administrador";
        }
        try {
            String nombreArchivo = file.getOriginalFilename();
            byte[] contenido = file.getBytes();
            // Crear un nuevo documento
            Documento documento = new Documento();
            documento.setAsamblea(asambleaId);
            documento.setContenido(contenido);
            documento.setNombre(nombreArchivo);

            // Guardar el documento en la base de datos
            documentoService.save(documento);
        } catch (IOException e) {
            // Manejar la excepción
            e.printStackTrace();
        }

        return "redirect:/administrador";
    }
    @GetMapping("/forum")
    public String aforo(Model model){
        int totalPersonas = copropiedadService.contarTodo() - 1;
        int asistencia = asam_coproService.contarPorAsamblea(obtenerDatos.asambleaHoy());
        double porcentajeAsistencia = ((double) asistencia / totalPersonas) * 100;
        model.addAttribute("totalPersonas", totalPersonas);
        model.addAttribute("asistencia", asistencia);
        model.addAttribute("porcentajeAsistencia", porcentajeAsistencia);

        return "forum";
    }
    @GetMapping("/descargar asistencia")
    public ResponseEntity<ByteArrayResource> descargarAsistentes() throws IOException {
        // Generar el archivo Excel
        Workbook workbook = excelService.generarExcel();

        // Convertir el libro de trabajo en un array de bytes
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        byte[] bytes = outputStream.toByteArray();

        // Crear un recurso de byte array a partir del array de bytes
        ByteArrayResource resource = new ByteArrayResource(bytes);

        // Crear los encabezados HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=asistentes.xlsx");

        // Devolver el archivo Excel como una respuesta HTTP
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }

}