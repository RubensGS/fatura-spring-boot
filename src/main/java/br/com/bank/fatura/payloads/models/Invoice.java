package br.com.bank.fatura.payloads.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor @Getter @Setter @AllArgsConstructor @Builder
public class Invoice {

    @JsonProperty("dadosCliente")
    private CustomerData customerData;

    @JsonProperty("transacoes")
    private Transactions transaction;

    @JsonProperty("total")
    private Total total;
}
