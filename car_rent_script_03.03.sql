DROP DATABASE IF EXISTS car_rent;
CREATE DATABASE car_rent;
USE car_rent;

-- create

CREATE TABLE car_info (
  `car_id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `car_brand` varchar(255) NOT NULL,
  `car_model` varchar(255) DEFAULT NULL,
  `car_plate_number` varchar(255) NOT NULL,
  `car_type` varchar(255) DEFAULT NULL
);

CREATE TABLE car_rent_details (
 car_rent_details_id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
 cost_per_day DOUBLE DEFAULT NULL,
 rent_start_date VARCHAR(20) DEFAULT NULL,
 rent_end_date VARCHAR(20) DEFAULT NULL,
 car_info_id INT(11) NOT NULL UNIQUE,
 avaliable_to_rent BOOLEAN,
 FOREIGN KEY (car_info_id) REFERENCES car_info (car_id)
);

CREATE TABLE user (
user_id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR(30) DEFAULT NULL,
user_lastname VARCHAR(30) DEFAULT NULL
);

 -- insert


INSERT INTO car_info (car_brand, car_model, car_plate_number, car_type)  VALUES 
('VOLVO', 'V40','ZS11110','CLASSIC'),
('TOYOTA', 'Yaris','ZS11111' ,'CLASSIC'),
('VOLVO', 'XC90','ZS11112','SUV'),
('FORD', 'Fusion','ZS11113' ,'CLASSIC'),
('MASERATI', 'Quattroporte','ZS11114' ,'SPORT'),
('HONDA', 'HR-V','ZS11115' ,'SUV'),
('PEUGEOT', 'Expert','ZS11116' ,'VAN'),
('MERCEDES', 'Marco Polo','ZS11117' ,'VAN'),
('VOLKSWAGEN', 'California','ZS11118' ,'CLASSIC'),
('TOYOTA', 'RAV4','ZS11119' ,'SUV'),
('HONDA', 'Civic','ZS11120' ,'SPORT'),
('MAZDA', 'CX-9','ZS11121' ,'SUV'),
('OPEL', 'Adam','ZS11122' ,'CLASSIC'),
('TOYOTA', 'Supra','ZS11123' ,'SPORT'),
('OPEL', 'Astra','ZS11124' ,'CLASSIC'),
('OPEL', 'Omega','ZS11125' ,'CLASSIC'),
('TOYOTA', 'Camry','ZS11126' ,'CLASSIC'),
('MERCEDES', 'Citan','ZS11127' ,'VAN'),
('NISSAN', 'Mirca','ZS11128' ,'CLASSIC'),
('MERCEDES', 'Sprinter','ZS11129' ,'VAN'),
('MERCEDES', 'AMG GT','ZS11130' ,'SPORT'),
('MERCEDES', 'CLA','ZS11131' ,'CLASSIC'),
('MERCEDES', 'CLS','ZS11132' ,'CLASSIC'),
('VOLKSWAGEN', 'Arteon','ZS11133' ,'SPORT'),
('VOLKSWAGEN', 'Golf','ZS11134' ,'CLASSIC'),
('FORD', 'Mustang','ZS11135' ,'SPORT'),
('VOLKSWAGEN', 'Passat','ZS11136' ,'CLASSIC'),
('FERRARI', 'LaFerrari','ZS11137' ,'SPORT'),
('OPEL', 'Vivaro','ZS11138' ,'VAN'),
('VOLKSWAGEN', 'Up','ZS11139' ,'CLASSIC'),
('VOLKSWAGEN', 'Polo','ZS11140' ,'CLASSIC'),
('VOLKSWAGEN', 'T-Cross','ZS11141' ,'SUV'),
('NISSAN', '370Z','ZS11142' ,'SPORT'),
('NISSAN', 'GT-R','ZS11143' ,'SPORT'),
('NISSAN', 'Quashqai','ZS11144' ,'SUV'),
('NISSAN', 'Leaf','ZS11145' ,'CLASSIC'),
('BMW', 'X3','ZS11146' ,'SUV'),
('BMW', 'X7','ZS11147' ,'SUV'),
('NISSAN', 'X-Trail','ZS11148' ,'SUV'),
('MERCEDES', 'GLE','ZS11149' ,'SUV'),
('MERCEDES', 'Vito','ZS11150' ,'VAN'),
('BMW', 'Z4','ZS11151' ,'SPORT'),
('BMW', 'i3','ZS11152' ,'CLASSIC'),
('VOLVO', 'S90','ZS11153','CLASSIC'),
('BMW', 'i8','ZS11154' ,'SPORT'),
('FORD', 'Fiesta','ZS11155' ,'CLASSIC'),
('OPEL', 'Corsa-e','ZS11156' ,'CLASSIC'),
('TOYOTA', 'Land Crusier','ZS11157' ,'SUV'),
('TOYOTA', 'Prius','ZS11158' ,'CLASSIC'),
('HONDA', 'Accord','ZS11159' ,'CLASSIC'),
('MAZDA', 'CX-9','ZS11160', 'SUV');

INSERT INTO car_rent_details (cost_per_day, rent_start_date, rent_end_date, car_info_id, avaliable_to_rent) VALUES
(200.12, '12-12-2020', '22-12-2020',1, true),
(200.12, '12-12-2020', '22-12-2020',2, true),
(200.12, '12-12-2020', '22-12-2020',3, true),
(200.12, '12-12-2020', '22-12-2020',4, true),
(200.12, '12-12-2020', '22-12-2020',5, true),
(200.12, '12-12-2020', '22-12-2020',6, true),
(200.12, '12-12-2020', '22-12-2020',7, true),
(200.12, '12-12-2020', '22-12-2020',8, true),
(200.12, '12-12-2020', '22-12-2020',9, true),
(200.12, '12-12-2020', '22-12-2020',10, true),
(200.12, '12-12-2020', '22-12-2020',11, true),
(200.12, '12-12-2020', '22-12-2020',12, true),
(200.12, '12-12-2020', '22-12-2020',13, true),
(200.12, '12-12-2020', '22-12-2020',14, true),
(200.12, '12-12-2020', '22-12-2020',15, true),
(200.12, '12-12-2020', '22-12-2020',16, true),
(200.12, '12-12-2020', '22-12-2020',17, true),
(200.12, '12-12-2020', '22-12-2020',18, true),
(200.12, '12-12-2020', '22-12-2020',19, true),
(200.12, '12-12-2020', '22-12-2020',20, true),
(200.12, '12-12-2020', '22-12-2020',21, true),
(200.12, '12-12-2020', '22-12-2020',22, true),
(200.12, '12-12-2020', '22-12-2020',23, true),
(200.12, '12-12-2020', '22-12-2020',24, true),
(200.12, '12-12-2020', '22-12-2020',25, true),
(200.12, '12-12-2020', '22-12-2020',26, true),
(200.12, '12-12-2020', '22-12-2020',27, true),
(200.12, '12-12-2020', '22-12-2020',28, true),
(200.12, '12-12-2020', '22-12-2020',29, true),
(200.12, '12-12-2020', '22-12-2020',30, true),
(200.12, '12-12-2020', '22-12-2020',31, true),
(200.12, '12-12-2020', '22-12-2020',32, true),
(200.12, '12-12-2020', '22-12-2020',33, true),
(200.12, '12-12-2020', '22-12-2020',34, true),
(200.12, '12-12-2020', '22-12-2020',35, true),
(200.12, '12-12-2020', '22-12-2020',36, true),
(200.12, '12-12-2020', '22-12-2020',37, true),
(200.12, '12-12-2020', '22-12-2020',38, true),
(200.12, '12-12-2020', '22-12-2020',39, true),
(200.12, '12-12-2020', '22-12-2020',40, true),
(200.12, '12-12-2020', '22-12-2020',41, true),
(200.12, '12-12-2020', '22-12-2020',42, true),
(200.12, '12-12-2020', '22-12-2020',43, true),
(200.12, '12-12-2020', '22-12-2020',44, true),
(200.12, '12-12-2020', '22-12-2020',45, true),
(200.12, '12-12-2020', '22-12-2020',46, true),
(200.12, '12-12-2020', '22-12-2020',47, true),
(200.12, '12-12-2020', '22-12-2020',48, true),
(200.12, '12-12-2020', '22-12-2020',49, true),
(200.12, '12-12-2020', '22-12-2020',50, true),
(200.12, '12-12-2020', '22-12-2020',51, true);

INSERT INTO user(user_name, user_lastname) VALUES 
('Michael','Scott'), 
('Pam','Beesly'); 

UPDATE car_info
SET car_type = 'SUV'
WHERE car_id = 5;

-- describe

DESCRIBE car_info;

-- selecty

SELECT * FROM car_info;

SELECT * FROM user;