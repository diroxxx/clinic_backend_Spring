INSERT INTO User (first_name, last_name, email, phone_number, password, role)
VALUES
    ('John', 'Doe', 'john.doe@example.com', '123456789', 'password123', 'CLIENT'),
    ('Jane', 'Smith', 'jane.smith@example.com', '987654321', 'password123', 'VET'),
    ('Mark', 'Johnson', 'mark.johnson@example.com', '123123123', 'password123', 'CLIENT'),
    ('Emily', 'Brown', 'emily.brown@example.com', '987987987', 'password123', 'VET');

-- Wstawienie danych do tabeli Client
INSERT INTO Client (user_id)
VALUES
    (1),  -- John Doe
    (3);  -- Mark Johnson

-- Wstawienie danych do tabeli Vet
INSERT INTO Vet (user_id, years_of_experience)
VALUES
    (2, 5),  -- Jane Smith, 5 lat doświadczenia
    (4, 10); -- Emily Brown, 10 lat doświadczenia

-- Wstawienie danych do tabeli Article
INSERT INTO Article (title, content, vet_id, publication_date)
VALUES
    ('How to Care for Your Dog', 'This article covers dog care basics.', 1, '2023-01-15'),
    ('Understanding Feline Health', 'An overview of common cat health issues.', 2, '2023-03-10');

-- Wstawienie danych do tabeli AnimalType
INSERT INTO AnimalType (type_name)
VALUES
    ('Dog'),
    ('Cat'),
    ('Horse'),
    ('Cow');

-- Wstawienie danych do tabeli Animal
INSERT INTO Animal (name, animal_type_id, client_id)
VALUES
    ('Buddy', 1, 1),  -- Pies (Dog) należący do Johna Doe
    ('Whiskers', 2, 1),  -- Kot (Cat) należący do Johna Doe
    ('Thunder', 3, 3),  -- Koń (Horse) należący do Marka Johnsona
    ('Bessie', 4, 3);  -- Krowa (Cow) należąca do Marka Johnsona

-- Wstawienie danych do tabeli Service
INSERT INTO Service (name, price)
VALUES
    ('Vaccination', 50.00),
    ('Checkup', 30.00),
    ('Surgery', 200.00);

-- Wstawienie danych do tabeli Appointment
INSERT INTO Appointment (appointment_date, vet_id, client_id, animal_id, service_id)
VALUES
    ('2023-06-01 10:00:00', 1, 1, 1, 1),  -- Wizyta u weterynarza (Vaccination) dla psa (Buddy)
    ('2023-06-15 14:00:00', 2, 3, 3, 2),  -- Checkup konia (Thunder)
    ('2023-07-01 11:00:00', 1, 1, 2, 1);  -- Vaccination dla kota (Whiskers)