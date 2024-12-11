drop database if exists apiAutos;
Create database apiAutos;
use apiAutos;
CREATE TABLE   Autos(
                           id int auto_increment PRIMARY KEY,
                           marca VARCHAR(50) NOT NULL ,
                           color VARCHAR(50) NOT NULL


);


INSERT INTO Autos  VALUES
                          (1, 'renault', 'rojo'),
                          (2, 'ford', 'blanco'),
                          (3, 'mazda', 'gris'),
                          (4, 'dacia', 'negro');