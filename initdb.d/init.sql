/* MYSQL */

create table if not exists system_user
(
    id              bigint primary key not null auto_increment,
    username        varchar(100)       not null,
    password        varchar(100)       not null,
    nickname        varchar(100)       null,
    email           varchar(100)       null,
    phone           varchar(100)       null,
    create_user_id  bigint             null,
    create_username varchar(100)       null,
    create_time     datetime           null,
    update_user_id  bigint             null,
    update_username varchar(100)       null,
    update_time     datetime           null,
    is_deleted      tinyint default 0  null,
    delete_user_id  bigint             null,
    delete_username varchar(100)       null,
    delete_time     datetime           null,
    remark          varchar(500)       null,
    UNIQUE index username_unique (username)
) comment 'user table';

insert into system_user (username, password, nickname, email, create_user_id, create_username, create_time)
    value ('user', '$2a$10$1skIu6oo1C84tTCGg0oAHOB/dKplS19URYGHG3xc9xBhmz1Y1Ri0K', 'user', 'xxx@xx.com', 1, 'user',
           now());

create table if not exists system_role
(
    id              bigint primary key not null auto_increment,
    name            varchar(100)       not null,
    create_user_id  bigint             null,
    create_username varchar(100)       null,
    create_time     datetime           null,
    update_user_id  bigint             null,
    update_username varchar(100)       null,
    update_time     datetime           null,
    is_deleted      tinyint default 0  null,
    delete_user_id  bigint             null,
    delete_username varchar(100)       null,
    delete_time     datetime           null,
    remark          varchar(500)       null,
    UNIQUE index name_unique (name)
) comment 'role table';

insert into system_role (name, create_user_id, create_username, create_time)
    value ('admin', 1, 'user', now());
insert into system_role (name, create_user_id, create_username, create_time)
    value ('user', 1, 'user', now());

create table if not exists system_role_user
(
    id              bigint primary key not null auto_increment,
    role_id         bigint             not null,
    user_id         bigint             not null,
    create_user_id  bigint             null,
    create_username varchar(100)       null,
    create_time     datetime           null,
    update_user_id  bigint             null,
    update_username varchar(100)       null,
    update_time     datetime           null,
    is_deleted      tinyint default 0  null,
    delete_user_id  bigint             null,
    delete_username varchar(100)       null,
    delete_time     datetime           null,
    remark          varchar(500)       null
) comment 'role user link table';

insert into system_role_user (role_id, user_id, create_user_id, create_username, create_time)
    value (1, 1, 1, 'user', now());

create table if not exists system_permission
(
    id              bigint primary key not null auto_increment,
    name            varchar(100)       not null,
    permission      varchar(100)       not null,
    create_user_id  bigint             null,
    create_username varchar(100)       null,
    create_time     datetime           null,
    update_user_id  bigint             null,
    update_username varchar(100)       null,
    update_time     datetime           null,
    is_deleted      tinyint default 0  null,
    delete_user_id  bigint             null,
    delete_username varchar(100)       null,
    delete_time     datetime           null,
    remark          varchar(500)       null,
    UNIQUE index permission_unique (permission)
) comment 'permission table';

insert into system_permission (name, permission, create_user_id, create_username, create_time)
    value ('admin', 'admin', 1, 'user', now());

create table if not exists system_role_permission
(
    id              bigint primary key not null auto_increment,
    role_id         bigint             not null,
    permission_id   bigint             not null,
    create_user_id  bigint             null,
    create_username varchar(100)       null,
    create_time     datetime           null,
    update_user_id  bigint             null,
    update_username varchar(100)       null,
    update_time     datetime           null,
    is_deleted      tinyint default 0  null,
    delete_user_id  bigint             null,
    delete_username varchar(100)       null,
    delete_time     datetime           null,
    remark          varchar(500)       null
) comment 'role permission link table';

insert into system_role_permission (role_id, permission_id, create_user_id, create_username, create_time)
    value (1, 1, 1, 'user', now());

create table if not exists system_user_permission
(
    id              bigint primary key not null auto_increment,
    user_id         bigint             not null,
    permission_id   bigint             not null,
    create_user_id  bigint             null,
    create_username varchar(100)       null,
    create_time     datetime           null,
    update_user_id  bigint             null,
    update_username varchar(100)       null,
    update_time     datetime           null,
    is_deleted      tinyint default 0  null,
    delete_user_id  bigint             null,
    delete_username varchar(100)       null,
    delete_time     datetime           null,
    remark          varchar(500)       null
) comment 'user permission link table';

create table if not exists system_config
(
    id              bigint primary key not null auto_increment,
    name            varchar(100)       not null,
    value           varchar(100)       not null,
    create_user_id  bigint             null,
    create_username varchar(100)       null,
    create_time     datetime           null,
    update_user_id  bigint             null,
    update_username varchar(100)       null,
    update_time     datetime           null,
    is_deleted      tinyint default 0  null,
    delete_user_id  bigint             null,
    delete_username varchar(100)       null,
    delete_time     datetime           null,
    remark          varchar(500)       null,
    UNIQUE index name_unique (name)
) comment 'config table';

# insert into system_config (name, value, create_user_id, create_username, create_time)
# values ('systemName', 'go-zero-admin', 1, 'user', now()),
#        ('systemVersion', 'v1.0.0', 1, 'user', now()),
#        ('system_author', 'go-zero', 1, 'user', now()),
#        ('system_description', 'go-zero-admin', 1, 'user', now());
