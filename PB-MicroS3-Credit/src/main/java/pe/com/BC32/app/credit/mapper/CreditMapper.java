package pe.com.BC32.app.credit.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import pe.com.BC32.app.credit.dto.CreditDto;
import pe.com.BC32.app.credit.entity.Credit;

@Component
public class CreditMapper {

    public CreditDto entityToDto(Credit entity){
        CreditDto dto = new CreditDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    public Credit dtoToEntity(CreditDto dto){
        Credit entity = new Credit();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
