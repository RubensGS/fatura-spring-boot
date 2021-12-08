package br.com.bank.fatura.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Transaction implements Serializable {

    @JsonProperty("estabelecimento")
    private String establishment;



}
