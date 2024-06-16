# Passos para fazer funcionar

- O projeto depende do JDK 22, baixe e instale caso não tenha [Link para o instalador que usei (Windows x64)](https://download.oracle.com/java/22/latest/jdk-22_windows-x64_bin.exe)
- Instale o Maven, pois ele gerenciará todas as dependências do projeto (Usei o Maven 3.9.7)
- Copiar o arquivo `application.properties.example`, renomeando a cópia para `application.properties` e mudar as configurações do ambiente conforme o necessário para rodar na sua máquina (tipo nome de usuário e/ou senha para acessar o postgres, etc)
- Com o Maven, instale todas as dependências descritas no arquivo pom.xml com o comando: `mvn dependency:copy-dependencies` (isso no mesmo diretório onde o arquivo pom.xml se encontra)

> O projeto roda na porta :8090

Relação entre as tabelas:
 - Um paciente(tg_patient) se registra no sistema e, com base nos seus sintomas e comorbidade, é calculado a sua prioridade na fila (tb_queue)
 - Juntamente com esse registro, também é criado um registro de atendimento (tb_report), que é vinculado ao registro da fila
 - Todos os sintomas são ligados as tabelas de relação entre sintoma e registro de atendimento (tb_report_xref_symptom)
 - Todos os sintomas são ligados as tabelas de relação entre sintoma e paciente (tb_patient_xref_symptom)

Tabelas
- tb_genre: Guarda o gênero biológico humano, separado para realizar buscas mais ricas no banco
- tb_comorbidity: Guarda registro de comorbidades, utilizado para potencializar o valor de sintomas
- tb_symptom: Guarda os dados dos sintomas
- tb_patient: Guarda informações do paciente 
- tb_address: Guarda informações do endereço do paciente, separado para realizar buscas mais ricas no banco
- tb_priority: Guarda informações que definem a prioridade de atendimento
- tb_queue: Guarda os registros de pacientes já atendidos ou não
- tb_report: Guarda o relatorio do atendimento do paciente
- tb_patient_xref_symptom: Guarda a relação entre paciente e sintoma, usado para realizar buscas mais ricas no banco
- tb_report_xref_symptom: Guarda a relação entre relatorio e sintoma, usado para realizar buscas mais ricas no banco

## Possível forma de fazer o formulário para o paciente:
1.  o que vc ta sentindo?
    - 1.1 por quanto tempo ta sentindo (dias)
    - 1.2 intensidade da dor (1 a 5)
2.  possui alguma comorbidade? Se sim, quais?
