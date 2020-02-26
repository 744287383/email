SET FOREIGN_KEY_CHECKS=0;
CREATE TABLE IF NOT EXISTS `inbox` (
  `message_name` varchar(200) NOT NULL,
  `repository_name` varchar(100) NOT NULL,
  `message_state` varchar(30) NOT NULL,
  `error_message` varchar(200) DEFAULT NULL,
  `sender` varchar(255) DEFAULT NULL,
  `recipients` text NOT NULL,
  `remote_host` varchar(255) NOT NULL,
  `remote_addr` varchar(20) NOT NULL,
  `message_body` longblob NOT NULL,
  `message_attributes` longblob,
  `last_updated` datetime NOT NULL,
  PRIMARY KEY (`repository_name`,`message_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
