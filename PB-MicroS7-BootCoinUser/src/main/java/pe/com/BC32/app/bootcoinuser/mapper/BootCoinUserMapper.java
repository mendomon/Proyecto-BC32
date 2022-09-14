package pe.com.BC32.app.bootcoinuser.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import pe.com.BC32.app.bootcoinuser.dto.BootCoinUserDto;
import pe.com.BC32.app.bootcoinuser.entity.BootCoinUser;

@Component
public class BootCoinUserMapper {

    public BootCoinUserDto entityToDto(BootCoinUser entity){
        BootCoinUserDto dto = new BootCoinUserDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    public BootCoinUser dtoToEntity(BootCoinUserDto dto){
        BootCoinUser entity = new BootCoinUser();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
