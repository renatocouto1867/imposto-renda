package com.manoelcampos.impostorenda;

import static com.manoelcampos.impostorenda.FormatadorMoeda.formatarMoeda;

public class Main {
    public static void main(String[] args) {
        PessoaFisica pf = new PessoaFisica(5000, 2, 300, 200);
        System.out.println("Impostos PF: " + formatarMoeda(pf.calcularImpostos()));


        PessoaJuridica pj = new PessoaJuridica(100000, 50000);
        System.out.println("Impostos PJ: " + formatarMoeda(pj.calcularImpostos()));
    }
}
