-- Wstawienie danych do tabeli user
INSERT INTO user (first_name, last_name, email, phone_number, password)
VALUES
    ('John', 'Doe', 'john.doe@example.com', '123456789', 'password123'),
    ('Jane', 'Smith', 'jane.smith@example.com', '987654321', 'password456'),
    ('Emily', 'Johnson', 'emily.johnson@example.com', '555666777', 'password789'),
    ('Anthony', 'Clark', 'anthony.clark@example.com', '123432657', 'password111')
    ;

-- Wstawienie danych do tabeli client
INSERT INTO client (user_id)
VALUES
    (1), -- John Doe
    (2); -- Jane Smith

-- Wstawienie danych do tabeli vet
INSERT INTO vet (years_of_experience, user_id)
VALUES
    (5, 3),
    (1, 4);

-- Wstawienie danych do tabeli AnimalType
INSERT INTO Animal_Type (type)
VALUES
    ('Dog'),
    ('Cat'),
    ('Horse'),
    ('Rabbit'),
    ('Bird'),
    ('Hamster'),
    ('Guinea Pig'),
    ('Ferret');

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
    ('Surgery', 300.00),
    ('Dental Cleaning', 120.00),
    ('X-Ray', 150.00),
    ('Blood Test', 45.00),
    ('Ultrasound', 200.00),
    ('Neutering', 250.00),
    ('Microchipping', 40.00),
    ('Emergency Care', 500.00),
    ('Pet Grooming', 70.00),
    ('Nutritional Consultation', 60.00);


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
    ('How to Care for Senior Pets', 'As pets age, they require different care...', '2024-10-01', 1),
    ('Dental Care for Pets',
     'Dental health is an often-overlooked aspect of pet care, but it is essential to their overall well-being. Poor dental hygiene can lead not only to bad breath and tooth decay but also to more serious issues such as periodontal disease and infections that can spread to other parts of the body. Regular brushing and dental check-ups can prevent these problems. Your vet may recommend professional cleanings or special dental diets to help maintain your pet’s oral health. Remember, prevention is much easier—and less expensive—than treatment for advanced dental disease.',
     '2024-09-20',
     2),

    ('Why Spaying and Neutering is Important',
     'Spaying and neutering your pet is a responsible decision that offers numerous health benefits. Not only does it help control the pet population, but it can also prevent various health problems, including reproductive cancers and infections. In females, spaying significantly reduces the risk of uterine infections and breast cancer, while neutering males decreases the risk of testicular cancer and can reduce aggressive behaviors. Additionally, spaying and neutering can help minimize certain behavioral issues, making it easier to manage pets in a household environment.',
     '2024-08-15',
     2),

    ('Recognizing Early Signs of Illness in Pets',
     'One of the keys to maintaining your pet’s health is recognizing the early signs of illness. Pets often hide discomfort or pain, so it’s essential to be observant of changes in behavior, appetite, or energy levels. Symptoms such as sudden weight loss, changes in eating or drinking habits, coughing, vomiting, or diarrhea can indicate underlying health issues. Regular vet check-ups are important, but as a pet owner, your role in early detection is crucial. If you notice any changes in your pet’s behavior or physical condition, consult your veterinarian as soon as possible.',
     '2024-09-30',
     3);

