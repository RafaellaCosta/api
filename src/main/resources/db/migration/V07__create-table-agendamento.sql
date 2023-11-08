create table agendamento(
    id bigint not null auto_increment,
    paciente varchar(100),
    medico varchar(100),
    data timestamp,

    primary key (id)
)