 /* CREATE DATABASE restaurante; 
USE restaurante; 

DROP TABLE IF EXISTS PEDIDO;

CREATE TABLE PEDIDO (
    ID INT PRIMARY KEY,
    DATA DATE,
    ID_RESTA INT,
    VALOR DECIMAL(10, 2),
    TAXA_ENTREGA DECIMAL(10, 2),
    ID_PROMO INT,
    ID_STATUS_ENTREGA INT,
    ID_FORMA_PAG INT,
    OBS TEXT,
    TROCO DECIMAL(10, 2),
    ID_ENDE INT
);

CREATE TABLE PEDIDO_PRODUTO (
    ID_PEDIDO INT,
    ID_PRODUTO INT,
    QUANTIDADE INT,
    PRIMARY KEY (ID_PEDIDO, ID_PRODUTO)
);

CREATE TABLE PEDIDO_PRODUTO_ACOMP (
    ID_PEDIDO_PRODUTO INT,
    ID_ACOMP INT,
    PRIMARY KEY (ID_PEDIDO_PRODUTO, ID_ACOMP)
);

CREATE TABLE RESTAURANTE (
    ID INT PRIMARY KEY,
    NOME VARCHAR(100),
    ENDERECO VARCHAR(200),
    TELEFONE VARCHAR(20),
    CATEGORIA INT,
    HORA_FUNCIONAMENTO TIME,
    IS_RETIRADA BOOLEAN
);

CREATE TABLE ENDERECO (
    ID INT PRIMARY KEY,
    RUA VARCHAR(100),
    NUMERO VARCHAR(10),
    BAIRRO VARCHAR(50),
    CIDADE VARCHAR(50),
    ESTADO VARCHAR(2),
    CEP VARCHAR(10),
    ID_USUARIO INT
);

CREATE TABLE PROMOCAO (
    ID INT PRIMARY KEY,
    NOME VARCHAR(50),
    CODIGO VARCHAR(20),
    VALOR DECIMAL(10, 2),
    VALIDADE DATE
);

CREATE TABLE AVALIACAO (
    ID INT PRIMARY KEY,
    NOTA INT,
    PEDIDO INT,
    REGISTRO_DATA DATE
);

CREATE TABLE PRODUTO_ACOMP (
    ID_PRODUTO INT,
    ID_ACOMP INT,
    PRIMARY KEY (ID_PRODUTO, ID_ACOMP)
);

CREATE TABLE STATUS_ENTREGA (
    ID INT PRIMARY KEY,
    NOME VARCHAR(50)
);

CREATE TABLE ACOMPANHAMENTO (
    ID INT PRIMARY KEY,
    NOME VARCHAR(50),
    DESCRICAO TEXT,
    VALOR DECIMAL(10, 2)
);

CREATE TABLE CATEGORIA (
    ID INT PRIMARY KEY,
    TIPO VARCHAR(50),
    NOME VARCHAR(50),
    DESCRICAO TEXT
);

CREATE TABLE FORMA_PAGAMENTO (
    ID INT PRIMARY KEY,
    TIPO_DE_PAGAMENTO VARCHAR(50)
);

CREATE TABLE HISTORICO_ENTREGA (
    ID INT PRIMARY KEY,
    ID_STATUS_ENTREGA INT,
    ID_PEDIDO INT,
    DATA_HORA DATETIME
);

CREATE TABLE HISTORICO_PAGAMENTO (
    ID INT PRIMARY KEY,
    DATA DATE,
    ID_FORMA INT,
    VALOR DECIMAL(10, 2)
);

CREATE TABLE PRODUTO (
    ID_PRODUTO INT PRIMARY KEY,
    NOME VARCHAR(100),
    DESCRICAO TEXT,
    PRECO DECIMAL(10, 2),
    CATEGORIA_ID INT,
    RESTAURANTE_ID INT
);

CREATE TABLE RESTAURANTE_PAGAMENTO (
    ID_RES INT,
    ID_PAGA INT,
    PRIMARY KEY (ID_RES, ID_PAGA)
); 

ALTER TABLE PEDIDO
    ADD CONSTRAINT FK_RESTAURANTE FOREIGN KEY (ID_RESTA) REFERENCES RESTAURANTE(ID),
    ADD CONSTRAINT FK_PROMO FOREIGN KEY (ID_PROMO) REFERENCES PROMOCAO(ID),
    ADD CONSTRAINT FK_STATUS_ENTREGA FOREIGN KEY (ID_STATUS_ENTREGA) REFERENCES STATUS_ENTREGA(ID),
    ADD CONSTRAINT FK_FORMA_PAG FOREIGN KEY (ID_FORMA_PAG) REFERENCES FORMA_PAGAMENTO(ID),
    ADD CONSTRAINT FK_ENDERECO FOREIGN KEY (ID_ENDE) REFERENCES ENDERECO(ID);

ALTER TABLE PEDIDO_PRODUTO
    ADD CONSTRAINT FK_PEDIDO FOREIGN KEY (ID_PEDIDO) REFERENCES PEDIDO(ID),
    ADD CONSTRAINT FK_PRODUTO FOREIGN KEY (ID_PRODUTO) REFERENCES PRODUTO(ID_PRODUTO);

ALTER TABLE PEDIDO_PRODUTO_ACOMP
    ADD CONSTRAINT FK_PEDIDO_PRODUTO FOREIGN KEY (ID_PEDIDO_PRODUTO) REFERENCES PEDIDO_PRODUTO(ID_PEDIDO),
    ADD CONSTRAINT FK_ACOMP FOREIGN KEY (ID_ACOMP) REFERENCES ACOMPANHAMENTO(ID);

ALTER TABLE PRODUTO
    ADD CONSTRAINT FK_CATEGORIA FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA(ID),
    ADD CONSTRAINT FK_RESTAURANTE FOREIGN KEY (RESTAURANTE_ID) REFERENCES RESTAURANTE(ID);

ALTER TABLE HISTORICO_ENTREGA
    ADD CONSTRAINT FK_STATUS FOREIGN KEY (ID_STATUS_ENTREGA) REFERENCES STATUS_ENTREGA(ID),
    ADD CONSTRAINT FK_PEDIDO FOREIGN KEY (ID_PEDIDO) REFERENCES PEDIDO(ID);

-- Produto que mais vendeu
SELECT p.NOME, SUM(pp.QUANTIDADE) AS TOTAL_VENDIDO
FROM PEDIDO_PRODUTO pp
JOIN PRODUTO p ON pp.ID_PRODUTO = p.ID_PRODUTO
GROUP BY p.ID_PRODUTO
ORDER BY TOTAL_VENDIDO DESC
LIMIT 1;

-- Produto que menos vendeu
SELECT p.NOME, SUM(pp.QUANTIDADE) AS TOTAL_VENDIDO
FROM PEDIDO_PRODUTO pp
JOIN PRODUTO p ON pp.ID_PRODUTO = p.ID_PRODUTO
GROUP BY p.ID_PRODUTO
ORDER BY TOTAL_VENDIDO ASC
LIMIT 1;

-- Mês do ano com mais vendas
SELECT MONTH(DATA) AS MES, COUNT(*) AS TOTAL_VENDAS
FROM PEDIDO
GROUP BY MONTH(DATA)
ORDER BY TOTAL_VENDAS DESC
LIMIT 1;

-- 4. Forma de pagamento mais usada
SELECT f.TIPO_DE_PAGAMENTO, COUNT(*) AS TOTAL_USO
FROM PEDIDO p
JOIN FORMA_PAGAMENTO f ON p.ID_FORMA_PAG = f.ID
GROUP BY f.ID
ORDER BY TOTAL_USO DESC
LIMIT 1;

-- 5. Endereço que mais teve entrega
SELECT e.RUA, e.NUMERO, e.BAIRRO, e.CIDADE, COUNT(*) AS TOTAL_ENTREGAS
FROM PEDIDO p
JOIN ENDERECO e ON p.ID_ENDE = e.ID
GROUP BY e.ID
ORDER BY TOTAL_ENTREGAS DESC
LIMIT 1;

-- 6. Venda com mais produtos
SELECT p.ID, SUM(pp.QUANTIDADE) AS TOTAL_PRODUTOS
FROM PEDIDO p
JOIN PEDIDO_PRODUTO pp ON p.ID = pp.ID_PEDIDO
GROUP BY p.ID
ORDER BY TOTAL_PRODUTOS DESC
LIMIT 1;

-- 7. Venda do mês atual por pagamento
SELECT f.TIPO_DE_PAGAMENTO, COUNT(*) AS TOTAL_VENDAS
FROM PEDIDO p
JOIN FORMA_PAGAMENTO f ON p.ID_FORMA_PAG = f.ID
WHERE MONTH(p.DATA) = MONTH(CURDATE()) AND YEAR(p.DATA) = YEAR(CURDATE())
GROUP BY f.ID;

-- 8. Venda do mês anterior por pagamento
SELECT f.TIPO_DE_PAGAMENTO, COUNT(*) AS TOTAL_VENDAS
FROM PEDIDO p
JOIN FORMA_PAGAMENTO f ON p.ID_FORMA_PAG = f.ID
WHERE MONTH(p.DATA) = MONTH(CURDATE()) - 1 AND YEAR(p.DATA) = YEAR(CURDATE())
GROUP BY f.ID; 


-- inserts

INSERT INTO FORMA_PAGAMENTO (ID, TIPO_DE_PAGAMENTO) VALUES
(1, 'Cartão de Crédito'),
(2, 'Cartão de Débito'),
(3, 'Dinheiro'),
(4, 'Pix'),
(5, 'Boleto Bancário'),
(6, 'Carteira Digital'),
(7, 'Vale Refeição'),
(8, 'Transferência Bancária'),
(9, 'PayPal'),
(10, 'Crédito Loja');



INSERT INTO RESTAURANTE (ID, NOME, ENDERECO, TELEFONE, CATEGORIA, HORA_FUNCIONAMENTO, IS_RETIRADA) VALUES
(1, 'Restaurante ZM Delícias', 'Rua dos Coentro, 17', '1717-17171', 1, '08:00:00', true),
(2, 'Pregos e Coca Cola', 'Rua Palmito, 456', '2222-2221', 2, '10:00:00', false),
(3, 'Bol Boni Bençãos', 'Rua Abençoada Lima, 189', '3333-3333', 3, '10:00:00', false),
(4, 'S&J Refeições', 'Rua Das Graças, 456', '8922-2261', 4, '17:00:00', true),
(5, 'Colinas Refeições', 'Rua Dos Matos Verdes, 46', '8992-2161', 5, '02:00:00', true),
(6, 'Pizza do Chef', 'Rua Dos Matos Verdes, 29', '9987-1832', 6, '13:00:00', true),
(7, 'Açaí da Tarde', 'Rua Queiroz, 219', '9821-2183', 7, '05:00:00', true),
(8, 'Churrascaria do Zé', 'Rua Dos Matos Verdes, 196', '9999-2111', 8, '05:50:00', false),
(9, 'Sushi Master', 'Rua Dos Matos Verdes, 222', '9712-0182', 9, '07:00:00', true),
(10, 'Espetinhos da Vovó', 'Rua Dos Matos Verdes, 346', '8999-4567', 10, '15:00:00', false); 

INSERT INTO ENDERECO (ID, RUA, NUMERO, BAIRRO, CIDADE, ESTADO, CEP, ID_USUARIO) VALUES
(2, 'Rua Palmito', '456', 'Santa Mônica', 'Uberlândia', 'MG', '38401-000', 2),
(3, 'Rua Abençoada Lima', '189', 'Tabajaras', 'Uberlândia', 'MG', '38402-000', 3),
(4, 'Rua Das Graças', '456', 'Martins', 'Uberlândia', 'MG', '38403-000', 4),
(5, 'Rua Dos Matos Verdes', '46', 'Osvaldo', 'Uberlândia', 'MG', '38404-000', 5),
(6, 'Rua Dos Matos Verdes', '29', 'Custódio', 'Uberlândia', 'MG', '38405-000', 6),
(7, 'Rua Queiroz', '219', 'Jardim Botânico', 'Uberlândia', 'MG', '38406-000', 7),
(8, 'Rua Dos Matos Verdes', '196', 'Granja Marileusa', 'Uberlândia', 'MG', '38407-000', 8),
(9, 'Rua Dos Matos Verdes', '222', 'Brasil', 'Uberlândia', 'MG', '38408-000', 9),
(10, 'Rua Dos Matos Verdes', '346', 'Sagrado', 'Uberlândia', 'MG', '38409-000', 10); 
   
INSERT INTO CATEGORIA (ID, TIPO, NOME, DESCRICAO) VALUES
(1, 'Comida', 'Massas', 'Pratos à base de massas, como pizzas e macarronadas.'),
(2, 'Comida e não', 'Pregos e coca', 'Pregos e coca cola.'),
(3, 'Benção', 'Benção', 'Benção, bençãos, bençãos e bençãos.'),
(4, 'Comida', 'Bebidas', 'Sucos, refrigerantes, e bebidas alcoólicas.'),
(5, 'Comida', 'Vegetariano', 'Pratos exclusivos para vegetarianos.'),
(6, 'Comida', 'Pizza', 'Pizzas boas e suculentas.'),
(7, 'Sobremesa', 'Açaí', 'Açaí.'),
(8, 'Comida', 'Churrasco', 'Pratos à base de churrasco.'),
(9, 'Comida', 'Frutos do mar', 'Pratos típicos do Japão.'),
(10, 'Comida', 'Espetinho', 'Comidas rápidas e práticas no espeto.'); 

INSERT INTO ACOMPANHAMENTO (ID, NOME, DESCRICAO, VALOR) VALUES
(1, 'Molho Especial', 'Molho feito com ervas frescas e especiarias.', 2.50),
(2, 'Batata Frita', 'Porção de batatas fritas crocantes.', 5.00),
(3, 'Salada Simples', 'Alface, tomate e cenoura.', 3.50),
(4, 'Molho de Alho', 'Molho cremoso de alho.', 1.50),
(5, 'Arroz Branco', 'Porção de arroz branco soltinho.', 4.00),
(6, 'Farofa', 'Farofa com temperos especiais.', 3.00),
(7, 'Feijão Tropeiro', 'Feijão temperado com bacon e farinha.', 6.00),
(8, 'Molho Apimentado', 'Molho com toque de pimenta.', 2.00),
(9, 'Queijo Ralado', 'Queijo parmesão ralado.', 1.00),
(10, 'Pão de Alho', 'Pão grelhado com creme de alho.', 4.50) 


INSERT INTO PRODUTO (ID_PRODUTO, NOME, DESCRICAO, PRECO, CATEGORIA_ID, RESTAURANTE_ID) VALUES
(1, 'Pirão de galinha', 'Pirão de galinha feito na hora quentinho.', 70.00, 1, 1),
(2, 'Feijão', 'Feijão bom.', 70.00, 1, 1),
(3, 'Pregos', 'Pregos.', 20.00, 2, 2),
(4, 'Cola Cola 3L', 'Bebida gaseificada gelada.', 20.00, 2, 2),
(5, 'Benção', 'Benção de Bol Boni', 100.00, 3, 3),
(6, 'Mais bençãos', 'Mais bençãos de Bol Boni.', 200.00, 3, 3),
(7, 'Cumbuca de farinha', 'Conjunto de farinhas em uma cumbuca.', 2.00, 4, 4),
(8, 'Salgado frio', 'Um salgado frio e provavelmente duro.', 10.00, 4, 4),
(9, 'Espetinho de Carne', 'Suculenta carne no espeto feito na hora.', 15.00, 10, 10),
(10, 'Coxinha de matte verde', 'Sobremesa relaxante.', 8.00, 5, 5),
(11, 'Açaí Tradicional', 'Açaí Tradicional.', 15.00, 7, 7); 

ALTER TABLE PEDIDO 
RENAME COLUMN DATA TO DATA_PEDIDO; 
  


INSERT INTO PEDIDO_PRODUTO (ID_PEDIDO, ID_PRODUTO, QUANTIDADE) VALUES
(1, 1, 2),
(2, 2, 1),
(3, 3, 3),
(4, 4, 4),
(5, 5, 2),
(6, 6, 1),
(7, 7, 5),
(8, 8, 2),
(9, 9, 1),
(10, 10, 3); 

INSERT INTO PEDIDO_PRODUTO_ACOMP (ID_PEDIDO_PRODUTO, ID_ACOMP) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

INSERT INTO PROMOCAO (ID, NOME, CODIGO, VALOR, VALIDADE) VALUES
(1, 'Promo Verão', 'VERAO2024', 10.00, '2024-12-31'),
(2, 'Frete Grátis', 'FRETEZERO', 15.00, '2024-12-25'),
(3, 'Black Friday', 'BLACK2024', 20.00, '2024-11-30'),
(4, 'Natal Feliz', 'NATAL2024', 25.00, '2024-12-24'),
(5, 'Ano Novo', 'ANO2025', 30.00, '2025-01-01'),
(6, 'Cupom Fidelidade', 'FIDELIDADE', 5.00, '2025-06-30'),
(7, 'Outono', 'OUTONO23', 12.00, '2024-03-20'),
(8, 'Primavera', 'FLOR2024', 18.00, '2024-09-22'),
(9, 'Primeira Compra', 'NOVOCLI', 20.00, '2024-12-31'),
(10, 'Feriado Especial', 'FERIADO', 22.00, '2024-12-15');

INSERT INTO PRODUTO_ACOMP (ID_PRODUTO, ID_ACOMP) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 6),
(6, 7),
(7, 8),
(8, 9),
(9, 10);

INSERT INTO STATUS_ENTREGA (ID, NOME) VALUES
(1, 'Pedido Realizado'),
(2, 'Preparando Pedido'),
(3, 'Pedido Enviado'),
(4, 'Pedido Entregue'),
(5, 'Cancelado'),
(6, 'Aguardando Pagamento'),
(7, 'Pagamento Confirmado'),
(8, 'Reembolsado'),
(9, 'Coleta Agendada'),
(10, 'Devolução Solicitada');

INSERT INTO RESTAURANTE_PAGAMENTO (ID_RES, ID_PAGA) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 4),
(2, 5),
(3, 6),
(3, 7),
(3, 8),
(4, 9);

INSERT INTO HISTORICO_ENTREGA (ID, ID_STATUS_ENTREGA, ID_PEDIDO, DATA_HORA) VALUES
(1, 1, 1, '2024-12-01 08:00:00'),
(2, 2, 1, '2024-12-01 10:00:00'),
(3, 3, 1, '2024-12-01 12:00:00'),
(4, 4, 1, '2024-12-01 14:00:00'),
(5, 1, 2, '2024-12-02 09:00:00'),
(6, 2, 2, '2024-12-02 11:00:00'),
(7, 3, 2, '2024-12-02 13:00:00'),
(8, 4, 2, '2024-12-02 15:00:00'),
(9, 5, 3, '2024-12-03 08:30:00'),
(10, 6, 3, '2024-12-03 10:30:00');

INSERT INTO HISTORICO_PAGAMENTO (ID, DATA, ID_FORMA, VALOR) VALUES
(1, '2024-12-01', 1, 150.50),
(2, '2024-12-02', 2, 200.00),
(3, '2024-12-03', 3, 100.00),
(4, '2024-12-04', 4, 50.00),
(5, '2024-12-05', 5, 120.00),
(6, '2024-12-06', 6, 90.00),
(7, '2024-12-07', 7, 180.00),
(8, '2024-12-08', 8, 300.00),
(9, '2024-12-09', 9, 250.00),
(10, '2024-12-10', 10, 400.00);

INSERT INTO PEDIDO (ID, DATA_PEDIDO, ID_RESTA, VALOR, TAXA_ENTREGA, ID_PROMO, ID_STATUS_ENTREGA, ID_FORMA_PAG, OBS, TROCO, ID_ENDE) VALUES
(1, '2024-12-01', 1, 150.50, 10.00, 1, 1, 1, 'Sem cebola, por favor.', 0.00, 1),
(2, '2024-12-02', 2, 200.00, 15.00, 2, 2, 2, 'Trocar refri por suco.', 20.00, 2),
(3, '2024-12-03', 3, 300.00, 20.00, 3, 3, 3, 'Entrega rápida.', 50.00, 3),
(4, '2024-12-04', 4, 50.00, 5.00, NULL, 4, 4, '', 10.00, 4),
(5, '2024-12-05', 5, 120.00, 12.00, 5, 5, 5, 'Sem troco.', 0.00, 5),
(6, '2024-12-06', 6, 90.00, 8.00, NULL, 6, 6, '', 10.00, 6),
(7, '2024-12-07', 7, 180.00, 15.00, 6, 7, 7, 'Entrega até às 20h.', 0.00, 7),
(8, '2024-12-08', 8, 300.00, 25.00, 7, 8, 8, 'Adicionar molho extra.', 5.00, 8),
(9, '2024-12-09', 9, 250.00, 18.00, 8, 9, 9, '', 10.00, 9),
(10, '2024-12-10', 10, 400.00, 30.00, NULL, 10, 10, 'Sem observações.', 0.00, 10);

*/


