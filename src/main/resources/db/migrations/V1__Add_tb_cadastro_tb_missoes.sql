CREATE TABLE tb_missoes (
    id BIGINT PRIMARY KEY,
    nomeMissao VARCHAR(50),
    dificuldade VARCHAR(20)
);

CREATE TABLE tb_cadastro (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(50),
    email VARCHAR(50),
    idade INTEGER,
    missoes_id BIGINT,
    CONSTRAINT fk_cadastro_missoes
        FOREIGN KEY (missoes_id)
        REFERENCES tb_missoes(id)
);