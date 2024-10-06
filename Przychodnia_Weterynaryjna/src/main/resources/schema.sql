-- Tabela User
CREATE TABLE User (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      first_name VARCHAR(50) NOT NULL,
                      last_name VARCHAR(50) NOT NULL,
                      email VARCHAR(50) NOT NULL UNIQUE,
                      phone_number VARCHAR(9),
                      password VARCHAR(40) NOT NULL,
                      role ENUM('CLIENT', 'VET') NOT NULL
);

-- Tabela Client
CREATE TABLE Client (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        user_id INT NOT NULL,
                        FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);



-- Tabela Vet
CREATE TABLE Vet (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     user_id INT NOT NULL,
                     years_of_experience INT NOT NULL,
                     FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE

                 );

CREATE TABLE Article (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR(100) NOT NULL,
                         content VARCHAR(1000) NOT NULL,
                         vet_id INT NOT NULL,
                         publication_date DATE NOT NULL,
                         FOREIGN KEY (vet_id) REFERENCES Vet(id) ON DELETE CASCADE
);

-- Tabela AnimalType (typy zwierząt)
CREATE TABLE AnimalType (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            type_name VARCHAR(50) NOT NULL UNIQUE
);

-- Tabela Animal
CREATE TABLE Animal (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(50),
                        animal_type_id INT NOT NULL,
                        client_id INT NOT NULL,
                        FOREIGN KEY (animal_type_id) REFERENCES AnimalType(id) On DELETE CASCADE ,
                        FOREIGN KEY (client_id) REFERENCES Client(id) ON DELETE CASCADE
);

-- Tabela Service
CREATE TABLE Service (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         price DECIMAL(10, 2) NOT NULL
);

-- Tabela Appointment
CREATE TABLE Appointment (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             appointment_date DATETIME NOT NULL,
                             vet_id INT NOT NULL,
                             client_id INT NOT NULL,
                             animal_id INT NOT NULL,
                             service_id INT NOT NULL,
                             FOREIGN KEY (vet_id) REFERENCES Vet(id),
                             FOREIGN KEY (client_id) REFERENCES Client(id),
                             FOREIGN KEY (animal_id) REFERENCES Animal(id),
                             FOREIGN KEY (service_id) REFERENCES Service(id)
);
