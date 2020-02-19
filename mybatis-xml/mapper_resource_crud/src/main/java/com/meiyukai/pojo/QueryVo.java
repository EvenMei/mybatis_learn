package com.meiyukai.pojo;

import java.util.List;

public class QueryVo {
    private String name;
    private List<Integer> ids ;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
