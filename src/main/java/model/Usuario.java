package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usuario extends Pessoa {
    private Integer matricula;
    private List<Livro> livrosEmprestados = new ArrayList<>();

    public Usuario(String nome, Integer matricula) {
        super(nome);
        this.matricula = matricula;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public List<Livro> getLivrosEmprestados() {
        return Collections.unmodifiableList(livrosEmprestados);
    }

    public void adicionaLivroALista(Livro livro) {
        if (livrosEmprestados.size() > 1) {
            throw new IllegalArgumentException("Usuário com limite de livros emprestados!");
        }
        this.livrosEmprestados.add(livro);
    }

    public void removeLivroDaLista(Livro livro) {
        this.livrosEmprestados.remove(livro);
    }
}
