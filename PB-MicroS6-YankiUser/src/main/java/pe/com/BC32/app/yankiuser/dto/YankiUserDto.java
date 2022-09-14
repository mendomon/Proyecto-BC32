package pe.com.BC32.app.yankiuser.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YankiUserDto {

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
