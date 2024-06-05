# Passos para fazer funcionar

- O projeto depende do JDK 22, baixe e instale caso não tenha [Link para o instalador que usei (Windows x64)](https://download.oracle.com/java/22/latest/jdk-22_windows-x64_bin.exe)
- Instale o Maven, pois ele gerenciará todas as dependências do projeto (Usei o Maven 3.9.7)
- Com o Maven, instale todas as dependências descritas no arquivo pom.xml com o comando: `mvn dependency:copy-dependencies` (isso no mesmo diretório onde o arquivo pom.xml se encontra)

> O projeto roda na porta :8090

## TODO:

- [ ] Fazer as modelos para as tabelas (olhar os arquivos: GenreModel.java, PatientsModel.java e AddressModel.java)
- [ ] Criar tela de login do atendente, de dashboard, de lista de pacientes
- [ ] Criar feature de ver relatório do paciente (front e back)

Tabelas a serem criadas (Ainda podem faltar campos, use isso só como guia)
|STATUS | nome | colunas | Observações|
|-|-|-|-|
|CRIADA | patients | uuid, name, mother_name, father_name, birthday, genre*, address*, phoneNumber, email||
|NÃO CRIADA | attendants | uuid, name, username, password_hash, email, phone_number, speciality||
|NÃO CRIADA | priorities | uuid, name||
|NÃO CRIADA | genres | uuid, name||
|NÃO CRIADA | symptoms | uuid, name, weight||
|NÃO CRIADA | comorbidities | uuid, name, weight||
|NÃO CRIADA | attendance_registrations | uuid, patients*, attendant*, birthday, annotations, priority* | antiga tabela relatorios|
|NÃO CRIADA | service_queues | uuid, patients*, attendance_registration*, arrival_date, priority* | |
|NÃO CRIADA | service_queues_history | uuid, patients*, attendance_registration*, arrival_date, priority*, departure_date||
|NÃO CRIADA | patient_xref_symptoms | uuid, symptom*, patient*, annotations, intensity, average_days, attendance_registrations* | Guarda as questões|


## Possível forma de fazer o formulário para o paciente:
1.  o que vc ta sentindo?
    - 1.1 por quanto tempo ta sentindo (dias)
    - 1.2 intensidade da dor (1 a 5)
2.  possui alguma comorbidade? Se sim, quais?
