package innosage.crm.attribute;

import innosage.crm.content.Content;
import innosage.crm.sheet.Sheet;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
}
