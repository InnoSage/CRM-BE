package innosage.crm.domain.attribute;

import innosage.crm.domain.content.Content;
import innosage.crm.domain.sheet.Sheet;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AttributeType type;

    private String name;

    private String description;

    @OneToOne(mappedBy = "attribute", cascade = CascadeType.ALL, orphanRemoval = true)
    private Content content;

    @JoinColumn(name = "sheet_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sheet sheet;

    public void update(String name, String dataType, String description) {
        this.name = name;
        this.type = AttributeType.valueOf(dataType);
        this.description = description;
    }
}
