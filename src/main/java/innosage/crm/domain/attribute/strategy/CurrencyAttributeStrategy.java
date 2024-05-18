package innosage.crm.domain.attribute.strategy;

import innosage.crm.domain.attribute.Attribute;

import java.util.HashMap;
import java.util.Map;

public class CurrencyAttributeStrategy implements AttributeStrategy{
    @Override
    public Map<String, Object> getData(Attribute attribute) {
        Map<String, Object> data = new HashMap<>();
        data.put("currency", attribute.getCurrencyCode());
        return data;
    }

    @Override
    public void setData(Attribute attribute, Map<String, ?> data) {
        attribute.setCurrencyCode((String) data.get("currency"));
    }


}
