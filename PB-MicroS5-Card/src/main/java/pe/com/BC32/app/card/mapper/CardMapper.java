package pe.com.BC32.app.card.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import pe.com.BC32.app.card.dto.CardDto;
import pe.com.BC32.app.card.entity.Card;

@Component
public class CardMapper {
    public CardDto entityToDto(Card entity){
        CardDto dto = new CardDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    public Card dtoToEntity(CardDto dto){
        Card entity = new Card();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
