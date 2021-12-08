package br.com.bank.fatura.payloads;

import br.com.bank.fatura.models.Account;
import br.com.bank.fatura.models.Transaction;

import java.io.Serializable;
import java.util.List;


public class RequestPayload implements Serializable {

    private Account conta;

    private List<Transaction> transacoes;
}
