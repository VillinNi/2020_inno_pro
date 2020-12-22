package com.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Excel_test {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\dkh\\Desktop\\aa.xlsx");
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        // 获取每一个工作薄
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // 获取当前工作薄的每一行
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    XSSFCell one = xssfRow.getCell(0);
                    //读取第一列数据
                    XSSFCell two = xssfRow.getCell(1);

                    if(one.getRawValue()==null)
                        break;
                    one.setCellType(Cell.CELL_TYPE_STRING);
                    two.setCellType(Cell.CELL_TYPE_STRING);
                    System.out.println(one.getStringCellValue()+"  "+two.getStringCellValue());
                   // System.out.println(one.getRawValue()+"   "+two.getRawValue());

                    //读取第二列数据
                    //XSSFCell three = xssfRow.getCell(2);
                    //读取第三列数据
                    //需要转换数据的话直接调用getValue获取字符串
                }
            }
        }
        //转换数据格式


    }
}
