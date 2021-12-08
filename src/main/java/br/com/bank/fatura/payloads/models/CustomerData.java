package br.com.bank.fatura.payloads.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter @Builder
public class CustomerData implements Serializable {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Transaction> transactions;

    @JsonProperty("nomeCLiente")
    private String nameClient;
    @JsonProperty("saldoAnterior")
    private BigDecimal previousBalance;
    @JsonProperty("totalFatura")
    private BigDecimal totalInvoice;
    @JsonProperty("saldoDisponivel")
    private BigDecimal balanceAvailable;

    public CustomerData (String nameClient, List<Transaction> transactions) {
        this.transactions = transactions;
        this.nameClient = nameClient;
        this.previousBalance = getResultPreviousBalance();
        this.totalInvoice = getResultTotalInvoice();
        this.balanceAvailable = getResultBalanceAvailable();
    }

    private BigDecimal getResultTotalInvoice() {
        BigDecimal sum;
        sum = transactions.stream()
                .filter(transaction -> !transaction.getEstablishment().equals("Pagamento"))
                .map(Transaction::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .abs();
        return sum;
    };

    private BigDecimal getResultPreviousBalance() {
        BigDecimal sum;
        sum = transactions.stream()
                .filter(transaction -> transaction.getEstablishment().equals("Pagamento"))
                .map(Transaction::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .abs();
        return sum;
    };

    private BigDecimal getResultBalanceAvailable() {
        return previousBalance.subtract(totalInvoice);
    }
}
