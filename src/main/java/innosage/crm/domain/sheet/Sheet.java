package innosage.crm.domain.sheet;

import innosage.crm.auth.organization.Organization;
import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.filter.Filter;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "sheet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attribute> attributes;

    @OneToMany(mappedBy = "sheet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Filter> filters;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    public void update(String name) {
        this.name = name;
    }
}
