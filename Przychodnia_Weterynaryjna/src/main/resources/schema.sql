-- Table: user
CREATE TABLE IF NOT EXISTS user (
                      id int NOT NULL AUTO_INCREMENT,
                      first_name varchar(50) NOT NULL,
                      last_name varchar(50) NOT NULL,
                      email varchar(100) NOT NULL,
                      phone_number varchar(15) NOT NULL,
                      password varchar(40) NOT NULL,
                      CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: client
CREATE TABLE IF NOT EXISTS client (
                        id int NOT NULL AUTO_INCREMENT,
                        user_id int NOT NULL,
                        CONSTRAINT client_pk PRIMARY KEY (id),
                        FOREIGN KEY (user_id) REFERENCES user(id)
);

-- Table: vet
CREATE TABLE IF NOT EXISTS vet (
                     id int NOT NULL AUTO_INCREMENT,
                     years_of_experience int NOT NULL,
                     user_id int NOT NULL,
                     CONSTRAINT vet_pk PRIMARY KEY (id),
                     FOREIGN KEY (user_id) REFERENCES user(id)
);

-- Table: service
CREATE TABLE IF NOT EXISTS service (
                         id int NOT NULL AUTO_INCREMENT,
                         name varchar(50) NOT NULL,
                         price DECIMAL(10,2) NOT NULL,
                         CONSTRAINT service_pk PRIMARY KEY (id)
);

-- Table: AnimalType
CREATE TABLE IF NOT EXISTS AnimalType (
                            id int NOT NULL AUTO_INCREMENT,
                            type varchar(50) NOT NULL,
                            CONSTRAINT AnimalType_pk PRIMARY KEY (id)
);

-- Table: Animal
CREATE TABLE IF NOT EXISTS Animal (
                        id int NOT NULL AUTO_INCREMENT,
                        name varchar(50) NULL,
                        animal_type_id  int NOT NULL,
                        client_id int NOT NULL,
                        CONSTRAINT Animal_pk PRIMARY KEY (id),
                        FOREIGN KEY (animal_type_id ) REFERENCES AnimalType(id),
                        FOREIGN KEY (client_id) REFERENCES client(id)
);

-- Table: article
CREATE TABLE IF NOT EXISTS article (
                         id int NOT NULL AUTO_INCREMENT,
                         title varchar(100) NOT NULL,
                         content varchar(1000) NOT NULL,
                         date date NOT NULL,
                         vet_id int NOT NULL,
                         CONSTRAINT article_pk PRIMARY KEY (id),
                         FOREIGN KEY (vet_id) REFERENCES vet(id)
);

-- Table: Appointment
CREATE TABLE IF NOT EXISTS Appointment (
                             id int NOT NULL AUTO_INCREMENT,
                             ap_date date NOT NULL,
                             description varchar(500) NULL ,
                             status ENUM('scheduled', 'completed', 'canceled') NOT NULL,
                             vet_id int NOT NULL,
                             service_id int NOT NULL,
                             client_id int NOT NULL,
                             animal_id int NOT NULL,
                             CONSTRAINT Appointment_pk PRIMARY KEY (id),
                             FOREIGN KEY (vet_id) REFERENCES vet(id),
                             FOREIGN KEY (service_id) REFERENCES service(id),
                             FOREIGN KEY (client_id) REFERENCES client(id),
                             FOREIGN KEY (animal_id) REFERENCES Animal(id)
);
