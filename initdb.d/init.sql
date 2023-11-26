create table if not exists system_users
(
    id              bigint primary key not null auto_increment,
    username        varchar(100)       not null,
    password        varchar(100)       not null,
    nickname        varchar(100)       null,
    email           varchar(100)       null,
    mobile          varchar(100)       null,
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
);
