# Back-End Challenge - Contas Correntes

## Desafio: Run The Bank!

Projeto desenvolvido com a finalidade de participar do challenge **Run The Bank!**

## Configurações utilizadas:

* Project: Maven
* Spring Boot: 3.2.1
* Java: 17
   * Dependencies:
   * Spring Data JPA
   * H2 Database
   * Apache Camel
   * Spring web
   
## Como iniciar o projeto:

Para executar a aplicação inicie a Classe **Startup**, e aguarde a subida do Spring boot. 

## Endpoints:
endpoint http://localhost:8080/clientes => Busca todos os clientes cadastrados

endpoint http://localhost:8080/clientes/{id} => Busca os clientes pelo id

endpoint http://localhost:8080/clientes/delete/{id} => Exclui os dados de um cliente pelo id

Para criar um cliente é feito a um POST com as seguintes informações, nome, endereço, senha, cpf ou cnpj.
Exemplos:
{
   "nome": "Thais",
    "endereco": "Leite da silva",
    "senha": "123456",
    "cpf": "22438900032"
}

{
    "nome": "Marcelo",
    "endereco": "Andrade abrão",
    "senha": "142511",
    "cnpj": "54700714000131",
    "razaoSocial": "Empresa legal"
}

endpoint http://localhost:8080/clientes/{clienteId}/associar-conta => associa um cliente à uma conta
Exemplo:
http://localhost:8080/clientes/3/associar-conta

{
    "agencia": "123456",
    "saldo": "22",
    "status": true
}


endpoint http://localhost:8080/conta => trás todos as contas cadastradas

endpoint http://localhost:8080/conta/{id} => Busca uma conta pelo id

endpoint http://localhost:8080/conta/delete/{id} => Exclui os dados de uma conta pelo id

Para criar uma conta é feito um POST com as seguintes informações, agencia, saldo, status.
Exemplo:
{
    "agencia": "123456",
    "saldo": "22",
    "status": true
}
## Sugestão de melhorias:
Um Controller para o Service Pagamento e outro para o Service Transferencia.

