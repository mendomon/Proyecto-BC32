package pe.com.BC32.app.parameter.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import pe.com.BC32.app.parameter.dto.ParameterDto;
import pe.com.BC32.app.parameter.entity.Parameter;

@Component
public class ParameterMapper {

    public ParameterDto entityToDto(Parameter entity){
        ParameterDto dto = new ParameterDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    public Parameter dtoToEntity(ParameterDto dto){
        Parameter entity = new Parameter();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
