package com.example.demo_tree;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PoiController {

    @RequestMapping(value = "/poi")
    public  void poitest(HttpServletResponse response){

        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
//建立新的sheet对象（excel的表单）
        HSSFSheet sheet=wb.createSheet("122");
//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1=sheet.createRow(0);

        row1.createCell(0).setCellValue("姓名");


        List<String> list=new ArrayList<>();
        list.add("张三");
        list.add("张三2");
        list.add("张三3");

        for (int i = 1; i <=list.size() ; i++) {
            HSSFRow row = sheet.createRow(i);
            for (int j = 0; j <1; j++) {
                row.createCell(j).setCellValue(list.get(i-1));
            }
        }


//输出Excel文件
        OutputStream output= null;
        try {
            output = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=excel.xls");
        response.setContentType("application/vnd.ms-excel;chartset=utf-8");
        try {
            wb.write(output);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
