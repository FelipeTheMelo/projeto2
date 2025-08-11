package br.com.melol.dao;

import br.com.melol.dao.generic.IGenericDAO;
import br.com.melol.domain.Produto;
import br.com.melol.exceptions.TipoChaveNaoEncontradaException;

public interface IProdutoDAO extends IGenericDAO<Produto, String>{

    Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException;
}