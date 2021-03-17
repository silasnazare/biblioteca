package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Livro {
    private Integer isbn;
    private String titulo;
    private Autor autor;
    private boolean reservado;
    private boolean emprestado;
    private List<Emprestimo> historico = new ArrayList<>();

    public Livro(Integer isbn, String titulo, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.reservado = false;
        this.emprestado = false;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public void reserva(Livro livro) {
        if (isReservado()) {
            throw new IllegalArgumentException("Livro já reservado. Selecione outro livro!");
        }
        if (isEmprestado()) {
            throw new IllegalArgumentException("Livro já emprestado. Selecione outro livro!");
        }
        else {
            this.reservado = true;
        }
    }

    public void empresta(Livro livro) {
        if (!isReservado()) {
            throw new IllegalArgumentException("Livro não reservado. Selecione outro livro!");
        }
        if (isEmprestado()) {
            throw new IllegalArgumentException("Livro já emprestado. Selecione outro livro!");
        }
        else {
            this.emprestado = true;
        }
    }

    public void devolve(Livro livro) {
        if (!this.emprestado) {
            throw new IllegalArgumentException("Livro não emprestado!");
        }
        else {
            this.emprestado = false;
            this.reservado = false;
        }
    }

    public List<Emprestimo> getHistorico() {
        return Collections.unmodifiableList(historico);
    }

    public void adicionaAoHistorico(Emprestimo emprestimo) {
        this.historico.add(emprestimo);
    }
}
