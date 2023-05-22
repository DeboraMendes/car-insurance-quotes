package br.com.audsat.carinsurancequotes.domains.pojo;

import java.time.LocalDate;

public interface IDriverEntity {
    Long getId();

    String getDocument();

    LocalDate getBirthdate();

    Boolean getMainDriver();
}
