package kr.co.ordermanagement.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class OrderedProduct {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;
}
