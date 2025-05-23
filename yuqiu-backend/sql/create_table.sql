# 用户表
create table tag
(
    id           bigint auto_increment comment 'id'  primary key,
    tagName  varchar(256)                       null comment '标签名称',
    userId    varchar(1024)                      null comment '用户id',
    parentId  bigint                             null comment '父标签名称',
    isParent  tinyint                           null comment '0 - 不是， 1 - 父标签',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete     tinyint  default 0                 not null comment '是否删除'
)
    comment '标签';
