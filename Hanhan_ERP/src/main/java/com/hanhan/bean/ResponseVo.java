package com.hanhan.bean;

import java.util.List;

public class ResponseVo<T> {
    List<T> rows;
    int total;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


}
