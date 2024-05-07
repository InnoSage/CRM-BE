package innosage.crm.domain.deal;

import innosage.crm.domain.content.Content;
import innosage.crm.domain.company.Company;
import innosage.crm.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Deal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company company;

    @OneToMany(mappedBy = "deal", cascade = CascadeType.ALL)
    private List<Content> contents;

    public void changeCompany(Company newCompany) {
        this.company = newCompany;
    }
}
