package innosage.crm.member.entity;

import innosage.crm.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Organization extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "organization_id")
    private Long id;

    // 조직 이름
    private String name;

    @OneToMany(mappedBy = "organization")
    private List<Member> members = new ArrayList<>();
}
