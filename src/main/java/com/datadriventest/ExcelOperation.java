package com.datadriventest;

import com.test.xlsreader.utility.Xls_Reader;

public class ExcelOperation {

	public static void main(String[] args) {
		Xls_Reader reader = new Xls_Reader("I:\\All Eclipse Code6\\DataDriven\\testdata.xlsx");
		//reader.addSheet("HomePage");
		if (!reader.isSheetExist("HomePage")) {

			reader.addSheet("HomePage");
		}
		// int rowCount = reader.getRowCount("RegisterData");
		int colCount = reader.getColumnCount("RegisterData");
		System.out.println(colCount);
		
		System.out.println(reader.getCellRowNum("RegisterData", "firstname", "Chetan"));
	}

}
