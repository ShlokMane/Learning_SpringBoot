package net.javaguides.springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {
    private String orderTrackingNumber;
    private String status;
    private String message;
}
