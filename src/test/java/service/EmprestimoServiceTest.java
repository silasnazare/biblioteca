package service;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.EmprestimoService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimoServiceTest {
    private EmprestimoService emprestimoService;
    private Autor stephenKing;
    private Usuario silas;
    private Livro oIluminado;

    @BeforeEach
    void inicio() {
        emprestimoService = new EmprestimoService();
        silas = new Usuario("Silas Nazare", 11);
        stephenKing = new Autor("Stephen King");
        oIluminado = new Livro(123, "O Iluminado", stephenKing);
    }

    @Test
    void verificaSeDataPrevistaEstaCorreta() {
        oIluminado.reserva(oIluminado);
        Emprestimo emprestimo = emprestimoService.emprestaLivro(silas, oIluminado);
        LocalDate umaSemana = LocalDate.now().plusDays(7);

        assertTrue(emprestimo.getDataPrevista().equals(umaSemana));
    }

    @Test
    void testaDevolucaoAntesDaData() {
        oIluminado.reserva(oIluminado);
        Emprestimo emprestimo = emprestimoService.emprestaLivro(silas, oIluminado);
        LocalDate dataDevolucao = LocalDate.of(2021, 3, 22);
        Devolucao devolucao = new Devolucao(oIluminado, silas, dataDevolucao);

        emprestimoService.calculaValorDoEmprestimo(emprestimo, devolucao);

        assertEquals(emprestimo.getValor(), 5.0, 0.0001d);
    }

    @Test
    void testaDevolucaoNaData() {
        oIluminado.reserva(oIluminado);
        Emprestimo emprestimo = emprestimoService.emprestaLivro(silas, oIluminado);
        LocalDate dataDevolucao = LocalDate.of(2021, 3, 24);
        Devolucao devolucao = new Devolucao(oIluminado, silas, dataDevolucao);

        emprestimoService.calculaValorDoEmprestimo(emprestimo, devolucao);

        assertEquals(emprestimo.getValor(), 5.0, 0.0001);
    }

    @Test
    void testaDevolucaoUmDiaAposAData() {
        oIluminado.reserva(oIluminado);
        Emprestimo emprestimo = emprestimoService.emprestaLivro(silas, oIluminado);
        LocalDate dataDevolucao = LocalDate.of(2021, 3, 25);
        Devolucao devolucao = new Devolucao(oIluminado, silas, dataDevolucao);

        emprestimoService.calculaValorDoEmprestimo(emprestimo, devolucao);

        assertEquals(emprestimo.getValor(), 5.4, 0.0001d);
    }

    @Test
    void testaDevolucaoTrintaDiasAposAData() {
        oIluminado.reserva(oIluminado);
        Emprestimo emprestimo = emprestimoService.emprestaLivro(silas, oIluminado);
        LocalDate dataDevolucao = LocalDate.of(2021, 4, 17);
        Devolucao devolucao = new Devolucao(oIluminado, silas, dataDevolucao);

        emprestimoService.calculaValorDoEmprestimo(emprestimo, devolucao);

        assertEquals(emprestimo.getValor(), 8.0, 0.0001);
    }
}