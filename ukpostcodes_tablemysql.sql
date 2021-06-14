--
-- Table structure for table `postcodelatlng`
--
CREATE TABLE IF NOT EXISTS `postcodelatlng` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postcode` varchar(8) NOT NULL,
  `latitude` decimal(12,9) NOT NULL,
  `longitude` decimal(12,9) NOT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;