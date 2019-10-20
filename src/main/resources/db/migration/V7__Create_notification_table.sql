create table notification
  (
    id bigint auto_increment primary key,
    notifier bigint not null comment '通知者',
    notifier_name varchar(100) null,
    receiver bigint not null comment '收到通知者',
    outer_id bigint not null comment '回复id或问题id',
    type int not null comment '回复、点赞类型',
    outer_title varchar(256) null,
    gmt_create bigint not null,
    status int default 0 not null comment '状态'
  );