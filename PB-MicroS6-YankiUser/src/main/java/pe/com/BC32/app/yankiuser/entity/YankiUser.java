package pe.com.BC32.app.yankiuser.entity;

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
@Document(collection = "yankiusers")
public class YankiUser {

    @Id
    private String id;
    private String userDocumentType;
    private String userDocumentNumber;
    private String cellphoneNumber;
    private String cellphoneIMEI;
    private String email;
    private double yankiWalletBalance;
    private String debitCardNumber;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
