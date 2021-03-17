package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    private Autor stephenKing;
    private Usuario silas;
    private Livro oIluminado;

    @BeforeEach
    void inicio() {
        silas = new Usuario("Silas Nazare", 11);
        stephenKing = new Autor("Stephen King");
        oIluminado = new Livro(123, "O Iluminado", stephenKing);
    }
    @Test
    void testaUsuarioSemEmprestimo() {
        assertEquals(silas.getLivrosEmprestados().size(), 0);
    }

    @Test
    void testaUsuarioComUmEmprestimo() {
        silas.adicionaLivroALista(oIluminado);
        assertEquals(silas.getLivrosEmprestados().size(), 1);
    }

    @Test
    void testaUsuarioComDoisEmprestimos() {
        Livro doutorSono = new Livro(456, "Doutor Sono", stephenKing);

        silas.adicionaLivroALista(oIluminado);
        silas.adicionaLivroALista(doutorSono);
        assertEquals(silas.getLivrosEmprestados().size(), 2);
    }

    @Test
    void testaUsuarioComTresEmprestimos() {
        Livro doutorSono = new Livro(456, "Doutor Sono", stephenKing);
        Livro oCemiterio = new Livro(789, "O Cemitério", stephenKing);

        silas.adicionaLivroALista(oIluminado);
        silas.adicionaLivroALista(doutorSono);
        silas.adicionaLivroALista(oCemiterio);
        assertEquals(silas.getLivrosEmprestados().size(), 3);
    }
}