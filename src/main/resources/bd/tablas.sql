if not exists (select * from sysobjects where name='evento' and xtype='U')
create table evento (evento_id int primary key, evento_nombre varchar(255));

if not exists (select * from sysobjects where name='detalle' and xtype='U')
create table detalle (detalle_id int primary key, detalle_nombre varchar(255));

if not exists (select * from sysobjects where name='usuario' and xtype='U')
create table usuario (id int primary key, password varchar(255) default null, username varchar(255) default null);

if not exists (select * from sysobjects where name='authority' and xtype='U')
create table authority (id int primary key, authority varchar(255) default null);

if not exists (select * from sysobjects where name='authority' and xtype='U')
create table authority (id int primary key, authority varchar(255) default null);

if not exists (select * from sysobjects where name='authorities_users' and xtype='U')
create table authorities_users (usuario_id int not null, authority_id int not null, primary key
    (usuario_id, authority_id), foreign key (authority_id) references authority (id), foreign key (usuario_id) references usuario (id));