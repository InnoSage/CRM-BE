package innosage.crm.domain.attribute.content;

import innosage.crm.domain.attribute.Attribute;
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

    private String value;

    @JoinColumn
    @ManyToOne
    private Deal deal;

    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    private Attribute attribute;
}
