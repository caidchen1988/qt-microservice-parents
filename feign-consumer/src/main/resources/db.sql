/*==============================================================*/
/* Table: s_user_role    系统用户角色关系表                       */
/*==============================================================*/
drop table if exists s_user_role;

create table s_user_role
(
  id                   int not null,
  s_user_id            int not null,
  s_role_id            int not null,
  primary key (id)
);

alter table s_user_role add constraint FK_Reference_1 foreign key (s_user_id)
references s_user (id) on delete restrict on update restrict;

alter table s_user_role add constraint FK_Reference_2 foreign key (s_role_id)
references s_role (id) on delete restrict on update restrict;

/*==============================================================*/
/* Table: s_role_permission   系统角色权限关系表                  */
/*==============================================================*/
drop table if exists s_role_permission;

create table s_role_permission
(
  id                   int not null,
  role_id              int not null,
  permission           int not null,
  primary key (id)
);

alter table s_role_permission add constraint FK_Reference_3 foreign key (role_id)
references s_role (id) on delete restrict on update restrict;

alter table s_role_permission add constraint FK_Reference_4 foreign key (permission)
references s_permission (id) on delete restrict on update restrict;


/*==============================================================*/
/* Table: s_user            系统用户表                           */
/*==============================================================*/
drop table if exists s_user;

create table s_user
(
  id                   int not null,
  user_name            varchar(50) not null,
  password             varchar(100) not null,
  created              datetime not null DEFAULT CURRENT_TIMESTAMP ,
  primary key (id)
);

/*==============================================================*/
/* Table: s_role         系统用户角色表                           */
/*==============================================================*/
drop table if exists s_role;

create table s_role
(
  id                   int not null,
  role_name            varchar(50) not null,
  role_code            varchar(20) not null,
  created              datetime not null DEFAULT CURRENT_TIMESTAMP,
  primary key (id)
);

/*==============================================================*/
/* Table: s_permission        系统权限表                         */
/*==============================================================*/
drop table if exists s_permission;

create table s_permission
(
  id                   int not null,
  code                 varchar(50) not null,
  description          varchar(100),
  url                  varchar(100),
  pid                  int not null,
  method               varchar(100),
  created              datetime not null DEFAULT CURRENT_TIMESTAMP ,
  primary key (id)
);

/*==============================================================*/
/* Table: persistent_logins    记住用户登录表                     */
/*==============================================================*/
drop table if exists persistent_logins;

create table persistent_logins
(
  id                   int not null,
  user_name            varchar(50) not null,
  series               varchar(64) not null,
  token                varchar(64) not null,
  last_used            timestamp not null DEFAULT CURRENT_TIMESTAMP ,
  primary key (id)
);


/*==============================================================*/
/*                         初始化数据                            */
/*==============================================================*/

# 密码admin@123
insert into s_user (id,user_name, password) values (1,'admin', '$2a$04$woAVh6KwAkO5HZNwDtcfwu7WgWFJl.5Z6KWuJz9mN/6v/kOglr3ai');
# 密码abel@123
insert into s_user (id,user_name, password) values (2,'abel', '$2a$04$1W76mNEaO2WJwjKpUykYsuLczYB5Wyj2dX0Kg6GUuHoa9vxYLkFWS');

insert into s_role(id,role_name,role_code) values(1,'ROLE_ADMIN','ROLE_ADMIN');
insert into s_role(id,role_name,role_code) values(2,'ROLE_USER','ROLE_USER');

insert into s_user_role(id,s_user_id,s_role_id) values(1, 1, 1);
insert into s_user_role(id,s_user_id,s_role_id) values(2, 1, 2);
insert into s_user_role(id,s_user_id,s_role_id) values(3, 2, 2);