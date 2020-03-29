package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
		
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
		
		
public class excelRead {

							 
				
				public static Object[][] getData(String sheetName) throws IOException
				{
				//fileInputStream argument
				ArrayList<List> a=new ArrayList<List>();

				FileInputStream fis=new FileInputStream("C:\\Users\\Sandya\\Desktop\\Sandya\\work\\new job interview prep\\testdata.xlsx");
				XSSFWorkbook workbook=new XSSFWorkbook(fis);

				int sheets=workbook.getNumberOfSheets();
				XSSFSheet sheet= null;
				for(int i=0;i<sheets;i++)
				{
				if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))
				{
					sheet=workbook.getSheetAt(i);
					break;
				}
				}
				//Identify Testcases coloum by scanning the entire 1st row

				Iterator<Row>  rows= sheet.iterator();// sheet is collection of rows
				
				

				////once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
				int k=0;
				while(rows.hasNext())
				{

				Row r=rows.next();


				Iterator<Cell>  cv=r.cellIterator();
				ArrayList <Object>b = new ArrayList<Object>();
				while(cv.hasNext())
				{
				Cell c= cv.next();
				if(c.getCellType()==CellType.STRING)
				{

				b.add(c.getStringCellValue());
				}
				else{

				b.add(NumberToTextConverter.toText(c.getNumericCellValue()));
				}
				//}
				}
				a.add(b);
				}
				
				int r = a.size();
				int c = ((ArrayList)a.get(0)).size();
				Object [][] ret = new Object [r][c];
				
				for (int i=0 ; i < r ; i++) {
					ArrayList<Object> tmp = (ArrayList<Object>)a.get(i);
					for (int j=0; j<c; j++) {
						ret[i][j]= tmp.get(j);
					}
				}
				return ret;
			}

public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub
System.out.println("I AM HERE");
Object[][] row = excelRead.getData("login");
for (int i = 0; i < row.length; i++){
	for (int j = 0; j < row[i].length; j++){
		String val = (String)row[i][j];
		System.out.print(" "+val);
		//System.out.print("Data: "+list.get(i));
	}
	System.out.println();
}
}
}
				
				
				
	

