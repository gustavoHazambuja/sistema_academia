package com.example.sistema_academia.domain.enums;

import java.math.BigDecimal;

public enum EnumPlano {
    MENSAL (new BigDecimal("159.90")),
    TRIMESTRAL (new BigDecimal("129.90")),
    ANUAL (new BigDecimal("99.90"));

    private final BigDecimal valor;

    private EnumPlano(BigDecimal valor){
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
