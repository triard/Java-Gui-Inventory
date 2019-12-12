-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versi server:                 10.1.37-MariaDB - mariadb.org binary distribution
-- OS Server:                    Win32
-- HeidiSQL Versi:               10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- membuang struktur untuk table dbinventory.barang
CREATE TABLE IF NOT EXISTS `barang` (
  `id_item` int(11) NOT NULL AUTO_INCREMENT,
  `idkategori` int(11) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `qty` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id_item`),
  KEY `FK_barang_kategory` (`idkategori`),
  CONSTRAINT `FK_barang_kategory` FOREIGN KEY (`idkategori`) REFERENCES `kategory` (`idkategori`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

-- Membuang data untuk tabel dbinventory.barang: ~37 rows (lebih kurang)
/*!40000 ALTER TABLE `barang` DISABLE KEYS */;
INSERT INTO `barang` (`id_item`, `idkategori`, `item_name`, `qty`, `price`) VALUES
	(1, 1, 'Rei Atmos Ag 65 Pack', 48, 800000),
	(2, 1, 'Rei Co-op Traverse 35 Pack', 20, 500000),
	(3, 1, 'osprey Aether AG 70 Pack', 30, 950000),
	(4, 1, 'osprey Tempest 40 Pack', 30, 450000),
	(5, 1, 'Eiger Rhinos 45L - Black', 20, 925000),
	(6, 1, 'Eiger R. Compact 23L - black', 13, 359100),
	(7, 1, 'Eiger Equator Rucksack 45 L - Blue', 25, 1399000),
	(8, 1, 'Eiger Velocity cycling backpack 12L - RED', 15, 395000),
	(9, 1, 'Consina Extraterrestial 60L', 5, 595000),
	(10, 1, 'Extraterrestrial 28L', 20, 345000),
	(11, 1, 'Tarebbi', 3, 515000),
	(12, 1, 'Ardennes', 27, 310000),
	(13, 2, 'Consina Calais', 7, 225000),
	(14, 2, 'Consina Glen Etive', 6, 375000),
	(15, 2, 'Consina Lite Speed', 20, 295000),
	(16, 2, 'Consina North Field', 10, 375000),
	(17, 2, 'Rei patagonia Nano Puff ', 30, 2000000),
	(18, 2, 'Rei Co-op Groundbreaker Rain ', 0, 300000),
	(19, 2, 'Rei Torrentshell jackey', 10, 1000000),
	(20, 2, 'Rei Co-op Rainer Rain', 20, 960000),
	(21, 2, 'Eiger DNA active', 9, 355500),
	(22, 2, 'Eiger Eminence Jacket', 16, 645000),
	(23, 2, 'Eiger Triple Jacket', 20, 659000),
	(24, 5, 'Eiger Short Sector 1.0', 5, 145000),
	(25, 5, 'Eiger Highland 1.1 pants', 9, 445000),
	(26, 5, 'Rei Mamot Verde Pants', 20, 600000),
	(27, 5, 'Rei Co-op savana trails Pants', 11, 300000),
	(28, 5, 'Silver Ridge Convertible pants', 20, 250000),
	(29, 3, 'Eiger t-shirt black', 10, 80000),
	(30, 4, 'Eiger Searcher 1.0 shirt olive', 30, 274000),
	(31, 4, 'Eiger Borneo Kalamantra', 40, 270000),
	(32, 4, 'Eiger Majestic Neo SS', 30, 300000),
	(33, 6, 'Eiger Multi Hut Tent', 5, 675000),
	(34, 6, 'Eiger Creek 5P Tent', 5, 1950000),
	(35, 6, 'Rei Co-op Half Dome 2 plus tent', 7, 700000),
	(36, 6, 'Rei Co-op Passage 4 Tent', 5, 900000);
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;

-- membuang struktur untuk table dbinventory.barangout
CREATE TABLE IF NOT EXISTS `barangout` (
  `id_barangout` int(11) NOT NULL AUTO_INCREMENT,
  `id_item` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  PRIMARY KEY (`id_barangout`),
  KEY `FK__barang` (`id_item`),
  CONSTRAINT `FK__barang` FOREIGN KEY (`id_item`) REFERENCES `barang` (`id_item`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Membuang data untuk tabel dbinventory.barangout: ~5 rows (lebih kurang)
/*!40000 ALTER TABLE `barangout` DISABLE KEYS */;
INSERT INTO `barangout` (`id_barangout`, `id_item`, `qty`, `tanggal`) VALUES
	(1, 13, 10, '2019-12-11'),
	(2, 18, 10, '2019-12-09'),
	(3, 14, 9, '2019-12-02'),
	(4, 35, 3, '2019-12-10'),
	(5, 11, 7, '2019-12-10');
/*!40000 ALTER TABLE `barangout` ENABLE KEYS */;

-- membuang struktur untuk table dbinventory.kategory
CREATE TABLE IF NOT EXISTS `kategory` (
  `idkategori` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `keterangan` varchar(250) NOT NULL,
  PRIMARY KEY (`idkategori`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Membuang data untuk tabel dbinventory.kategory: ~6 rows (lebih kurang)
/*!40000 ALTER TABLE `kategory` DISABLE KEYS */;
INSERT INTO `kategory` (`idkategori`, `nama`, `keterangan`) VALUES
	(1, 'Backpack', 'inside backpack under 20 ltr, 40-60 ltr, over 60 ltr'),
	(2, 'Jacket', 'jaket eiger, consina, dan rei'),
	(3, 'T-shirt', 'Kaos oblong dan polo shirt'),
	(4, 'Shirt', 'Flannel, dan Kemeja'),
	(5, 'Pants', 'trousers dan shorts'),
	(6, 'Tent', '1 person, 2 person, 3 person, 4 person');
/*!40000 ALTER TABLE `kategory` ENABLE KEYS */;

-- membuang struktur untuk table dbinventory.orderin
CREATE TABLE IF NOT EXISTS `orderin` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `id_item` int(11) NOT NULL,
  `id_supplier` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  PRIMARY KEY (`id_order`),
  KEY `FK_order_barang` (`id_item`),
  KEY `FK_order_supplier` (`id_supplier`),
  CONSTRAINT `FK_order_barang` FOREIGN KEY (`id_item`) REFERENCES `barang` (`id_item`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_order_supplier` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`idsupplier`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Membuang data untuk tabel dbinventory.orderin: ~5 rows (lebih kurang)
/*!40000 ALTER TABLE `orderin` DISABLE KEYS */;
INSERT INTO `orderin` (`id_order`, `id_item`, `id_supplier`, `qty`, `tanggal`) VALUES
	(1, 13, 3, 10, '2019-12-10'),
	(2, 31, 2, 20, '2019-12-07'),
	(3, 22, 2, 5, '2019-04-10'),
	(4, 1, 1, 3, '2019-12-10');
/*!40000 ALTER TABLE `orderin` ENABLE KEYS */;

-- membuang struktur untuk table dbinventory.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `idsupplier` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `telp` varchar(50) NOT NULL,
  PRIMARY KEY (`idsupplier`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Membuang data untuk tabel dbinventory.supplier: ~3 rows (lebih kurang)
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`idsupplier`, `nama`, `alamat`, `telp`) VALUES
	(1, 'Rei Indonesia', 'Jl. Buah Batu No. 168, Cijagra, Lengkong, Bandung,', '+62 815 1548 4701'),
	(2, 'Eiger Indonesia', 'Jl. Sumatera No.23, Braga, Sumur Bandung, Kota Ban', '021 – 7262818'),
	(3, 'Consina Indonesia', 'Jl.Raya Narogong KM.12 Kel. Bantargebang, Bekasi', '+622182621354');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;

-- membuang struktur untuk trigger dbinventory.barangKeluar
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `barangKeluar` BEFORE INSERT ON `barangout` FOR EACH ROW BEGIN
UPDATE barang set qty = qty - New.qty WHERE
id_item=new.id_item;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- membuang struktur untuk trigger dbinventory.barangmasuk
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `barangmasuk` AFTER INSERT ON `orderin` FOR EACH ROW BEGIN 
UPDATE barang set qty = qty + New.qty WHERE id_item=new.id_item;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
