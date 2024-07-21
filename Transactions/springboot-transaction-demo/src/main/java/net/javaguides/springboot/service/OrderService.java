package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.OrderRequestDto;
import net.javaguides.springboot.dto.OrderResponseDto;

public interface OrderService {
    OrderResponseDto placeOrder(OrderRequestDto orderRequestDto);
}
