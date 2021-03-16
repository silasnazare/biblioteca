package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.EmprestimoService;

import static org.junit.jupiter.api.Assertions.*;

class LivroTest {
    private EmprestimoService emprestimoService;
    private Autor a;
    private Livro l;
    private Usuario u;
    private Emprestimo e;

    @BeforeEach
    void inicio() {
        a = new Autor("Stephen King");
        l = new Livro(1234, "O Iluminado", a);
        u = new Usuario("Silas Nazare", 11);
        e = new Emprestimo(u, l);
    }
    //Realizar Empréstimo em livro que não esteja reservado.
    @Test
    void empresta() {

    }
}