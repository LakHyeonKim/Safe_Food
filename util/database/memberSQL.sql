CREATE TABLE `member` (
  `id` varchar(40) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `allergy` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci