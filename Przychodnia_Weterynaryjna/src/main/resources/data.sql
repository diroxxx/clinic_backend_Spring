-- Wstawienie danych do tabeli user
INSERT INTO user (first_name, last_name, email, phone_number, password)
VALUES
    ('John', 'Doe', 'john.doe@example.com', '123456789', 'password123'),
    ('Jane', 'Smith', 'jane.smith@example.com', '987654321', 'password456'),
    ('Emily', 'Johnson', 'emily.johnson@example.com', '555666777', 'password789');

-- Wstawienie danych do tabeli client
INSERT INTO client (user_id)
VALUES
    (1), -- John Doe
    (2); -- Jane Smith

-- Wstawienie danych do tabeli vet
INSERT INTO vet (years_of_experience, user_id)
VALUES
    (5, 3); -- Emily Johnson (Weterynarz)

-- Wstawienie danych do tabeli AnimalType
INSERT INTO AnimalType (type)
VALUES
    ('Dog'),
    ('Cat'),
    ('Horse');

-- Wstawienie danych do tabeli Animal
INSERT INTO Animal (name, animal_type_id, client_id)
VALUES
    ('Buddy', 1, 1), -- Pies należący do Johna
    ('Whiskers', 2, 1), -- Kot Johna
    ('Thunder', 3, 2); -- Koń Jane

-- Wstawienie danych do tabeli service
INSERT INTO service (name, price)
VALUES
    ('Vaccination', 50.00),
    ('Check-up', 30.00),
    ('Surgery', 300.00);

-- Wstawienie danych do tabeli Appointment
INSERT INTO Appointment (ap_date, description, status, vet_id, service_id, client_id, animal_id)
VALUES
    ('2024-10-07', 'Annual vaccination for Buddy', 'completed', 1, 1, 1,2), -- Wizyta Johna z Buddy u Emily
    ('2024-10-09', 'Check-up for Whiskers', 'scheduled', 1, 2, 1,1), -- Wizyta Johna z Whiskers
    ('2024-10-10', 'Surgery for Thunder', 'scheduled', 1, 3, 2,1); -- Wizyta Jane z Thunder

-- Wstawienie danych do tabeli article
INSERT INTO article (title, content, date, vet_id)
VALUES
    ('The Importance of Vaccinations', 'Vaccinations are crucial for your pet’s health...', '2024-10-05', 1),
    ('How to Care for Senior Pets', 'As pets age, they require different care...', '2024-10-01', 1);

