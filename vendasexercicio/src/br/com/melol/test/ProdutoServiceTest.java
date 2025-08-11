package br.com.melol.test;

import br.com.melol.dao.IProdutoDAO;
import br.com.melol.domain.Produto;
import br.com.melol.exceptions.TipoChaveNaoEncontradaException;
import br.com.melol.services.IProdutoService;
import br.com.melol.services.ProdutoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public class ProdutoServiceTest {

    private IProdutoService produtoService;

    private Produto produto;

    public ProdutoServiceTest() {
        IProdutoDAO dao = new ProdutoDaoMock();
        produtoService = new ProdutoService(dao);
    }

    @Before
    public void init() {
        produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
    }

    @Test
    public void pesquisar() {
        Produto produtor = this.produtoService.consultar(produto.getCodigo());
        Assert.assertNotNull(produtor);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException {
        Boolean retorno = produtoService.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluir() {
        produtoService.excluir(produto.getCodigo());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        produto.setNome("Rodrigo Pires");
        produtoService.alterar(produto);

        Assert.assertEquals("Rodrigo Pires", produto.getNome());
    }

    private class ProdutoDaoMock implements IProdutoDAO {
        @Override
        public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
            return null;
        }

        @Override
        public void excluir(String valor) {

        }

        @Override
        public void alterar(Produto entity) throws TipoChaveNaoEncontradaException, TipoChaveNaoEncontradaException {

        }

        @Override
        public Produto consultar(String valor) {
            return null;
        }

        @Override
        public Collection<Produto> buscarTodos() {
            return List.of();
        }
    }
}