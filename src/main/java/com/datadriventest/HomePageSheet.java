package com.datadriventest;

import com.test.xlsreader.utility.Xls_Reader;

public class HomePageSheet {
	public static void main(String[] args) {
		Xls_Reader reader = new Xls_Reader("I:\\All Eclipse Code6\\DataDriven\\testdata.xlsx");

		if (!reader.isSheetExist("Sheet22")) {
			reader.addSheet("Sheet22");
			
		}
		int colCount = reader.getColumnCount("RegisterData");
		System.out.println("The col in sheet> "+colCount);
	}
}