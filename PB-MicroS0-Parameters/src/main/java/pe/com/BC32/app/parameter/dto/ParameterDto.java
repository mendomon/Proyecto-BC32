package pe.com.BC32.app.parameter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParameterDto {

    private String id;
    private String paramNumber;
    private String paramDescription;
    private String paramValue;
}
