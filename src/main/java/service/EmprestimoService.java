package service;

import model.Emprestimo;
import model.Livro;
import model.Usuario;

import java.time.temporal.ChronoUnit;

public class EmprestimoService {
    public Emprestimo emprestaLivro(Usuario usuario, Livro livro) {
        if (livro.isEmprestado() || !livro.isReservado()) {
            throw new IllegalArgumentException("O livro já está emprestado ou não foi reservado");
        }
        Emprestimo emprestimo = new Emprestimo(usuario, livro);
        livro.empresta(livro);
        emprestimo.setDataEmprestimo();
        emprestimo.setDataPrevista();
        emprestimo.setValor(calculaValorDo(emprestimo));
        livro.adicionaAoHistorico(emprestimo);
        return emprestimo;
    }

    private double calculaValorDo(Emprestimo emprestimo) {
        double valorTotal = 0d;
        emprestimo.setDataDevolucao(2021, 03, 20);
        long num = emprestimo.getDataPrevista().until(emprestimo.getDataDevolucao(), ChronoUnit.DAYS);

        if (num < 0) {
            throw new IllegalArgumentException("Data inválida!");
        }
        valorTotal += emprestimo.getValor() + (num * 0.4);
        if (valorTotal >= emprestimo.getValor() * 1.6) {
            valorTotal = emprestimo.getValor() * 1.6;
        }
        else {
            valorTotal = emprestimo.getValor();
        }
        return valorTotal;
    }
}