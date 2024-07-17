package kr.co.ordermanagement.presentation.dto;

import kr.co.ordermanagement.domain.order.Order;
import kr.co.ordermanagement.domain.order.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class OrderResponseDto {
    private Long id;
    private List<OrderedProductDto> orderedProducts;
    private Integer totalPrice;
    private State state;

    public static OrderResponseDto toDto(Order order) {
        List<OrderedProductDto> orderedProductDtos = order.getOrderedProducts()
                .stream()
                .map(orderedProduct -> OrderedProductDto.toDto(orderedProduct))
                .toList();

        OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                .id(order.getId())
                .orderedProducts(orderedProductDtos)
                .totalPrice(order.getTotalPrice())
                .state(order.getState())
                .build();

        return orderResponseDto;
    }
}
