package com.solucionesvirtual.sistevoto.service;

import com.solucionesvirtual.sistevoto.domain.Asamblea_copropiedad;
import com.solucionesvirtual.sistevoto.model.ObtenerDatos;
import com.solucionesvirtual.sistevoto.repository.Asam_CoproRepo;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExcelService {

    private Asam_CoproRepo asamCoproRepository;
    public ObtenerDatos obtenerDatos;

    public Workbook generarExcel() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Asistentes");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Numero propiedad");
        List<Asamblea_copropiedad> asistentes = asamCoproRepository.findByAsamblea(obtenerDatos.asambleaHoy());
        for (int i = 0; i < asistentes.size(); i++) {
            Asamblea_copropiedad asistente = asistentes.get(i);
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(asistente.getCopropiedad());
        }
        return workbook;
    }
}