CREATE TABLE if not exists `tweakdeaths` (
    `id` int unsigned NOT NULL UNIQUE AUTO_INCREMENT,
    `playername` varchar(32) NOT NULL,
    `world` varchar(32) NOT NULL,
    `deathcause` varchar(32) NOT NULL,
    `x` double NOT NULL,
    `y` double NOT NULL,
    `z` double NOT NULL,
    `datetime` timestamp NOT NULL,
    `otherentity` varchar(32),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;
    