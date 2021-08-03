create type colors as enum ('red', 'yellow', 'green');
create table apple
(
    id     serial PRIMARY KEY NOT NULL,
    weight numeric            NOT NULL,
    color  colors             NOT NULL,
    grade  varchar(30)        NOT NULL UNIQUE,
    sour   bool               NOT NULL
);