package service;

import model.Devolucao;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

import java.time.temporal.ChronoUnit;

public class EmprestimoService {

    public Emprestimo emprestaLivro(Usuario usuario, Livro livro) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário inválido. Selecione outro usuário!");
        }
        if (livro == null) {
            throw new IllegalArgumentException("Livro inválido. Selecione outro livro!");
        } else {
            Emprestimo emprestimo = new Emprestimo(usuario, livro);
            livro.empresta(livro);
            livro.adicionaAoHistorico(emprestimo);
            usuario.adicionaLivroALista(livro);
            return emprestimo;
        }
    }

    public double calculaValorDoEmprestimo(Emprestimo emprestimo, Devolucao devolucao) {
        if (emprestimo == null || devolucao == null) {
            throw new IllegalArgumentException("Campo inválido. Tente novamente!");
        }
        long tempoEmprestado = emprestimo.getDataPrevista().until(devolucao.getDataDevolucao(), ChronoUnit.DAYS);
        if (tempoEmprestado < -7) {
            throw new IllegalArgumentException("Data inválida! Tente novamente!");
        }
        double valor = emprestimo.getValor() + (tempoEmprestado * 0.4);
        if (valor >= (emprestimo.getValor() * 1.6)) {
            emprestimo.setValor(emprestimo.getValor() * 1.6);
        }
        else {
            if (valor < emprestimo.getValor()) {
                valor = emprestimo.getValor();
            }
            emprestimo.setValor(valor);
        }
        return emprestimo.getValor();
    }
}