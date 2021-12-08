package br.com.bank.fatura.payloads.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor @AllArgsConstructor @Getter
public class Transactions implements Serializable {

    @JsonProperty("internacionais")
    private List<Transaction> internationalList;

    @JsonProperty("nacionais")
    private List<Transaction> nationalList;

    public Transactions (List<Transaction> list) {
        this.internationalList = getInternationalFilteredList(list);
        this.nationalList = getNationalFilteredList(list);
    }

    private List<Transaction> getNationalFilteredList(List<Transaction> listTransations) {
        return listTransations.stream()
                .filter(transaction -> transaction.getType().equals("Nacional"))
                .collect(Collectors.toList());
    }

    private List<Transaction> getInternationalFilteredList(List<Transaction> listTransations) {
        return listTransations.stream()
                .filter(transaction -> transaction.getType().equals("Internacional"))
                .collect(Collectors.toList());
    }
}
