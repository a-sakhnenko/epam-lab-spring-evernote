INSERT INTO user
SET email = 'user1', password = '1';
INSERT INTO user
SET email = 'user2', password = '2';
INSERT INTO user
SET email = 'user3', password = '3';
INSERT INTO user
SET email = 'user4', password = '4';
INSERT INTO user
SET email = 'user5', password = '5';

INSERT INTO notebook
SET name = 'notebook1', user_id = 1;
INSERT INTO notebook
SET name = 'notebook2', user_id = 1;
INSERT INTO notebook
SET name = 'notebook3', user_id = 1;
INSERT INTO notebook
SET name = 'notebook4', user_id = 2;
INSERT INTO notebook
SET name = 'notebook5', user_id = 2;
INSERT INTO notebook
SET name = 'notebook6', user_id = 3;
INSERT INTO notebook
SET name = 'notebook7', user_id = 4;
INSERT INTO notebook
SET name = 'notebook8', user_id = 4;

INSERT INTO note
SET name = 'note01', body = 'Lorem ipsum 01', notebook_id = 1;
INSERT INTO note
SET name = 'note02', body = 'Lorem ipsum 02', notebook_id = 1;
INSERT INTO note
SET name = 'note03', body = 'Lorem ipsum 03', notebook_id = 1;
INSERT INTO note
SET name = 'note04', body = 'Lorem ipsum 04', notebook_id = 2;
INSERT INTO note
SET name = 'note05', body = 'Lorem ipsum 05', notebook_id = 3;
INSERT INTO note
SET name = 'note06', body = 'Lorem ipsum 06', notebook_id = 3;
INSERT INTO note
SET name = 'note07', body = 'Lorem ipsum 07', notebook_id = 3;
INSERT INTO note
SET name = 'note08', body = 'Lorem ipsum 08', notebook_id = 4;
INSERT INTO note
SET name = 'note09', body = 'Lorem ipsum 09', notebook_id = 4;
INSERT INTO note
SET name = 'note10', body = '', notebook_id = 5;
INSERT INTO note
SET name = 'note11', body = '', notebook_id = 6;
INSERT INTO note
SET name = 'note12', body = '', notebook_id = 7;
INSERT INTO note
SET name = 'note13', body = '', notebook_id = 7;

INSERT INTO tag
SET name = 'tag1';
INSERT INTO tag
SET name = 'tag2';
INSERT INTO tag
SET name = 'tag3';
INSERT INTO tag
SET name = 'tag4';
INSERT INTO tag
SET name = 'tag5';
INSERT INTO tag
SET name = 'tag6';
INSERT INTO tag
SET name = 'tag7';

INSERT INTO notes_tags
SET note_id = 1, tag_id = 1;
INSERT INTO notes_tags
SET note_id = 1, tag_id = 2;
INSERT INTO notes_tags
SET note_id = 1, tag_id = 3;
INSERT INTO notes_tags
SET note_id = 2, tag_id = 4;
INSERT INTO notes_tags
SET note_id = 3, tag_id = 5;
INSERT INTO notes_tags
SET note_id = 4, tag_id = 6;
INSERT INTO notes_tags
SET note_id = 5, tag_id = 7;
INSERT INTO notes_tags
SET note_id = 6, tag_id = 7;
INSERT INTO notes_tags
SET note_id = 7, tag_id = 7;
INSERT INTO notes_tags
SET note_id = 8, tag_id = 3;
INSERT INTO notes_tags
SET note_id = 9, tag_id = 2;
INSERT INTO notes_tags
SET note_id = 2, tag_id = 2;
INSERT INTO notes_tags
SET note_id = 4, tag_id = 6;

INSERT INTO users_tags
SET user_id = 1, tag_id = 1;
INSERT INTO users_tags
SET user_id = 1, tag_id = 2;
INSERT INTO users_tags
SET user_id = 1, tag_id = 3;
INSERT INTO users_tags
SET user_id = 1, tag_id = 4;
INSERT INTO users_tags
SET user_id = 1, tag_id = 5;
INSERT INTO users_tags
SET user_id = 1, tag_id = 6;
INSERT INTO users_tags
SET user_id = 1, tag_id = 7;
INSERT INTO users_tags
SET user_id = 2, tag_id = 2;
INSERT INTO users_tags
SET user_id = 2, tag_id = 3;


