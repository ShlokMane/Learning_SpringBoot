package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.OrderRequestDto;
import net.javaguides.springboot.dto.OrderResponseDto;
import net.javaguides.springboot.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderRequestDto orderRequestDto) {
        System.out.println("here");
        OrderResponseDto orderResponseDto =  orderService.placeOrder(orderRequestDto);
        return ResponseEntity.ok(orderResponseDto);
    }
}
