package com.ecommerce.EcommerceBackend.Controller;


import com.ecommerce.EcommerceBackend.Model.Cart;
import com.ecommerce.EcommerceBackend.Model.ExcelRead;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelReadController {


    @GetMapping()
    public synchronized void getAllCart(){
        try  {
            String name = "C:\\Users\\Osama\\Documents\\contacts.xlsx";
            System.out.println(name);
            FileInputStream file2 = new FileInputStream(new File(name));
            Workbook workbook = new XSSFWorkbook(file2);
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();
            Iterator<Sheet> sheets = workbook.iterator();
            Integer count = sheet.getLastRowNum();
            Integer col;
            for(Integer i  = 0; i <= count ; i++) {
                Row row = sheet.getRow(i);
                col = sheet.getRow(i).getPhysicalNumberOfCells();
                if(row!=null) {
                    for (Integer j = 0; j < col; j++) {
                        Cell cell = row.getCell(j);
                        if(cell!=null) {
                            String cellvalue = dataFormatter.formatCellValue(cell);
                            System.out.print(cellvalue);
                        }
                    }
//                    ExcelRead excelRead = new ExcelRead();
//                    excelRead.setId(dataFormatter.formatCellValue(row.getCell(0)));
                }
            }


//            while (sheets.hasNext()) {
//
//                Sheet s = sheets.next();
//                Iterator<Row> iterator = s.iterator();
//                while (iterator.hasNext()) {
//                    Row row = iterator.next();
//                    Iterator<Cell> cellIterator = row.iterator();
////                    System.out.println(dataFormatter.formatCellValue(row.getCell(count)));
//                    while (cellIterator.hasNext()) {
//                        Cell cell = cellIterator.next();
//                        String cellvalue = dataFormatter.formatCellValue(cell);
//                        System.out.println(cellvalue);
//                    }
//                }
////                count++;
//            }
            file2.close();
            workbook.close();

        }catch (Exception e) {
            System.out.println(e);
        }
    }
    @PostMapping
    public void createExcel()  {
        String name2 = "C:\\Users\\Osama\\Documents\\";
        List<ExcelRead> list = new ArrayList<>();
        list.add(new ExcelRead(1L,"ssda",345));
        list.add(new ExcelRead(2L,"aaaa",321));
        String[] col = {"id","firstName","SecondName"};

        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("contacts");
            Row header = sheet.createRow(0);
            for(int i = 0; i < col.length;i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(col[i]);
            }
            int count = 1;
            for (ExcelRead excelRead : list) {
                Row row = sheet.createRow(count++);
                row.createCell(0).setCellValue(excelRead.getId());
                row.createCell(1).setCellValue(excelRead.getName());
                row.createCell(2).setCellValue(excelRead.getNumber());
            }
            FileOutputStream fileOutputStream = new FileOutputStream(name2 + workbook.getSheetName(0) + ".xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            workbook.close();
        }catch (Exception e) {
            System.out.println(e);

        }
    }
    @PostMapping("/add")
    public void postData() {
//        String name = "C:\\Users\\Osama\\Documents\\";
        List<ExcelRead> list = new ArrayList<>();
        list.add(new ExcelRead(5L,"junaid",665));
        list.add(new ExcelRead(8L,"usama Bhai",777));
        try {
            String name = "C:\\Users\\Osama\\Documents\\contacts.xlsx";
            System.out.println(name);
            FileInputStream file2 = new FileInputStream(new File(name));
            Workbook workbook = new XSSFWorkbook(file2);
            Sheet sheet = workbook.getSheetAt(0);
            Integer count = sheet.getLastRowNum();
            String[] col = {"id", "firstName", "SecondName"};
            for (ExcelRead excelRead : list) {
                count++;
                Row row = sheet.createRow(count);
                row.createCell(0).setCellValue(excelRead.getId());
                row.createCell(1).setCellValue(excelRead.getName());
                row.createCell(2).setCellValue(excelRead.getNumber());
            }
            file2.close();
            FileOutputStream fileOutputStream = new FileOutputStream(name);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            workbook.close();
        }catch (Exception e) {
                System.out.println(e);

            }
    }


    @PostMapping("/addsingle")
    public void postSingleData(@RequestBody ExcelRead excelRead) {
//        String name = "C:\\Users\\Osama\\Documents\\";
        try {
            String name = "C:\\Users\\Osama\\Documents\\contacts.xlsx";
            System.out.println(name);
            FileInputStream file2 = new FileInputStream(new File(name));
            Workbook workbook = new XSSFWorkbook(file2);
            Sheet sheet = workbook.getSheetAt(0);
            Integer count = sheet.getLastRowNum() + 1;
            String[] col = {"id", "firstName", "SecondName"};
//            for (ExcelRead excelRead : list) {
                Row row = sheet.createRow(count);
                row.createCell(0).setCellValue(excelRead.getId());
                row.createCell(1).setCellValue(excelRead.getName());
                row.createCell(2).setCellValue(excelRead.getNumber());
//            }
            file2.close();
            FileOutputStream fileOutputStream = new FileOutputStream(name);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            workbook.close();
        }catch (Exception e) {
            System.out.println(e);

        }
    }
}
