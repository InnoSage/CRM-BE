package innosage.crm.domain.attribute;

import innosage.crm.domain.attribute.option.Option;
import innosage.crm.domain.attribute.useroption.UserOption;
import innosage.crm.domain.content.Content;
import innosage.crm.domain.sheet.Sheet;
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

    private String currencyCode;

    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Content> content;

    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options;

    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserOption> userOptions;

    @JoinColumn(name = "sheet_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sheet sheet;

    public void update(String name, String dataType, String description) {
        this.name = name;
        this.type = AttributeType.valueOf(dataType);
        this.description = description;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }


    public void setUserOptions(List<UserOption> userOptions) {
        this.userOptions = userOptions;
    }
}
