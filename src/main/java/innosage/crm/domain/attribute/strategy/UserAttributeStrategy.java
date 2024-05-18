package innosage.crm.domain.attribute.strategy;

import innosage.crm.domain.attribute.Attribute;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserAttributeStrategy implements AttributeStrategy{
    @Override
    public Map<String, Object> getData(Attribute attribute) {
        Map<String, Object> data = new HashMap<>();
        List<Map<String, ?>> userOptions = attribute.getUserOptions() != null
                ? attribute.getUserOptions().stream()
                .map(userOption -> Map.of("username", userOption.getName(), "email", userOption.getEmail()))
                .collect(Collectors.toList())
                : Collections.emptyList();
        data.put("users", userOptions);
        return data;
    }

    @Override
    public void setData(Attribute attribute, Map<String, ?> data) {
    }
}
