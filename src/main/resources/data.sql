DROP TABLE if exists    musei;
create table musei (
                       id INT AUTO_INCREMENT  PRIMARY KEY,
                       name VARCHAR(250) NOT NULL,
                       address VARCHAR(250) NOT NULL,

);

INSERT INTO musei (name, address) VALUES
('Museo Paleolitico', 'Via'),
('Museo della seconda guerra mondiale', 'Piazza');

drop table if exists ristoranti;
create table ristoranti (
                       id INT AUTO_INCREMENT  PRIMARY KEY,
                       name VARCHAR(250) NOT NULL,
                       address VARCHAR(250) NOT NULL,
                       descrizione VARCHAR(250) NOT NULL,
                       tipo_cucina VARCHAR(250) not null,
                       type VARCHAR(250) NOT NULL,
                       numero VARCHAR(250) NULL
);

INSERT INTO ristoranti (name, address, descrizione, tipo_cucina, type, numero) VALUES
('PUB', 'Vico ricci n1', 'PUB Irlanderse', 'panini / carne / patate', 'PUB', '0865123456'),
('LOCALE Dolce', 'Corso Garibaldi', 'Ottima pizza in centro citta', 'pizza al taglio', 'PIZZERIA', '3334444567'),
('131', 'Via OCCIDENTE', 'Locale Elegante nel centro storico', 'Panini', 'ELEGANTE', '12345678'),
('Osteria', 'Corso XYZ', 'Pizzeria Elegante nel centro storico', 'Panini', 'PIZZERIA_ELEGANTE', '4567382290');

drop table if exists locale;
create table locale (
                            id INT AUTO_INCREMENT  PRIMARY KEY,
                            name VARCHAR(250) NOT NULL,
                            address VARCHAR(250) NOT NULL,
                            descrizione VARCHAR(250) NOT NULL
);

drop table if exists place;
create table place(
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      address VARCHAR(250) NOT NULL,
                      name VARCHAR(250) NOT NULL,
                      descrizione VARCHAR(250) NOT NULL,
                      type VARCHAR(250) NOT NULL,
                      distanza integer null
);

INSERT INTO place(name, address ,descrizione, type, distanza) VALUES
('FONTANA ', 'PIAZZA ' ,'ANTICA FONTANA NEL CENTRO STORICO', 'STORICO', 3),
('LAGO ', 'SAN VINCENZO (IS)', 'LAGO ARTIFICIALE', 'NATURA_PAESAGGIO', 25),
('CATTEDRALE', 'Piazza', 'CATTEDRALE NEL CENTRO STORICO', 'STORICO', 1),
('EREMO', 'MONTAGNA', 'EREMO CON BELVEDERE', 'NATURA_PAESAGGIO', 10);


drop table if exists review;
CREATE TABLE review(
                       id INT AUTO_INCREMENT  PRIMARY KEY,
                       user VARCHAR(250) NOT NULL,
                       date DATE NOT NULL,
                       text VARCHAR(250) NOT NULL
)