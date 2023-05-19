package br.com.audsat.carinsurancequotes.domains.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @Column(name = "car_year")
    private Integer year;

    @Column(name = "fipe_value")
    private BigDecimal fipeValue;

}
