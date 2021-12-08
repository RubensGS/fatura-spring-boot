package br.com.bank.fatura.shared;

import br.com.bank.fatura.payloads.RequestPayloadInvoice;
import br.com.bank.fatura.payloads.models.CustomerData;
import br.com.bank.fatura.payloads.models.Invoice;
import br.com.bank.fatura.payloads.models.Total;
import br.com.bank.fatura.payloads.models.Transactions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class Utils {

    public RequestPayloadInvoice readingJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, RequestPayloadInvoice.class);
    }

    public Invoice buildInvoice(String json) throws JsonProcessingException {
        RequestPayloadInvoice request = readingJson(json);

        return Invoice.builder()
                .customerData(new CustomerData(request.getAccount().getNameClient(), request.getTransaction()))
                .transaction(new Transactions(request.getTransaction()))
                .total(new Total(new CustomerData(request.getAccount().getNameClient(), request.getTransaction())))
                .build();

    }
}
