package com.manoelcampos.impostorenda;

/**
 * @author Manoel Campos da Silva Filho
 */
public class PessoaFisica extends Pessoa {
    private double salarioBruto;
    private int numeroDependentes;
    private double gastosSaude;
    private double gastosEducacao;
    private final double ALIQUOTA_IR = 0.11;
    private final double DEDUCAO_DEPENDENTE = 189.59; //valor atualizado para 2024/2025
    private final double ALIQUOTA_INSS = 0.11;

    public PessoaFisica(double salarioBruto, int numeroDependentes, double gastosSaude, double gastosEducacao) {
        this.salarioBruto = salarioBruto;
        this.numeroDependentes = numeroDependentes;
        this.gastosSaude = gastosSaude;
        this.gastosEducacao = gastosEducacao;
    }

    @Override
    protected double calcularIR() {
        double inss = calcularINSS();
        double irParcial = (salarioBruto - ((numeroDependentes * DEDUCAO_DEPENDENTE) + inss)) * ALIQUOTA_IR;
        // aqui vale resaltar que na vida real não é assim que funciona,
        // gastos com saúde e edução são deduzidos da base de calculo não no imposto
        // coloquei para não retornar valor negativo, porque não faria sentido nesse caso imposto negativo
        return Math.max(0, irParcial - (gastosSaude + gastosEducacao));
    }

    private double calcularINSS() {
        return salarioBruto * ALIQUOTA_INSS;
    }

    @Override
    protected double calcularOutrosImpostos() {
        return calcularINSS();
    }
}