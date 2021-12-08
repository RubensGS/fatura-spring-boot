package br.com.bank.fatura.payloads;

import br.com.bank.fatura.payloads.models.Invoice;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class ResponsePayloadInvoice implements Serializable {

    @JsonProperty("fatura")
    private Invoice invoice;
}
