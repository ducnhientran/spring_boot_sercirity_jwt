INSERT INTO role(id, name, created_by, updated_by) VALUES (1, 'ADMIN', 'SYSTEM', 'SYSTEM');
INSERT INTO role(id, name, created_by, updated_by) VALUES (2, 'USER', 'SYSTEM', 'SYSTEM');

INSERT INTO role_permission(permission_code, role_id, created_by, updated_by) VALUES('ADMIN_CREATE', 1, 'SYSTEM', 'SYSTEM');
INSERT INTO role_permission(permission_code, role_id, created_by, updated_by) VALUES('ADMIN_LIST', 1, 'SYSTEM', 'SYSTEM');
INSERT INTO role_permission(permission_code, role_id, created_by, updated_by) VALUES('ADMIN_DETAIL', 1, 'SYSTEM', 'SYSTEM');
INSERT INTO role_permission(permission_code, role_id, created_by, updated_by) VALUES('ADMIN_UPDATE', 1, 'SYSTEM', 'SYSTEM');
INSERT INTO role_permission(permission_code, role_id, created_by, updated_by) VALUES('ADMIN_DELETE', 1, 'SYSTEM', 'SYSTEM');

INSERT INTO role_permission(permission_code, role_id, created_by, updated_by) VALUES('USER_CREATE', 2, 'SYSTEM', 'SYSTEM');
INSERT INTO role_permission(permission_code, role_id, created_by, updated_by) VALUES('USER_LIST', 2, 'SYSTEM', 'SYSTEM');
INSERT INTO role_permission(permission_code, role_id, created_by, updated_by) VALUES('USER_DETAIL', 2, 'SYSTEM', 'SYSTEM');
INSERT INTO role_permission(permission_code, role_id, created_by, updated_by) VALUES('USER_UPDATE', 2, 'SYSTEM', 'SYSTEM');
INSERT INTO role_permission(permission_code, role_id, created_by, updated_by) VALUES('USER_DELETE', 2, 'SYSTEM', 'SYSTEM');