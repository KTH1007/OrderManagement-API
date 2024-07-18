package kr.co.ordermanagement.presentation.controller;

import kr.co.ordermanagement.application.SimpleOrderService;
import kr.co.ordermanagement.domain.order.State;
import kr.co.ordermanagement.presentation.dto.ChangeStateRequestDto;
import kr.co.ordermanagement.presentation.dto.OrderProductRequestDto;
import kr.co.ordermanagement.presentation.dto.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderRestController {
    private SimpleOrderService simpleOrderService;

    @Autowired
    public OrderRestController(SimpleOrderService simpleOrderService) {
        this.simpleOrderService = simpleOrderService;
    }

    // 상품 주문 API
    @PostMapping("/orders")
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody List<OrderProductRequestDto> orderProductRequestDtos) {
        OrderResponseDto orderResponseDto = simpleOrderService.createOrder(orderProductRequestDtos);
        return ResponseEntity.ok(orderResponseDto);
    }

    // 주문 번호로 조회 API
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable Long orderId) {
        OrderResponseDto orderResponseDto = simpleOrderService.findById(orderId);
        return ResponseEntity.ok(orderResponseDto);
    }

    // 주문 상태 강제 변경 API
    @PatchMapping("/orders/{orderId}")
    public ResponseEntity<OrderResponseDto> changeOrderState(@PathVariable Long orderId, @RequestBody ChangeStateRequestDto changeStateRequestDto) {
        OrderResponseDto orderResponseDto = simpleOrderService.changeState(orderId, changeStateRequestDto);
        return ResponseEntity.ok(orderResponseDto);
    }

    // 주문 상태로 조회 API
    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getOrdersByState(@RequestParam State state) {
        List<OrderResponseDto> orderResponseDtos = simpleOrderService.findByState(state);
        return ResponseEntity.ok(orderResponseDtos);
    }
}
