package main.java.br.com.melol.dao;

import main.java.br.com.melol.dao.generic.IGenericDAO;
import main.java.br.com.melol.domain.Venda;
import main.java.br.com.melol.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}