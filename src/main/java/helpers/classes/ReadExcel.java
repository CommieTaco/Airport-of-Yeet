package helpers.classes;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import helpers.Presenter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public void ReadExcel(File fileName){
        List cellData = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            XSSFSheet hssfsheet = workbook.getSheetAt(0);
            Iterator rowIterator = hssfsheet.rowIterator();
            while(rowIterator.hasNext()){
                XSSFRow hssfRow = (XSSFRow) rowIterator.next();

                Iterator iterator = hssfRow.cellIterator();
                List cellTemp = new ArrayList<>();

                while(iterator.hasNext()){
                    XSSFCell hssfCell = (XSSFCell) iterator.next();
                    cellTemp.add(hssfCell);
                }
                cellData.add(cellTemp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        get(cellData);
    }

    private void get(List cellDataList){
        for (int i = 0; i < cellDataList.size(); i++){
            List cellTempList = (List) cellDataList.get(i);
            for(int j = 0; j < cellTempList.size(); j++){
                XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);

                String stringCellValue = hssfCell.toString();
                System.out.print(stringCellValue + " ");
            }
            System.out.println();
        }
    }
}