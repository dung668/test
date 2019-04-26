package com.dungnd.dao.impl;

import com.dungnd.dao.UserTaxDao;
import com.dungnd.model.UserTax;
import com.dungnd.util.Constant;
import com.dungnd.util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserTaxDaoImpl implements UserTaxDao {
    @Override
    public List<UserTax> findUserTaxesByMonth(int month, int year, int command) { // tìm thuế theo tháng hoặc 3 người nộp thuế cao nhất

        String min = year + "-" + month + "-01"; // biên bên trái (dùng so sánh ngày trong câu sql)
        String max = year + "-" + (month + 1) + "-01"; // biên bên phải

        String addition = ""; // thêm vào cuối câu lệnh sql

        if(command == Constant.FIND_FIVE_HIGHEST_USER_TAXES)
            addition = "LIMIT 5";

        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_tax WHERE thoi_gian_chiu_thue >= '" +
                                                min +"' AND thoi_gian_chiu_thue < '" + max + "' ORDER BY thue_phai_nop DESC " + addition);
        ){
            List<UserTax> userTaxes= new ArrayList<>();

            while(rs.next()){

                UserTax u = new UserTax();
                u.setId(rs.getString("id"));
                u.setHoTen(rs.getString("ho_ten"));
                u.setChucVu(rs.getString("chuc_vu"));
                u.setMst(rs.getString("mst"));
                u.setLuong(rs.getInt("luong"));
                u.setTienAn(rs.getInt("tien_an"));
                u.setGiamTruBanThan(rs.getInt("giam_tru_ban_than"));
                u.setGiamTruPhuThuoc(rs.getInt("giam_tru_phu_thuoc"));
                u.setSoNguoiPhuThuoc(rs.getInt("so_nguoi_phu_thuoc"));
                u.setThuePhaiNop(rs.getInt("thue_phai_nop"));
                u.setThoiGianChiuThue(rs.getDate("thoi_gian_chiu_thue"));

                userTaxes.add(u);
            }
            return userTaxes.size() > 0 ? userTaxes : null;

        } catch (Exception e){
            System.err.println("loi - findUserTaxesByMonth");
        }

        return null;

    }

    @Override
    public List<Integer> getYears() {

        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT YEAR(thoi_gian_chiu_thue) AS 'year' FROM tax_sqa.user_tax" +
                    " ORDER BY thoi_gian_chiu_thue DESC");
        ){
            List<Integer> years = new ArrayList<>();
            while(rs.next()){
                years.add(rs.getInt("year"));
            }
            return years;
        } catch(Exception e){e.printStackTrace();}
        return null;
    }

    public static void main(String[] args) {

        new UserTaxDaoImpl().findUserTaxesByMonth(2,2016,1).forEach(System.out::println);

        //System.out.println();
    }

}
