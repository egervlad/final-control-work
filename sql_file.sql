CREATE SCHEMA `HumanFriends`;

USE HumanFriends;

/*
- Создать таблицы, соответствующие иерархии из вашей диаграммы классов.
*/
DROP TABLE IF EXISTS animal_types;
CREATE TABLE animal_types (
    id SERIAL,
    name VARCHAR(100)
);

DROP TABLE IF EXISTS animals;
CREATE TABLE animals (
    id SERIAL,
    name VARCHAR(100),
    animal_types_id BIGINT UNSIGNED,
    FOREIGN KEY (animal_types_id) REFERENCES animal_types(id)
);

DROP TABLE IF EXISTS cat;
CREATE TABLE cat (
    id SERIAL,
    name VARCHAR(30),
    commands TEXT,
    birth_day DATE,
    animal_id BIGINT UNSIGNED,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

DROP TABLE IF EXISTS dog;
CREATE TABLE dog (
    id SERIAL,
    name VARCHAR(30),
    commands TEXT,
    birth_day DATE,
    animal_id BIGINT UNSIGNED,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

DROP TABLE IF EXISTS hamster;
CREATE TABLE hamster (
    id SERIAL,
    name VARCHAR(30),
    commands TEXT,
    birth_day DATE,
    animal_id BIGINT UNSIGNED,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

DROP TABLE IF EXISTS horse;
CREATE TABLE horse (
    id SERIAL,
    name VARCHAR(30),
    commands TEXT,
    birth_day DATE,
    animal_id BIGINT UNSIGNED,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

DROP TABLE IF EXISTS camel;
CREATE TABLE camel (
    id SERIAL,
    name VARCHAR(30),
    commands TEXT,
    birth_day DATE,
    animal_id BIGINT UNSIGNED,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

DROP TABLE IF EXISTS donkey;
CREATE TABLE donkey (
    id SERIAL,
    name VARCHAR(30),
    commands TEXT,
    birth_day DATE,
    animal_id BIGINT UNSIGNED,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

/*
- Заполнить таблицы данными о животных, их командах и датами рождения.
*/
INSERT INTO `animal_types` (`name`)
VALUES ('Pets'),
('Pack animals');

INSERT INTO animals (name, animal_types_id)
VALUES ('Cat', 1),
('Dog', 1),
('Hamster', 1),
('Horse', 2),
('Camel', 2),
('Donkey', 2);

INSERT INTO cat (name, commands, birth_day, animal_id) VALUES
	('Barsik', 'Meow, Sit, Pounce', '2021-01-01', 1),
	('Marsik', 'Meow, Sit, Pounce, Scratch', '2019-12-10', 1),
    ('Pusik', 'Meow, Run', '2020-02-02', 1),
    ('Mursik', 'Meow, Scratch, Jump', '2022-03-03', 1);

INSERT INTO dog (name, commands, birth_day, animal_id) VALUES
	('Fido', 'Sit, Stay, Fetch', '2020-01-01', 2),
	('Buddy', 'Sit, Paw, Bark', '2018-12-10', 2),
    ('Bella', 'Sit, Stay, Roll', '2019-02-02', 2);

INSERT INTO hamster (name, commands, birth_day, animal_id) VALUES
	('Hammy', 'Roll, Hide', '2021-03-10', 3),
	('Peanut', 'Roll, Spin', '2021-12-10', 3);

INSERT INTO horse (name, commands, birth_day, animal_id) VALUES
	('Thunder', 'Trot, Canter, Gallop', '2015-01-01', 4),
	('Storm', 'Trot, Canter', '2014-12-10', 4),
    ('Blaze', 'Trot, Jump, Gallop', '2016-02-02', 4);

INSERT INTO camel (name, commands, birth_day, animal_id) VALUES
	('Sandy', 'Walk, Carry Load', '2015-11-01', 5),
	('Dune', 'Walk, Sit', '2018-12-12', 5),
    ('Sahara', 'Walk, Run', '2015-08-02', 5);

INSERT INTO donkey (name, commands, birth_day, animal_id) VALUES
	('Eeyore', 'Walk, Carry Load, Bray', '2017-09-01', 6),
	('Burro', 'Walk, Bray, Kick', '2019-01-10', 6);


ALTER TABLE cat ADD COLUMN table_name VARCHAR(30) NOT NULL DEFAULT 'Cat';
ALTER TABLE dog ADD COLUMN table_name VARCHAR(30) NOT NULL DEFAULT 'Dog';
ALTER TABLE hamster ADD COLUMN table_name VARCHAR(30) NOT NULL DEFAULT 'Hamster';
ALTER TABLE horse ADD COLUMN table_name VARCHAR(30) NOT NULL DEFAULT 'Horse';
ALTER TABLE camel ADD COLUMN table_name VARCHAR(30) NOT NULL DEFAULT 'Camel';
ALTER TABLE donkey ADD COLUMN table_name VARCHAR(30) NOT NULL DEFAULT 'Donkey';

/*
 - Удалить записи о верблюдах и объединить таблицы лошадей и ослов.
*/
TRUNCATE camel;

DROP TABLE IF EXISTS horse_donkey;
CREATE TABLE horse_donkey (
    id SERIAL,
    name VARCHAR(30),
    commands TEXT,
    birth_day DATE,
    animal_id BIGINT UNSIGNED,
    table_name VARCHAR(30) NOT NULL DEFAULT 'horse_donkey',
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

INSERT INTO horse_donkey (name, commands, birth_day, animal_id)
SELECT name, commands, birth_day, animal_id FROM horse
UNION
SELECT name, commands, birth_day, animal_id FROM donkey;


/*
- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.
*/
DROP TABLE IF EXISTS young_animal;
CREATE TABLE young_animal (
    id SERIAL,
    name VARCHAR(30),
    commands TEXT,
    birth_day DATE,
    animal_id BIGINT UNSIGNED,
    table_name VARCHAR(30) NOT NULL DEFAULT 'young_animal',
    age_at_month INT NOT NULL DEFAULT 0,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);


INSERT INTO young_animal (name, commands, birth_day, animal_id, age_at_month)
SELECT name, commands, birth_day, animal_id, TIMESTAMPDIFF(month, birth_day, NOW()) AS age_at_month FROM cat WHERE TIMESTAMPDIFF(year, birth_day, NOW()) BETWEEN 1 AND 3
UNION
SELECT name, commands, birth_day, animal_id, TIMESTAMPDIFF(month, birth_day, NOW()) AS age_at_month FROM dog WHERE TIMESTAMPDIFF(year, birth_day, NOW()) BETWEEN 1 AND 3
UNION
SELECT name, commands, birth_day, animal_id, TIMESTAMPDIFF(month, birth_day, NOW()) AS age_at_month FROM hamster WHERE TIMESTAMPDIFF(year, birth_day, NOW()) BETWEEN 1 AND 3
UNION
SELECT name, commands, birth_day, animal_id, TIMESTAMPDIFF(month, birth_day, NOW()) AS age_at_month FROM camel WHERE TIMESTAMPDIFF(year, birth_day, NOW()) BETWEEN 1 AND 3
UNION
SELECT name, commands, birth_day, animal_id, TIMESTAMPDIFF(month, birth_day, NOW()) AS age_at_month FROM horse WHERE TIMESTAMPDIFF(year, birth_day, NOW()) BETWEEN 1 AND 3
UNION
SELECT name, commands, birth_day, animal_id, TIMESTAMPDIFF(month, birth_day, NOW()) AS age_at_month FROM donkey WHERE TIMESTAMPDIFF(year, birth_day, NOW()) BETWEEN 1 AND 3;

/*
 - Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.
*/
DROP TABLE IF EXISTS general_table;
CREATE TABLE general_table (
    id SERIAL,
    name VARCHAR(30),
    commands TEXT,
    birth_day DATE,
    animal_id BIGINT UNSIGNED,
    age_at_month INT NOT NULL DEFAULT 0,
    table_name VARCHAR(30) NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

INSERT INTO general_table (name, commands, birth_day, animal_id, age_at_month, table_name)
SELECT name, commands, birth_day, animal_id, TIMESTAMPDIFF(month, birth_day, NOW()) AS age_at_month, table_name FROM cat
UNION ALL
SELECT name, commands, birth_day, animal_id, TIMESTAMPDIFF(month, birth_day, NOW()) AS age_at_month, table_name FROM dog
UNION ALL
SELECT name, commands, birth_day, animal_id, TIMESTAMPDIFF(month, birth_day, NOW()) AS age_at_month, table_name FROM hamster
UNION ALL
SELECT name, commands, birth_day, animal_id, TIMESTAMPDIFF(month, birth_day, NOW()) AS age_at_month, table_name FROM camel
UNION ALL
SELECT name, commands, birth_day, animal_id, TIMESTAMPDIFF(month, birth_day, NOW()) AS age_at_month, table_name FROM horse
UNION ALL
SELECT name, commands, birth_day, animal_id, TIMESTAMPDIFF(month, birth_day, NOW()) AS age_at_month, table_name FROM donkey
UNION ALL
SELECT name, commands, birth_day, animal_id, TIMESTAMPDIFF(month, birth_day, NOW()) AS age_at_month, table_name FROM horse_donkey
UNION ALL
SELECT name, commands, birth_day, animal_id, age_at_month, table_name FROM young_animal;