/*7.Создадим базу данных "Друзья человека" */
DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE human_friends;

USE human_friends;

/*8.Создадим таблицы согласно иерархии на диаграмме */
DROP TABLE IF EXISTS animals;
CREATE TABLE animals (
	animal_id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    birth_date DATE
);

DROP TABLE IF EXISTS pets;
CREATE TABLE pets (
	pet_id INT PRIMARY KEY AUTO_INCREMENT,
    animal_id INT,
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id)
);

DROP TABLE IF EXISTS pack_animals;
CREATE TABLE pack_animals (
	pa_id INT PRIMARY KEY AUTO_INCREMENT,
    animal_id INT,
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id)
);

DROP TABLE IF EXISTS dogs;
CREATE TABLE dogs (
	dog_id INT PRIMARY KEY AUTO_INCREMENT,
    pet_id INT,
    FOREIGN KEY (pet_id) REFERENCES pets(pet_id)
);

DROP TABLE IF EXISTS cats;
CREATE TABLE cats (
	cat_id INT PRIMARY KEY AUTO_INCREMENT,
    pet_id INT,
    FOREIGN KEY (pet_id) REFERENCES pets(pet_id)
);

DROP TABLE IF EXISTS hamsters;
CREATE TABLE hamsters (
	hamster_id INT PRIMARY KEY AUTO_INCREMENT,
    pet_id INT,
    FOREIGN KEY (pet_id) REFERENCES pets(pet_id)
);

DROP TABLE IF EXISTS horses;
CREATE TABLE horses (
	horse_id INT PRIMARY KEY AUTO_INCREMENT,
    pa_id INT,
    FOREIGN KEY (pa_id) REFERENCES pack_animals(pa_id)
);

DROP TABLE IF EXISTS camels;
CREATE TABLE camels (
	camel_id INT PRIMARY KEY AUTO_INCREMENT,
    pa_id INT,
    FOREIGN KEY (pa_id) REFERENCES pack_animals(pa_id)
);

DROP TABLE IF EXISTS donkeys;
CREATE TABLE donkeys (
	donkey_id INT PRIMARY KEY AUTO_INCREMENT,
    pa_id INT,
    FOREIGN KEY (pa_id) REFERENCES pack_animals(pa_id)
);


/*9.Заполним таблицы данными */
INSERT INTO Animals (animal_id, animal_name, commands, birth_date)
VALUES 
	(1, 'Рекс', 'Сидеть, Умри', '2020-02-03'),
    (2, 'Шарик', 'Ко мне, Сидеть, Голос, Лежать', '2022-06-10'),
    (3, 'Тузик', 'Сидеть, Дай лапу, Лежать', '2019-02-07'),
    (4, 'Барсик', 'Ко мне', '2019-10-12'),
    (5, 'Мурка', 'Ко мне, Повернись', '2022-05-1'),
    (6, 'Кеша', 'Ко мне, Голос', '2023-05-25'),    
    (7, 'Гоша', 'Ко мне, умри', '2020-04-28'),
    (8, 'Стёпа', 'Ко мне', '2021-10-02'),
    (9, 'Маша', 'Ко мне', '2022-07-09'),
    (10, 'Зорька', 'Ко мне, Стоять, Поклон', '2018-05-20'),
    (11, 'Бельчик', 'Ко мне, Стоять', '2019-02-03'),
    (12, 'Плотва', 'Ко мне, Шевелись', '2020-07-12'),
    (13, 'Вася', 'Сидеть, Стоять', '2019-02-03'),
    (14, 'Малышка', 'Сидеть', '2020-06-03'),
    (15, 'Сеня', 'Ко мне', '2018-10-15'),
    (16, 'Толик', 'Ко мне, Стоять', '2019-05-14'),
    (17, 'Милка', 'Ко мне', '2020-08-04'),
    (18, 'Гоша', 'Ко мне', '2019-09-17');
    
INSERT INTO pets (animal_id)
VALUES
    (1), (2), (3), (4), (5), (6), (7), (8), (9);
    
INSERT INTO pack_animals (animal_id)
VALUES
    (10), (11), (12), (13), (14), (15), (16), (17), (18);
    
INSERT INTO dogs (pet_id)
VALUES
    (1), (2), (3);
    
INSERT INTO cats (pet_id)
VALUES
    (4), (5), (6);
    
INSERT INTO hamsters (pet_id)
VALUES
    (7), (8),(9);
    
INSERT INTO horses (pa_id)
VALUES
    (1), (2), (3);
    
INSERT INTO camels (pa_id)
VALUES
    (4), (5), (6);
    
INSERT INTO donkeys (pa_id)
VALUES
    (7), (8),(9);

/*10. Удалим записи из таблицы "верблюды" и объеденим таблицы "лошади" и "ослы"*/    
DELETE FROM camels;

DROP TABLE IF EXISTS horses_donkeys;
CREATE TABLE horses_donkeys (horse_donkey_id INT PRIMARY KEY AUTO_INCREMENT) 
SELECT pa_id
FROM horses 
UNION 
SELECT pa_id
FROM donkeys;

/*11. Создадим таблицу "мололдые животные" и занесём в неё животных от 1 года до 3 лет с указанием возраста в месяцах*/

CREATE TABLE young_animal AS
SELECT animal_id, TIMESTAMPDIFF(MONTH, birth_date, CURRENT_DATE()) AS age_in_months
FROM animals
WHERE birth_date > DATE_SUB(CURRENT_DATE(), INTERVAL 3 YEAR)
AND birth_date < DATE_SUB(CURRENT_DATE(), INTERVAL 1 YEAR);

/*12. Объеденим данные в одну таблицу с указанием принадлежности к старым таблицам.*/

SELECT animal_name, commands, birth_date, p.group_animal, p.type_animal
FROM animals AS a
JOIN 
(SELECT
    'pets' AS group_animal,
    c.type_animal,
    animal_id
FROM
    pets AS p
JOIN 
(SELECT
    'cats' AS type_animal,
    cat_id,
    pet_id
FROM
    cats
UNION ALL
SELECT
    'dogs' AS type,
    dog_id,
    pet_id
FROM
    dogs
UNION ALL
SELECT
    'hamsters' AS type,
    hamster_id,
    pet_id
FROM
    hamsters) AS c ON p.pet_id = c.pet_id
UNION    
SELECT
    'pack_animals' AS group_animal,
    h.type_animal,
    animal_id
FROM
    pack_animals AS p
JOIN 
(SELECT 
	'horses_and_monkeys' AS type_animal,
    horse_donkey_id,
    pa_id
FROM
	horses_donkeys) AS h ON p.pa_id = h.pa_id) AS p ON a.animal_id = p.animal_id;
    