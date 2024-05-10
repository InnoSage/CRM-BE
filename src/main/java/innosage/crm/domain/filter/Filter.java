package innosage.crm.domain.filter;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.sheet.Sheet;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Filter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;

    @Enumerated(EnumType.STRING)
    private FilterType filterType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sheetId")
    private Sheet sheet;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "targetId")
    private Attribute targetAttribute;
}
