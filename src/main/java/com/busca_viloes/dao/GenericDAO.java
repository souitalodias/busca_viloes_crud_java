package com.busca_viloes.dao;

import java.util.List;

public interface GenericDAO<T> {
    void cadastrar(T objeto) throws Exception;
    List<T> listar() throws Exception;
    T buscarPorId(Long id) throws Exception;
    void alterar(T objeto) throws Exception;
    void excluir(Long id) throws Exception;
}