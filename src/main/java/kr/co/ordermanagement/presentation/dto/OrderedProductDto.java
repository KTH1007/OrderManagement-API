package kr.co.ordermanagement.presentation.dto;

import kr.co.ordermanagement.domain.order.OrderedProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class OrderedProductDto {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;

    public static OrderedProductDto toDto(OrderedProduct orderedProduct) {
        OrderedProductDto orderedProductDto = OrderedProductDto.builder()
                .id(orderedProduct.getId())
                .name(orderedProduct.getName())
                .price(orderedProduct.getPrice())
                .amount(orderedProduct.getAmount())
                .build();
        return orderedProductDto;
    }
}
