package br.com.melol.test;

import br.com.melol.dao.IClienteDAO;
import br.com.melol.domain.Cliente;
import br.com.melol.exceptions.TipoChaveNaoEncontradaException;
import br.com.melol.services.ClienteService;
import br.com.melol.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Rodrigo");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);

    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Rodrigo Pires");
        clienteService.alterar(cliente);

        Assert.assertEquals("Rodrigo Pires", cliente.getNome());
    }

    private class ClienteDaoMock implements IClienteDAO {
        @Override
        public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
            return null;
        }

        @Override
        public void excluir(Long valor) {

        }

        @Override
        public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException, TipoChaveNaoEncontradaException {

        }

        @Override
        public Cliente consultar(Long valor) {
            return null;
        }

        @Override
        public Collection<Cliente> buscarTodos() {
            return List.of();
        }
    }
}