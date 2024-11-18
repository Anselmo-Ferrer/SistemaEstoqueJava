package Transacoes;

import java.time.MonthDay;

public abstract class Transacoes {
    protected int id;
    protected String tipo;
    protected String[] produtos;
    protected int quantidade;
    protected MonthDay dia;

    public abstract void transacaoConfirmar(String nome, int quantidade);

}
