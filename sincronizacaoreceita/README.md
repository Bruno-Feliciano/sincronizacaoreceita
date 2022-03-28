# Introdução
Projeto criado com base em desafio técnico para avaliação em processo.

Cenário de Negócio:
Todo dia útil por volta das 6 horas da manhã um colaborador da retaguarda do Sicredi recebe e organiza as informações de 
contas para enviar ao Banco Central. Todas agencias e cooperativas enviam arquivos Excel à Retaguarda. Hoje o Sicredi 
já possiu mais de 4 milhões de contas ativas.
Esse usuário da retaguarda exporta manualmente os dados em um arquivo CSV para ser enviada para a Receita Federal, 
antes as 10:00 da manhã na abertura das agências.

# Funcionalidades 
1. Processar um arquivo CSV de entrada com o formato abaixo.
2. Enviar a atualização para o SIMULADO pela classe ReceitaService.
3. Retornar um arquivo com o resultado do envio da atualização da Receita. Mesmo formato adicionando o resultado em uma nova coluna.

# Tecnologias
- [Spring Boot]
- [Java IO]
- [JUnit]

# Build
Utilizar o seguintes comandos:
- mvn clean
- mvn package
Verificar o executável criado em: sincronizacaoreceita\target\sincronizacaoreceita-0.0.1-SNAPSHOT.jar

# Testes
Testes unitários incluidos em: src\test\java\sincronizacaoreceita
- SincronizacaoUtilTests: classe criada para testar os metodos de SincronizacaoUtil que auxiliam na manipulação do arquivo CSV.

# Observações
- Classes criadas para avaliação: SincronizacaoReceita.java, SincronizacaoUtil.java e SincronizacaoParametros.java
- A classe ReceitaService.java não foi alterada.
- Melhorias: criação injeções via interfaces.
