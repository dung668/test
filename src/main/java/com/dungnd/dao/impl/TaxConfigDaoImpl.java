package com.dungnd.dao.impl;

import com.dungnd.dao.TaxConfigDao;
import com.dungnd.model.TaxConfig;
import com.dungnd.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TaxConfigDaoImpl implements TaxConfigDao {

    @Override
    public boolean editTax(TaxConfig taxConfig) {

        if(taxConfig.getPhuThuoc() == null || taxConfig.getTienAn() == null || taxConfig.getBanThan() == null
            || taxConfig.getPhuThuoc() < 1000 || taxConfig.getTienAn() < 1000 || taxConfig.getBanThan() < 1000)
            return false;

        try(
                Connection conn = DBConnection.getCon();
                PreparedStatement ps = conn.prepareCall("UPDATE `tax_sqa`.`tax_config` SET `ban_than` = ?, `nguoi_phu_thuoc` = ?, `tien_an` = ? WHERE (`ma_cau_hinh` = '1');");
        ){

            ps.setInt(1, taxConfig.getBanThan());
            ps.setInt(2, taxConfig.getPhuThuoc());
            ps.setInt(3, taxConfig.getTienAn());
            return ps.executeUpdate() > 0;

        }catch (Exception e){
            System.out.println("co loi - editTax");
        }
        return false;
    }

    @Override
    public TaxConfig getTaxConfig() {

        try(
            Connection conn = DBConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tax_sqa.tax_config;")
        ){

            if(rs.next())
                return new TaxConfig(rs.getInt("ma_cau_hinh"), rs.getInt("ban_than"), rs.getInt("nguoi_phu_thuoc"), rs.getInt("tien_an"));

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    public static void main(String[] args) {
        //new TaxConfigDaoImpl().editTax(new TaxConfig(null, 9000000,3600000,730000));
        System.out.println(new TaxConfigDaoImpl().getTaxConfig());
    }

}