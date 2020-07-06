create table brand (
    id bigint primary key generated always as identity not null,
    name varchar(255) not null
);

create table category (
    id bigint primary key generated always as identity not null,
    name varchar(50) not null
);

create table color (
    id bigint primary key generated always as identity not null,
    name varchar(50) not null
);

create table genre (
    id bigint primary key generated always as identity not null,
    name varchar(50) not null,
    category_id bigint not null
);

create table item (
    id bigint primary key generated always as identity not null,
    brand_id bigint not null,
    genre_id bigint not null,
    color_id bigint not null,
    image_url varchar(255) not null
);


