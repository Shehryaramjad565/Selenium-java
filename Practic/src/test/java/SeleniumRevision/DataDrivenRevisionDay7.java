package SeleniumRevision;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenRevisionDay7 {

    /**
     * Extracts data from a specific row in the "testdata" sheet where the test case name matches.
     * 
     * @param testcaseName The name of the test case to search for.
     * @return A list of all cell values from the matching row.
     * @throws IOException if file reading fails.
     */
    public ArrayList<String> getData(String testcaseName) throws IOException {
        ArrayList<String> data = new ArrayList<>();

        FileInputStream fis = new FileInputStream("D://Downloads//demodata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int numberOfSheets = workbook.getNumberOfSheets();

        for (int i = 0; i < numberOfSheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                XSSFSheet sheet = workbook.getSheetAt(i);

                // Identify "TestCases" column
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> cellIterator = firstRow.cellIterator();

                int columnIndex = -1;
                int currentIndex = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getStringCellValue().equalsIgnoreCase("TestCases")) {
                        columnIndex = currentIndex;
                        break;
                    }
                    currentIndex++;
                }

                // If column not found, return empty list
                if (columnIndex == -1) {
                    workbook.close();
                    return data;
                }

                // Scan for the row where the test case name matches
                while (rows.hasNext()) {
                    Row row = rows.next();
                    Cell testCaseCell = row.getCell(columnIndex);

                    if (testCaseCell != null && testCaseCell.getStringCellValue().equalsIgnoreCase(testcaseName)) {
                        Iterator<Cell> cellDataIterator = row.cellIterator();
                        while (cellDataIterator.hasNext()) {
                            Cell cell = cellDataIterator.next();
                            if (cell.getCellType() == CellType.STRING) {
                                data.add(cell.getStringCellValue());
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                data.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
                            }
                        }
                        break; // Exit after finding the matching row
                    }
                }
            }
        }

        workbook.close();
        return data;
    }

//	
    public static void main(String[] args) throws IOException {
    	DataDrivenRevisionDay7 extractor = new DataDrivenRevisionDay7();
        ArrayList<String> extractedData = extractor.getData("Login");
        
        // Print extracted data
        for (String value : extractedData) {
            System.out.println(value);
        }
    	System.out.println("ok");
    }
}
