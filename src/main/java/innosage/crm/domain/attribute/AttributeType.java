package innosage.crm.domain.attribute;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AttributeType {
    TEXT, NUMBER, CURRENCY, DATE, SELECT, MULTISELECT, CHECKBOX, USER;
}
