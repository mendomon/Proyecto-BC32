package pe.com.BC32.app.movement.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import pe.com.BC32.app.movement.dto.MovementDto;
import pe.com.BC32.app.movement.entity.Movement;

@Component
public class MovementMapper {

    public MovementDto entityToDto(Movement entity){
        MovementDto dto = new MovementDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    public Movement dtoToEntity(MovementDto dto){
        Movement entity = new Movement();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

}
