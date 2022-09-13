package pe.com.BC32.app.movement.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovementDto {

    private String id;
    private String productId;
    private String movementType; //Deposit - Withdrawal
    private double movementAmount;
    private String comment;
    private LocalDateTime createdAt;
    private String createdBy;
}
