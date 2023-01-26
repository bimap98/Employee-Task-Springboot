create table employee (
                          id bigserial not null,
                          created_at timestamp(6),
                          name VARCHAR(255) not null,
                          updated_at timestamp(6),
                          primary key (id)
);

create table task (
                      id bigserial not null,
                      created_at timestamp(6),
                      description TEXT not null,
                      status varchar(255),
                      title VARCHAR(255) not null,
                      updated_at timestamp(6),
                      employee_id bigint,
                      primary key (id)
);

alter table if exists task
    add constraint FKmeqi2abtbehx871tag4op3hag
    foreign key (employee_id)
    references employee;