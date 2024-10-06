-- Wstawienie użytkowników
INSERT INTO User (first_name, last_name, email, phone_number, password, role)
VALUES
    ('John', 'Doe', 'johndoe@email.com', '123456789', 'password123', 'VET'),
    ('Jane', 'Smith', 'janesmith@email.com', '987654321', 'password123', 'CLIENT');

-- Wstawienie weterynarza (Vet)
INSERT INTO Vet (user_id, years_of_experience)
VALUES
    (1, 10);  -- John Doe jako weterynarz z 10 latami doświadczenia

-- Wstawienie klienta (Client)
INSERT INTO Client (user_id)
VALUES
    (2);  -- Jane Smith jako klient

-- Wstawienie typów zwierząt (AnimalType)
INSERT INTO AnimalType (type_name)
VALUES
    ('DOG'),
    ('CAT'),
    ('HORSE'),
    ('COW');

-- Wstawienie zwierząt (Animal)
INSERT INTO Animal (name, animal_type_id, client_id)
VALUES
    ('Rex', 1, 1),  -- Pies Rex (typ DOG) przypisany do klienta Jane Smith
    ('Whiskers', 2, 1);  -- Kot Whiskers (typ CAT) przypisany do klienta Jane Smith

-- Wstawienie usług (Service)
INSERT INTO Service (name, price)
VALUES
    ('Vaccination', 100.00),
    ('Checkup', 50.00),
    ('Surgery', 300.00);

-- Wstawienie wizyty (Appointment)
INSERT INTO Appointment (appointment_date, vet_id, client_id, animal_id, service_id)
VALUES
    ('2024-10-10 14:00:00', 1, 1, 1, 1),  -- Wizyta weterynarza John Doe z klientem Jane Smith, zwierzę Rex, usługa Vaccination
    ('2024-10-12 10:00:00', 1, 1, 2, 2);  -- Wizyta weterynarza John Doe z klientem Jane Smith, zwierzę Whiskers, usługa Checkup
