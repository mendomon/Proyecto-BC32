package pe.com.BC32.app.movement.entity;

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
@Document(collection = "movements")
public class Movement {

    @Id
    private String id;
    private String productId;
    private String movementType; //Deposit - Withdrawal
    private double movementAmount;
    private String comment;
    private LocalDateTime createdAt;
    private String createdBy;
}
