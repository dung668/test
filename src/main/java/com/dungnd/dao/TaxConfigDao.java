package com.dungnd.dao;

import com.dungnd.model.TaxConfig;

public interface TaxConfigDao {

    boolean editTax(TaxConfig taxConfig);

    TaxConfig getTaxConfig();

}
