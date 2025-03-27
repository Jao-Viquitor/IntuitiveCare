# Projeto Java e Python - Extração, Download e Compactação de PDFs

## Descrição
Este projeto automatiza o processo de extração de links PDF específicos de uma página web do governo, realiza o download desses arquivos PDF para uma pasta local, extrai tabelas dos PDFs em arquivos CSV estruturados e compacta os arquivos CSV em um ZIP para distribuição ou armazenamento mais fácil.

## Pré-requisitos
Certifique-se de possuir as seguintes ferramentas instaladas:

- [Java SE 23 ou superior](https://www.oracle.com/java/technologies/javase-jdk23-downloads.html)
- [Apache Maven](https://maven.apache.org/) (Essencial para execução via linha de comando)
- [Python 3.x](https://www.python.org/downloads/)

Instale as dependências Python necessárias com:

```bash
pip install pandas tabula-py jpype1
```

## Estrutura do Projeto
```
projeto
│   README.md
│   pom.xml (se usando Maven)
│
└───src
    └───main
        ├───java
        │   └───org
        │       └───viquitor
        │           │   Main.java
        │           │
        │           └───utils
        │                   Constants.java
        │                   FileDownloader.java
        │                   FileManager.java
        │                   WebScraper.java
        │                   ZipCreator.java
        └───resources
                Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf
                Anexo_II_DUT_2021_RN_465.2021_RN628.2025_RN629.2025.pdf

└───public
        extrair_pdf.py
        rol_procedimentos.csv (gerado após execução)
        Teste_JoãoVictorSantos.zip (gerado após execução com os PDFS)
        Teste_João_Victor_Santos.zip (gerado após execução com o CSV)
```

## Como Executar

### Execução Java utilizando Maven (recomendado):

```bash
 mvn clean compile exec:java
```

### Execução Python para extração de tabelas e geração do CSV:
No terminal, navegue até a pasta `public` e execute:

```bash
cd public
python extrair_pdf.py
```

## Funcionalidades das Classes Java

- `Main.java`: Executa o fluxo principal, gerenciando a extração, download dos PDFs e criação do arquivo ZIP.
- `WebScraper.java`: Extrai links dos PDFs desejados da página web especificada.
- `FileDownloader.java`: Realiza o download dos arquivos PDF usando URLs extraídas.
- `FileManager.java`: Gerencia a criação de diretórios e nomes de arquivos locais.
- `ZipCreator.java`: Compacta o arquivo CSV gerado em um ZIP.
- `Constants.java`: Armazena constantes para facilitar manutenção e configuração.

## Configuração Adicional

Edite as constantes no arquivo `Constants.java` para:
- Alterar URLs ou caminhos de diretório;
- Modificar nome do arquivo ZIP gerado (`MY_NAME`).

## Observações
- Certifique-se de que o Java e Python instalados correspondem às versões especificadas ou superiores.
- Ajuste caminhos e nomes de arquivos conforme necessário no arquivo de constantes e scripts Python.

## Resultado Esperado
Após a execução com sucesso, os arquivos serão gerados no diretório `public`:
- `rol_procedimentos.csv`
- ` Teste_JoãoVictorSantos.zip` (gerado após execução com os PDFS)
- `Teste_João_Victor_Santos.zip` (gerado após execução com o CSV)