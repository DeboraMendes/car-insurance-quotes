package br.com.audsat.carinsurancequotes.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Entity(name = "cars")
public class CarEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "year")
    private String year;

    @Column(name = "fipe_value")
    private BigDecimal fipeValue;

}
