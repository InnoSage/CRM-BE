package innosage.crm.global.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RefreshToken {
    @Id
    @Column(name = "rt_key")
    private String key; //member id 들어감

    @Column(name = "rt_value")
    private String value;// token값 들어감

    public RefreshToken updateValue(String token) {
        this.value = token;
        return this;
    }
}