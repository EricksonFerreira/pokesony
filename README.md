# PokeSony

<!-- CONTEÚDOS -->
<details >
  <summary>Conteúdos</summary>
  <ol>
    <li>
      <a href="#explicação-do-projeto">Explicação do projeto</a>
    </li>
    <li>
      <a href="#tecnologia
    </li>
    <li>
        <a href="#iniciar-projeto">Iniciar projeto</a>
        <ul>
            <li><a href="#rodando-os-projetos">Rodando o projeto</a></li>
        </ul>
    </li>
    <li>
        <a href="#api-em-java">Api em Java</a>
        <ul>
            <li><a href="#organização-das-pastas-da-api">Organização das pastas da api</a></li>
            <li><a href="#padrões-utilizados-na-api">Padrões utilizados na api</a></li>
            <li><a href="#explicação-da-api">Explicação da Api</a></li>
        </ul>
    </li>
    <li>
        <a href="#aplicação-em-angular">Front-end Angular</a>
        <ul>
            <li><a href="#organização-das-pastas-do-angular">Organização das pastas do angular</a></li>
            <li><a href="#padrões-utilizados-no-angular">Padrões utilizados no angular</a></li>
            <li><a href="#explicação-de-alguns-componentes-do-angular">Explicação de alguns componentes do angular</a></li>
        </ul>
    </li>
    <li><a href="#licença">Licença</a></li>
    <li><a href="#contato">Contato</a></li>
  </ol>
</details>



<!-- EXPLICAÇÃO DO PROJETO -->
## Explicação do projeto
Esse projeto foi desenvolvido por Erickson Ferreira, aluno da disciplina de topícos avançados da web ministrada pelo prof. Ranieri Valença. O intuito desse projeto foi utilizar técnologias que não tinha muito conhecimento e desenvolver uma aplicação funcional com boas práticas.
<!-- TECNOLOGIAS UTILIZADAS -->
## Tecnologias utilizadas
Serão listadas abaixo as principais técnologias utilizadas no projeto: 
* [Angular](https://angular.io/)
* [Spring Boot](https://spring.io/)
* [Bootstrap](https://getbootstrap.com/)
<!-- INICIAR PROJETO -->
## Iniciar projeto
<!-- RODANDO OS PROJETOS -->
### Rodando os projetos
###### Baixe o Node e o instale: https://nodejs.org/en/download/ <br> Depois abra o terminal na pasta desejada e digite os seguintes comando:
 ```
 git clone https://github.com/EricksonFerreira/pokesony.git
cd pokesony
cd angular
npm install
npm start
 ```

###### Após instale a ide intelliJ e o instale: https://www.jetbrains.com/pt-br/idea/download/#section=windows <br> Abra o projeto na pasta java
<img src="images_readme/mapa_arquivos_java.png" alt="Logo" width="300" height="150">

###### Caso não tenha o jdk na versão do projeto siga esses passos para instala-la:
<img src="images_readme/pom_xml.png" alt="Logo" width="700" height="250">
<img src="images_readme/pass_1.png" alt="Logo" width="620" height="70">
<img src="images_readme/pass_2.png" alt="Logo" width="600" height="150">
<img src="images_readme/pass_3.png" alt="Logo" width="600" height="300">
<img src="images_readme/pass_4.png" alt="Logo" width="600" height="200">
<img src="images_readme/pass_5.png" alt="Logo" width="600" height="150">
<img src="images_readme/pass_6.png" alt="Logo" width="600" height="200">

###### Inicie o projeto java:
<img src="images_readme/pass_7.png" alt="Logo" width="800" height="400">
<br>
Agora é apenas acessar essa url: http://www.localhost:4200

<!-- INICIAR PROJETO -->
## API em java
<!-- ORGANIZAÇÃO DA API-->
### Organização das pastas da API
```
  .
  └── java
      ├── .mvn
      │   └── wrapper
      └── src
          ├── test
          │   └── java
          │       └── com
          │           └── pokemon
          └── main
             └── java
                  └── com
                      └── pokemon
                          ├── convert
                          │   ├── pokemon
                          │   ├── tipo
                          │   ├── tipooposicao
                          │   ├── tipopokemon
                          │   └── treinador
                          ├── domain
                          │   ├── pokemon
                          │   ├── tipo
                          │   ├── tipooposicao
                          │   ├── tipopokemon
                          │   └── treinador
                          ├── dto
                          │   ├── pokemon
                          │   ├── statustipo
                          │   ├── tipo
                          │   ├── tipooposicao
                          │   ├── tipopokemon
                          │   └── treinador
                          ├── repository
                          │   ├── pokemon
                          │   ├── tipo
                          │   ├── tipooposicao
                          │   ├── tipopokemon
                          │   └── treinador
                          ├── resource
                          │   ├── pokemon
                          │   ├── tipo
                          │   └── treinador                          
                          └── service
                              ├── pokemon
                              ├── tipo
                              └── treinador                          
```
<!--PADRÕES DA API -->
### Boas práticas utilizados na API
- #### Lombok
  - ##### O que é o lombok
      É uma biblioteca java que tem como intuito remover alguns boilerplates utilizando anotações. pois a linguagem java é muito verborrágica, e o lombok acaba automatizandoque se repetem em várias classes, como getters, setters, equals, etc.
  - ##### Porque utiliza-lo
     Pois utilizando o lombok acabamos não precisando utilizar os métodos getters,setters, equals, etc. Com isso a produtividade será aumentada.
  - ##### Algumas anotações
    - ###### @Data
      Essa anotação tem um poder imenso, pois ela é uma coleção de anotações. Ao utiliza-la você está utilizando algumas anotações, como:
        -  **@Getter** - *Gera metodos getters padrões automaticamente*
        -  **@Setter** - *Gera metodos setters padrões automaticamente*
        -  **@RequiredArgsConstructor** - *Gera um construtor com 1 parâmetro para cada campo que requer tratamento especial*
        -  **@ToString** - *Fará com que o lombok gere uma implementação do método toString()* 
        -  **@EqualsAndHashCode** - *Gera implementações dos métodos equals(Object other) e hashCode()*
      <br>
  
        ```java
              pokemon.dto.tipo.TipoDto

              @Data
              public class TipoDTO implements Serializable {

                  private static final long serialVersionUID = 1L;
                  
                  private Integer id;
                  private String nome;
              }
        ```
        É igual a: 

        ```java

              @Getter
              @Setter
              @RequiredArgsConstructor
              @ToString
              @EqualsAndHashCode
              public class TipoDTO implements Serializable {

                  private static final long serialVersionUID = 1L;
                  
                  private Integer id;
                  private String nome;
              }
        ```




    - ###### @Builder
      - Ele é utilizado para métodos quando nos objetos da classe não quero modificar a propriedade dos atributos ou estender a classe. 
      - Ele permite que você produza automaticamente o código necessário para que sua classe seja instanciável com código, como:
      
      ```java
      pokemon.dto.tipo.TipoDto

      @Data
      @NoArgsConstructor
      @AllArgsConstructor
      //Aqui eu utilizei o buider no tipoDTO, com isso ao chamar o tipoDto e utilizar o método builder() e no final build()
      @Builder
      public class TipoDTO implements Serializable {

          private static final long serialVersionUID = 1L;
          
          private Integer id;
          private String nome;
      }

      pokemon.convert.tipo.TipoConvert
 
      public static TipoDTO tipoDomainToDTO(Tipo domain) {
      // Podemos observar que foi criado um objeto TipoDTO e nele tem por obrigação todos os atributos da classe pai(TipoDTO)
        return TipoDTO.builder().id(domain.getId()).nome(domain.getNome()).build();
      }
    
      ```

    - ###### @NoArgsConstructor
      - Fornece a criação de um construtor vazio
      - Construtor vazio é utilizado quanto temos um construtor que recebe argumentos, mas esses argumentos são opcionais.
      <br>
                                                                       
      ``` java
        pokemon.dto.tipo.TipoDto

        @NoArgsConstructor
        public class TipoDTO implements Serializable {

            private static final long serialVersionUID = 1L;
            
            private Integer id;
            private String nome;
        }
      ```
      É igual a: 

      ``` java

        public class TipoDTO implements Serializable {

          private static final long serialVersionUID = 1L;
          
          private Integer id;
          private String nome;

          public TipoDTO(){

          }
        }
      ```

    - ###### @AllArgsConstructor
      Fornece a criação de um construtor com todos os atributos
      <br>
      ``` java
        pokemon.dto.tipo.TipoDto

        @NoArgsConstructor
        public class TipoDTO implements Serializable {

            private static final long serialVersionUID = 1L;
            
            private Integer id;
            private String nome;
        }
      ```
      É igual a: 
      ``` java

        public class TipoDTO implements Serializable {

          private static final long serialVersionUID = 1L;
          
          private Integer id;
          private String nome;

          public TipoDTO(integer id, String nome){
            this.id = id;
            this.nome = nome;
          }
        }
      ```
- #### Data Transfer Object (DTO) 
  - ##### O que é Transfer Object (DTO)
    Data Tranfer Object é um padrão de projetos bastante usado em Java para o transporte de dados entre diferentes componentes de um sistema, diferentes instâncias ou processos de um sistema distribuído ou diferentes sistemas via serialização.
  - ##### Vantagens e desvantagens da sua utilização
    - ###### Vantagens
      - Aumento a complexidade;
      - Existe grande possibilidade do código ficar duplicado. 
    - ###### Desvantagens
      - Deixa explícito quais campos irão para a camada da view. Sim, existem várias anotações em diversos frameworks que indicam quais campos não irão para a visualização. Porém, caso esqueçamos de fazer as anotações, podemos exportar um campo crítico de maneira acidental como a senha do usuário;
      - Facilita o desenho em relação a orientação de objeto. Um dos pontos que o clean code deixa claro sobre orientação a objetos é que, o POO esconde os dados para expor o comportamento e, o encapsulamento, ajuda com isso;
      - Facilita o atualização do banco de dados. Muitas vezes é importante refatorar ou migrar o banco de dados sem que essa alteração impacte o cliente. Essa separação facilita otimizações, modificações no banco de dados sem que isso impacte a visualização;
      - Versionamento e retrocompatibilidade são pontos importantes, principalmente, quando se tem uma API de uso público e com vários clientes, assim é possível ter um DTO para cada versão e evoluir o modelo de negócio sem se preocupar;
  - ##### Como eu utilizei

    - **Primeiro verifiquei a minha entidade e seus atributos**
      ``` java
      @Entity
      public class Treinador {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String nome;
      }
      ``` 
    - **Depois quais valores desejo receber no formulário, pois esses valores serão os atributos da minha classe DTO**
    ``` java
    @PostMapping
    public ResponseEntity<TreinadorDTO> adicionaTreinador(@RequestBody TreinadorFormDTO treinadorFormDTO){
        TreinadorDTO treinador = treinadorService.adicionaTreinador(treinadorFormDTO);
        return ResponseEntity.ok(treinador);
    }
    ```
    - **Após saber quais atributos desejo receber no formulário, crio uma classe e coloco no fim dela o nome DTO**
    ``` java
    public class TreinadorFormDTO implements Serializable {
      private static final long serialVersionUID = 1L;
      
      private String nome;    
    }
    ```
    Podemos ver que já temos o método que será chamado quando fizer a requisição HTTP e que ao chama-lo, esse chamamento deverá trazer um objeto do tipo treinado DTO, porém não acessamos o banco de dados com os objjetos DTO, pois como vimos no inicio o DTO é um dado de transferencia e não na manipulação deles no banco. Por conta disso utilizamos o Convert, que é onde conveteremos de DTO(abstração) para uma classe concreta do objeto e assim manipularemos ele.
    - **Fazendo a conversão de DTO para Entidade**
    ``` java
    public class TreinadorConvert {
      private TreinadorConvert() {
      }        
      public static Treinador treinadorFormToTreinadorEntity(TreinadorFormDTO treinadorForm) {
        return Treinador.builder().nome(treinadorForm.getNome()).build();
      }
    }
    ```

  - **Passo a passo exemplificado:**
    1. Verificar quais informações desejo receber no formulario
    2. Criar um DTO do formulário com essas informações
    3. Criar um método resource que recebe esse DTO do formulário como parâmetro
    4. Criar um Convert que recebe essse DTO do formulário que retorne uma entidade do objeto
    5. Salvar essas informações no banco
    6. Criar um DTO com as informações que deseja retorna na chamada HTTP
    7. Na mesma classe que criou um Convert  criar um método que transforme de entidade para DTO 
    8. Retornar esse DTO no corpo do requisição

- #### Hibernate
  - ##### O que é o Hibernate
      É uma ferramenta de mapeamento objeto-relacional( ou ORM) para java. Sua ideia é transformar o acesso a dados, em um banco de dados relacional, mais simples através da manipulação de objetos java, deixando de lado as intruções SQL empregadas em operações de CRUD. É um dos frameworks de persistência de dados mais utilizados.
  - ##### Vantagens e desvantagens da sua utilização
    - ###### Vantagens
      - Como praticamente todos os ORMs, deve ser citado como grande vantagens o aumento da velocidade de desenvolvimento e facilidade na possível troca do banco de dados.
      - Hoje em dia, essa popularidade do Hibernate pode ser um grande diferencial na escolha dele, pois possui uma comunidade maior na internet e é mais fácil de encontrar mão de obra.
      - O suporte a múltiplos bancos de é ponto positivo para o Hibernate. Seja Oracle, MySQL, PostgreSql ou com outros o Hibernate se vira muito bem.
      - O cache de 2º nível é para mim, uma das principais vantagens do Hibernate. Já que nos principais bancos de dados que o ORM trabalha, é praticamente indiferente para ele buscas, 10, 30 ou até 100 colunas em uma consulta.
      - O Hibernate é Open Source (licensa LGPL).

    - ###### Desvantagens
      - A dificuldade em algumas coisas, como consultas mais complexas pode ser citado com um fator negativo para o Hibernate.
      - Em consultas um pouco mais complexas, o Hibernate também possuí uma notória perda de desempenho. Isso é algo que pode pesar contra.
  - ##### Como eu utilizei

<!--EXPLICAÇÃO DA API -->
### Explicação da API

[![Run in Insomnia}](https://insomnia.rest/images/run.svg)](https://insomnia.rest/run/?label=pokesony&uri=https%3A%2F%2Fgithub.com%2FEricksonFerreira%2Fpokesony%2Fblob%2Fmain%2Fexport.json)

Recursos disponíveis para acesso via API:

- [**Pokemon**](#pokemon)
- [**Treinador**](#treinador)
- [**Tipo**](#tipo)

#### Métodos

Requisições para a API devem seguir os padrões:
| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou mais registros. |
| `POST` | Utilizado para criar um novo registro. |
| `PUT` | Atualiza dados de um registro ou altera sua situação. |
| `DELETE` | Remove um registro do sistema. |

#### Respostas

| Código | Descrição                                                          |
| ------ | ------------------------------------------------------------------ |
| `200`  | Requisição executada com sucesso (success).                        |
| `400`  | Erros de validação ou os campos informados não existem no sistema. |

### Grupo dos Recursos

#### Login [/login]

Login dos usuarios do sistema.

#### login [POST]

- Attributes (object)

  - username: username do usuario(string) - limite 255 caracteres,
  - password: senha do usuario(string) - limite 255 caracteres

- Request (application/json)

  - Body

          {
            "username":"ERICKSON",
            "password":"123"
          }

- Response 200 (application/json)

  - Body

          {
            "login": "ERICKSON",
            "token": "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NDMzNzgwMzUsImV4cCI6MTY0MzM4MTYzNSwiYXV0aG9yaXRpZXMiOjF9.lnY_kPeztFWo7UEw7QnnUCIeAoAS1zmMEX1FIg1LCH0",
            "prefix": "Berear"
          }

#### Tabela das rotas
| Método | URL
|--- |--- |
| `GET` | `/api/pokemon` 
| `GET` | `/api/pokemon/{id}` 
| `POST` | `/api/pokemon/`
| `PUT` | `/api/pokemon/{id}`
| `DELETE` | `/api/pokemon/{id}` 
| `GET` | `/api/treinador` 
| `GET` | `/api/treinador/{id}` 
| `POST` | `/api/treinador/`
| `PUT` | `/api/treinador/{id}`
| `DELETE` | `/api/treinador/{id}` 
| `GET` | `/api/tipo` 
| `GET` | `/api/tipo/{id}` 
| `POST` | `/api/tipo/`
| `PUT` | `/api/tipo/{id}`
| `DELETE` | `/api/tipo/{id}` 

### Tipo [/tipo]

Os tipos da aplicação.

#### Listar (List) [GET /tipo/{id}]

- Parameters

  - id (number, optional) - Filtrar por id do tipo

- Response 200 (application/json)

            {
                "id": 3,
                "nome": "Fogo",
                "tipo_forte": [
                    {
                        "id": 1,
                        "nome": "Grama"
                    }
                ],
                "tipo_fraco": [
                    {
                        "id": 1,
                        "nome": "Água"
                    }
                ]
            }


#### Novo (Create) [POST]

- Attributes (object)

  - nome: nome do tipo (string) - limite 255 caracteres,
  - tipo_forte: tipo do tipo que ele é forte(integer) - limite 11 numeros,
  - tipo_fraco: tipo do tipo que ele é fraco(integer) - limite 11 numeros,

- Request (application/json)

  - Body

          {
            "nome": "lorem2",
            "tipo_forte": [],
            "tipo_fraco": []
          }

- Response 200 (application/json)           

#### Editar (Update) [PUT /tipo/{codigo}]

- Request (application/json)

  - Body

        {
            "nome": "Fogarel",
        }

- Response 200 (application/json)
  Todos os dados do tipo

  - Body

        {
            "id": 3,
            "nome": "Fogarel"
        }

#### Remover (Delete) [DELETE /tipo/{codigo}]

- Parameters

  - id (number, required) - codigo do tipo

- Response 200 (application/json)

### Treinador [/treinador]

Os treinadors da aplicação.

#### Listar (List) [GET /treinador/{id}]

- Parameters

  - id (number, optional) - Filtrar por id do treinador

- Response 200 (application/json)

        {
            "id": 1,
            "nome": "Ashe"
        }


#### Novo (Create) [POST]

- Attributes (object)

  - nome: nome do treinador (string) - limite 255 caracteres,
  

- Request (application/json)

  - Body

          {
            "nome": "Hugh",
          }

- Response 200 (application/json)

  - Body

            {
                "id": 1,
                "nome": "Hugh",
            }

#### Editar (Update) [PUT /treinador/{codigo}]

- Request (application/json)

  - Body

        {
            "nome": "Ashe",
        }

- Response 200 (application/json)
  Todos os dados do treinador

  - Body

        {
            "id": 1,
            "nome": "Ashe",
        }

#### Remover (Delete) [DELETE /treinador/{codigo}]

- Parameters

  - id (number, required) - codigo do treinador

- Response 200 (application/json)

### Pokemon [/pokemon]

Os pokemons da aplicação.

#### Listar (List) [GET /pokemon/{id}]

- Parameters

  - id (number, optional) - Filtrar por id do pokemon

- Response 200 (application/json)

          [
            "codigo": 2,
            "nome": "Raichu",
            "level": 2,
            "tipo": {
                "codigo": 2,
                "nome": "lorem ipsum"
            },
            "treinador": {
                "codigo": 1,
                "nome": "lorem"
            }
          ]


#### Novo (Create) [POST]

- Attributes (object)

  - nome: nome do pokemon (string) - limite 255 caracteres,
  - level: level do pokemon(integer) - limite 11 numeros,
  - tipo_id: tipo do pokemon(integer) - limite 11 numeros,
  - treinador_id: treinador do pokemon(integer) - limite 11 numeros,

- Request (application/json)

  - Body

          {
            "nome": "Raichu",
            "level": 1,
            "tipo_id": 1,
            "treinador_id":1
          }

- Response 200 (application/json)

  - Body

            {
                "id": 1,
                "nome": "Raichu",
                "level": 1,
                "tipo": {
                    "codigo": 1,
                    "nome": "fogo"
                },
                "treinador": {
                    "id": 1,
                    "nome": "erickson"
                }
            }

#### Editar (Update) [PUT /pokemon/{codigo}]

- Request (application/json)

  - Body

        {
            "nome": "aa",
            "level":1,
            "tipo_id": 2,
            "treinador_id":2
        }

- Response 200 (application/json)
  Todos os dados do pokemon

  - Body

        {
            "id": 1,
            "nome": "aa",
            "level": null,
            "tipo": {
                "codigo": 2,
                "nome": "lorem2"
            },
            "treinador": {
                "id": 2,
                "nome": "lorem"
            }
        }

#### Remover (Delete) [DELETE /pokemon/{codigo}]

- Parameters

  - id (number, required) - codigo do pokemon

- Response 200 (application/json)

<!-- APLICAÇÃO EM ANGULAR -->
## Aplicação em angular
<!-- ORGANIZAÇÃO -->
### Organização das pastas do angular
```
  .
  └── angular
      ├── e2e
      │   └── src
      └── src
          ├── app
          |   ├── core
          |   |   └── components
          |   |       └── navbar
          |   ├── pages
          |   |   ├── pokemons
          |   |   |   ├── pokemon-form
          |   |   |   ├── pokemon-list
          |   |   |   └── shared
          |   |   ├── tipos
          |   |   |   ├── tipo-form
          |   |   |   ├── tipo-list
          |   |   |   └── shared
          |   |   └── treinadores
          |   |       ├── treinador-form
          |   |       ├── treinador-list
          |   |       └── shared
          |   └── shared
          |       ├── components
          |       |   ├── base-resource-form
          |       |   ├── base-resource-list
          |       |   ├── bread-crumb
          |       |   ├── form-field-error
          |       |   ├── page-header
          |       |   └── server-error-messages
          |       ├── models
          |       └── services
          |          
          ├── assets
          └── environments
```
<!--PADRÕES ANGULAR -->
### Padrões utilizados no angular
<!--EXPLICAÇÃO API -->
### Explicação de alguns componentes do angular

<!--LICENÇA -->
## Licença
Distributed under the MIT License. See `LICENSE.txt` for more information.

<!--CONTATO -->
## Contato

Github: [https://github.com/ericksonferreira](https://github.com/ericksonferreira)

LinkedIn: [https://www.linkedin.com/in/erickson-ferreira-627202174/](https://www.linkedin.com/in/erickson-ferreira-627202174/)



