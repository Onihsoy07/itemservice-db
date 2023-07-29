package hello.itemservice.domain;

import lombok.*;

@Data
@NoArgsConstructor
public class Item {

    private Long id;

    private String itemName;
    private Integer price;
    private Integer quantity;

    @Builder
    public Item(Long id, String itemName, Integer price, Integer quantity) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    @Builder
    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
