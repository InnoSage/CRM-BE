package innosage.crm.domain.content;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.content.mapper.AttributeTypeConverter;
import innosage.crm.domain.content.mapper.ContentMapper;
import innosage.crm.domain.deal.Deal;
import innosage.crm.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = AttributeTypeConverter.class)
    private Object value;

    @JoinColumn
    @ManyToOne
    private Deal deal;

    @JoinColumn(name = "attribute_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Attribute attribute;

    public void updateValue(Object value) {
        this.value = ContentMapper.convertValueByType(value, this.attribute.getType());
    }
}
