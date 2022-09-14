package pe.com.BC32.app.parameter.entity;

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
@Document(collection = "parameters")
public class Parameter {

    @Id
    private String id;
    private String paramNumber;
    private String paramDescription;
    private String paramValue;
}
