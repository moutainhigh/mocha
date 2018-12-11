package com.efruit.micro.arkmanager.utils;

import com.efruit.micro.arkmanager.bean.DispatchingExportAreaOrderResult;
import com.efruit.micro.arkmanager.bean.DispatchingExportAreaOrderResult.Books;
import com.efruit.micro.arkmanager.bean.DispatchingExportAreaOrderResult.FetchUser;
import com.efruit.micro.arkmanager.utils.JodaDateUtil.Pattern;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;


/**
 * @param <T>
 * @author leno
 * @version v1.0
 */
public class ExportDispatchingExcel<T> {
    public static final String[] DEFAULT_HEADER = {"取货码", "收货人", "电话", "配送地点", "商品名称", "规格", "数量", "备注"};
    private static final int DEFAULT_COL_START = 0;
    //title开始行
    private static final int TITLE_ROW_INDEX = 0;
    //汇总数据开始行
    private static final int FRUIT_CATEGORY_ROW_INDEX = 1;
    //表头开始行
    private static final int HEAD_ROW_INDEX = 2;
    //数据体开始行
    private static final int DATA_BODY_ROW_INDEX = 3;

    public static void exportExcel(Map<String, DispatchingExportAreaOrderResult> areaOrderMap, Date sendDate, OutputStream out) {
        HSSFWorkbook book = new HSSFWorkbook();
        for (String key : areaOrderMap.keySet()) {
            DispatchingExportAreaOrderResult areaOrderResult = areaOrderMap.get(key);
            final String areaName = areaOrderResult.getAreaName();
            //sheet页对象
            HSSFSheet sheet = (HSSFSheet) book.createSheet(areaName);
            sheet.setDefaultColumnWidth(15);
            sheet.setColumnWidth(0, 256 * 6 + 184);
            sheet.setColumnWidth(1, 256 * 8 + 184);
            sheet.setColumnWidth(2, 256 * 11 + 184);
            sheet.setColumnWidth(3, 256 * 21 + 184);
            sheet.setColumnWidth(4, 256 * 21 + 184);
            sheet.setColumnWidth(5, 256 * 21 + 184);
            sheet.setColumnWidth(6, 256 * 5 + 184);
            sheet.setColumnWidth(7, 256 * 5 + 184);

            //设置sheet页头
            setTitle(book, sheet, areaName, sendDate);
            //初始化表头
            setHeaderValue(book, sheet);
            //初始化数据体
            Map<String, Integer> fruitCategoryCountMap = initBodyData(book, sheet, areaOrderResult, areaOrderMap);
            //初始化汇总数据
            setFruitCategoryInfo(book, sheet, fruitCategoryCountMap);
        }
        try {
            book.write(out);
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setHeaderValue(HSSFWorkbook book, HSSFSheet sheet) {
        HSSFCellStyle style = getHeaderCellStyle(book);
        int rowNum = HEAD_ROW_INDEX;
        int colNum = DEFAULT_COL_START;
        Row row = sheet.createRow(rowNum);
        Cell cell;
        for (String key : DEFAULT_HEADER) {
            cell = row.createCell(colNum);
            cell.setCellValue(key);
            cell.setCellStyle(style);
            row.setHeightInPoints(20);
            colNum++;
        }
    }

    private static void setTitle(HSSFWorkbook book, HSSFSheet sheet, String area, Date sendDate) {
        HSSFCellStyle style = getTitleCellStyle(book);
        final Row row = sheet.createRow(TITLE_ROW_INDEX);
        row.setHeightInPoints(30);
        Cell cell = row.createCell(DEFAULT_COL_START);
        cell.setCellStyle(style);
        cell.setCellValue(JodaDateUtil.date2str(sendDate, Pattern.yyyyMMdd) + area + "发货表");
        for (int i = DEFAULT_COL_START + 1; i < DEFAULT_HEADER.length; i++) {
            row.createCell(i);
        }
        mergedRegion(sheet, TITLE_ROW_INDEX, TITLE_ROW_INDEX, DEFAULT_COL_START, DEFAULT_HEADER.length - 1);
    }

    private static void setFruitCategoryInfo(HSSFWorkbook book, HSSFSheet sheet, Map<String, Integer> fruitCategoryCountMap) {
        HSSFCellStyle style = getFruitCategoryCellStyle(book);
        style.setWrapText(true);
        final Row row = sheet.createRow(FRUIT_CATEGORY_ROW_INDEX);
        //调节行高度
        int singlRow = 40;
        if (fruitCategoryCountMap.size() > 4) {
            singlRow = 20;
        }
        row.setHeightInPoints(singlRow * fruitCategoryCountMap.size());
        Cell cell = row.createCell(DEFAULT_COL_START);
        cell.setCellStyle(style);
        StringBuilder str = new StringBuilder();
        for (String key : fruitCategoryCountMap.keySet()) {
            str.append(key).append("        [").append("×").append(fruitCategoryCountMap.get(key)).append("]").append("\n");
        }
        cell.setCellValue(new HSSFRichTextString(str.toString()));
        for (int i = DEFAULT_COL_START + 1; i < DEFAULT_HEADER.length - 1; i++) {
            row.createCell(i);
        }
        mergedRegion(sheet, FRUIT_CATEGORY_ROW_INDEX, FRUIT_CATEGORY_ROW_INDEX, DEFAULT_COL_START, DEFAULT_HEADER.length - 1);
    }


    private static Map<String, Integer> initBodyData(HSSFWorkbook book, HSSFSheet sheet, DispatchingExportAreaOrderResult areaOrderResult, Map<String, DispatchingExportAreaOrderResult> areaOrderMap) {

        Map<String, Integer> fruitCategoryCountMap = new HashMap<>();

        HSSFCellStyle style = getCellStyle(book);
        int rowNum = DATA_BODY_ROW_INDEX;
        Map<Integer, FetchUser> userMap = areaOrderResult.getUserMap();
        for (Integer fetchCode : userMap.keySet()) {
            FetchUser user = userMap.get(fetchCode);
            int colNum = 0;
            Row row = sheet.createRow(rowNum);
            final List<Books> booksList = user.getBooksList();
            final int addressBooksCount = booksList.size();
            colNum = setCellValue(sheet, row, rowNum, colNum, user.getFetchCode(), addressBooksCount, style);
            colNum = setCellValue(sheet, row, rowNum, colNum, user.getUserName(), addressBooksCount, style);
            colNum = setCellValue(sheet, row, rowNum, colNum, user.getUserTel(), addressBooksCount, style);
            colNum = setCellValue(sheet, row, rowNum, colNum, user.getAddressName(), addressBooksCount, style);
            int i = 0;
            int bookCol = colNum;
            for (Books books : booksList) {
                if (i > 0) {
                    row = sheet.createRow(rowNum);
                }
                final String title = books.getTitle();
                final String specification = books.getSpecification();
                final int num = books.getNum();
                colNum = setCellValue(row, bookCol, title, style);
                colNum = setCellValue(row, colNum, specification, style);
                colNum = setCellValue(row, colNum, num + "", style);
                StringBuilder keyBuilder = new StringBuilder();
                keyBuilder.append(title).append("   【").append(specification).append("】");
                String key = keyBuilder.toString();
                if (fruitCategoryCountMap.containsKey(key)) {
                    int oldCount = fruitCategoryCountMap.get(key);
                    fruitCategoryCountMap.put(key, oldCount + num);
                } else {
                    fruitCategoryCountMap.put(key, num);
                }
                row.setHeightInPoints(20);
                rowNum++;
                i++;
            }
        }
        return fruitCategoryCountMap;
    }

    private static void mergedRegion(HSSFSheet sheet, int startRow, int endRow, int startCol, int endCol) {
        CellRangeAddress cra = new CellRangeAddress(startRow, endRow, startCol, endCol);
        sheet.addMergedRegion(cra);
        // 使用RegionUtil类为合并后的单元格添加边框
        RegionUtil.setBorderBottom(BorderStyle.THIN, cra, sheet); // 下边框
        RegionUtil.setBorderLeft(BorderStyle.THIN, cra, sheet); // 左边框
        RegionUtil.setBorderRight(BorderStyle.THIN, cra, sheet); // 有边框
        RegionUtil.setBorderTop(BorderStyle.THIN, cra, sheet); // 上边框
    }

    private static int setCellValue(HSSFSheet sheet, Row row, int rowNum, int colNum, String value, int userBooksCount, HSSFCellStyle style) {
        Cell cell = row.createCell(colNum);
        cell.setCellValue(value);
        cell.setCellStyle(style);
        if (userBooksCount >= 2) {
            mergedRegion(sheet, rowNum, rowNum + userBooksCount - 1, colNum, colNum);
        }
        colNum++;
        return colNum;
    }

    private static int setCellValue(Row row, int colNum, String value, HSSFCellStyle style) {
        Cell cell = row.createCell(colNum);
        cell.setCellValue(value);
        cell.setCellStyle(style);
        colNum++;
        return colNum;
    }

    private static HSSFCellStyle getCellStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setAlignment(HorizontalAlignment.CENTER);
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        font.setFontHeightInPoints((short) 9);
        style.setFont(font);
        return style;
    }

    private static HSSFCellStyle getHeaderCellStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.LIGHT_YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderTop(BorderStyle.THIN);
        HSSFFont font = workbook.createFont();
        font.setFontName("微软雅黑");
        font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        font.setFontHeightInPoints((short) 12);
        font.setBold(false);
        style.setFont(font);
        return style;
    }

    private static HSSFCellStyle getFruitCategoryCellStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(HSSFColorPredefined.LIGHT_GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setBorderTop(BorderStyle.THIN);
        HSSFFont font = workbook.createFont();
        font.setFontName("微软雅黑");
        font.setColor(HSSFColorPredefined.BLACK.getIndex());
        font.setFontHeightInPoints((short) 9);
        font.setBold(false);
        style.setFont(font);
        return style;
    }

    private static HSSFCellStyle getTitleCellStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(HSSFColorPredefined.WHITE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderTop(BorderStyle.THIN);
        HSSFFont font = workbook.createFont();
        font.setFontName("微软雅黑");
        font.setColor(HSSFColorPredefined.BLACK.getIndex());
        font.setFontHeightInPoints((short) 9);
        font.setBold(false);
        style.setFont(font);
        return style;
    }

}

