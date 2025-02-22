package com.manoelcampos.impostorenda;

public class PessoaJuridica extends Pessoa {
    private double lucro;
    private double valorProdutosAdquiridos;
    private final double ALIQUOTA_IRPJ = 0.15;
    private final double ALIQUOTA_IRPJ_ADICIONAL = 0.1;
    private final double LIMITE_COBRANCA_IR = 20000;
    private final double ALIQUOTA_CSLL = 0.09;
    private final double ALIQUOTA_ICMS = 0.05;

    public PessoaJuridica(double lucro, double valorICMSProdutos) {
        this.lucro = lucro;
        this.valorProdutosAdquiridos = valorICMSProdutos;
    }

    @Override
    protected double calcularIR() {

        double irParcial = lucro * ALIQUOTA_IRPJ;
        double irExcedente = Math.max(0, irParcial - LIMITE_COBRANCA_IR);
        return irParcial + (irExcedente * ALIQUOTA_IRPJ_ADICIONAL);
    }

    private double calcularCSLL() {
        return lucro * ALIQUOTA_CSLL;
    }

    private double calcularICMS() {
        return valorProdutosAdquiridos * ALIQUOTA_ICMS;
    }

    @Override
    protected double calcularOutrosImpostos() {
        return calcularCSLL() + calcularICMS();
    }
}