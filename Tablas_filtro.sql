use buafp2cnsqv8amlnd3bp;

create table Ninja (
	ID int auto_increment primary key,
    Nombre varchar(50) not null,
    Rango enum('Bronce', 'Plata', 'Oro'),
    Aldea varchar(100) not null
);

create table Mision (
	ID int auto_increment primary key,
    Descripcion varchar(100),
    Rango enum('Bronce', 'Plata', 'Oro'),
    Recompensa varchar(100)
);

create table MisionNinja (
	ID_Ninja int primary key,
    ID_Mision int,
    FechaInicio Date,
    FechaFin Date,
    foreign key (ID_Ninja) references Ninja(ID),
    foreign key (ID_Mision) references Mision(ID)
);

create table Habilidad (
	ID_Ninja int auto_increment primary key,
    Nombre varchar(50),
    Descripcion varchar(100),
    foreign key (ID_Ninja) references Ninja(ID)
);