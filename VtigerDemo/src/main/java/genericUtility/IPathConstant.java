package genericUtility;

public interface IPathConstant {
	
	String PROPERTY_FILE_PATH = "./src/test/resources/commonData.properties";
    String EXCEL_FILE_PATH= "./src/test/resources/VtigerTestData (2).xlsx";
    
    int IMPLICIT_WAIT= 20;
    int EXPLICIT_WAIT= 20;
    
    String LEAD_SHEET_NAME="Lead_001";
    String PRODUCT_SHEET_NAME="Product_001";
    
    String SCREENSHOT_PATH="./VtigerDemo/screenshots/";
    
    String DATABASE_URL="jdbc:mysql://localhost:3306/projectDemo";
    String DATABASE_USERNAME="root";
    String DATABASE_PASSWORD="root";
     
}
