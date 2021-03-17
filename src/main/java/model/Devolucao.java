package model;

import java.time.LocalDate;

public class Devolucao {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataDevolucao;
    private double valor;

    public Devolucao(Livro livro, Usuario usuario, LocalDate dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataDevolucao = dataDevolucao;
        this.valor = 5.00;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void efetuaDevolucao(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Campo inválido. Tente novamente!");
        }
        livro.devolve(livro);
        usuario.removeLivroDaLista(livro);
    }
}
