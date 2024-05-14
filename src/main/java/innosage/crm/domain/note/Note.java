package innosage.crm.domain.note;

import innosage.crm.auth.member.entity.Member;
import innosage.crm.domain.deal.Deal;
import innosage.crm.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Note extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authorId")
    private Member author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealId")
    private Deal deal;

    public void update(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
