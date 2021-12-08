package br.com.bank.fatura.payloads;

import br.com.bank.fatura.payloads.models.Account;
import br.com.bank.fatura.payloads.models.Transaction;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class RequestPayloadInvoice implements Serializable {

    @JsonProperty("conta")
    private Account account;

    @JsonProperty("transacoes")
    private List<Transaction> transaction;
}
