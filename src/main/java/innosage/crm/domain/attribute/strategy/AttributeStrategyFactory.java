package innosage.crm.domain.attribute.strategy;

import innosage.crm.domain.attribute.AttributeType;

import java.util.EnumMap;
import java.util.Map;

public class AttributeStrategyFactory {

    private static final Map<AttributeType, AttributeStrategy> strategies = new EnumMap<>(AttributeType.class);

    static {
        strategies.put(AttributeType.TEXT, new TextAttributeStrategy());
        strategies.put(AttributeType.NUMBER, new TextAttributeStrategy());
        strategies.put(AttributeType.CURRENCY, new CurrencyAttributeStrategy());
        strategies.put(AttributeType.DATE, new TextAttributeStrategy());
        strategies.put(AttributeType.SELECT, new SelectAttributeStrategy());
        strategies.put(AttributeType.MULTISELECT, new SelectAttributeStrategy());
//        strategies.put(AttributeType.CHECKBOX, new CheckboxAttributeStrategy());
        strategies.put(AttributeType.USER, new UserAttributeStrategy());
    }

    public static AttributeStrategy getStrategy(AttributeType type) {
        return strategies.get(type);
    }
}
