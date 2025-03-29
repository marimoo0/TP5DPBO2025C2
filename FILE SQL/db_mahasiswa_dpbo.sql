-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2025 at 10:48 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_mahasiswa_dpbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` int(11) NOT NULL,
  `nim` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(255) NOT NULL,
  `nilai` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `nim`, `nama`, `jenis_kelamin`, `nilai`) VALUES
(1, '2203999', 'Amelia Zalfa Julianti', 'Perempuan', 0),
(2, '2202292', 'Muhammad Iqbal Fadhilah', 'Laki-laki', 0),
(3, '2202346', 'Muhammad Rifky Afandi', 'Laki-laki', 0),
(5, '2202046', 'Nurainun', 'Perempuan', 0),
(6, '2205101', 'Kelvin Julian Putra', 'Laki-laki', 0),
(7, '2200163', 'Rifanny Lysara Annastasya', 'Perempuan', 0),
(8, '2202869', 'Revana Faliha Salma', 'Perempuan', 0),
(9, '2209489', 'Rakha Dhifiargo Hariadi', 'Laki-laki', 0),
(10, '2203142', 'Roshan Syalwan Nurilham', 'Laki-laki', 0),
(11, '2200311', 'Raden Rahman Ismail', 'Laki-laki', 0),
(12, '2200978', 'Ratu Syahirah Khairunnisa', 'Perempuan', 0),
(13, '2204509', 'Muhammad Fahreza Fauzan', 'Laki-laki', 0),
(14, '2205027', 'Muhammad Rizki Revandi', 'Laki-laki', 0),
(15, '2203484', 'Arya Aydin Margono', 'Laki-laki', 0),
(16, '2200481', 'Marvel Ravindra Dioputra', 'Laki-laki', 0),
(17, '2209889', 'Muhammad Fadlul Hafiizh', 'Laki-laki', 0),
(18, '2206697', 'Rifa Sania', 'Perempuan', 0),
(19, '2207260', 'Imam Chalish Rafidhul Haque', 'Laki-laki', 0),
(24, '2100991', 'Khana Yusdiana', 'Perempuan', 90);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
