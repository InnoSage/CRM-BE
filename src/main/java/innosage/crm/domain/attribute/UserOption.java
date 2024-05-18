package innosage.crm.domain.attribute;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "userOptions")
public class UserOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @JoinColumn(name = "attribute_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Attribute attribute;
}
