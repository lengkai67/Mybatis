package com.lengkai.domain;

import java.io.Serializable;
import java.util.List;


public class Queryvo implements Serializable {

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
