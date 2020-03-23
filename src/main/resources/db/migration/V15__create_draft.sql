CREATE TABLE draft (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `recipients` text,
  `subjects` text,
  `content` text,
  `sender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;