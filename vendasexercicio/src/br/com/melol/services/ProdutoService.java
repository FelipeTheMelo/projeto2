package br.com.melol.services;

import br.com.melol.dao.IProdutoDAO;
import br.com.melol.domain.Produto;
import br.com.melol.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}