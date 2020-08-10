INSERT INTO  role values(100,'Admin');
INSERT INTO  role values(101,'User');
INSERT INTO  role values(102,'WhatsappWrite');
INSERT INTO  role values(103,'WhatsappRead');
INSERT INTO  role values(104,'Authenticated');

insert into user (id, email, mobile_no, password, username, first_time_login)  values  (100, 'multi@test.com', 9873456782, '$2a$10$igKIeUe5SUwqnpEJTdzWquZHAxiFBOt8YHp7rZAtUewNuzb5iWy8y', 'multi',false);
insert into user (id, email, mobile_no, password, username, first_time_login)  values  (101, 'admin@test.com', 8382224756, '$2a$10$igKIeUe5SUwqnpEJTdzWquZHAxiFBOt8YHp7rZAtUewNuzb5iWy8y', 'admin',false);
insert into user (id, email, mobile_no, password, username, first_time_login)  values  (102, 'user@test.com', 7023387364, '$2a$10$igKIeUe5SUwqnpEJTdzWquZHAxiFBOt8YHp7rZAtUewNuzb5iWy8y', 'user',false);
insert into user (id, email, mobile_no, password, username, first_time_login)  values  (103, 'whatsapp@test.com', 7023387364, '$2a$10$igKIeUe5SUwqnpEJTdzWquZHAxiFBOt8YHp7rZAtUewNuzb5iWy8y', 'whatsapp',false);

insert into  user_role  (user_id, role_id) values (100, 100);
insert into  user_role  (user_id, role_id) values (100, 101);
insert into  user_role  (user_id, role_id) values (101, 100);
insert into  user_role  (user_id, role_id) values (102, 101);
insert into  user_role  (user_id, role_id) values (103, 102);
insert into  user_role  (user_id, role_id) values (103, 103);