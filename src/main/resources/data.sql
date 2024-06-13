INSERT INTO tb_genre (name) VALUES ('Masculino'), ('Feminino');
INSERT INTO tb_patients (id, name, fk_genre, fk_address, birthday, mother_name) VALUES ('e251401a-797b-49d3-8696-2e0347a60faa', 'Carlos Magno', 1, null, '1989-07-22', 'Adélia Magna');
INSERT INTO tb_symptom (uuid, name, weight)  VALUES ('2173180e-edb8-46c9-a926-8729e8d64196','Enxaqueca', 78);
INSERT INTO TB_ATTENDANT (uuid, name, username, password_hash, email, phone_number, speciality) VALUES
('cf09dc9d-a5d4-493e-a8dd-63455da61298', 'John Doe', 'johndoe', 'password123', 'john@example.com', '1234567890', 'Atendente');
