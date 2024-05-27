# Passos para fazer funcionar
- O projeto depende do JDK 22, baixe e instale caso não tenha [Link para o instalador que usei (Windows x64)](https://download.oracle.com/java/22/latest/jdk-22_windows-x64_bin.exe)
- Instale o Maven, pois ele gerenciará todas as dependências do projeto (Usei o Maven 3.9.7)
- Com o Maven, instale todas as dependências descritas no arquivo pom.xml com o comando: `mvn dependency:copy-dependencies` (isso no mesmo diretório onde o arquivo pom.xml se encontra)

O projeto roda na porta :8090