package br.com.bank.fatura.payloads.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Account implements Serializable {

    @JsonProperty("nomeCliente")
    private String nameClient;

    @JsonProperty("limite")
    private BigDecimal limit;

}
