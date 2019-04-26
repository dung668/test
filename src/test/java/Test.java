package test;

import com.dungnd.dao.impl.TaxConfigDaoImpl;
import com.dungnd.dao.impl.UserTaxDaoImpl;
import com.dungnd.model.TaxConfig;
import com.dungnd.model.UserTax;
import com.dungnd.util.DBConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TestCaseTax {
    TaxConfig cu = new TaxConfig(1, 9000000, 3600000, 760000);
    private Connection connect;
    private Savepoint savepoint;
    private List<Integer> checkGetYear;

    @Test
    public void testGetConnect() throws SQLException {
        Connection connnection = DBConnection.getCon();
        assertNotEquals(null, connnection);
    }

    // test get
    @Test
    public void testGetTaxConfig() {
        TaxConfigDaoImpl check = new TaxConfigDaoImpl();
        TaxConfig test = check.getTaxConfig();
        TaxConfig curen = new TaxConfig(1, 9000000, 3600000, 760000);
        boolean t = curen.equals(test);

        assertEquals(true, t);
    }

    @BeforeEach
    public void setUp() throws SQLException, ClassNotFoundException {
        checkGetYear = new ArrayList<>();
        checkGetYear.add(2019);
        checkGetYear.add(2018);
        checkGetYear.add(2017);
        checkGetYear.add(2016);
        checkGetYear.add(2015);
        checkGetYear.add(2014);
        checkGetYear.add(2013);
        checkGetYear.add(2012);
        checkGetYear.add(2011);
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/tax_sqa?setUnicode=true&characterEncoding=UTF-8&useSSL=false", "root",
                "");
        connect.setAutoCommit(false);
        savepoint = connect.setSavepoint("before");
    }

    // test nhập chuẩn
    @Test
    public void testEditTaxConfig() {
        TaxConfigDaoImpl check = new TaxConfigDaoImpl();
        TaxConfig curen = new TaxConfig(1, 9900000, 3600000, 760000);
        boolean b = check.editTax(curen);
        assertTrue(b);
    }

    //test get year
    @Test
    public void testGetYear() {
        UserTaxDaoImpl check = new UserTaxDaoImpl();
        assertEquals(checkGetYear, check.getYears());
    }

    //test get tax năm 1 tháng 1
    @Test
    public void testGetTax() {
        UserTaxDaoImpl check = new UserTaxDaoImpl();
        List<UserTax> test = check.findUserTaxesByMonth(1, 1, 1);
        assertEquals(null, test);
    }

    // test get tax năm 1 tháng -1
    @Test
    public void testGetTax2() {
        UserTaxDaoImpl check = new UserTaxDaoImpl();
        List<UserTax> test = check.findUserTaxesByMonth(-1, 2018, 1);
        assertEquals(null, test);
    }

    // test get tax năm 30 tháng 1
    @Test
    public void testGetTax3() {
        UserTaxDaoImpl check = new UserTaxDaoImpl();
        List<UserTax> test = check.findUserTaxesByMonth(2018, -1, 5);
        assertEquals(null, test);
    }

    @Test
    public void testGetTax4() {
        UserTaxDaoImpl check = new UserTaxDaoImpl();
        List<UserTax> test = check.findUserTaxesByMonth(2018, 3, -1);
        assertEquals(null, test);
    }

    @Test
    public void testGetTax5() {
        UserTaxDaoImpl check = new UserTaxDaoImpl();
        List<UserTax> test = check.findUserTaxesByMonth(-1, -1, -1);
        assertEquals(null, test);
    }

// test chuẩn
//	@Test
//	public void testGetTax6() throws ParseException {
//		datatest j = new datatest();
//		List<UserTax> h = j.getDatatest();
//		UserTaxDaoImpl check = new UserTaxDaoImpl();
//		List<UserTax> test = check.findUserTaxesByMonth(3, 2018, 5);
//		assertEquals(h, test);
//	}

    //test edit false
    @Test
    public void testEditTaxConfig1() {
        TaxConfigDaoImpl check = new TaxConfigDaoImpl();
        TaxConfig curen = new TaxConfig(1, null, 3600000, 760000);
        boolean b = check.editTax(curen);
        assertEquals(false, b);
    }

    // test edit false
    @Test
    public void testEditTaxConfig3() {
        TaxConfigDaoImpl check = new TaxConfigDaoImpl();
        TaxConfig curen = new TaxConfig(1, 9000000, null, 760000);
        boolean b = check.editTax(curen);
        assertEquals(false, b);
    }

    // test edit false
    @Test
    public void testEditTaxConfig4() {
        TaxConfigDaoImpl check = new TaxConfigDaoImpl();
        TaxConfig curen = new TaxConfig(1, 9000000, 3600000, null);
        boolean b = check.editTax(curen);
        assertEquals(false, b);
    }

    // test edit false
    @Test
    public void testEditTaxConfig5() {
        TaxConfigDaoImpl check = new TaxConfigDaoImpl();
        TaxConfig curen = new TaxConfig(1, null, null, null);
        boolean b = check.editTax(curen);
        assertEquals(false, b);
    }

    // test edit false
    @Test
    public void testEditTaxConfig6() {
        TaxConfigDaoImpl check = new TaxConfigDaoImpl();
        TaxConfig curen = new TaxConfig(1, -1, 3600000, 7600000);
        boolean b = check.editTax(curen);
        assertEquals(false, b);
    }

    // test edit false
    @Test
    public void testEditTaxConfig7() {
        TaxConfigDaoImpl check = new TaxConfigDaoImpl();
        TaxConfig curen = new TaxConfig(1, 9000000, -1, 7600000);
        boolean b = check.editTax(curen);
        assertEquals(false, b);
    }

    // test edit false
    @Test
    public void testEditTaxConfig8() {
        TaxConfigDaoImpl check = new TaxConfigDaoImpl();
        TaxConfig curen = new TaxConfig(1, 9000000, 3600000, -1);
        boolean b = check.editTax(curen);
        assertEquals(false, b);
    }

    @Test
    public void testEditTaxConfig9() {
        TaxConfigDaoImpl check = new TaxConfigDaoImpl();
        TaxConfig curen = new TaxConfig(1, 1000000000, 3600000, 760000);
        boolean b = check.editTax(curen);
        assertEquals(true, b);
    }

    @Test
    public void testEditTaxConfig10() {
        TaxConfigDaoImpl check = new TaxConfigDaoImpl();
        TaxConfig curen = new TaxConfig(1, 9000000, 1000000000, 760000);
        boolean b = check.editTax(curen);
        assertEquals(true, b);
    }

    @Test
    public void testEditTaxConfig11() {
        TaxConfigDaoImpl check = new TaxConfigDaoImpl();
        TaxConfig curen = new TaxConfig(1, 9000000, 3600000, 1000000000);
        boolean b = check.editTax(curen);
        assertEquals(true, b);
    }

    @AfterEach
    public void tearDown() throws SQLException {
        TaxConfigDaoImpl check = new TaxConfigDaoImpl();
        check.editTax(cu);
        connect.close();
    }

}
