package br.com.bank.fatura.services;

import br.com.bank.fatura.payloads.ResponsePayloadInvoice;
import br.com.bank.fatura.shared.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenerateInvoiceService {

    @Autowired
    Utils utils;

    public ResponsePayloadInvoice execute(String json) throws JsonProcessingException {
        return ResponsePayloadInvoice.builder()
                .invoice(utils.buildInvoice(json))
                .build();
    }
}
