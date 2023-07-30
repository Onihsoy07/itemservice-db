package hello.itemservice.repository.mybatis;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {

    void save(Item item);

    //파라매터 1개면 @Param 생략 가능
    void update(@Param("id") Long id, @Param("updateParam") ItemUpdateDto updateDto);

    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond itemSearchCond);

}
