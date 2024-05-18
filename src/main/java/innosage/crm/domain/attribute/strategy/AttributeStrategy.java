package innosage.crm.domain.attribute.strategy;

import innosage.crm.domain.attribute.Attribute;

import java.util.Map;

public interface AttributeStrategy {

    Map<String, Object> getData(Attribute attribute);
    void setData(Attribute attribute, Map<String, ?> data);
}
