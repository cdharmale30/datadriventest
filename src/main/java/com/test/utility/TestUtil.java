package com.test.utility;

import java.util.ArrayList;

import com.test.xlsreader.utility.Xls_Reader;

public class TestUtil {
	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel() {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		try {
			reader = new Xls_Reader("I:\\All Eclipse Code6\\DataDriven\\testdata.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int rowNum = 2; rowNum <= reader.getRowCount("RegisterData"); rowNum++) {
			String firstName = reader.getCellData("RegisterData", "firstname", rowNum);
			String lastName = reader.getCellData("RegisterData", "lastname", rowNum);
			String email = reader.getCellData("RegisterData", "email", rowNum);
			String status = reader.getCellData("RegisterData", "password", rowNum);
			Object obj[] = { firstName, lastName, email, status };
			myData.add(obj);
		}
		return myData;
	}
}
