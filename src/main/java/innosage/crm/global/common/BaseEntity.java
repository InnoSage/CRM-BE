package innosage.crm.global.common;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class BaseEntity {

    @CreatedDate
    private String createdAt;

    @LastModifiedDate
    private String updatedAt;

    @PrePersist // DB에 저장하기 전에 실행
    public void prePersist() {
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        this.updatedAt = this.createdAt;
    }

    @PreUpdate // DB에 업데이트 하기 전에 실행
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }

}
