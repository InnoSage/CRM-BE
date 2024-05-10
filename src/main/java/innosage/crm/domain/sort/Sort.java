package innosage.crm.domain.sort;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.filter.FilterType;
import innosage.crm.domain.sheet.Sheet;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SortType sortType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sheetId")
    private Sheet sheet;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "targetId")
    private Attribute targetAttribute;
}
