package pe.com.BC32.app.account.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import pe.com.BC32.app.account.dto.AccountDto;
import pe.com.BC32.app.account.entity.Account;

@Component
public class AccountMapper {

    public AccountDto entityToDto(Account entity){
        AccountDto dto = new AccountDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    public Account dtoToEntity(AccountDto dto){
        Account entity = new Account();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
