package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.dto.OrderRequestDto;
import net.javaguides.springboot.dto.OrderResponseDto;
import net.javaguides.springboot.entity.Order;
import net.javaguides.springboot.entity.Payment;
import net.javaguides.springboot.exception.PaymentException;
import net.javaguides.springboot.repository.OrderRepository;
import net.javaguides.springboot.repository.PaymentRepository;
import net.javaguides.springboot.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }
    @Override
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
        Order order= orderRequestDto.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        Order savedOrder = orderRepository.save(order);

        Payment payment = orderRequestDto.getPayment();
        if(!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Payment Type is Not Supported");
        }
        payment.setOrderId(savedOrder.getId());
        paymentRepository.save(payment);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setStatus(order.getStatus());
        orderResponseDto.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponseDto.setMessage("Success");

        return orderResponseDto;
    }
}
