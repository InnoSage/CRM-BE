package innosage.crm.domain.sheet;

import innosage.crm.auth.organization.Organization;
import innosage.crm.domain.attribute.Attribute;
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

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
