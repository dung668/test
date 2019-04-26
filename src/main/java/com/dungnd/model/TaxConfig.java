package com.dungnd.model;

public class TaxConfig {

    private Integer id, banThan, phuThuoc, tienAn;

    public TaxConfig(){
        super();
    }

    public TaxConfig(Integer id, Integer banThan, Integer phuThuoc, Integer tienAn) {
        this.id = id;
        this.banThan = banThan;
        this.phuThuoc = phuThuoc;
        this.tienAn = tienAn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBanThan() {
        return banThan;
    }

    public void setBanThan(Integer banThan) {
        this.banThan = banThan;
    }

    public Integer getPhuThuoc() {
        return phuThuoc;
    }

    public void setPhuThuoc(Integer phuThuoc) {
        this.phuThuoc = phuThuoc;
    }

    public Integer getTienAn() {
        return tienAn;
    }

    public void setTienAn(Integer tienAn) {
        this.tienAn = tienAn;
    }

    @Override
    public String toString() {
        return "TaxConfig{" +
                "id=" + id +
                ", banThan=" + banThan +
                ", phuThuoc=" + phuThuoc +
                ", tienAn=" + tienAn +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TaxConfig)
            return true;
        return false;
    }
}
