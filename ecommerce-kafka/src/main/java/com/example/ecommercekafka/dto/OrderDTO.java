package com.example.ecommercekafka.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {

    @NotNull
    private Long num;
    @Min(0)
    private Float value;
    @NotNull(message = "Cliente inválido")
    private String client;
}
