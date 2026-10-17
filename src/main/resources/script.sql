CREATE DATABASE IF NOT EXISTS busca_viloes_db;
USE busca_viloes_db;

CREATE TABLE IF NOT EXISTS viloes (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      nome VARCHAR(100) NOT NULL,
    codinome VARCHAR(100) NOT NULL,
    nivel_ameaca VARCHAR(50) NOT NULL,
    preco_diaria DOUBLE NOT NULL,
    disponivel BOOLEAN NOT NULL
    );