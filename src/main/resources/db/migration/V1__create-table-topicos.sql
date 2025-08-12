create table topicos(
    id bigint not null auto_incremet,
    titulo varchar(100) not null,
    mensaje varchar(500),
    fecha_de_creacion not null,
    status varchar(20) not null,
    autor varchar(100) not null,
    curso varchar(100) not null

    primary key(id)
);