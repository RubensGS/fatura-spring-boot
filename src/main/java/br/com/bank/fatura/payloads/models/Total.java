package br.com.bank.fatura.payloads.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor @AllArgsConstructor @Setter @Getter
public class Total implements Serializable {

    @JsonProperty("totalDebitos")
    private BigDecimal totalDebits;

    @JsonProperty("totalCreditos")
    private BigDecimal totalCredits;

    public Total (CustomerData customerData) {
        this.totalDebits = customerData.getTotalInvoice();
        this.totalCredits = customerData.getPreviousBalance();
    }
}
