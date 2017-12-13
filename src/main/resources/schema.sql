CREATE TABLE user
(
  id       INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
  email    VARCHAR(50)                        NOT NULL UNIQUE,
  password VARCHAR(50)                        NOT NULL
);

CREATE TABLE notebook
(
  id      INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
  user_id INTEGER                            NOT NULL,
  name    VARCHAR                            NOT NULL,
  CONSTRAINT notebook_user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE note
(
  id          INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name        VARCHAR(50)                        NOT NULL,
  body        VARCHAR,
  notebook_id INTEGER                            NOT NULL,
  CONSTRAINT note_notebook_id_fk FOREIGN KEY (notebook_id) REFERENCES notebook (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE tag
(
  id   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR NOT NULL UNIQUE
);

CREATE TABLE notes_tags
(
  note_id INTEGER NOT NULL,
  tag_id  INTEGER NOT NULL,
  CONSTRAINT notes_tags_note_id_fk FOREIGN KEY (note_id) REFERENCES note (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT notes_tags_tag_id_fk FOREIGN KEY (tag_id) REFERENCES tag (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- CREATE TABLE users_tags
-- (
--   user_id INTEGER NOT NULL,
--   tag_id  INTEGER NOT NULL,
--   CONSTRAINT users_tags_user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE,
--   CONSTRAINT notes_tags_tag2_id_fk FOREIGN KEY (tag_id) REFERENCES tag (id) ON DELETE CASCADE ON UPDATE CASCADE
-- );
