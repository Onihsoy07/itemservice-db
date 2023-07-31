package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//하이버네이트 5.6.7 버그(쿼리 메서드에도 @Param 넣어줘야함) or 버전 낮추기
public interface SpringDataJpaItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemNameLike(@Param("itemName") String itemName);
    List<Item> findByPriceLessThanEqual(@Param("price") Integer price);

    //쿼리 메서드(아래랑 같은 기능 수행)
    List<Item> findByItemNameLikeAndPriceLessThanEqual(@Param("itemName") String itemName, @Param("price") Integer price);

    //쿼리 직접 수행(JPQL)
    @Query("select i from Item i where i.itemName like :itemName and i.price <= :price")
    List<Item> findItems(@Param("itemName") String itemName, @Param("price") Integer price);
}
