-- Inserări în tabela unit
INSERT INTO unit (id, name) VALUES (nextval('unit_seq'), 'Patient House 1');
INSERT INTO unit (id, name) VALUES (nextval('unit_seq'), 'Patient House 2');

-- Inserări în tabela app_user
-- Asigură-te că id-urile unităților sunt corecte (cele generate de secvență)

INSERT INTO app_user (username, first_name, last_name, password, role, unit_id)
VALUES ('unitAdmin1', 'Admin', '1', '$2a$10$Z0/YwZCojgHpLy66/1xUuuoKPoAINYZAzJNsdezTYc/bm7SDhLUtu', 'ADMIN', (SELECT id FROM unit WHERE name = 'Patient House 1'));

INSERT INTO app_user (username, first_name, last_name, password, role, unit_id)
VALUES ('unitAdmin2', 'Admin', '2', '$2a$10$Z0/YwZCojgHpLy66/1xUuuoKPoAINYZAzJNsdezTYc/bm7SDhLUtu', 'ADMIN', (SELECT id FROM unit WHERE name = 'Patient House 2'));

INSERT INTO app_user (username, first_name, last_name, password, role, unit_id)
VALUES ('moderator1', 'Moderator', '1', '$2a$10$Z0/YwZCojgHpLy66/1xUuuoKPoAINYZAzJNsdezTYc/bm7SDhLUtu', 'MODERATOR', (SELECT id FROM unit WHERE name = 'Patient House 1'));

INSERT INTO app_user (username, first_name, last_name, password, role, unit_id)
VALUES ('moderator2', 'Moderator', '2', '$2a$10$Z0/YwZCojgHpLy66/1xUuuoKPoAINYZAzJNsdezTYc/bm7SDhLUtu', 'MODERATOR', (SELECT id FROM unit WHERE name = 'Patient House 2'));

-- Inserări în tabela patient
-- Asigură-te că id-urile unităților sunt corecte (cele generate de secvență)
INSERT INTO patient (patient_id, first_name, last_name, gender, date_of_birth, mentions, recommendation, diseases, unit_id, contact_persons)
VALUES ('1234567890123', 'Ionut', 'Grad', 'Male', 1741181128000, 'Mentiuni Initiale:
- Este important să se respecte nevoile și preferințele personale ale fiecărei persoane în vârstă.
- Monitorizarea sănătății este esențială pentru prevenirea problemelor medicale.
- Un mediu sigur și confortabil reduce riscul accidentelor casnice.
- Interacțiunea socială contribuie la menținerea unei stări emoționale pozitive.
- Un stil de viață activ și echilibrat poate îmbunătăți calitatea vieții.', '1. Sănătate și bunăstare
	• Alimentație echilibrată – Dietă bogată în legume, fructe, proteine slabe și hidratare suficientă.
	• Activitate fizică – Plimbări zilnice, exerciții ușoare, yoga pentru seniori.
	• Control medical regulat – Vizite periodice la medic pentru monitorizarea sănătății.
	• Odihnă și somn de calitate – Program regulat de somn și un mediu odihnitor.

2. Activități mentale și sociale
	• Citit, integrame, sudoku – Menținerea minții active.
	• Discuții cu prietenii și familia – Prevenirea izolării sociale.
	• Cursuri online sau hobby-uri – Învață lucruri noi, cum ar fi pictura, grădinăritul sau muzica.

3. Siguranță și confort
	• Adaptarea locuinței – Iluminare bună, bare de sprijin în baie, covoare antiderapante.
	• Tehnologie accesibilă – Telefon simplu de folosit, buton de urgență, televizor cu subtitrare mare.

4. Relaxare și plăcere
	• Muzică relaxantă, filme, podcasturi – Pentru momente plăcute.
	• Ieșiri în natură – Plimbări în parc, excursii scurte.
	• Animale de companie – Dacă îi place, un câine sau o pisică pot aduce multă bucurie.', 'No diseases', (SELECT id FROM unit WHERE name = 'Patient House 1'), '[{"firstName": "Elon", "lastName": "Musk", "phoneNumber": "0752132141", "email": "elon.musk@gmail.com"}, {"firstName": "Donald", "lastName": "Trump", "phoneNumber": "0752132141", "email": "donald.trump@gmail.com"}]');

INSERT INTO patient (patient_id, first_name, last_name, gender, date_of_birth, mentions, recommendation, diseases, unit_id, contact_persons)
VALUES ('1234567890124', 'John', 'bob', 'Male', 1741181128000, 'Mentiuni Initiale:
- Este important să se respecte nevoile și preferințele personale ale fiecărei persoane în vârstă.
- Monitorizarea sănătății este esențială pentru prevenirea problemelor medicale.
- Un mediu sigur și confortabil reduce riscul accidentelor casnice.
- Interacțiunea socială contribuie la menținerea unei stări emoționale pozitive.
- Un stil de viață activ și echilibrat poate îmbunătăți calitatea vieții.', '1. Sănătate și bunăstare
	• Alimentație echilibrată – Dietă bogată în legume, fructe, proteine slabe și hidratare suficientă.
	• Activitate fizică – Plimbări zilnice, exerciții ușoare, yoga pentru seniori.
	• Control medical regulat – Vizite periodice la medic pentru monitorizarea sănătății.
	• Odihnă și somn de calitate – Program regulat de somn și un mediu odihnitor.

2. Activități mentale și sociale
	• Citit, integrame, sudoku – Menținerea minții active.
	• Discuții cu prietenii și familia – Prevenirea izolării sociale.
	• Cursuri online sau hobby-uri – Învață lucruri noi, cum ar fi pictura, grădinăritul sau muzica.

3. Siguranță și confort
	• Adaptarea locuinței – Iluminare bună, bare de sprijin în baie, covoare antiderapante.
	• Tehnologie accesibilă – Telefon simplu de folosit, buton de urgență, televizor cu subtitrare mare.

4. Relaxare și plăcere
	• Muzică relaxantă, filme, podcasturi – Pentru momente plăcute.
	• Ieșiri în natură – Plimbări în parc, excursii scurte.
	• Animale de companie – Dacă îi place, un câine sau o pisică pot aduce multă bucurie.', 'No diseases', (SELECT id FROM unit WHERE name = 'Patient House 1'), null);

INSERT INTO patient (identification_number, first_name, last_name, gender, date_of_birth, mentions, recommendation, diseases, unit_id, contact_persons)
VALUES ('1234567890126', 'John', 'Cena', 'Male', 1741181128000, 'Nothing to say', 'Drink a lot of water', 'No diseases', (SELECT id FROM unit WHERE name = 'Patient House 2'), null);

INSERT INTO patient (identification_number, first_name, last_name, gender, date_of_birth, mentions, recommendation, diseases, unit_id, contact_persons)
VALUES ('1234567890129', 'The', 'Undertaker', 'Male', 1741181128000, 'Nothing to say', 'Drink a lot of water', 'No diseases', (SELECT id FROM unit WHERE name = 'Patient House 2'), null);