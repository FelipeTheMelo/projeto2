package br.com.melol.dao;

import br.com.melol.dao.generic.IGenericDAO;
import br.com.melol.domain.Cliente;
import br.com.melol.exceptions.TipoChaveNaoEncontradaException;

public interface IClienteDAO extends IGenericDAO<Cliente, Long> {


    @Override
    Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException;
}