package pe.com.BC32.app.yankiuser.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import pe.com.BC32.app.yankiuser.dto.YankiUserDto;
import pe.com.BC32.app.yankiuser.entity.YankiUser;

@Component
public class YankiUserMapper {

    public YankiUserDto entityToDto(YankiUser entity){
        YankiUserDto dto = new YankiUserDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    public YankiUser dtoToEntity(YankiUserDto dto){
        YankiUser entity = new YankiUser();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
