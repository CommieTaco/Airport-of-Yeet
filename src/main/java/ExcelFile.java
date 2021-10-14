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
        //Creates a new workbook in blank
        Workbook workbook = new HSSFWorkbook();
        //Creates a new sheet
        Sheet sheet = workbook.createSheet("Hoja de datos");
        //Por cada línea se crea un arreglo de objetos (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"Identificador", "Nombre", "Apellidos"});
        data.put("2", new Object[]{1, "María", "Remen"});
        data.put("3", new Object[]{2, "David", "Allos"});
        data.put("4", new Object[]{3, "Carlos", "Caritas"});
        data.put("5", new Object[]{4, "Luisa", "Vitz"});
        //Iterate over data to write on the sheet
        Set keyset = data.keySet();
        int numRenglon = 0;
        for (Object key : keyset) {
            Row row = sheet.createRow(numRenglon++);
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
            FileOutputStream out = new FileOutputStream(new File("C:/Users/Dany/Documents/SOLID Project/Airport-of-Yeet/example.xls"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
