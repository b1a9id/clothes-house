insert into brand (name) values
    ('ETHOSENS'),
    ('STOF'),
    ('bedsidedrama'),
    ('STORAMA'),
    ('Portaille'),
    ('Dulcamara'),
    ('YARN&COPPER'),
    ('mitake'),
    ('OLTA DESIGNS');

insert into category (name) values
    ('TOPS'),
    ('OUTER'),
    ('PANTS'),
    ('SKIRT'),
    ('ONE PIECE'),
    ('BAG'),
    ('SHOES'),
    ('HAT'),
    ('SOCKS');

insert into color (name) values
    ('RED'),
    ('YELLOW'),
    ('GREEN'),
    ('BLUE'),
    ('PURPLE'),
    ('BROWN'),
    ('WHITE'),
    ('GRAY'),
    ('ORANGE'),
    ('NAVY'),
    ('BLACK');

insert into genre (name, category_id) values
    ('T Shirts', (select id from category where name = 'TOPS')),
    ('Shirts', (select id from category where name = 'TOPS')),
    ('Knit', (select id from category where name = 'TOPS')),
    ('PARKA', (select id from category where name = 'TOPS')),
    ('Sweat', (select id from category where name = 'TOPS')),
    ('Cardigan', (select id from category where name = 'TOPS')),
    ('Jacket', (select id from category where name = 'OUTER')),
    ('Coat', (select id from category where name = 'OUTER')),
    ('DenimPants', (select id from category where name = 'PANTS')),
    ('Pants', (select id from category where name = 'PANTS')),
    ('Skirt', (select id from category where name = 'SKIRT')),
    ('One Piece', (select id from category where name = 'ONE PIECE')),
    ('Bag', (select id from category where name = 'BAG')),
    ('Shoes', (select id from category where name = 'SHOES')),
    ('Hat', (select id from category where name = 'HAT')),
    ('Socks', (select id from category where name = 'SOCKS'));

insert into item (brand_id, genre_id, color_id, image_url) values
    ((select id from brand where name = 'ETHOSENS'), (select id from genre where name = 'Shirts'), (select id from color where name = 'BLUE'), 'https://www.ethosens.com/onlinestore/wp-content/uploads/2019/12/e120-207a.jpghttps://www.ethosens.com/onlinestore/wp-content/uploads/2019/12/e120-207a.jpg');
