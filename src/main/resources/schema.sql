--
-- Таблица организаций
--
CREATE TABLE IF NOT EXISTS Organization (
  id        INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version   INTEGER      NOT NULL,
  name      VARCHAR(255) NOT NULL,
  full_name VARCHAR(255) NOT NULL,
  inn       VARCHAR(12) UNIQUE,
  kpp       VARCHAR(9),
  address   VARCHAR(255),
  phone     VARCHAR(16),
  is_active BOOLEAN      NOT NULL
);

--
-- Таблица оффисов
--
CREATE TABLE IF NOT EXISTS Office (
  id              INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version         INTEGER      NOT NULL,
  address         VARCHAR(50)  NOT NULL,
  organization_id INT UNSIGNED NOT NULL,
  name            VARCHAR(255) NOT NULL,
  phone           VARCHAR(16),
  is_active       BOOLEAN
);

--
-- Таблица пользователей
--
CREATE TABLE IF NOT EXISTS Employee (
  id            INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  doc_id        INT UNSIGNED NOT NULL,
  country_id    INT UNSIGNED NOT NULL,
  version       INTEGER      NOT NULL,
  office_id     INT UNSIGNED NOT NULL,
  first_name    VARCHAR(255) NOT NULL,
  second_name   VARCHAR(255) NOT NULL,
  middle_name   VARCHAR(255) NOT NULL,
  position      VARCHAR(255),
  phone         VARCHAR(16),
  is_identified BOOLEAN
);

--
-- Таблица активации пользователей
--
CREATE TABLE IF NOT EXISTS User_Activation (
  id                   INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  registration_data_id INT UNSIGNED NOT NULL,
  message_hash         VARCHAR(255) NOT NULL,
  version              INTEGER      NOT NULL
);

--
-- Таблица регистрационных данных
--
CREATE TABLE IF NOT EXISTS Registration_Data (
  id       INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  login    VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  name     VARCHAR(255) NOT NULL,
  version  INTEGER      NOT NULL
);

--
-- Таблица сообщений
--
CREATE TABLE Notification (
  id      INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  address VARCHAR(255) NOT NULL,
  massage VARCHAR(255) NOT NULL,
  version INTEGER      NOT NULL
);

--
-- Таблица документов
--
CREATE TABLE IF NOT EXISTS Document (
  id          INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  doc_type_id INT UNSIGNED NOT NULL,
  version     INTEGER      NOT NULL,
  number      INTEGER,
  date        VARCHAR(9)   NOT NULL
);

--
-- Таблица типов документов
--
CREATE TABLE IF NOT EXISTS Doc_Type (
  id      INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version INTEGER      NOT NULL,
  code    VARCHAR(3)   NOT NULL,
  name    VARCHAR(255) NOT NULL
);

--
-- Таблица гражданств
--
CREATE TABLE IF NOT EXISTS Country (
  id      INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  version INTEGER      NOT NULL,
  code    VARCHAR(3),
  name    VARCHAR(255) NOT NULL
);

CREATE INDEX IX_Organization_Name
  ON Organization (name);
CREATE INDEX IX_Organization_Full_Name
  ON Organization (full_name);
CREATE INDEX IX_Organization_INN
  ON Organization (inn);
CREATE INDEX IX_Office_Organization_Id
  ON Office (organization_id);
CREATE INDEX IX_Office_Name
  ON Office (name);
CREATE INDEX IX_User_First_Name
  ON User (first_name);
CREATE INDEX IX_User_Second_Name
  ON User (second_name);
CREATE INDEX IX_User_Phone
  ON User (phone);
CREATE INDEX IX_User_Doc_Id
  ON User (doc_id);
CREATE INDEX IX_User_Office_Id
  ON User (office_id);
CREATE INDEX IX_User_Country_Id
  ON User (country_id);
CREATE INDEX IX_User_Activation_User_Id
  ON User_Activation (registration_data_id);
CREATE INDEX IX_Document_Doc_Type_Id
  ON Document (doc_type_id);
ALTER TABLE Office
  ADD FOREIGN KEY (organization_id) REFERENCES Organization (id);
ALTER TABLE User
  ADD FOREIGN KEY (office_id) REFERENCES Office (id);
ALTER TABLE User
  ADD FOREIGN KEY (doc_id) REFERENCES Document (id);
ALTER TABLE User
  ADD FOREIGN KEY (country_id) REFERENCES Country (id);
ALTER TABLE User_Activation
  ADD FOREIGN KEY (registration_data_id) REFERENCES User (id);
ALTER TABLE Document
  ADD FOREIGN KEY (doc_type_id) REFERENCES Doc_Type (id);