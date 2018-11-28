create table MenuItemCategory
(
	itemCategoryID varchar(3) not null,
	itemCategoryDescription varchar(20) not null,
	primary key (itemCategoryID)
);

create table MenuItem
(
	itemID int not null,
	itemCategoryID varchar(3) not null,
	description varchar(80) not null,
	price int not null,
	vegetarian boolean not null,
	primary key (itemID),
	foreign key (itemCategoryID) references MenuItemCategory(itemCategoryID) on delete cascade
);
