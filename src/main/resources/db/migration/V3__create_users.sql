SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE IF NOT EXISTS  `users` (
  `username` varchar(64) NOT NULL,
  `pwdHash` varchar(50) DEFAULT NULL,
  `pwdAlgorithm` varchar(20) DEFAULT NULL,
  `useForwarding` smallint(6) DEFAULT NULL,
  `forwardDestination` varchar(255) DEFAULT NULL,
  `useAlias` smallint(6) DEFAULT NULL,
  `alias` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
