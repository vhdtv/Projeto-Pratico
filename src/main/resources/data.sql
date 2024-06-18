INSERT INTO tb_genre (name) VALUES 
    ('Masculino'),
    ('Feminino');
INSERT INTO tb_symptom (uuid, name, weight) VALUES 
    ('2173180e-edb8-46c9-a926-8729e8d64196', 'Enxaqueca', 4), 
    ('b5b45059-5a8b-4916-96cb-f9cd254e5d30', 'Tosse seca', 3),
    ('54dfd081-c144-455e-b71f-b93f36c94850', 'Febre acima de 38ºC', 5),
    ('738c6497-b709-41f3-9cb4-34b536f9f47a', 'Cansaço excessivo', 5),
    ('213b3269-4196-4da3-b7e6-6a6c4195f32c', 'Dor muscular generalizada', 5),
    ('036506d1-02c8-40b5-94bb-eb0d7a9c1052', 'Dor de cabeça', 5),
    ('78d56b12-891e-4183-a0a1-e651cbb19d9d', 'Garganta inflamada', 5),
    ('4148baec-7e28-4cb4-b303-7d72b44eacf5', 'Coriza ou nariz entupido', 5),
    ('e4cde92b-73bc-4978-891d-f8d5af92132c', 'diarreia', 5);

INSERT INTO tb_priority (color, description) VALUES
    ('Vermelho', 'Emergência - atendimento imediato'),
    ('Amarelo', 'Urgência - atendimento o mais rápido possível'),
    ('Verde', 'Pouco Urgente'),
    ('Azul', 'Não Urgente - Horário de chegada');

INSERT INTO tb_address (id, first_line, house_number, residence_type, second_line, city, state, postal_code) VALUES
    ('9107b0e2-ef0a-4d11-a7d8-bb7d5010545a', 'Rua Doutor Carlos Agra', '200', 'Apartamento', 'Centro', 'Campina Grande', 'PB', '58400-204'),
    ('ca831ca3-d57c-4478-9a46-cf2b16d7a951', 'Rua Passiflora', '657', 'Casa', 'Jardim Esperança', 'Japeri', 'RJ', '26460-075'),
    ('385910ec-650d-4808-99c0-7419fed60f32', 'Rua Olinda Pires de Almeida', '712', 'Casa', 'Cohafaba II Plano', 'Dourados', 'MS', '79826-120'),
    ('baf055d0-ffdc-4321-b4b1-2050de3bf96b', 'Rua Olavo Brasil Filho', '227', 'Casa', 'Jardim Floresta', 'Boa Vista', 'RR', '69312-133'),
    ('3fe8714b-debe-405e-bf9f-b497c025aca7', 'Rua Rio Tocantins', '924', 'Casa', 'Boné Azul', 'Macapá', 'AP', '68909-492'),
    ('8c0e6304-a403-439d-8b9c-dfc16993d2b3', 'Quadra QS 401 Conjunto I', '555', 'Casa', 'Samambaia Norte (Samambaia)', 'Brasília', 'DF', '72319-529'),
    ('bced0970-3b96-4ab7-92e2-f567ea6bff7b', 'Rua Padre Nestor Sampaio', '481', 'Apartamento', 'Ponto Novo', 'Aracaju', 'SE', '49045-000'),
    ('140b2083-6794-4ef9-8570-db6b16e58658', 'Rua Vereador Ernâni Batista Rosas', '674', 'Apartamento', 'Jardim Carvalho', 'Ponta Grossa', 'PR', '84015-150'),
    ('9dcfdf8f-38cb-4ed5-ad26-a2e957eb8ba7', 'Rua Projetada 08', '884', 'Apartamento', 'SETSUL', 'Três Lagoas', 'MS', '79610-376'),
    ('ccca5059-5b56-4513-8588-5f2abffc6cf5', 'Rua Salgado Filho', '289', 'Apartamento', 'Jardim Curitiba', 'Paranavaí', 'PR', '87708-200'),
    ('66682d2f-16a3-4ffd-a6f4-d8f4c92c567d', 'Rua Santa Maria Bertila', '985', 'Apartamento', 'Cidade Nova', 'Manaus', 'AM', '69095-614'),
    ('02e6007c-cf61-4da1-9b10-adedd8340aa7', 'Quadra G', '324', 'Casa', 'Kennedy', 'Caruaru', 'PE', '55036-560'),
    ('e7d8bdda-f0d4-46d6-928c-c7eaa6464b79', 'Rua EF 13', '124', 'Casa', 'Residencial Eli Forte', 'Goiânia', 'GO', '74371-036'),
    ('487dca24-7e07-4634-a179-7099cd56f5ec', 'Rua AB', '459', 'Casa', 'Serraria', 'Maceió', 'AL', '57046-481'),
    ('ac690efb-f346-4fa1-be6d-672adfd7096a', 'Quadra 309 Sul Rua 21', '745', 'Casa', 'Plano Diretor Sul', 'Palmas', 'TO', '77015-510'),
    ('e6e8bffa-d62c-4a8c-9b95-0c2c727e85ad', 'Avenida José Cardoso da Silva', '181', 'Casa', 'Goiabal', 'Macapá', 'AP', '68906-015'),
    ('d9e9f818-ca24-41e0-a8a9-33d1baee73ca', 'Rua Por do Sol', '427', 'Casa', 'Gilberto Mestrinho', 'Manaus', 'AM', '69006-421'),
    ('fa0588d1-7e26-4563-b3c3-3d051d325b57', 'Rua do Girassol', '103', 'Casa', 'Privê Lírios dos Campos', 'Anápolis', 'GO', '75093-410'),
    ('c9f4b705-fa47-4ef4-94f3-c3ed6e473e07', 'Rua Buonon', '119', 'Casa', 'Bonsucesso', 'Fortaleza', 'CE', '60545-472'),
    ('4925e70d-4d43-406d-8939-76933883080e', 'Rua Luiz Carlos de Aguiar Machado', '259', 'Casa', 'Jabotiana', 'Aracaju', 'SE', '49095-480'),
    ('277baefa-e11d-4b61-b054-d868c377ae89', 'Rua da Liberdade', '153', 'Casa', 'Passarinho', 'Recife', 'PE', '52165-180'),
    ('08102959-f50b-45b3-a513-4cc15bfdf98d', 'Rua Rio de Janeiro', '390', 'Apartamento', 'Jardim América', 'Itaguaí', 'RJ', '23810-770'),
    ('b2da1e92-299e-4179-8f40-bb6d8f6bd792', 'Rua Gustavo Persuhn', '227', 'Apartamento', 'Itoupava Seca', 'Blumenau', 'SC', '89030-150'),
    ('6cd7ddf1-19e0-44ad-95f8-692a9b1a67db', 'Rua Primavera', '820', 'Apartamento', 'Conjunto Laélia Alcântara', 'Rio Branco', 'AC', '69914-478'),
    ('f119e9a1-7c61-4ba5-8f1b-7973f601a183', 'Quadra 408 Norte Alameda 9', '735', 'Apartamento', 'Plano Diretor Norte', 'Palmas', 'TO', '77006-498'),
    ('e37ce633-0159-42cd-a7ca-4a906783176b', 'Rua Maria Agda de Jesus', '482', 'Casa', 'Jardim Sarandí', 'Campo Grande', 'MS', '79108-308'),
    ('92d08218-6f9b-43e9-ae7d-464b41126de5', 'Rua Manoel da Silva', '799', 'Casa', 'Tabuazeiro', 'Vitória', 'ES', '29043-471'),
    ('53158dec-efa0-491e-a524-d218e4eba522', 'Residencial Israel', '891', 'Casa', 'Primavera', 'Teresina', 'PI', '64006-145'),
    ('929b2173-fc67-4077-95ea-8d191d0b61b4', 'Rua Pirapitinga', '711', 'Casa', 'Jorge Teixeira', 'Manaus', 'AM', '69088-748'),
    ('04d6e740-2175-4ce6-b547-57188650e66f', 'Rua Itabaiana', '346', 'Casa', 'São José', 'Aracaju', 'SE', '49015-110');


INSERT INTO tb_patients (id, name, fk_genre, fk_address, birthday, mother_name, email, phone_number, father_name) VALUES 
    ('e7829deb-2014-42d5-bfe0-5fb5e6f7d906', 'Heloise Esther Rayssa da Silva', 2, '9107b0e2-ef0a-4d11-a7d8-bb7d5010545a', '2003-06-10', 'Sara Simone', 'heloise_dasilva@larioja.com.br', '(69) 2822-8494', null),
    ('12f931dd-e427-4dd4-b869-852e1f73c891', 'Maria Luana Porto', 2, 'ca831ca3-d57c-4478-9a46-cf2b16d7a951', '1965-01-17', 'Fátima Andrea Clara', 'maria.luana.porto@nipbr.com.br', '(91) 2662-6943', 'Otávio João Freitas'),
    ('692ac970-2202-442c-b30a-b47f29edfd33', 'Sônia Laís Luna Brito', 2, '385910ec-650d-4808-99c0-7419fed60f32', '1994-03-27', 'Ana Alícia Rosângela', 'sonia-brito70@gmeil.com', '(86) 2737-4371', 'César Heitor Lorenzo Teixeira'),
    ('88201f48-c149-4898-80bb-292e200de241', 'Antonella Luciana Gabrielly Silva', 2, 'baf055d0-ffdc-4321-b4b1-2050de3bf96b', '1983-05-05', 'Laís Alessandra Rafaela', 'antonella_luciana_silva@lajescobre.com', '(65) 2724-4776', 'Iago Luan Erick Farias'),
    ('ba7ed7c1-713c-4325-b9f7-0130ceaeea1c', 'Kamilly Lúcia Helena Carvalho', 2, '3fe8714b-debe-405e-bf9f-b497c025aca7', '1947-01-13', 'Gabrielly Kamilly', 'kamilly-carvalho97@focoreducao.com.br', '(63) 3705-8573', 'Matheus Kaique Kevin Nunes'),
    ('fabc4539-0555-4a6e-925f-739c89423be4', 'Filipe Augusto Moraes', 1, '8c0e6304-a403-439d-8b9c-dfc16993d2b3', '1961-02-02', 'Mariane Luzia', 'filipe-moraes80@cebrace.com.br', '(83) 2580-9620', 'Joaquim Nathan da Costa'),
    ('cba9e18f-14de-443b-8312-5448c19f31aa', 'Aparecida Nicole Carla Rezende', 2, 'bced0970-3b96-4ab7-92e2-f567ea6bff7b', '1987-02-07', 'Sophia Regina', 'aparecida_rezende@icloub.com', '(43) 2856-1136', 'Calebe Matheus Ramos'),
    ('9c1a6c96-fe29-408d-956a-53c864c5321b', 'Severino Vicente Otávio Fernandes', 1, '140b2083-6794-4ef9-8570-db6b16e58658', '1968-03-15', 'Elza Isabelly', 'severino-fernandes95@castromobile.com.br', '(85) 3829-0763', 'Augusto Yago Martins'),
    ('90cc094a-67e1-4e58-b082-ba83e6e29eb3', 'Bento Matheus Gabriel Aragão', 1, '9dcfdf8f-38cb-4ed5-ad26-a2e957eb8ba7', '1998-01-20', 'Antonella Alana Clara', 'bento.matheus.aragao@pisbrasil.com.br', '(31) 3844-9542', 'Murilo Bruno Costa'),
    ('bcdfa0ec-87dd-448d-bf52-25973276fe83', 'Luana Fabiana dos Santos', 2, 'ccca5059-5b56-4513-8588-5f2abffc6cf5', '2000-01-08', 'Olivia Allana Milena', 'luanafabianadossantos@ideiaviva.com.br', '(96) 3987-3421', 'Pedro Henrique Luan Giovanni das Neves'),
    ('7e8048b5-ee61-4ed6-ad92-6f46a2b74c15', 'Emanuelly Maitê Pinto', 2, '66682d2f-16a3-4ffd-a6f4-d8f4c92c567d', '1993-05-02', 'Valentina Kamilly Alice', 'emanuelly-pinto71@coreval.com.br', '(82) 2803-7432', 'Benício Luan Emanuel Moreira'),
    ('5ff8d290-d65a-411a-9561-5e9291956275', 'Augusto Elias Vitor Monteiro', 1, '02e6007c-cf61-4da1-9b10-adedd8340aa7', '1951-03-27', 'Sarah Patrícia', 'augusto_elias_monteiro@alcoa.com.br', '(85) 2543-6476', 'Miguel Geraldo Arthur Corte Real'),
    ('73b13213-d6ec-4fa1-be5f-5d35d2926b4e', 'Valentina Alana da Conceição', 2, 'e7d8bdda-f0d4-46d6-928c-c7eaa6464b79', '1964-03-21', 'Raquel Sueli Priscila', 'valentina-daconceicao74@atualmarcenaria.com.br', '(81) 2523-4542', 'Roberto Lucas Anderson Moura'),
    ('47f532bb-6cf6-4b1b-a3da-da8c9babbba4', 'Caio Bruno Caleb Fogaça', 1, '487dca24-7e07-4634-a179-7099cd56f5ec', '1998-04-26', 'Cecília Eduarda Fernanda', 'caio_bruno_fogaca@casabellavidros.com.br', '(63) 3780-7191', 'Mateus Thomas Ferreira'),
    ('d9fc9092-2b2a-4e0a-8009-04f256015da8', 'Jorge Gustavo Mário Gonçalves', 1, 'ac690efb-f346-4fa1-be6d-672adfd7096a', '1987-06-04', 'Aparecida Giovanna', 'jorge.gustavo.goncalves@geniustyres.com.br', '(79) 3622-2366', 'Arthur Renan José Pinto'),
    ('03ec7f2d-f60a-4b65-8fb1-f54b90f160a0', 'Edson Fernando Elias Santos', 1, 'e6e8bffa-d62c-4a8c-9b95-0c2c727e85ad', '1969-06-14', 'Vera Aurora', 'edson.fernando.santos@zoomfoccus.com.br', '(98) 2984-1998', 'Cauã Henrique Sérgio da Rosa'),
    ('888aa525-9aec-4cd1-9dca-459e3a3a1860', 'Yasmin Nicole Peixoto', 2, 'd9e9f818-ca24-41e0-a8a9-33d1baee73ca', '1996-05-14', 'Laís Helena Emanuelly', 'yasmin_nicole_peixoto@triunfante.com.br', '(61) 3689-5646', 'Rafael Guilherme Carvalho'),
    ('bcae378c-c337-499e-a4ba-c9bcf462d6d2', 'Emanuelly Daiane Luna Cavalcanti', 2, 'fa0588d1-7e26-4563-b3c3-3d051d325b57', '1971-01-27', 'Jéssica Vitória Vitória', 'emanuelly-cavalcanti77@sorocaba.com', '(67) 3562-2587', 'Marcelo Benedito Ribeiro'),
    ('f39783a9-1ff6-426b-8deb-e6fce6eecce9', 'Luiz Luan Lopes', 1, 'c9f4b705-fa47-4ef4-94f3-c3ed6e473e07', '1977-05-03', 'Luana Aparecida', 'luiz.luan.lopes@elevaconsultancy.com.br', '(71) 2991-0159', 'Caio Noah Barbosa'),
    ('8147a158-61d1-4c4b-8c63-a98c15d0b5a5', 'Pietra Kamilly Campos', 2, '4925e70d-4d43-406d-8939-76933883080e', '1981-06-01', 'Agatha Larissa', 'pietra_kamilly_campos@danielvasconcelos.com.br', '(51) 3809-0957', 'Noah Ruan da Luz'),
    ('a5e8cd90-7fdc-42de-9e5b-abeb771e9d51', 'Elaine Cecília Souza', 2, '277baefa-e11d-4b61-b054-d868c377ae89', '1989-06-10', 'Bianca Eloá', 'elainececiliasouza@randstad.com.br', '(69) 2855-2627', 'Erick Benedito Arthur Monteiro'),
    ('9f309338-ae7a-481f-8690-4bbfa64f1df4', 'Antonella Marlene Nogueira', 2, '08102959-f50b-45b3-a513-4cc15bfdf98d', '1994-04-01', 'Regina Maria Marli', 'antonella.marlene.nogueira@ovi.com', '(27) 2937-0159', 'Manoel Danilo Kaique Duarte'),
    ('0c2f0d0a-48f6-4dad-a5d6-cea5b406dbe1', 'Elza Amanda de Paula', 2, 'b2da1e92-299e-4179-8f40-bb6d8f6bd792', '2004-01-11', 'Rosângela Nina Carla', 'elza_amanda_depaula@cursomarcato.com.br', '(53) 2665-4743', 'Márcio Bernardo Gonçalves'),
    ('0802aa05-165d-4c57-9527-0d4f01404efb', 'Nair Olivia Moura', 2, '6cd7ddf1-19e0-44ad-95f8-692a9b1a67db', '1992-05-20', 'Catarina Alícia', 'nair_olivia_moura@paae.com.br', '(69) 2935-5804', 'Pedro Henrique André da Mota'),
    ('223facfa-6511-4238-97d6-0e63ccc3b35d', 'Francisco Francisco Gustavo Lima', 1, 'f119e9a1-7c61-4ba5-8f1b-7973f601a183', '1959-06-14', 'Andreia Luana', 'francisco.francisco.lima@technicolor.com', '(71) 2614-3128', 'Kauê Diego Cardoso'),
    ('61668db7-18a3-4d29-88b4-affa91314875', 'Heloise Stella Aparecida Dias', 2, 'e37ce633-0159-42cd-a7ca-4a906783176b', '2003-06-06', 'Jéssica Kamilly', 'heloise.stella.dias@policiacivil.sp.gov.br', '(79) 2729-1019', null),
    ('0d1ad8a3-55a4-4a54-9ee1-880d64fec4ef', 'Emanuel Benício Freitas', 1, '92d08218-6f9b-43e9-ae7d-464b41126de5', '1944-05-17', 'Larissa Cristiane', 'emanuel_freitas@live.ie', '(62) 3716-9425', null),
    ('4977084d-6e83-40e2-bd6a-8bf68f13afb8', 'Márcia Fátima Jesus', 2, '53158dec-efa0-491e-a524-d218e4eba522', '1976-06-03', 'Gabriela Vitória Emanuelly', 'marciafatimajesus@yande.com.br', '(54) 3956-6505', 'Kauê Martin Calebe Cavalcanti'),
    ('4928f6c3-ba1b-4523-bda5-926035ec1d0c', 'Valentina Liz Elza da Costa', 2, '929b2173-fc67-4077-95ea-8d191d0b61b4', '1977-03-27', 'Clara Sandra Jéssica', 'valentina-dacosta75@destaco.com', '(82) 3537-9487', 'Rafael Paulo da Silva'),
    ('5a73e0f4-62a5-401f-b786-81a4a02b602c', 'Daniela Brenda Alves', 2, '04d6e740-2175-4ce6-b547-57188650e66f', '1971-06-02', 'Nina Emilly', 'daniela_brenda_alves@saae.sp.gov.br', '(79) 3734-9179', 'Bento Henrique Nogueira');
INSERT INTO TB_ATTENDANT (uuid, name, username, password, email, phone_number, speciality) VALUES 
    ('c25cef14-c78e-414c-964b-154c5043cba1', 'Teresinha Antonella Teixeira', 'teresinha_antonella_teixeira', 'aCJ9uArkNo', 'teresinha.antonella.teixeira@marramoncks.com.br', '(53) 2754-1652', 'Doenças Respiratórias'),
    ('a5835e44-d141-4930-9002-1af08f4ad6b6', 'Sueli Antonella Peixoto', 'sueli_antonella_peixoto', '8uyIDoqpS9', 'sueli.antonella.peixoto@yahool.com', '(67) 3819-0959', 'Geral'),
    ('1f3d616b-f0ff-4d1f-bd60-555c59740d2c', 'Cauã Iago da Costa', 'cauã_iago_da_costa', 'x382NG0Qb0', 'cauaiagodacosta@lnaa.com.br', '(86) 2767-8985', 'Viroses'),
    ('e7a77001-6e8c-40b8-ae16-bdad5c292fbc', 'Gael Thiago Leandro da Mata', 'gael_thiago_leandro_da_mata', 'u6wl6i1CHK', 'gael.thiago.damata@aichele.com.br', '(71) 2662-1415', 'Geral'),
    ('71a902e3-e60d-42fa-a954-798c02a513b6', 'Fábio Vinicius Geraldo da Mota', 'fábio_vinicius_geraldo_da_mota', 'oIn8LNSpQ4', 'fabio-damota92@ambarnet.com.br', '(83) 3779-5888', 'Maternidade'),
    ('1c8877f9-9b07-4a6c-9368-82ccef03ef9c', 'Pietra Aurora Rebeca Mendes', 'pietra_aurora_rebeca_mendes', 'LfYXbTPDG7', 'pietra.aurora.mendes@rafaeladson.com', '(14) 3731-7686', 'Pós Operatório'),
    ('fbf2e550-fe7d-4856-a73a-bef840e120be', 'Renan Fábio Nunes', 'renan_fábio_nunes', 'fglCidTihW', 'renanfabionunes@cbsaperfeicoamento.com.br', '(71) 2885-6056', 'Pós Operatório'),
    ('be2af9d2-56e0-4913-8e8d-7c0f0a4d7e0e', 'Caio Yago Assunção', 'caio_yago_assunção', 'IuqYJJz8mR', 'caio_yago_assuncao@mundivox.com.br', '(27) 3981-8719', 'Doenças Respiratórias'),
    ('4f26b825-a935-42ef-be19-aab772094a91', 'Tomás Leonardo Francisco da Paz', 'tomás_leonardo_francisco_da_paz', '4CM5zXCnRY', 'tomas.leonardo.dapaz@tigra.com.br', '(81) 3628-4436', 'Alergias'),
    ('b4f12683-7400-4596-9867-9bcecb39190b', 'Isabella Isabella Moura', 'isabella_isabella_moura', 'CSbBpS82St', 'isabellaisabellamoura@iesa.com.br', '(67) 3659-6197', 'Casos Delicados'),
    ('6bcab158-30d4-4882-a899-87c0913ff6f2', 'Sophia Catarina Elaine dos Santos', 'sophia_catarina_elaine_dos_santos', '1dLLddoM0n', 'sophia_dossantos@caferibeiro.com.br', '(86) 2734-0255', 'Pediatria'),
    ('ee4b624b-dc87-4826-81f1-712cff6c1a72', 'Lívia Isabella Carvalho', 'lívia_isabella_carvalho', '1Ln2s40S2X', 'liviaisabellacarvalho@ozsurfing.com.br', '(69) 2745-2796', 'Pediatria'),
    ('cf09dc9d-a5d4-493e-a8dd-63455da61298', 'John Doe', 'johndoe', 'password123', 'john@example.com', '1234567890', 'Geral');

INSERT INTO tb_report (uuid, annotations, fk_attendant, fk_patient, fk_priority, created_at, updated_at) VALUES
    ('c35050ef-2a32-4670-9a2e-2d98aa91ae73', 'Sentindo sintomas a mais de 2 semanas', 'c25cef14-c78e-414c-964b-154c5043cba1', 'e7829deb-2014-42d5-bfe0-5fb5e6f7d906', 2, '2024-06-15 14:12:10' , null),
    ('c35050ef-2a32-4670-9a2e-2d98aa91ae75', 'Sentindo sintomas a mais de 2 semanas', 'c25cef14-c78e-414c-964b-154c5043cba1', 'e7829deb-2014-42d5-bfe0-5fb5e6f7d906', 2, '2024-06-15 14:12:10' , '2024-06-15 15:17:10');

INSERT INTO tb_report_xref_symptom (fk_report, fk_symptom) VALUES
    ('c35050ef-2a32-4670-9a2e-2d98aa91ae73', 'b5b45059-5a8b-4916-96cb-f9cd254e5d30'),
    ('c35050ef-2a32-4670-9a2e-2d98aa91ae73', '54dfd081-c144-455e-b71f-b93f36c94850'),
    ('c35050ef-2a32-4670-9a2e-2d98aa91ae73', '213b3269-4196-4da3-b7e6-6a6c4195f32c'),
    ('c35050ef-2a32-4670-9a2e-2d98aa91ae73', '4148baec-7e28-4cb4-b303-7d72b44eacf5');