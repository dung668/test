package com.dungnd.controller;

import com.dungnd.dao.UserTaxDao;
import com.dungnd.dao.impl.UserTaxDaoImpl;
import com.dungnd.model.UserTax;
import com.dungnd.util.Constant;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;

@WebServlet(urlPatterns = {"/export", "/bao-cao"})
public class ExportTaxesController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition",
                "attachment; filename=report-" + System.currentTimeMillis() + ".xls");

        OutputStream outputStream = response.getOutputStream();

        HSSFWorkbook workbook = new HSSFWorkbook();

        //workbook.write(outputStream);

        HSSFSheet sheet = workbook.createSheet("Report Taxes");

        // get list user taxes
        UserTaxDao userTaxDao = new UserTaxDaoImpl();
        int year = 0, month = 0, command = Constant.GET_ALL_USER_TAXES;
        if(request.getParameter("year") != null){
            year = Integer.parseInt(request.getParameter("year"));
            month = Integer.parseInt(request.getParameter("month"));
        }

        int currentMonth = month != 0 ? month : Calendar.getInstance().get(Calendar.MONTH);
        int currentYear = year != 0 ? year : Calendar.getInstance().get(Calendar.YEAR);

        int prevMonth = (currentMonth == 0) ? 12 : currentMonth;

        if("top".equals(request.getParameter("cmd")))
            command = Constant.FIND_FIVE_HIGHEST_USER_TAXES;

        List<UserTax> userTaxes = userTaxDao.findUserTaxesByMonth(prevMonth,currentYear, command);

        // ------------------------

        int rownum = 0;
        Cell cell;
        Row row;

        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        // TaxNo
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("No");
        cell.setCellStyle(style);
        // TaxNo
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Họ tên");
        cell.setCellStyle(style);
        // TaxNo
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Chức vụ");
        cell.setCellStyle(style);
        // TaxNo
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("MST");
        cell.setCellStyle(style);
        // TaxNo
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Lương");
        cell.setCellStyle(style);
        // TaxNo
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Tiền ăn");
        cell.setCellStyle(style);
        // TaxNo
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Bản thân");
        cell.setCellStyle(style);
        // TaxNo
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Số người PT");
        cell.setCellStyle(style);
        // TaxNo
        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("Giảm trừ PT");
        cell.setCellStyle(style);
        // TaxNo
        cell = row.createCell(9, CellType.STRING);
        cell.setCellValue("Thuế phải nộp");
        cell.setCellStyle(style);


        // DATA

        int cursor = 0;
        for(UserTax userTax : userTaxes){

            rownum++; cursor ++;
            row = sheet.createRow(rownum);

            // TaxNo (A)
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(cursor);
            // TaxNo (A)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(userTax.getHoTen());
            // TaxNo (A)
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(userTax.getChucVu());
            // TaxNo (A)
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(userTax.getMst());
            // TaxNo (A)
            cell = row.createCell(4, CellType.NUMERIC);
            cell.setCellValue(userTax.getLuong());
            // TaxNo (A)
            cell = row.createCell(5, CellType.NUMERIC);
            cell.setCellValue(userTax.getTienAn());
            // TaxNo (A)
            cell = row.createCell(6, CellType.NUMERIC);
            cell.setCellValue(userTax.getGiamTruBanThan());
            // TaxNo (A)
            cell = row.createCell(7, CellType.NUMERIC);
            cell.setCellValue(userTax.getSoNguoiPhuThuoc());
            // TaxNo (A)
            cell = row.createCell(8, CellType.NUMERIC);
            cell.setCellValue(userTax.getGiamTruPhuThuoc());
            // TaxNo (A)
            cell = row.createCell(9, CellType.NUMERIC);
            cell.setCellValue(userTax.getThuePhaiNop());

        }

        workbook.write(outputStream);

        outputStream.close();

        System.out.println("Ghi file thanh cong ! ---");

    }
}
