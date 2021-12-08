package br.com.bank.fatura.payloads.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class Transaction implements Serializable {

    @JsonProperty("valor")
    private BigDecimal value;

    @JsonProperty("estabelecimento")
    private String establishment;

    @JsonProperty(value = "tipo", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    @JsonProperty("data")
    private String date;

}
