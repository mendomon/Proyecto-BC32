package pe.com.BC32.app.customer.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import pe.com.BC32.app.customer.dto.CustomerDto;
import pe.com.BC32.app.customer.entity.Customer;

@Component
public class CustomerMapper {

    public CustomerDto entityToDto(Customer entity){
        CustomerDto dto = new CustomerDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    public Customer dtoToEntity(CustomerDto dto){
        Customer entity = new Customer();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
