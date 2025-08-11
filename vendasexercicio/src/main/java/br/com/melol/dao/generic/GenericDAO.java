package main.java.br.com.melol.dao.generic;

import main.java.br.com.melol.dao.Persistente;
import main.java.br.com.melol.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO<T extends Persistente, E extends Serializable> implements IGenericDAO<T, E> {

    protected Map<E, T> mapa;

    public GenericDAO() {
        this.mapa = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
        E chave = (E) getChave(entity);
        if (mapa.containsKey(chave)) {
            return false;
        }
        mapa.put(chave, entity);
        return true;
    }

    @Override
    public void excluir(E valor) {
        T objCadastrado = mapa.get(valor);
        if (objCadastrado != null) {
            mapa.remove(valor, objCadastrado);
        }
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException {
        E chave = (E) getChave(entity);
        T objCadastrado = mapa.get(chave);
        if (objCadastrado != null) {
            atualiarDados(entity, objCadastrado);
        }
    }

    @Override
    public T consultar(E valor) {
        return this.mapa.get(valor);
    }

    @Override
    public Collection<T> buscarTodos() {
        return this.mapa.values();
    }

    public abstract void atualiarDados(T entity, T entityCadastrado);

    protected abstract E getChave(T entity);
}