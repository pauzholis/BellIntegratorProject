--
-- Таблица организаций
--
CREATE TABLE IF NOT EXISTS Organization (
  id        INTEGER PRIMARY KEY AUTO_INCREMENT
  COMMENT 'Идентификатор организации',
  version   INTEGER      NOT NULL
  COMMENT 'Служебное поле Hibernate',
  name      VARCHAR(255) NOT NULL
  COMMENT 'Сокращенное наименование организации',
  full_name VARCHAR(255) NOT NULL
  COMMENT 'Полное наименование организации',
  inn       NUMERIC(10) UNSIGNED UNIQUE
  COMMENT 'ИНН организации',
  kpp       NUMERIC(9) UNSIGNED
  COMMENT 'КПП организации',
  address   VARCHAR(255)
  COMMENT 'Адрес организации',
  phone     INTEGER
  COMMENT 'Телефон организации',
  isActive  BOOLEAN
  COMMENT 'Статус активности организации'
);

--
-- Таблица оффисов
--
CREATE TABLE IF NOT EXISTS Office (
  id              INTEGER PRIMARY KEY AUTO_INCREMENT
  COMMENT 'Идентификатор оффиса',
  version         INTEGER      NOT NULL
  COMMENT 'Служебное поле Hibernate',
  address         VARCHAR(50)  NOT NULL
  COMMENT 'Адрес оффиса',
  organization_id INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор организации',
  name            VARCHAR(255) NOT NULL
  COMMENT 'Наименование оффиса',
  phone           INTEGER
  COMMENT 'Телефон оффиса',
  isActive        BOOLEAN
  COMMENT 'Статус активности оффиса'
);

--
-- Таблица пользователей
--
CREATE TABLE IF NOT EXISTS User (
  id             INTEGER PRIMARY KEY AUTO_INCREMENT
  COMMENT 'Идентификатор пользователя',
  doc_id         INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор документа удостоверяющего личность',
  citizenship_id INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор записи о гражданстве',
  version        INTEGER      NOT NULL
  COMMENT 'Служебное поле Hibernate',
  office_id      INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор оффиса',
  first_name     VARCHAR(255) NOT NULL
  COMMENT 'Имя пользователя',
  second_name    VARCHAR(255) NOT NULL
  COMMENT 'Фамилия пользователя',
  middle_name    VARCHAR(255) NOT NULL
  COMMENT 'Отчество пользователя',
  position       VARCHAR(255)
  COMMENT 'Должность пользователя',
  phone          INTEGER
  COMMENT 'Номер телефона пользователя',
  isIdentified   BOOLEAN
  COMMENT 'Статус идентификации пользователя'
);

--
-- Таблица активации пользователей
--
CREATE TABLE IF NOT EXISTS User_Activation (
  id      INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор активации',
  user_id INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор пользователя',
  hash    VARCHAR(255) NOT NULL
  COMMENT 'Строка активации пользователя',
  version INTEGER      NOT NULL
  COMMENT 'Служебное поле Hibernate'
);

--
-- Таблица регистрационных данных
--
CREATE TABLE IF NOT EXISTS Registration_Data (
  id       INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор регистрационных данных',
  login    VARCHAR(255) NOT NULL
  COMMENT 'Логин',
  password VARCHAR(255) NOT NULL
  COMMENT 'Пароль',
  name     VARCHAR(255) NOT NULL
  COMMENT 'Имя регистрирующегося пользователя',
  version  INTEGER      NOT NULL
  COMMENT 'Служебное поле Hibernate'
);

--
-- Таблица сообщений
--
CREATE TABLE Notification (
  id      INT UNSIGNED          NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT 'Идентификатор сообщения',
  channel ENUM ('EMAIL', 'SMS') NOT NULL
  COMMENT 'Канал для отправки сообщения',
  address  VARCHAR(255)          NOT NULL
  COMMENT 'Адресс электронной почты',
  massage VARCHAR(255)          NOT NULL
  COMMENT 'Текст сообщения',
  version INTEGER               NOT NULL
  COMMENT 'Служебное поле Hibernate'
);

--
-- Таблица документов
--
CREATE TABLE IF NOT EXISTS Document (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT
  COMMENT 'Идентификатор документа',
  doc_type_id INT UNSIGNED NOT NULL
  COMMENT 'Идентификатор типа документа',
  version     INTEGER      NOT NULL
  COMMENT 'Служебное поле Hibernate',
  number      INTEGER
  COMMENT 'Номер документа',
  date        DATE         NOT NULL
  COMMENT 'Дата выдачи документа'
);

--
-- Таблица типов документов
--
CREATE TABLE IF NOT EXISTS Doc_Type (
  id      INTEGER PRIMARY KEY AUTO_INCREMENT
  COMMENT 'Идентификатор типа документа',
  version INTEGER      NOT NULL
  COMMENT 'Служебное поле Hibernate',
  code    INTEGER
  COMMENT 'Код документа',
  name    VARCHAR(255) NOT NULL
  COMMENT 'Наименование документа'
);

--
-- Таблица гражданств
--
CREATE TABLE IF NOT EXISTS Citizenship (
  id      INTEGER PRIMARY KEY AUTO_INCREMENT
  COMMENT 'Идентификатор записи',
  version INTEGER      NOT NULL
  COMMENT 'Служебное поле Hibernate',
  code    INTEGER
  COMMENT 'Код общероссийского класификатора стран мира',
  name    VARCHAR(255) NOT NULL
  COMMENT 'Наименование страны'
);

CREATE INDEX IX_Organization_Id
  ON Organization (id);
CREATE INDEX IX_Organization_Name
  ON Organization (name);
CREATE INDEX IX_Organization_Full_Name
  ON Organization (full_name);
CREATE INDEX IX_Organization_INN
  ON Organization (inn);
CREATE INDEX IX_Office_Id
  ON Office (id);
CREATE INDEX IX_Office_Organization_Id
  ON Office (organization_id);
CREATE INDEX IX_Office_Name
  ON Office (name);
CREATE INDEX IX_User_Id
  ON User (id);
CREATE INDEX IX_User_First_Name
  ON User (first_name);
CREATE INDEX IX_User_Second_Name
  ON User (second_name);
CREATE INDEX IX_User_Phone
  ON User (phone);
ALTER TABLE Office
  ADD FOREIGN KEY (organization_id) REFERENCES Organization (id);
ALTER TABLE User
  ADD FOREIGN KEY (office_id) REFERENCES Office (id);
ALTER TABLE User
  ADD FOREIGN KEY (doc_id) REFERENCES Document (id);
ALTER TABLE User
  ADD FOREIGN KEY (citizenship_id) REFERENCES Citizenship (id);
ALTER TABLE User_Activation
  ADD FOREIGN KEY (user_id) REFERENCES User (id);
ALTER TABLE Document
  ADD FOREIGN KEY (doc_type_id) REFERENCES Doc_Type (id);