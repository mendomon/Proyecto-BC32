package pe.com.BC32.app.bootcoinuser.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BootCoinUserDto {

    private String id;
    private String userDocumentType;
    private String userDocumentNumber;
    private String cellphoneNumber;
    private String email;
    private double BootCoinBalance;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
