package com.kodigo.classes;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelFile {
    public static void main(String[] args) {
        //Class constructor
        Flights flight = new Flights();
        //Creates a new workbook in blank
        Workbook workbook = new HSSFWorkbook();
        //Creates a new sheet
        Sheet sheet = workbook.createSheet("Hoja de datos");
        //Second counter for lines in excel file and for index posicion
        Integer num = 2;
        //For each line it creates an array of objects (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"Identificador", "Nombre", "Apellidos"});    
        for(int i = 0; i <= flight.flights.size(); i++)
        {
            data.put(num.toString(), new Object[]{flight.flights.indexOf(i)});
            num++;
        }
        //Iterate over data to write on the sheet
        Set keyset = data.keySet();
        int numRow = 0;
        for (Object key : keyset) {
            Row row = sheet.createRow(numRow++);
            Object[] ObjectArray = data.get(key);
            int numCell = 0;
            for (Object obj : ObjectArray) {
                Cell cell = row.createCell(numCell++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
        try {
            //It generates the document
            FileOutputStream out = new FileOutputStream(new File("E:\\Eclipse\\eclipseNeon\\Kodigo\\weather\\example.xls"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
