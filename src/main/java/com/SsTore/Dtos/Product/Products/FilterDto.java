package com.SsTore.Dtos.Product.Products;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FilterDto {
    private String name;
    private String interval;
    private List<String> values;

    public List<String> getValues() {
        List<String> tmp = new ArrayList<>();
        values.forEach(value -> tmp.add('\'' + value + '\''));
        return tmp;
    }

    public String toFilterSQLFormat() {
        var tmp = getValues().toString();
        return "( c.name = '" + getName() + "' and pc.value " + getInterval() + " (" + tmp.substring(1, tmp.length() - 1) + ") )";
    }
}
