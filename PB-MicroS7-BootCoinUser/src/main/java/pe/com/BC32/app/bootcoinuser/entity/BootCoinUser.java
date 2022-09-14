package pe.com.BC32.app.bootcoinuser.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bootcoinusers")
public class BootCoinUser {

    @Id
    private String id;
    private String userDocumentType;
    private String userDocumentNumber;
    private String cellphoneNumber;
    private String email;
    private double bootCoinBalance;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
