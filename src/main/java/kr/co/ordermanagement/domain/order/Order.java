package kr.co.ordermanagement.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Order {
    private Long id;
    private List<OrderedProduct> orderedProducts;
    private Integer totalPrice;
    private State state;

    public Order(List<OrderedProduct> orderedProducts) {
        this.id = id;
        this.orderedProducts = orderedProducts;
        this.totalPrice = calculateTotalPrice(orderedProducts);
        this.state = State.CREATED;
    }

    public Boolean sameId(Long id) {
        return this.id.equals(id);
    }

    public Boolean sameState(State state) {
        return this.state.equals(state);
    }

    public void changeStateForce(State state) {
        this.state = state;
    }
    public void cancel() {
        this.state.checkCancellable();
        this.state = State.CANCELED;
    }

    private Integer calculateTotalPrice(List<OrderedProduct> orderedProducts) {
        return orderedProducts.stream()
                .mapToInt(orderedProduct -> orderedProduct.getPrice() * orderedProduct.getAmount())
                .sum();
    }
}
