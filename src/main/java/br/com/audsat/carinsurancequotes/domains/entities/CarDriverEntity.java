package br.com.audsat.carinsurancequotes.domains.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "car_drivers")
public class CarDriverEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private CarEntity car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private DriverEntity driver;

    @Column(name = "main_driver")
    private Boolean isMainDriver;

}
