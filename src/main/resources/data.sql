INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$dZjz96PsdqkOMmVBbGXVH.PKiGQlhhdsNJn0t5DAeaLvvm3317We6');

INSERT INTO PARTIDO(NOME_PARTIDO, SIGLA, IDEOLOGIA, DATA_FUNDACAO) VALUES
('Partido Novo', 'Novo', 'CENTRO', '2011-02-12'),
('Movimento Democrático Brasileiro', 'MDB', 'CENTRO', '1980-01-15'),
('Partido dos Trabalhadores', 'PT', 'ESQUERDA', '1980-02-10'),
('União Brasil', 'UNIAO', 'DIREITA', '2021-10-06'),
('Partido Liberal', 'PL', 'DIREITA', '2006-10-06'),
('Sem Partido', 'Sem Partido', 'CENTRO', '2006-10-06');

INSERT INTO ASSOCIADO(NOME_ASSOCIADO, CARGO, DATA_NASCIMENTO, SEXO, PARTIDO_ID) VALUES
('Christian Martins Carvalho', 'NENHUM', '1993-09-05', 'MASCULINO', 1),
('Fernanda Pereira Altoé', 'VEREADOR', '1979-08-31', 'FEMININO', 1),
('Ricardo Luis Reis Nunes', 'PREFEITO', '1967-11-13', 'MASCULINO', 2),
('Adriana Sauthier Accorsi', 'DEPUTADO_ESTADUAL', '1973-03-17', 'FEMININO', 3),
('Erika Juca Kokay', 'DEPUTADO_FEDERAL', '1957-08-15', 'FEMININO', 3),
('David Samuel Alcolumbre', 'SENADOR', '1977-06-19', 'MASCULINO', 4),
('Ibaneis Rocha Barros Junior', 'GOVERNADOR', '1971-07-10', 'MASCULINO', 2),
('Jair Messias Bolsonaro', 'PRESIDENTE', '1955-03-21', 'MASCULINO', 5);

