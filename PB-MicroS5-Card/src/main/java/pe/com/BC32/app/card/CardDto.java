package pe.com.BC32.app.card;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private String id;
    private String cardNumber;
    private String customerId;
    private String cardType; //Credit or Debit
    private LocalDateTime createdAt;
}
