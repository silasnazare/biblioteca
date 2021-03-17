package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.EmprestimoService;

import static org.junit.jupiter.api.Assertions.*;

class LivroTest {
    private Autor stephenKing;
    private Livro oIluminado;

    @BeforeEach
    void inicio() {
        stephenKing = new Autor("Stephen King");
        oIluminado = new Livro(123, "O Iluminado", stephenKing);
    }
    @Test
    void realizaEmprestimoEmLivroNaoReservado() {
        oIluminado.empresta(oIluminado);

        assertTrue(oIluminado.isReservado());
    }

    @Test
    void realizaEmprestimoEmLivroReservado() {
        oIluminado.reserva(oIluminado);
        oIluminado.empresta(oIluminado);
        assertTrue(oIluminado.isReservado());
    }
}