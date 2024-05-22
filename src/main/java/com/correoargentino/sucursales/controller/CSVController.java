package com.correoargentino.sucursales.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/csv")
public class CSVController {

    @GetMapping("/read")
    public List<String[]> readCSV() {
        String csvFile = "src/main/resources/BASE_RED_COMERCIAL.csv";
        String line;
        String csvDelimiter = ",";
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Leemos el archivo línea por línea
            while ((line = br.readLine()) != null) {
                // Dividimos la línea en campos usando el delimitador CSV
                String[] fields = line.split(csvDelimiter);
                records.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }
}
