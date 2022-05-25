drop table if exists Users;

create table Users
(
    user_no  int auto_increment,
    id       varchar(10) not null,
    pwd      varchar(20) not null,
    nickname varchar(10) not null,
    constraint ak_id unique key (id),
    primary key (user_no)
);

select *
from Users;

drop table if exists Posts;
-- auto 로 증가시켜야 할값이 몇개 인가?
create table Posts
(
    post_no          int auto_increment not null,
    post_no_above    int null,
    user_no_writer   int          not null,
    user_no_modifier int null,
    writed_at        datetime     not null,
    modified_at      datetime null,
    title            varchar(30)  not null,
    content          varchar(100) not null,
    view_activate    boolean,
    file_name        varchar(100) null,
    primary key (post_no)
);


drop table if exists `Comments`;

create table `Comments`
(
    comment_no int auto_increment not null,
    post_no    int         not null,
    user_no    int         not null,
    content    varchar(50) not null,
    primary key (comment_no)
);


drop table if exists `LikesViewCounts`;

create table `LikesViewCounts`
(
    part    varchar(30) not null,
    post_no int         not null,
    user_no int         not null,
    primary key (part, post_no, user_no)
);
