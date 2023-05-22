package br.com.audsat.carinsurancequotes.domains.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity(name = "drivers")
public class DriverEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "document")
    private String document;

    @Column(name = "birthdate")
    private LocalDate birthdate;

}
