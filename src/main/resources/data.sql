INSERT INTO address (address_line1, address_line2, city, postal_code) VALUES
                                                                          ('ul. Wielka 12', 'mieszkanie 3', 'Warszawa', '00-001'),
                                                                          ('ul. Mała 4', 'mieszkanie 2B', 'Kraków', '30-010'),
                                                                          ('ul. Jagiellońska 7', '', 'Gdańsk', '80-020'),
                                                                          ('ul. Starowiejska 2', 'mieszkanie 10', 'Poznań', '60-030'),
                                                                          ('ul. Mickiewicza 1', '', 'Wrocław', '50-040'),
                                                                          ('ul. Piastowska 15', 'mieszkanie 8', 'Katowice', '40-050'),
                                                                          ('ul. Sobieskiego 3', 'mieszkanie 12A', 'Łódź', '90-060'),
                                                                          ('ul. Kosciuszki 20', '', 'Szczecin', '70-070');

INSERT INTO doctor (first_name, last_name, telephone_number, email, doctor_number, specialization, address_id) VALUES
                                                                                                       ('Jan', 'Kowalski', '123456789', 'jan.kowalski@example.com', '123', 'OCULIST', 2),
                                                                                                       ('Anna', 'Nowak', '987654321', 'anna.nowak@example.com', '456', 'SURGEON', 5),
                                                                                                       ('Karolina', 'Dąbrowska', '555666777', 'karolina.dabrowska@example.com', '789', 'GP', 7),
                                                                                                       ('Marcin', 'Lewandowski', '888999000', 'marcin.lewandowski@example.com', '012', 'DERMATOLOGIST', 1);

INSERT INTO patient (first_name, last_name, telephone_number, email, patient_number, date_of_birth, age, address_id) VALUES
                                                                                                        ('Aleksandra', 'Wiśniewska', '111222333', 'aleksandra.wisniewska@example.com', '789', '1990-05-15', 30, 1),
                                                                                                        ('Piotr', 'Kowalczyk', '444555666', 'piotr.kowalczyk@example.com', '012', '1985-10-20', 35, 2),
                                                                                                        ('Adam', 'Nowak', '111222333', 'adam.nowak@example.com', '111', '1980-03-10', 40, 3),
                                                                                                        ('Katarzyna', 'Kowalczyk', '444555666', 'katarzyna.kowalczyk@example.com', '222', '1992-07-20', 28, 4),
                                                                                                        ('Michał', 'Wójcik', '777888999', 'michal.wojcik@example.com', '333', '1975-12-05', 45, 5),
                                                                                                        ('Monika', 'Kamińska', '123456789', 'monika.kaminska@example.com', '444', '1988-09-15', 32, 6),
                                                                                                        ('Paweł', 'Zając', '999888777', 'pawel.zajac@example.com', '555', '1996-04-25', 24, 8);

INSERT INTO visit (description, time, doctor_id, patient_id) VALUES
                                                                 ('Badanie kontrolne', '2024-05-25 10:00:00', 1, 1),
                                                                 ('Wizyta pierwszego kontaktu', '2024-05-26 14:30:00', 2, 2),
                                                                 ('Konsultacja neurologiczna', '2024-05-28 09:15:00', 3, 3),
                                                                 ('Badanie kardiologiczne', '2024-05-30 11:30:00', 4, 4),
                                                                 ('Kontrola ogólna', '2024-06-02 14:00:00', 1, 5);

INSERT INTO medical_treatment (description, type, visit_id) VALUES
                                                                ('Badanie USG jamy brzusznej', 'USG', 4),
                                                                ('Badanie EKG serca', 'EKG', 5),
                                                                ('Badanie RTG klatki piersiowej', 'RTG', 3),
                                                                ('Badanie USG narządu ruchu', 'USG', 2),
                                                                ('Badanie EKG serca', 'EKG', 1);

