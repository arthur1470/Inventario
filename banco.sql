create sequence SEQ_ID_PRODUTO
/

create sequence SEQ_ID_INVENTARIO
/

create sequence SEQ_ID_PRODUTO_INSERIDO
/

create table PRODUTO
(
	ID_PRODUTO NUMBER not null
		primary key,
	NOME_PRODUTO VARCHAR2(80)
)
/

create table INVENTARIO
(
	ID_INVENTARIO NUMBER not null
		primary key,
	NOME_INVENTARIO VARCHAR2(100) not null,
	DATA_INVENTARIO DATE not null
)
/

create table INVENTARIO_PRODUTO_INSERIDO
(
	ID_INVENTARIO NUMBER
		constraint ID_INVENTARIO
			references INVENTARIO,
	ID_PRODUTO_INSERIDO NUMBER
)
/

create table PRODUTO_INSERIDO
(
	ID_PRODUTO_INSERIDO NUMBER not null
		primary key,
	ID_PRODUTO NUMBER
		constraint PRODUTO_INSERIDO_FK
			references PRODUTO,
	QUANTIDADE_PRODUTO_INSERIDO NUMBER not null
)
/

alter table INVENTARIO_PRODUTO_INSERIDO
	add constraint ID_PRODUTO_INSERIDO
		foreign key (ID_PRODUTO_INSERIDO) references PRODUTO_INSERIDO
/
