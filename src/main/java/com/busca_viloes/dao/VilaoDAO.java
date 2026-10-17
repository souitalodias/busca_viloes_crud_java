package com.busca_viloes.dao;

import com.busca_viloes.model.Vilao;
import com.busca_viloes.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VilaoDAO implements GenericDAO<Vilao> {

    @Override
    public void cadastrar(Vilao vilao) throws Exception {
        String sql = "INSERT INTO viloes (nome, codinome, nivel_ameaca, preco_diaria, disponivel) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vilao.getNome());
            stmt.setString(2, vilao.getCodinome());
            stmt.setString(3, vilao.getNivelAmeaca());
            stmt.setDouble(4, vilao.getPrecoDiaria());
            stmt.setBoolean(5, vilao.getDisponivel());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Vilao> listar() throws Exception {
        List<Vilao> viloes = new ArrayList<>();
        String sql = "SELECT * FROM viloes";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Vilao v = new Vilao();
                v.setId(rs.getLong("id"));
                v.setNome(rs.getString("nome"));
                v.setCodinome(rs.getString("codinome"));
                v.setNivelAmeaca(rs.getString("nivel_ameaca"));
                v.setPrecoDiaria(rs.getDouble("preco_diaria"));
                v.setDisponivel(rs.getBoolean("disponivel"));
                viloes.add(v);
            }
        }
        return viloes;
    }

    @Override
    public Vilao buscarPorId(Long id) throws Exception {
        String sql = "SELECT * FROM viloes WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Vilao v = new Vilao();
                    v.setId(rs.getLong("id"));
                    v.setNome(rs.getString("nome"));
                    v.setCodinome(rs.getString("codinome"));
                    v.setNivelAmeaca(rs.getString("nivel_ameaca"));
                    v.setPrecoDiaria(rs.getDouble("preco_diaria"));
                    v.setDisponivel(rs.getBoolean("disponivel"));
                    return v;
                }
            }
        }
        return null;
    }

    @Override
    public void alterar(Vilao vilao) throws Exception {
        String sql = "UPDATE viloes SET nome = ?, codinome = ?, nivel_ameaca = ?, preco_diaria = ?, disponivel = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vilao.getNome());
            stmt.setString(2, vilao.getCodinome());
            stmt.setString(3, vilao.getNivelAmeaca());
            stmt.setDouble(4, vilao.getPrecoDiaria());
            stmt.setBoolean(5, vilao.getDisponivel());
            stmt.setLong(6, vilao.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void excluir(Long id) throws Exception {
        String sql = "DELETE FROM viloes WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}