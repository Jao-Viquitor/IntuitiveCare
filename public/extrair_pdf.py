# Bibliotecas necessárias
import pandas as pd
import tabula
import zipfile

# Passo 1: Extração dos dados do PDF
tabelas = tabula.read_pdf('../src/main/resources/Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf', pages='3-181', lattice=True)

# Concatenar todas as tabelas em um único DataFrame
df = pd.concat(tabelas, ignore_index=True)

# Passo 2: Substituir abreviações nas colunas OD e AMB pela descrição completa
abreviacoes = {
    'OD': 'Seg. Odontológica',
    'AMB': 'Seg. Ambulatorial'
}

df = df.replace({'OD': abreviacoes, 'AMB': abreviacoes})

# Passo 3: Salvar os dados em CSV
csv_filename = 'rol_procedimentos.csv'
df.to_csv(csv_filename, index=False)

# Passo 4: Compactar o arquivo CSV em ZIP
zip_filename = 'Teste_Joao_Victor_Santos.zip'
with zipfile.ZipFile(zip_filename, 'w', zipfile.ZIP_DEFLATED) as zipf:
    zipf.write(csv_filename)

print(f'Arquivo CSV compactado com sucesso: {zip_filename}')