insert into equipo (id, nombre, pais)
values(1, 'FC Barcelona', 'Espana');
insert into equipo (id, nombre, pais)
values(2, 'Manchester City', 'Inglaterra');
insert into equipo (id, nombre, pais)
values(3, 'Bayern Munich', 'Alemania');

insert into jugador (id, fecha_nacimiento, nombre, pais_origen, pasaporte, posicion)
values (1, '1984-02-02', 'Claudio Bravo', 'Chile', 'CN96633', 'Portero');
insert into jugador (id, fecha_nacimiento, nombre, pais_origen, pasaporte, posicion)
values (2, '1991-03-01', 'Douglas Pereira', 'Brasil', 'BN96633', 'Defensa');
insert into jugador (id, fecha_nacimiento, nombre, pais_origen, pasaporte, posicion)
values (3, '1989-04-09', 'Gerard Piqué', 'Espana', 'SN96633', 'Defensa');
insert into jugador (id, fecha_nacimiento, nombre, pais_origen, pasaporte, posicion)
values (4, '1987-05-08', 'Dani Alves', 'Brasil', 'AN96633', 'Defensa');
insert into jugador (id, fecha_nacimiento, nombre, pais_origen, pasaporte, posicion)
values (5, '1991-06-07', 'Marc Bartra', 'Espana', 'AN96633', 'Defensa');

insert into jugador (id, fecha_nacimiento, nombre, pais_origen, pasaporte, posicion)
values (6, '1984-02-02', 'Robert Lewandowski', 'Polonia', 'CN96633', 'Delantero');
insert into jugador (id, fecha_nacimiento, nombre, pais_origen, pasaporte, posicion)
values (7, '1987-03-01', 'Arjen Robben', 'Holanda', 'BN96633', 'Centrocampista');
insert into jugador (id, fecha_nacimiento, nombre, pais_origen, pasaporte, posicion)
values (8, '1981-04-09', 'Thomas Muller', 'Alemania', 'SN96633', 'Delantero');
insert into jugador (id, fecha_nacimiento, nombre, pais_origen, pasaporte, posicion)
values (9, '1982-05-08', 'Frank Ribery', 'Francia', 'AN96633', 'Centrocampista');
insert into jugador (id, fecha_nacimiento, nombre, pais_origen, pasaporte, posicion)
values (10, '1983-06-07', 'Manuel Neuer', 'Alemania', 'AN96633', 'Portero');

insert into equipo_jugadores (equipo_id, jugadores_id) values(1, 1);
insert into equipo_jugadores (equipo_id, jugadores_id) values(1, 2);
insert into equipo_jugadores (equipo_id, jugadores_id) values(1, 3);
insert into equipo_jugadores (equipo_id, jugadores_id) values(1, 4);
insert into equipo_jugadores (equipo_id, jugadores_id) values(1, 5);

insert into equipo_jugadores (equipo_id, jugadores_id) values(3, 6);
insert into equipo_jugadores (equipo_id, jugadores_id) values(3, 7);
insert into equipo_jugadores (equipo_id, jugadores_id) values(3, 8);
insert into equipo_jugadores (equipo_id, jugadores_id) values(3, 9);
insert into equipo_jugadores (equipo_id, jugadores_id) values(3, 10);
