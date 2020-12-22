package com.myutils;

import com.bean.StudentBean;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
    public static List<StudentBean> read_student_from_excel(InputStream fi) throws IOException {

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fi);

        List<StudentBean> list = new ArrayList<StudentBean>();
        for(int i=0;i<xssfWorkbook.getNumberOfSheets();i++){
            XSSFSheet xssfSheet=xssfWorkbook.getSheetAt(i);//获取第i行数据
            if(xssfSheet==null)
                continue;
            for(int row_num=0;row_num<=xssfSheet.getLastRowNum();row_num++){
                XSSFRow xssfRow=xssfSheet.getRow(row_num); //获取第几行的数据
                if(xssfRow!=null){
                    StudentBean studentBean = new StudentBean();
                    XSSFCell one=xssfRow.getCell(0);
                    XSSFCell two=xssfRow.getCell(1);
                    one.setCellType(Cell.CELL_TYPE_STRING);
                    two.setCellType(Cell.CELL_TYPE_STRING);

                    String id;
                    String name;
                    id =one.getStringCellValue();
                    name=two.getStringCellValue();
                    if(id==null)break;
                    studentBean.setStu_name(name);
                    studentBean.setStu_id(id);
                    list.add(studentBean);
                }
            }
        }
        /*for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getStu_name()+"   "+ list.get(i).getStu_id());
        }*/
        fi.close();
        return list;
    }
}
