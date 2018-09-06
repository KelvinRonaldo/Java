-- Insert = Para inserir dados no banco de dados
INSERT INTO
-- ↓ tabela   ↓ campos da tabela
funcionario (nome, email, peso, cidade)
-- Values = Para inserir valores nos campos digitados
VALUES ('Sabrina França', 'sasa@hotmail.com', 52, 'Carapicuíba' );
	--     ↑ Valores que serão adiconados nos campos digitados

	
-- Update = Atualizar dados do banco de dados
UPDATE funcionario
	--  ↑ tabela onde estao o campo que será atualizado
	SET cidade ='Rio de Janeiro',
	--↑ seleciona o campo que será atualizados
	email = 'fabi@bol.com'
	WHERE codigo = 2;
	--↑ especificar o dados que será atualizado

	
-- Delete = Deletar dados do banco de dados
DELETE FROM funcionario
		--   ↑ tabela onde o dados que será excluido esta
WHERE codigo = 5;
--↑ especificar o dados que será excluido

-- Exibe os dados desejados da ↓tabela especificada
SELECT <campos> FROM <nome da Tabela> WHERE codigo = 3;
	--   ↑ campos que serão exibidos; ↑ especificar onde esta o dados que será exibido


