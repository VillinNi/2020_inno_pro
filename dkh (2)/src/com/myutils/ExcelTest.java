package com.myutils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.bean.StudentBean;
import org.apache.poi.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelTest {
    public List<StudentBean> read_student_from_excel() throws IOException {
        String path="C:\\Users\\dkh\\Desktop\\a.xlsx";
        File excel_file = new File(path);
        FileInputStream fi= new FileInputStream(excel_file);
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
                    String id = xssfRow.getCell(0).getRawValue();//学生学号
                    String name=xssfRow.getCell(1).getRawValue(); //学生名
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
    public static void main(String[] args) throws IOException {
       ExcelTest test = new ExcelTest();
       test.read_student_from_excel();
    }
}
