Create.sqlQueries for create schema:create table person(    -> id int not null auto_increment primary key,    -> phone_person_generalization int,    -> foreign key(phone_person_generalization) references phone(id),    -> address_person_generalization int,     -> foreign key(address_person_generalization) references Address(id),    -> firstName varchar(100),    -> lastName varchar(100),    -> userName varchar(100),    -> password varchar(100),    -> email varchar(100),     -> dob date);     alter table phone add column `primary` boolean not null default 0;alter table address add column `primary` boolean not null default 0;mysql> create table user(    -> id int primary key references person(id),    -> userAgreement bool);create table developer(    -> id int primary key references person(id),    -> developerKey varchar(100)     -> );     Create table widget(> id int auto_increment primary key,> name varchar(100),> width int,> height int,> cssClass varchar(100),> cssStyle varchar(100),> text varchar(100),> order int;create table heading(    -> id int primary key references widget(id),     -> size int);          create table html(    -> id int primary key references widget(id),     -> html varchar(100));create table image(    -> id int primary key references widget(id),       -> src varchar(100));     create table youtube(    -> id int primary key references widget(id),    -> url varchar(100),    -> shareble boolean,     -> expandable boolean);create table page( id int auto_increment primary key, title varchar(100),widget_page_generalization int, d description varchar(100), created date, updated date, visits int);create table website(    -> id int auto_increment primary key,    -> name varchar(100),    -> page_website_generalization int,    -> foreign key(page_website_generalization) references page(id),    -> created date,    -> updated date,     -> visits int);create table single_table(                                                                      ->  website_id int auto_increment primary key,    -> name varchar(100),    -> page_id int,    -> page_desc varchar(100),    -> widget_id int,    -> widget_name varchar(100),    -> dtypes varchar(100)    -> );create table phone( id int not null auto_increment primary key, phone varchar(100));create table address(    -> id int not null auto_increment primary key,    -> street1 varchar(100),    -> street2 varchar(100),    -> city varchar(100),    -> state varchar(100),     -> zip varchar(100));     create table websiteRole(    -> id int auto_increment primary key,    -> webRole_website_generalization int,    ->  foreign key(webRole_website_generalization) references website(id),     -> webRole_developer_generalization int,    -> foreign key(webRole_developer_generalization) references developer(id)     -> role enum('owner','admin','writer','editor','reviewer'));create table website_priviliage(    -> id int auto_increment primary key,    -> web_priviliage_website_generalization int,    -> foreign key(web_priviliage_website_generalization) references website(id),     -> web_priviliage_developer_generalization int,     -> foreign key(web_priviliage_developer_generalization) references developer(id)     ->privilidge enum('create','read','update','delete')     -> );     create table pagePriviliage(    -> id int auto_increment primary key,    -> page_priviliage_page_generalization int,    -> foreign key(page_priviliage_page_generalization) references page(id),     -> page_priviliage_developer_generalization int,    -> foreign key(page_priviliage_developer_generalization) references developer(id),     -> role enum('create','read','update','delete'));     create table pageRole(    -> id int auto_increment primary key,    -> page_role_page_generalization int,    -> foreign key(page_role_page_generalization) references page(id),     -> page_role_developer_generalization int,    -> foreign key(page_role_developer_generalization) references developer(id),    -> role enum('owner','admin','writer','editor','reviewer'));    