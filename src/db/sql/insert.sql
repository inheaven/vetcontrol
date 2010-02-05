INSERT INTO `generator`(`generatorName`, `generatorValue`) VALUES ('books', 0);

INSERT INTO `locales`(`language`, isSystem) VALUES ('ru', 1);
INSERT INTO `locales`(`language`) VALUES ('en');

INSERT INTO `stringculture`(`id`, `locale`, `value`) VALUES (1, 'ru', 'Государственный комитет ветеринарной медицины'),
                                    (2, 'ru', 'Одеський РСДВСКН'),
                                    (3, 'ru', 'Апарат управління Одеськой РСДВСКН'),
                                    (4, 'ru', 'Арцизький ПДВСКН'),
                                    (5, 'ru', 'Б-Дністровський ПДВСКН'),
                                    (6, 'ru', 'Березінський ПДВСКН'),
                                    (7, 'ru', 'Болградський ПДВСКН'),
                                    (8, 'ru', 'Велико-Михайлівський ПДВСКН'),
                                    (9, 'ru', 'Вознесенський ПДВСКН'),
                                    (10, 'ru', 'Звенігородський ПДВСКН'),
                                    (11, 'ru', 'Знам\'янський ПДВСКН'),
                                    (12, 'ru', 'Ізмаїльський ПДВСКН'),
                                    (13, 'ru', 'Іллічівський ПДВСКН'),
                                    (14, 'ru', 'Каховський ПДВСКН'),
                                    (15, 'ru', 'Кілійський ПДВСКН'),
                                    (16, 'ru', 'Кіровоградський ПДВСКН'),
                                    (17, 'ru', 'Кодимський ПДВСКН'),
                                    (18, 'ru', 'Котовський ПДВСКН'),
                                    (19, 'ru', 'Красно-Окнянський ПДВСКН'),
                                    (20, 'ru', 'Миколаївський ПДВСКН'),
                                    (21, 'ru', 'Одеський ПДВСКН'),
                                    (22, 'ru', 'Первомайский ПДВСКН'),
                                    (23, 'ru', 'Роздільнянський ПДВСКН'),
                                    (24, 'ru', 'Ренійський ПДВСКН'),
                                    (25, 'ru', 'Скадовський ПДВСКН'),
                                    (26, 'ru', 'Старокозацький ПДВСКН'),
                                    (27, 'ru', 'Вапнярський ПДВСКН'),
                                    (28, 'ru', 'Удобнянський ПДВСКН'),
                                    (29, 'ru', 'Уманський ПДВСКН'),
                                    (30, 'ru', 'Херсонський ПДВСКН'),
                                    (31, 'ru', 'Черкаський ПДВСКН'),
                                    (32, 'ru', 'Шевченківський ПДВСКН'),
                                    (33, 'ru', 'Южненський ПДВСКН');


INSERT INTO `department`(`name`, `parent_id`) VALUES (1, NULL),
                                                            (2, 1),
                                                            (3, 2),
                                                            (4, 2),
                                                            (5, 2),
                                                            (6, 2),
                                                            (7, 2),
                                                            (8, 2),
                                                            (9, 2),
                                                            (10, 2),
                                                            (11, 2),
                                                            (12, 2),
                                                            (13, 2),
                                                            (14, 2),
                                                            (15, 2),
                                                            (16, 2),
                                                            (17, 2),
                                                            (18, 2),
                                                            (19, 2),
                                                            (20, 2),
                                                            (21, 2),
                                                            (22, 2),
                                                            (23, 2),
                                                            (24, 2),
                                                            (25, 2),
                                                            (26, 2),
                                                            (27, 2),
                                                            (28, 2),
                                                            (29, 2),
                                                            (30, 2),
                                                            (31, 2),
                                                            (32, 2),
                                                            (33, 2);

UPDATE `generator` SET `generatorValue` = 33 WHERE `generatorName` = 'books';

