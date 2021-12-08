package br.com.bank.fatura.controllers;

import br.com.bank.fatura.services.GenerateInvoiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards/v1/invoice")
public class InvoiceController {

    @Autowired
    GenerateInvoiceService generateInvoiceService;

    @GetMapping()
    public ResponseEntity listInvoices() {
        return ResponseEntity.ok().body("Lista Fatuas");
    }

    @PostMapping()
    public ResponseEntity generateInvoice(@RequestBody String json) throws JsonProcessingException {
        return ResponseEntity.ok().body(generateInvoiceService.execute(json));
    }

}
