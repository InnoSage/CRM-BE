package innosage.crm.domain.attribute.strategy;

import innosage.crm.domain.attribute.Attribute;

import java.util.Collections;
import java.util.Map;

public class TextAttributeStrategy implements AttributeStrategy{


    @Override
    public Map<String, Object> getData(Attribute attribute) {
        return Collections.emptyMap();
    }

    @Override
    public void setData(Attribute attribute, Map<String, ?> data) {
    }
}
