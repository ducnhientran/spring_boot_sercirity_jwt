INSERT INTO user(id, username, password, email, status, created_by, updated_by) VALUES(1,'admin','$2y$12$P2Hr.vji2ON6NRrowpJjQe.cxbagJmLzWFwykyZeVCD1rf/W44dGS','admin@gmail.com','ACTIVE', 'SYSTEM', 'SYSTEM');
INSERT INTO user(id, username, password, email, status, created_by, updated_by) VALUES(2,'user','$2a$10$ZScR0yl0WfUJvTYOwPoXMeE2pgQy4GSJ87hlrahBi8mr9nzwSL8ie','user@gmail.com','ACTIVE', 'SYSTEM', 'SYSTEM');

INSERT INTO user_role(id,user_id, role_id, created_by, updated_by) VALUES(1, 1, 1, 'SYSTEM', 'SYSTEM');
INSERT INTO user_role(id,user_id, role_id, created_by, updated_by) VALUES(2, 1, 2, 'SYSTEM', 'SYSTEM');
INSERT INTO user_role(id,user_id, role_id, created_by, updated_by) VALUES(3, 2, 2, 'SYSTEM', 'SYSTEM');
