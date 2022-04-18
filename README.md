<h1 align="center"> Cadastrar Cliente 🖊️ </h1> 

<h4 align="center"> 
    🚧 Projeto em construção 🚧
</h4>
<br>

## **Descrição**:
Projeto em desenvolvimento para diciplina de Análise e Programa Orientados a Objetos. É um software para cadastrar um cliente em um banco de dados relacional. 

## **Requisitos**:
- ``Java 8+``
- ``MySQL``
- ``Makefile``

## **Como executar**:

### **Passo 1:**

```text
git clone https://github.com/henrisama/CadastrarCliente.git
cd CadastrarCliente
```

### **Passo 2:**
Setar a senha do banco de dados local nos arquivos ConnectionDB.java e Migration.java (variável "Password") dentro da pasta "config" em "src". Caso o banco de dados não tenha senha apenas setar a variável para string vazia.

![](public/img/migration.gif)

### **Passo 3:**
Responsável por criar o banco de dados (RegisterClient) e suas tabelas (Client e Address). Os Atributos de cada tabela podem ser encontrado no arquivo "src/config/Migration.java".
```text
make migration
```

### **Passo 4:**
Responsável por compilar e executar a aplicação.
```text
make run
```