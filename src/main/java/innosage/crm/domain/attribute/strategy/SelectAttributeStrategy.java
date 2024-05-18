package innosage.crm.domain.attribute.strategy;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.Option;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SelectAttributeStrategy implements AttributeStrategy{
    @Override
    public Map<String, Object> getData(Attribute attribute) {
        Map<String, Object> data = new HashMap<>();
        List<Map<String, ?>> options = attribute.getOptions() != null
                ? attribute.getOptions().stream()
                .map(option -> Map.of("optionId", option.getId(), "optionName", option.getName()))
                .collect(Collectors.toList())
                : Collections.emptyList();
        data.put("options", options);
        return data;
    }

    @Override
    public void setData(Attribute attribute, Map<String, ?> data) {
    }
}
