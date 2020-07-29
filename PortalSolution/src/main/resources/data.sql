INSERT INTO  role values(100,'Admin');
INSERT INTO  role values(101,'User');
INSERT INTO  role values(102,'Developer');
INSERT INTO  role values(103,'HOD');
INSERT INTO  role values(104,'CP');

insert into user (id, email, mobile_no, password, username)  values  (100, 'multi@test.com', 9873456782, '$2a$10$igKIeUe5SUwqnpEJTdzWquZHAxiFBOt8YHp7rZAtUewNuzb5iWy8y', 'multi');
insert into user (id, email, mobile_no, password, username)  values  (101, 'admin@test.com', 8382224756, '$2a$10$igKIeUe5SUwqnpEJTdzWquZHAxiFBOt8YHp7rZAtUewNuzb5iWy8y', 'admin');
insert into user (id, email, mobile_no, password, username)  values  (102, 'user@test.com', 7023387364, '$2a$10$igKIeUe5SUwqnpEJTdzWquZHAxiFBOt8YHp7rZAtUewNuzb5iWy8y', 'user');

insert into  user_role  (user_id, role_id) values (100, 100);
insert into  user_role  (user_id, role_id) values (100, 101);
insert into  user_role  (user_id, role_id) values (101, 100);
insert into  user_role  (user_id, role_id) values (102, 101);