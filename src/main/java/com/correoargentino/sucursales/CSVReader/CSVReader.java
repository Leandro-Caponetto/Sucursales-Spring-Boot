package com.correoargentino.sucursales.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    // Ruta del archivo CSV
    private static final String CSV_FILE_PATH = "src/main/resources/BASE_RED_COMERCIAL.csv";

    // Método para leer un archivo CSV y devolver una lista de registros
    public static List<String[]> readCSVFile() {
        String line = "";
        String csvDelimiter = ","; // Delimitador CSV
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
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


