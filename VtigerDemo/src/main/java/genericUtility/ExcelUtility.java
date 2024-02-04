package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generics method to fetch data from excel 
 * @author SHUBHAM
 *
 */
public class ExcelUtility {
	
	/**'
	 * 
	 *This method is used to fetch string data from sheet
	 * @param sheetName
	 * @param RowNo
	 * @param CellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String fetchStringDataFromExcel(String sheetName, int RowNo, int CellNo) throws EncryptedDocumentException, IOException{
		
		FileInputStream fis=new FileInputStream(IPathConstant.EXCEL_FILE_PATH);
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(RowNo).getCell(CellNo).getStringCellValue();
		 
	}
	
	
	
	
    public int fetchNumericDataFromExcel(String sheetName, int RowNo, int CellNo) throws EncryptedDocumentException, IOException{
		
		FileInputStream fis=new FileInputStream(IPathConstant.EXCEL_FILE_PATH);
		return (int) WorkbookFactory.create(fis).getSheet(sheetName).getRow(RowNo).getCell(CellNo).getNumericCellValue();
 
    }
    
    public Boolean fetchBooleanDataFromExcel(String sheetName, int RowNo, int CellNo) throws EncryptedDocumentException, IOException{
		
		FileInputStream fis=new FileInputStream(IPathConstant.EXCEL_FILE_PATH);
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(RowNo).getCell(CellNo).getBooleanCellValue();
		 
    }
    
 public Date fetchDateDataFromExcel(String sheetName, int RowNo, int CellNo) throws EncryptedDocumentException, IOException{
		
		FileInputStream fis=new FileInputStream(IPathConstant.EXCEL_FILE_PATH);
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(RowNo).getCell(CellNo).getDateCellValue();
		 
 }
}
