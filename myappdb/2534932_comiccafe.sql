-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2017 at 09:31 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `comic_cafe`
--

-- --------------------------------------------------------

--
-- Table structure for table `chapter_has_images`
--

CREATE TABLE `chapter_has_images` (
  `id` int(11) NOT NULL,
  `id_chapter` int(11) NOT NULL,
  `url` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chapter_has_images`
--

INSERT INTO `chapter_has_images` (`id`, `id_chapter`, `url`) VALUES
(1, 1, 'http://2.bp.blogspot.com/-k4AGcLvbE2w/WAsJerGu4yI/AAAAAAD5szc/e0bZ6c_aYB4/w1900/MR-20606-338065-1.jpg'),
(2, 1, 'http://3.bp.blogspot.com/-RYnTuqRf7qU/WAsJeCQi8LI/AAAAAAD5szA/fZ8s1o4bRY0/w1900/MR-20606-338065-2.jpg'),
(3, 1, 'http://4.bp.blogspot.com/-Fan59YrgQ-w/WAsJdpbJ5nI/AAAAAAD5sys/0qXr0y3XClg/w1900/MR-20606-338065-3.jpg'),
(4, 6, 'http://4.bp.blogspot.com/--dqaxg8zvNg/VmCz0zHAZ9I/AAAAAAADMWY/ez6UveoUWiA/w1900/3.jpg'),
(5, 6, 'http://2.bp.blogspot.com/-FNJxumr6Gpw/VmCz1xuzatI/AAAAAAADMXE/fNO4JxuE6gY/w1900/5.jpg'),
(6, 6, 'http://3.bp.blogspot.com/-1sCrMroHNlo/VmCz2YIc7WI/AAAAAAADMXQ/ygk6RCx4Ajc/w1900/6.jpg'),
(7, 6, 'http://4.bp.blogspot.com/-LFx2UYC43Co/VmCz29EhL6I/AAAAAAADMXo/Va4On_Rc8aw/w1900/7.jpg'),
(8, 7, 'http://1.bp.blogspot.com/-bZzm0L7LoeA/V-qz9hrJv1I/AAAAAACZSkY/lyMM57FthGM/w1900/MR-90-4354-4.jpg'),
(9, 7, 'http://3.bp.blogspot.com/-rXpUkH27AaE/V-qz7kDs5II/AAAAAACZSjY/F6-WYxTooC0/w1900/MR-90-4354-6.jpg'),
(10, 7, 'http://4.bp.blogspot.com/-6lKAK465khM/V-qz6iN6hGI/AAAAAACZSjE/eBvfUEKBwEQ/w1900/MR-90-4354-7.jpg'),
(11, 7, 'http://1.bp.blogspot.com/-vhnca4dQuYM/V-qz55TP1SI/AAAAAACZSiw/Xb8FDtmDmYg/w1900/MR-90-4354-8.jpg'),
(12, 8, 'http://1.bp.blogspot.com/-vhnca4dQuYM/V-qz55TP1SI/AAAAAACZSiw/Xb8FDtmDmYg/w1900/MR-90-4354-8.jpg'),
(13, 8, 'http://1.bp.blogspot.com/-uSS3-6b-fZ8/WCS5rHgDu9I/AAAAAAFDUJk/9GYaEN51EJA/w1900/MR-90-4355-4.jpg'),
(14, 8, 'http://2.bp.blogspot.com/-ddq_QIuVDfg/WCS5qvMLSXI/AAAAAAFDUJM/tkmwf3flCJc/w1900/MR-90-4355-5.jpg'),
(15, 8, 'http://3.bp.blogspot.com/-eEwQNIRy2II/WCS5qF3Ev2I/AAAAAAFDUIw/cM-cIZXxRp0/w1900/MR-90-4355-6.jpg'),
(16, 9, 'http://3.bp.blogspot.com/-jsjwDyC_QCU/V-rLaZA8btI/AAAAAACZcxI/PKdImRZf1_I/w1900/MR-90-4356-2.jpg'),
(17, 9, 'http://1.bp.blogspot.com/-l8Jwq8mJ-XY/V-rLXpuHELI/AAAAAACZcv0/X10UPGf6ub8/w1900/MR-90-4356-4.jpg'),
(18, 9, 'http://2.bp.blogspot.com/-Mx61WUr_oG4/V-rLWpdpihI/AAAAAACZcvY/VwHGdEXJhPE/w1900/MR-90-4356-5.jpg'),
(19, 9, 'http://3.bp.blogspot.com/-lO8s6wLqon0/V-rLVis2PiI/AAAAAACZcu8/nxPSmm0_3e8/w1900/MR-90-4356-6.jpg'),
(20, 10, 'http://2.bp.blogspot.com/-DpVqedrW824/V-qsLwhR-nI/AAAAAACZPHA/MkFild_AAOU/w1900/MR-90-4357-1.jpg'),
(21, 10, 'http://3.bp.blogspot.com/-8DyXyz6UuvI/V-qsKDoVFPI/AAAAAACZPGk/jP-C7q-hoZY/w1900/MR-90-4357-2.jpg'),
(22, 10, 'http://4.bp.blogspot.com/-EHggxNZISlw/V-qsJLgh1tI/AAAAAACZPFs/jdEmHaPBSMQ/w1900/MR-90-4357-3.jpg'),
(23, 10, 'http://1.bp.blogspot.com/-SVp2ABN6rI0/V-qsICuYcmI/AAAAAACZPFM/swRbgIDqTL0/w1900/MR-90-4357-4.jpg'),
(24, 11, 'http://2.bp.blogspot.com/-GCg9S32GGR8/WDUc3X5UN1I/AAAAAAFpI6w/XcK-yKHWWAM/w1900/MR-6983-62291-1.jpg'),
(25, 11, 'http://3.bp.blogspot.com/-4IloPOlyhmY/WDUc2feeopI/AAAAAAFpI6Y/LR2w8nBblU8/w1900/MR-6983-62291-2.jpg'),
(26, 11, 'http://4.bp.blogspot.com/-c6Wh_z-gEXg/WDUc17p_TMI/AAAAAAFpI6A/XVZ3EL31_hA/w1900/MR-6983-62291-3.jpg'),
(27, 11, 'http://1.bp.blogspot.com/-G3IX8_uS8D8/WDUc1FiMIZI/AAAAAAFpI5s/iBGeyniCyW4/w1900/MR-6983-62291-4.jpg'),
(28, 11, 'http://2.bp.blogspot.com/-UFW4lWaGH6k/WDUc0ZFqTiI/AAAAAAFpI5Y/Ltwa4p_cM5M/w1900/MR-6983-62291-5.jpg'),
(29, 11, 'http://2.bp.blogspot.com/-UFW4lWaGH6k/WDUc0ZFqTiI/AAAAAAFpI5Y/Ltwa4p_cM5M/w1900/MR-6983-62291-5.jpg'),
(30, 11, 'http://4.bp.blogspot.com/-dEtq1Oxv1Os/WDUcyzYt2_I/AAAAAAFpI4k/rsyn0p1bdh0/w1900/MR-6983-62291-7.jpg'),
(31, 11, 'http://1.bp.blogspot.com/-QOGkYmaMGkk/WDUcyM2ZW8I/AAAAAAFpI4Q/R5B61RcwWIM/w1900/MR-6983-62291-8.jpg'),
(32, 11, 'http://2.bp.blogspot.com/-gxOZ6Ijfsfc/WDUcxqLkS1I/AAAAAAFpI38/vvuPDqaaWuo/w1900/MR-6983-62291-9.jpg'),
(33, 11, 'http://3.bp.blogspot.com/-xVHfIEVBixU/WDUcwnjg0gI/AAAAAAFpI3k/h4FKCS063-U/w1900/MR-6983-62291-10.jpg'),
(34, 11, 'http://4.bp.blogspot.com/-QGECIhvyJy0/WDUcvxywdpI/AAAAAAFpI3c/uzBVylxAe7I/w1900/MR-6983-62291-11.jpg'),
(35, 11, 'http://1.bp.blogspot.com/-cFCWjQP2UiI/WDUcvFWRcxI/AAAAAAFpI3M/pptBA8IITmA/w1900/MR-6983-62291-12.jpg'),
(36, 11, 'http://2.bp.blogspot.com/-dQyUItvsyzs/WDUbx52XRpI/AAAAAAFpIek/9qps4VEOJ9U/w1900/MR-6983-62291-13.jpg'),
(37, 11, 'http://3.bp.blogspot.com/-m0uDQiJHHlw/WDUbwjEekdI/AAAAAAFpIeM/1HG5hG_e7RM/w1900/MR-6983-62291-14.jpg'),
(38, 11, 'http://4.bp.blogspot.com/-s0hmMT78nRk/WDUbvzrqWkI/AAAAAAFpId0/J1pbl2kSIH8/w1900/MR-6983-62291-15.jpg'),
(39, 11, 'http://1.bp.blogspot.com/-p2PidJ-Nn3Y/WDUbvZQmD7I/AAAAAAFpIdg/YzFnG9se36k/w1900/MR-6983-62291-16.jpg'),
(40, 11, 'http://2.bp.blogspot.com/-vgkeiNNVXAI/WDUbuuvUheI/AAAAAAFpIdQ/meYZTKjg8jE/w1900/MR-6983-62291-17.jpg'),
(41, 11, 'http://3.bp.blogspot.com/-1dDo__Z6uU8/WDUbt9KVjzI/AAAAAAFpIdE/1YSzZVaF3NY/w1900/MR-6983-62291-18.jpg'),
(42, 11, 'http://4.bp.blogspot.com/-vo7CIN60E8M/WDUbtAqwXKI/AAAAAAFpIcw/QMoz8UuvGGs/w1900/MR-6983-62291-19.jpg'),
(43, 11, 'http://1.bp.blogspot.com/-sqLSPhKBGNM/WDUbsThm20I/AAAAAAFpIcg/HXnO7nKBB6w/w1900/MR-6983-62291-20.jpg'),
(44, 11, 'http://2.bp.blogspot.com/-pMCGqjTfwIw/WDUbr70T22I/AAAAAAFpIcM/YdCFAnkTIMU/w1900/MR-6983-62291-21.jpg'),
(45, 11, 'http://3.bp.blogspot.com/--uu9f0h7FUk/WDUbrNHut_I/AAAAAAFpIb8/XEis6O8oN-A/w1900/MR-6983-62291-22.jpg'),
(46, 11, 'http://4.bp.blogspot.com/-HgLPZ9JdTtI/WDUbqbcRpzI/AAAAAAFpIbo/Ayt2NQ-WPVA/w1900/MR-6983-62291-23.jpg'),
(47, 11, 'http://1.bp.blogspot.com/-N907p7WIMP4/WDUbptMCShI/AAAAAAFpIbU/GGBziUUDy0s/w1900/MR-6983-62291-24.jpg'),
(48, 11, 'http://2.bp.blogspot.com/-_AmjGIiyYag/WDUbo2UxQgI/AAAAAAFpIa8/VbNzXMwcgXY/w1900/MR-6983-62291-25.jpg'),
(49, 11, 'http://3.bp.blogspot.com/-g0nkxw6jBk8/WDUboH56fkI/AAAAAAFpIas/mz9MT9yUDzE/w1900/MR-6983-62291-26.jpg'),
(50, 11, 'http://4.bp.blogspot.com/-usbGJyuhsRY/WDUbm0Mh7jI/AAAAAAFpIaY/gg_07itOIlQ/w1900/MR-6983-62291-27.jpg'),
(51, 11, 'http://1.bp.blogspot.com/--SX3poViKtY/WDUbl-GYZGI/AAAAAAFpIZ0/7UgFRYgSJJs/w1900/MR-6983-62291-28.jpg'),
(52, 11, 'http://2.bp.blogspot.com/-EU0g8xO6fAg/WDUblYhJzeI/AAAAAAFpIZg/RWVqYGXxCxs/w1900/MR-6983-62291-29.jpg'),
(53, 11, 'http://3.bp.blogspot.com/-uDPyLJRUlg8/WDUbkgjje7I/AAAAAAFpIZQ/8z6lGeHbKcU/w1900/MR-6983-62291-30.jpg'),
(54, 11, 'http://4.bp.blogspot.com/-YOAP7hHUJE0/WDUa1bKwosI/AAAAAAFpIFc/T4IsT322pCE/w1900/MR-6983-62291-31.jpg'),
(55, 11, 'http://1.bp.blogspot.com/-WiGtlZwVQ6k/WDUa0IQ1UDI/AAAAAAFpIFI/ev1joCPHQhA/w1900/MR-6983-62291-32.jpg'),
(56, 11, 'http://2.bp.blogspot.com/-cwih6qZmmNo/WDUazVuW5LI/AAAAAAFpIEw/0aCKFR8gvrc/w1900/MR-6983-62291-33.jpg'),
(76, 16, 'http://3.p.mpcdn.net/48872/1066609/4.jpg'),
(77, 16, 'http://3.p.mpcdn.net/48872/1066609/3.jpg'),
(78, 16, 'http://3.p.mpcdn.net/48872/1066609/5.jpg'),
(79, 16, 'http://3.p.mpcdn.net/48872/1066609/6.jpg'),
(80, 16, 'http://3.p.mpcdn.net/48872/1066609/7.jpg'),
(81, 16, 'http://3.p.mpcdn.net/48872/1066609/8.jpg'),
(82, 16, 'http://3.p.mpcdn.net/48872/1066609/9.jpg'),
(83, 16, 'http://3.p.mpcdn.net/48872/1066609/10.jpg'),
(84, 16, 'http://3.p.mpcdn.net/48872/1066609/11.jpg'),
(85, 16, 'http://3.p.mpcdn.net/48872/1066609/12.jpg'),
(86, 16, 'http://3.p.mpcdn.net/48872/1066609/13.jpg'),
(87, 16, 'http://3.p.mpcdn.net/48872/1066609/14.jpg'),
(88, 16, 'http://3.p.mpcdn.net/48872/1066609/15.jpg'),
(89, 16, 'http://3.p.mpcdn.net/48872/1066609/16.jpg'),
(90, 16, 'http://3.p.mpcdn.net/48872/1066609/17.jpg'),
(91, 16, 'http://3.p.mpcdn.net/48872/1066609/18.jpg'),
(92, 16, 'http://3.p.mpcdn.net/48872/1066609/19.jpg'),
(93, 16, 'http://3.p.mpcdn.net/48872/1066609/20.jpg'),
(94, 16, 'http://3.p.mpcdn.net/48872/1066609/21.jpg'),
(95, 17, 'http://2.bp.blogspot.com/-qKg60nTpz60/WB4Yth6S79I/AAAAAAEyLfM/2LEZQbx_vfg/w1900/MR-18288-283567-1.jpg'),
(96, 17, 'http://3.bp.blogspot.com/-AxOKeqJshQs/WB4Ysx8BcKI/AAAAAAEyLew/2IfVOputCf4/w1900/MR-18288-283567-2.jpg'),
(97, 17, 'http://4.bp.blogspot.com/-UYYFxWPdYZg/WB4YsTVa_MI/AAAAAAEyLeY/pTd8QxAmoe4/w1900/MR-18288-283567-3.jpg'),
(98, 17, 'http://1.bp.blogspot.com/-ikX4_5_ebpw/WB4YrtxM-8I/AAAAAAEyLd0/lP7SgNa6geo/w1900/MR-18288-283567-4.jpg'),
(99, 17, 'http://2.bp.blogspot.com/-py4K3TgVPkQ/WB4Yq2nCSzI/AAAAAAEyLdM/8SOjpesW1Cg/w1900/MR-18288-283567-5.jpg'),
(100, 17, 'http://3.bp.blogspot.com/-PYr6azNDF14/WB4YqZCxDCI/AAAAAAEyLco/0YQ0uuVoJXw/w1900/MR-18288-283567-6.jpg'),
(101, 17, 'http://4.bp.blogspot.com/-3hcJ7aXHngg/WB4Ypp55R5I/AAAAAAEyLcE/ITUUMwEl68s/w1900/MR-18288-283567-7.jpg'),
(102, 17, 'http://1.bp.blogspot.com/-Wno9xjdHYvY/WB4Yo2_6rsI/AAAAAAEyLbc/OkjWm3d4AqU/w1900/MR-18288-283567-8.jpg'),
(103, 17, 'http://2.bp.blogspot.com/-2wDSH5glW3M/WB4YnWCh6zI/AAAAAAEyLa4/lPKuNePqwpc/w1900/MR-18288-283567-9.jpg'),
(104, 17, 'http://3.bp.blogspot.com/-6IFjMZn3dqw/WB4YmSHuK_I/AAAAAAEyLaQ/a9aiLkPQNqA/w1900/MR-18288-283567-10.jpg'),
(105, 17, 'http://4.bp.blogspot.com/-P1jiHOQB1Ts/WB4YloLFkEI/AAAAAAEyLZY/itMVwRrwDk0/w1900/MR-18288-283567-11.jpg'),
(106, 17, 'http://1.bp.blogspot.com/-JtVHAhIKbgk/WB4YlKAruwI/AAAAAAEyLY4/Oq6HM69NXjI/w1900/MR-18288-283567-12.jpg'),
(107, 17, 'http://2.bp.blogspot.com/-qVc2cTCRVh4/WB4YkULbemI/AAAAAAEyLYQ/hUljbcmWzS8/w1900/MR-18288-283567-13.jpg'),
(108, 17, 'http://3.bp.blogspot.com/-sdftEhQO3yo/WB4Yi7y-vdI/AAAAAAEyLXk/Ex8NEV2xvD8/w1900/MR-18288-283567-14.jpg'),
(109, 17, 'http://4.bp.blogspot.com/-qkhGdziIvEA/WB4WWM6gsDI/AAAAAAEyJv8/sfaNOHb50Cw/w1900/MR-18288-283567-15.jpg'),
(110, 17, 'http://1.bp.blogspot.com/-L5Lvx5XcDkI/WB4WVQ5H4PI/AAAAAAEyJvo/qx-PdXdzfgY/w1900/MR-18288-283567-16.jpg'),
(111, 17, 'http://2.bp.blogspot.com/-x04-eAp4JuA/WB4WUxoAp9I/AAAAAAEyJvQ/bAWs2ULqezs/w1900/MR-18288-283567-17.jpg'),
(112, 17, 'http://3.bp.blogspot.com/-8zhdsNEHkUU/WB4WT6-pHbI/AAAAAAEyJug/bwt0CArcFMI/w1900/MR-18288-283567-18.jpg'),
(113, 17, 'http://4.bp.blogspot.com/-8N4zXz6HFrc/WB4WTb7lTXI/AAAAAAEyJuI/vcjP-qR9p3k/w1900/MR-18288-283567-19.jpg'),
(114, 18, 'http://2.bp.blogspot.com/-klV7ijDvj5o/V__sw-VFi2I/AAAAAADb1oc/NN5V-B2WJRU/w1900/MR-25683-442844-1.jpg'),
(115, 18, 'http://3.bp.blogspot.com/-pmThwqW58eg/V__sv13pvaI/AAAAAADb1n4/MVCn4jz6IDM/w1900/MR-25683-442844-2.jpg'),
(116, 18, 'http://4.bp.blogspot.com/-krednSCsxwo/V__qf6eHRPI/AAAAAADbz_k/io0XHIaaIEs/w1900/MR-25683-442844-3.jpg'),
(117, 18, 'http://1.bp.blogspot.com/-UEOGOkye3rM/V__qfIu5TCI/AAAAAADbz_E/2zeiw8PF5Fw/w1900/MR-25683-442844-4.jpg'),
(118, 18, 'http://2.bp.blogspot.com/-jHcGC0rGQ_U/V__qeO3pC7I/AAAAAADbz-Y/0wynAAN5LK8/w1900/MR-25683-442844-5.jpg'),
(119, 18, 'http://3.bp.blogspot.com/-WMru9MbBsOU/V__qc954BvI/AAAAAADbz9g/eWW2zHgOMPw/w1900/MR-25683-442844-6.jpg'),
(120, 18, 'http://4.bp.blogspot.com/-HgfWYqSNa8k/V__qb2KAQ9I/AAAAAADbz80/7G1FUkFfjWw/w1900/MR-25683-442844-7.jpg'),
(121, 18, 'http://1.bp.blogspot.com/-7x31a28VK5M/V__qbOk4B-I/AAAAAADbz8Y/b1siRCVTdHQ/w1900/MR-25683-442844-8.jpg'),
(122, 18, 'http://2.bp.blogspot.com/-FM9Od1ifFlE/V__qaZshq9I/AAAAAADbz70/P-9HqDsFl_0/w1900/MR-25683-442844-9.jpg'),
(123, 18, 'http://3.bp.blogspot.com/-WvncDtjyhdE/V__qZ_zojEI/AAAAAADbz7U/i2XY-ayklUI/w1900/MR-25683-442844-10.jpg'),
(124, 18, 'http://4.bp.blogspot.com/-wDQKGAEmCzM/V__qZMx-VUI/AAAAAADbz60/S1JwrPzgFgU/w1900/MR-25683-442844-11.jpg'),
(125, 18, 'http://1.bp.blogspot.com/-kw3QDpaMr3g/V__qYUhgehI/AAAAAADbz6U/Hqt0S1d5jgA/w1900/MR-25683-442844-12.jpg'),
(126, 19, 'http://2.bp.blogspot.com/-UMjcZWGXjH4/WAqIY970IeI/AAAAAAD4Ox0/JMksrr7Myk4/w1900/MR-22043-377666-1.jpg'),
(127, 19, 'http://3.bp.blogspot.com/-078PtUJIDDk/WAqIXxGGcYI/AAAAAAD4Ow4/jVNQSSmEvtw/w1900/MR-22043-377666-2.jpg'),
(128, 19, 'http://4.bp.blogspot.com/-HFyET77_Qcc/WAqIXLd-VyI/AAAAAAD4OwI/WEh3LuYm6EM/w1900/MR-22043-377666-3.jpg'),
(129, 19, 'http://1.bp.blogspot.com/-7XPkOdROpYI/WAqIWYzAkgI/AAAAAAD4Ovc/suKI6h3ukmA/w1900/MR-22043-377666-4.jpg'),
(130, 19, 'http://1.bp.blogspot.com/-7XPkOdROpYI/WAqIWYzAkgI/AAAAAAD4Ovc/suKI6h3ukmA/w1900/MR-22043-377666-4.jpg'),
(131, 19, 'http://3.bp.blogspot.com/-n7QZbujk--I/WAqGFFfhh3I/AAAAAAD4NE8/lQN7UrQ7K54/w1900/MR-22043-377666-6.jpg'),
(132, 19, 'http://4.bp.blogspot.com/-oNpAkvL6IYM/WAqGEdewR7I/AAAAAAD4NEc/bRE3naFL8xM/w1900/MR-22043-377666-7.jpg'),
(133, 19, 'http://1.bp.blogspot.com/-p4pFdWwvlBA/WAqGDWVMsQI/AAAAAAD4ND8/MUx_IpkGDjY/w1900/MR-22043-377666-8.jpg'),
(134, 19, 'http://2.bp.blogspot.com/-e7jK0WU-XoE/WAqGCkb7byI/AAAAAAD4NDE/dUpJiadB8ZM/w1900/MR-22043-377666-9.jpg'),
(135, 19, 'http://3.bp.blogspot.com/-BOSH9o2ohxM/WAqGBzqpuOI/AAAAAAD4NCc/uKVvJE4Hs3Y/w1900/MR-22043-377666-10.jpg'),
(136, 19, 'http://4.bp.blogspot.com/-27meK4yiLPc/WAqGAw1lbxI/AAAAAAD4NB4/EEx7e4mKN6k/w1900/MR-22043-377666-11.jpg'),
(137, 19, 'http://1.bp.blogspot.com/-hRQpPA4ggSc/WAqGAAnXeZI/AAAAAAD4NBE/rRIUmliSwfY/w1900/MR-22043-377666-12.jpg'),
(138, 19, 'http://2.bp.blogspot.com/-G44jcyJzvMQ/WAqF_oj-TVI/AAAAAAD4NAg/l3x1JJvawaY/w1900/MR-22043-377666-13.jpg'),
(139, 19, 'http://3.bp.blogspot.com/-O6gI7-2hUrU/WAqF-t-9LQI/AAAAAAD4M_w/21DVwmp7MCg/w1900/MR-22043-377666-14.jpg'),
(140, 19, 'http://4.bp.blogspot.com/-kOYZadq-W58/WAqF-LIPKYI/AAAAAAD4M_M/QqQBYExzsnA/w1900/MR-22043-377666-15.jpg'),
(141, 19, 'http://1.bp.blogspot.com/-3QSVy46DEg4/WAqF8sd_EKI/AAAAAAD4M-k/Sgdex7FAmwE/w1900/MR-22043-377666-16.jpg'),
(142, 19, 'http://2.bp.blogspot.com/-oT50FTs3MYQ/WAqF8Oa5yPI/AAAAAAD4M90/00V5iJ5nrd0/w1900/MR-22043-377666-17.jpg'),
(143, 19, 'http://3.bp.blogspot.com/-NzWE8XEVUBI/WAqF7cWN8_I/AAAAAAD4M9Q/iRqUBhsyyGY/w1900/MR-22043-377666-18.jpg'),
(144, 19, 'http://4.bp.blogspot.com/-jE2o7SRBjIg/WAqF6iK0AmI/AAAAAAD4M8s/1fR-N8fBaVs/w1900/MR-22043-377666-19.jpg'),
(145, 19, 'http://1.bp.blogspot.com/-5umadS4KR8s/WAqF5xt0uPI/AAAAAAD4M8E/Lui-N81ySFc/w1900/MR-22043-377666-20.jpg'),
(146, 19, 'http://2.bp.blogspot.com/-0vkrOtVk1gY/WAqF5JNL1tI/AAAAAAD4M7c/0qma_evXSos/w1900/MR-22043-377666-21.jpg'),
(147, 19, 'http://3.bp.blogspot.com/-hlIgNPmjdzk/WAqF4H1AxII/AAAAAAD4M60/DNbRZntkfa0/w1900/MR-22043-377666-22.jpg'),
(148, 19, 'http://4.bp.blogspot.com/-Uasg4XwWGrE/WAqF3aieVQI/AAAAAAD4M50/Fns41X88b4Y/w1900/MR-22043-377666-23.jpg'),
(149, 19, 'http://1.bp.blogspot.com/-aK7PMBuES0A/WAqF215eWbI/AAAAAAD4M5U/RghxaWqfKng/w1900/MR-22043-377666-24.jpg'),
(150, 19, 'http://2.bp.blogspot.com/-A0w2AWLEAlA/WAqF14uDgBI/AAAAAAD4M4k/-0eMmpdQssQ/w1900/MR-22043-377666-25.jpg'),
(151, 19, 'http://3.bp.blogspot.com/-Sswc3ODWLyI/WAqDnkhD2dI/AAAAAAD4LPI/GhFlBuf855g/w1900/MR-22043-377666-26.jpg'),
(152, 19, 'http://4.bp.blogspot.com/-swSxy1hD7Q8/WAqDmsR1zKI/AAAAAAD4LOo/SrPo_-bTWd0/w1900/MR-22043-377666-27.jpg'),
(153, 19, 'http://1.bp.blogspot.com/-3otLuhiXGAc/WAqDl2pLBiI/AAAAAAD4LNw/WgYf_OrDaI0/w1900/MR-22043-377666-28.jpg'),
(154, 19, 'http://2.bp.blogspot.com/-s_Kkhvg66-A/WAqDkRmPGVI/AAAAAAD4LNM/b1lptWieCto/w1900/MR-22043-377666-29.jpg'),
(155, 19, 'http://3.bp.blogspot.com/-KCUPgt3XNwU/WAqDjoNZ48I/AAAAAAD4LMU/21Y3w0dy0xU/w1900/MR-22043-377666-30.jpg'),
(156, 19, 'http://4.bp.blogspot.com/-zZTNkPr4Uhw/WAqDiv5I3KI/AAAAAAD4LLs/E1Hyl-gzEK0/w1900/MR-22043-377666-31.jpg'),
(157, 19, 'http://1.bp.blogspot.com/-RzXlZe4Rbbs/WAqDhZQQHoI/AAAAAAD4LKg/M7QiNPjQgn8/w1900/MR-22043-377666-32.jpg'),
(158, 19, 'http://2.bp.blogspot.com/-YzrtwYsRncU/WAqDg1uYu5I/AAAAAAD4LJ8/lXTOHKNoa-I/w1900/MR-22043-377666-33.jpg'),
(159, 20, 'http://3.p.mpcdn.net/48872/1066610/3.jpg'),
(160, 20, 'http://3.p.mpcdn.net/48872/1066610/4.jpg'),
(161, 20, 'http://3.p.mpcdn.net/48872/1066610/5.jpg'),
(162, 20, 'http://3.p.mpcdn.net/48872/1066610/6.jpg'),
(163, 20, 'http://3.p.mpcdn.net/48872/1066610/7.jpg'),
(164, 20, 'http://3.p.mpcdn.net/48872/1066610/8.jpg'),
(165, 20, 'http://3.p.mpcdn.net/48872/1066610/9.jpg'),
(166, 20, 'http://3.p.mpcdn.net/48872/1066610/10.jpg'),
(167, 20, 'http://3.p.mpcdn.net/48872/1066610/11.jpg'),
(168, 20, 'http://3.p.mpcdn.net/48872/1066610/12.jpg'),
(169, 20, 'http://3.p.mpcdn.net/48872/1066610/13.jpg'),
(170, 20, 'http://3.p.mpcdn.net/48872/1066610/14.jpg'),
(171, 21, 'http://3.p.mpcdn.net/48872/1066611/3.jpg'),
(172, 21, 'http://3.p.mpcdn.net/48872/1066611/4.jpg'),
(173, 21, 'http://3.p.mpcdn.net/48872/1066611/5.jpg'),
(174, 21, 'http://3.p.mpcdn.net/48872/1066611/6.jpg'),
(175, 21, 'http://3.p.mpcdn.net/48872/1066611/7.jpg'),
(176, 21, 'http://3.p.mpcdn.net/48872/1066611/8.jpg'),
(177, 21, 'http://3.p.mpcdn.net/48872/1066611/9.jpg'),
(178, 21, 'http://3.p.mpcdn.net/48872/1066611/10.jpg'),
(179, 21, 'http://3.p.mpcdn.net/48872/1066611/11.jpg'),
(180, 21, 'http://3.p.mpcdn.net/48872/1066611/12.jpg'),
(181, 21, 'http://3.p.mpcdn.net/48872/1066611/13.jpg'),
(182, 21, 'http://3.p.mpcdn.net/48872/1066611/14.jpg'),
(183, 22, 'http://3.bp.blogspot.com/-36C0LlCCQho/WDUayCXkVBI/AAAAAAFpIEA/w5dJ_5OnIas/w1900/MR-6983-62292-2.jpg'),
(184, 22, 'http://4.bp.blogspot.com/-LjN50KzJOTo/WDUaxJsdZPI/AAAAAAFpIDk/OQTOygoRnMc/w1900/MR-6983-62292-3.jpg'),
(185, 22, 'http://1.bp.blogspot.com/-aq1ZtqyuxbQ/WDUawjJ4_vI/AAAAAAFpIDM/sEjh9q3eG3M/w1900/MR-6983-62292-4.jpg'),
(186, 22, 'http://2.bp.blogspot.com/-Fm_THJB4Ol0/WDUav-FdK2I/AAAAAAFpIC0/5XxOsop_K1M/w1900/MR-6983-62292-5.jpg'),
(187, 22, 'http://3.bp.blogspot.com/-YNQswN-aMY8/WDUavXIL7gI/AAAAAAFpICc/mY__5KWjzSw/w1900/MR-6983-62292-6.jpg'),
(188, 22, 'http://4.bp.blogspot.com/-5P5CSm_VxlA/WDUaur5dqwI/AAAAAAFpICI/yGU03bBhCi0/w1900/MR-6983-62292-7.jpg'),
(189, 22, 'http://1.bp.blogspot.com/-6T5sNXFPWck/WDUatzxygJI/AAAAAAFpIB4/20NE4EahY6o/w1900/MR-6983-62292-8.jpg'),
(190, 22, 'http://2.bp.blogspot.com/-0dnDddO5Kgk/WDUas80yy4I/AAAAAAFpIBc/nrwKUvH-hxY/w1900/MR-6983-62292-9.jpg'),
(191, 22, 'http://3.bp.blogspot.com/-5TSHdi_rXwA/WDUasb1_0JI/AAAAAAFpIBI/sOEwX_kABf8/w1900/MR-6983-62292-10.jpg'),
(192, 22, 'http://4.bp.blogspot.com/-jmWQ4uS7WIs/WDUarlb-9oI/AAAAAAFpIAw/5otqdhpnYCQ/w1900/MR-6983-62292-11.jpg'),
(193, 22, 'http://1.bp.blogspot.com/-uS_NdettMSg/WDUaq9j5noI/AAAAAAFpIAY/Z5sw94C89JI/w1900/MR-6983-62292-12.jpg'),
(194, 22, 'http://2.bp.blogspot.com/-He2dY6QD62Y/WDUaqBLUGaI/AAAAAAFpIAA/JT1ExlikleY/w1900/MR-6983-62292-13.jpg'),
(195, 22, 'http://3.bp.blogspot.com/-2V-sddtIA40/WDUapZ7mAXI/AAAAAAFpH_s/9U_qTXUPMZo/w1900/MR-6983-62292-14.jpg'),
(196, 22, 'http://4.bp.blogspot.com/-0fXs3bJsIp4/WDUaogI0v0I/AAAAAAFpH_U/l5WEOIOMQgo/w1900/MR-6983-62292-15.jpg'),
(197, 22, 'http://1.bp.blogspot.com/-mNIFJT1BvcQ/WDUZsENhRrI/AAAAAAFpHmk/CLuK_LzeW3w/w1900/MR-6983-62292-16.jpg'),
(198, 22, 'http://2.bp.blogspot.com/-fJinDEDFgSM/WDUZrqV0XBI/AAAAAAFpHmQ/wj7fwGb-JLY/w1900/MR-6983-62292-17.jpg'),
(199, 22, 'http://3.bp.blogspot.com/-F-0WgYo3UBg/WDUZqxakH3I/AAAAAAFpHmA/E_C1nFwGhxE/w1900/MR-6983-62292-18.jpg'),
(200, 22, 'http://4.bp.blogspot.com/-cJE9PR9Bwp8/WDUZp2xmLuI/AAAAAAFpHls/6K6-4IB6RHY/w1900/MR-6983-62292-19.jpg'),
(201, 22, 'http://1.bp.blogspot.com/-LCuTkQdf1Tg/WDUZo0VwP5I/AAAAAAFpHlI/21mMM9xe3Ao/w1900/MR-6983-62292-20.jpg'),
(202, 22, 'http://2.bp.blogspot.com/-0IAt-5qAEPQ/WDUZofIqN4I/AAAAAAFpHk0/ZvZwzviZvNM/w1900/MR-6983-62292-21.jpg'),
(203, 22, 'http://3.bp.blogspot.com/-o-lR8-rVqtY/WDUZniBMTiI/AAAAAAFpHkc/V-7EdtgIAHk/w1900/MR-6983-62292-22.jpg'),
(204, 22, 'http://4.bp.blogspot.com/-NKA8YCO3UBs/WDUZly-By7I/AAAAAAFpHkI/QzWlGWV-_FY/w1900/MR-6983-62292-23.jpg'),
(205, 22, 'http://1.bp.blogspot.com/-rIrrKHkt9cw/WDUZlOQYDhI/AAAAAAFpHjc/QCbHExSRnjg/w1900/MR-6983-62292-24.jpg'),
(206, 22, 'http://2.bp.blogspot.com/-TabmfsWHH1E/WDUZkIEMN7I/AAAAAAFpHjE/KzILKhXEISU/w1900/MR-6983-62292-25.jpg'),
(207, 22, 'http://3.bp.blogspot.com/-v97Oyn9e6OE/WDUZjJx7iWI/AAAAAAFpHik/UTA1D0DPXOQ/w1900/MR-6983-62292-26.jpg'),
(208, 23, 'http://3.bp.blogspot.com/-oGsuEj_67ug/WDUZhgndnBI/AAAAAAFpHh0/BSKhk46zNEU/w1900/MR-6983-62293-2.jpg'),
(209, 23, 'http://4.bp.blogspot.com/-SaBPBpRjJIQ/WDUZgjOU1WI/AAAAAAFpHhc/yTfsD7xPTUY/w1900/MR-6983-62293-3.jpg'),
(210, 23, 'http://1.bp.blogspot.com/-8SIJrUnF_dE/WDUZftPObiI/AAAAAAFpHhI/_B0MwkyebhY/w1900/MR-6983-62293-4.jpg'),
(211, 23, 'http://2.bp.blogspot.com/-Y9LGfUBSRK0/WDUZe3ajlTI/AAAAAAFpHgw/FNZMm3GLJAI/w1900/MR-6983-62293-5.jpg'),
(212, 23, 'http://3.bp.blogspot.com/-iqSY1qOXZWk/WDUZeIfWWQI/AAAAAAFpHgc/dRvgbG7OG4M/w1900/MR-6983-62293-6.jpg'),
(213, 23, 'http://3.bp.blogspot.com/-iqSY1qOXZWk/WDUZeIfWWQI/AAAAAAFpHgc/dRvgbG7OG4M/w1900/MR-6983-62293-6.jpg'),
(214, 23, 'http://4.bp.blogspot.com/-XyorcZoJ9Mg/WDUZdAG-DyI/AAAAAAFpHgM/KpCJCdu96g4/w1900/MR-6983-62293-7.jpg'),
(215, 23, 'http://1.bp.blogspot.com/-ZHCM6vATx98/WDUYgvvu28I/AAAAAAFpHJY/1iNTZJd91m0/w1900/MR-6983-62293-8.jpg'),
(216, 23, 'http://2.bp.blogspot.com/-xBszv6e0dlk/WDUYfc9A0cI/AAAAAAFpHJE/une9yBk1tKM/w1900/MR-6983-62293-9.jpg'),
(217, 23, 'http://3.bp.blogspot.com/-JeVUJ5mIQGw/WDUYejhCR-I/AAAAAAFpHIo/1klF-AcdC-A/w1900/MR-6983-62293-10.jpg'),
(218, 23, 'http://4.bp.blogspot.com/-33THixzj4TY/WDUYeB5UeLI/AAAAAAFpHIU/JcPyMhcunv8/w1900/MR-6983-62293-11.jpg'),
(219, 23, 'http://1.bp.blogspot.com/-ftTN69XW5rc/WDUYdIa9A9I/AAAAAAFpHIE/ZsUxBA3Xc9c/w1900/MR-6983-62293-12.jpg'),
(220, 23, 'http://2.bp.blogspot.com/-or_7JyM44As/WDUYb3vTzGI/AAAAAAFpHHo/xuSMPu68pIc/w1900/MR-6983-62293-13.jpg'),
(221, 23, 'http://3.bp.blogspot.com/-9Eor_wCYCFc/WDUYbPxRzaI/AAAAAAFpHHQ/MCllU5rwEPw/w1900/MR-6983-62293-14.jpg'),
(222, 23, 'http://4.bp.blogspot.com/-zt4JrhWn9x8/WDUYaLHfA_I/AAAAAAFpHHA/AcEvojtvjpA/w1900/MR-6983-62293-15.jpg'),
(223, 23, 'http://1.bp.blogspot.com/-0O2P9aZX0pU/WDUYZFZSNoI/AAAAAAFpHGo/kAooQdWpX_U/w1900/MR-6983-62293-16.jpg'),
(224, 23, 'http://2.bp.blogspot.com/-o-NL_UC77Jc/WDUYYSQYYMI/AAAAAAFpHGQ/40aU07NVnjY/w1900/MR-6983-62293-17.jpg'),
(225, 23, 'http://3.bp.blogspot.com/-OtZ0OigvLYs/WDUYXv4tEiI/AAAAAAFpHF8/VlbBnv0sZC4/w1900/MR-6983-62293-18.jpg'),
(226, 23, 'http://4.bp.blogspot.com/-uRpGtsJmdzw/WDUYW3pe4sI/AAAAAAFpHFs/oFEKmQ3zpv8/w1900/MR-6983-62293-19.jpg'),
(227, 23, 'http://1.bp.blogspot.com/-nnWxaB0VFt8/WDUYWGjQRlI/AAAAAAFpHFY/3WJPdgIbU8Y/w1900/MR-6983-62293-20.jpg'),
(228, 23, 'http://2.bp.blogspot.com/-Mf_390I-l-g/WDUYVg6d0XI/AAAAAAFpHFI/xFyMzgIkGck/w1900/MR-6983-62293-21.jpg'),
(229, 23, 'http://3.bp.blogspot.com/-t3sc94VN44M/WDUYUwjJ_ZI/AAAAAAFpHE4/vdcakVb2X08/w1900/MR-6983-62293-22.jpg'),
(230, 23, 'http://4.bp.blogspot.com/-ikT1A808_rc/WDUYUfXcgEI/AAAAAAFpHEk/VwakUlCLra0/w1900/MR-6983-62293-23.jpg'),
(231, 23, 'http://1.bp.blogspot.com/-2ZdhfxiFPoI/WDUYTfehzXI/AAAAAAFpHEM/DxA2NHfc63s/w1900/MR-6983-62293-24.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`id`, `name`) VALUES
(1, 'Action'),
(2, 'Adult'),
(3, 'Adventure'),
(4, 'Comedy'),
(5, 'Doujinshi'),
(6, 'Drama'),
(7, 'Ecchi'),
(8, 'Fantasy'),
(9, 'Gender Bender'),
(10, 'Harem'),
(11, 'Hentai'),
(12, 'Historical'),
(13, 'Horror'),
(14, 'Josei'),
(15, 'Martial Arts'),
(16, 'Mature'),
(17, 'Mecha'),
(18, 'Mystery'),
(19, 'N/a'),
(20, 'One Shot'),
(21, 'Psychological'),
(22, 'Romance'),
(23, 'School Life'),
(24, 'Sci-fi'),
(25, 'Seinen'),
(26, 'Shoujo'),
(27, 'Shoujo Ai'),
(28, 'Shounen'),
(29, 'Shounen Ai'),
(30, 'Slice of Life'),
(31, 'Smut'),
(32, 'Sports'),
(33, 'Supernatural'),
(34, 'Tragedy'),
(35, 'Webtoons'),
(36, 'Yaoi'),
(37, 'Yuri');

-- --------------------------------------------------------

--
-- Table structure for table `manga`
--

CREATE TABLE `manga` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `author` text NOT NULL,
  `status` text NOT NULL,
  `img_cover` text NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manga`
--

INSERT INTO `manga` (`id`, `name`, `author`, `status`, `img_cover`, `description`) VALUES
(1, 'Naruto', 'Kishimoto Masashi', 'On Going', 'http://3.c.mpcdn.net/6844/15/180.jpg', 'Twelve years ago, the powerful Nine-Tailed Demon Fox attacked the ninja village of Konohagakure the village hidden in the leaves.\r\nThe demon was defeated and sealed into the infant Naruto Uzumaki, by the Fourth Hokage who sacrificed his life to protect the village. \r\nNow, Naruto is the number one most Unpredictable knuckleheaded ninja who\'s determined to become the next Hokage and be acknowledged by everyone who ever doubted him! From cool fights showing what it really means to be a ninja to fights for things they believe in to hairbrained fun and jokes naruto\'s adventures have got it all! \r\nWith the will to never give up and a great left hook along with his ninja way: to never go back on his word, will Naruto the former outcast achieve his dream?'),
(2, '.Hack//G.U.', 'Hamazaki Tatsuya', 'On Going', 'http://3.c.mpcdn.net/90/1/180.jpg', 'It is the year 2017, and the stakes have gotten even higher in the massively multiplayer online game The World--now The World R:2, a dangerous place overrun by player killers, where lawlessness abounds. The PKK Haseo, known as \"The Terror of Death,\" is a fearsome foe who punishes those who want to slay other players. But things have gotten personal as Haseo tries to track down the killer Tri-Edge, who has threatened the real life of his friend Shino... '),
(3, 'Flying Witch', 'Ishizuka Chihiro', 'On Going', 'http://3.c.mpcdn.net/6986/6/180.jpg', 'Kowata Makoto is an airhead with a bad sense of direction who just moved into her relative\'s house... but is that all?'),
(4, 'Aharen-san wa Hakarenai', 'Mizu Asato', 'On Going', 'http://3.c.mpcdn.net/48871/2/180.jpg', 'From the author of Denkigai no Honya-san and Dansai Joshi comes a short-length comedy about Raidou and his seatmate Aharen-san, who has problems determining how chummy she has to be when approaching other people. Get up close and personal with the small, quiet but unfathomable girl, Aharen-san!'),
(5, 'Touhou - Akizakura', 'Dr Vermillion', 'On Going', 'http://3.c.mpcdn.net/18316/1/180.jpg', 'A flower has bloom out of season at Hakugyokuro. Furthermore it is under Saigyou Ayakashi tree. Is it just a simple flower? or there is more to it?'),
(6, 'Touhou - After Gold', 'Vivit Gray (Circle) ; Shinoasa', 'On Going', 'http://3.c.mpcdn.net/25788/1/180.jpg', 'Friendship between Mokou an Keine'),
(7, 'Touhou - Across The Ocean', 'Sora Freebird', 'On Going', 'http://3.c.mpcdn.net/22103/1/180.jpg', 'Sanae is visiting Patchy to kill time, but she still feel bored. Sanae starts talking about how she spent time in the outside world. the small talk turn into planning how to cross the Hakurei border.');

-- --------------------------------------------------------

--
-- Table structure for table `manga_has_chapter`
--

CREATE TABLE `manga_has_chapter` (
  `id` int(11) NOT NULL,
  `id_manga` int(11) NOT NULL,
  `title` text NOT NULL,
  `number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manga_has_chapter`
--

INSERT INTO `manga_has_chapter` (`id`, `id_manga`, `title`, `number`) VALUES
(1, 1, 'Uzumaki Naruto', 1),
(2, 1, 'Ko No Ha Maru!!', 2),
(3, 1, 'Uchiha Sasuke!!', 3),
(4, 1, 'Hatake kAKASHI!!', 4),
(5, 1, 'Carelessness Is Your Worst Enemy', 5),
(6, 2, 'Tri-Edge', 1),
(7, 2, 'The Lost Ones', 2),
(8, 2, 'The Epitaph User', 3),
(9, 2, 'Endrance\'s Cat', 4),
(10, 2, 'Avatar Awoken', 5),
(11, 3, 'The First Miracle in Six Years', 1),
(16, 4, 'Chapter 1', 1),
(17, 5, 'Akizakura', 1),
(18, 6, 'Atfer Gold', 1),
(19, 7, 'Across The Ocean', 1),
(20, 4, 'Chapter 2', 2),
(21, 4, 'Chapter 3', 3),
(22, 3, 'Wayside Grass is a Panacea', 2),
(23, 3, 'The National Bird Won\'t Stop Calling', 3);

-- --------------------------------------------------------

--
-- Table structure for table `manga_has_genre`
--

CREATE TABLE `manga_has_genre` (
  `id` int(11) NOT NULL,
  `id_manga` int(11) NOT NULL,
  `id_genre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manga_has_genre`
--

INSERT INTO `manga_has_genre` (`id`, `id_manga`, `id_genre`) VALUES
(1, 1, 1),
(2, 1, 3),
(3, 1, 4),
(4, 1, 6),
(5, 1, 8),
(6, 1, 15),
(7, 1, 28),
(8, 2, 1),
(9, 2, 3),
(10, 2, 8),
(11, 2, 24),
(12, 2, 28),
(13, 3, 4),
(14, 3, 8),
(15, 3, 23),
(16, 3, 28),
(17, 3, 30),
(18, 3, 33),
(19, 4, 4),
(20, 4, 22),
(21, 4, 23),
(22, 4, 28),
(23, 4, 30),
(24, 5, 5),
(25, 5, 30),
(26, 6, 5),
(27, 7, 5),
(28, 7, 8);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `email` text COLLATE utf8_unicode_ci NOT NULL,
  `img_profile` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `email`, `img_profile`) VALUES
(1, 'matemo22', '1234', 'matemo2204@gmail.com', 2131165290),
(2, 'kho', '1234', 'kho@gmail.com', 2131165290),
(3, 'arisu', '1234', 'arisu@gmail.com', 2131165290),
(4, 'jepe', '1234', 'jepe@gmail.com', 2131165290);

-- --------------------------------------------------------

--
-- Table structure for table `user_favorites_manga`
--

CREATE TABLE `user_favorites_manga` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_manga` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_favorites_manga`
--

INSERT INTO `user_favorites_manga` (`id`, `id_user`, `id_manga`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `user_likes_manga`
--

CREATE TABLE `user_likes_manga` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_manga` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chapter_has_images`
--
ALTER TABLE `chapter_has_images`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_chapter` (`id_chapter`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `manga`
--
ALTER TABLE `manga`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `manga_has_chapter`
--
ALTER TABLE `manga_has_chapter`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_manga` (`id_manga`);

--
-- Indexes for table `manga_has_genre`
--
ALTER TABLE `manga_has_genre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_manga` (`id_manga`),
  ADD KEY `id_genre` (`id_genre`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_favorites_manga`
--
ALTER TABLE `user_favorites_manga`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_likes_manga`
--
ALTER TABLE `user_likes_manga`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chapter_has_images`
--
ALTER TABLE `chapter_has_images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=232;

--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `manga`
--
ALTER TABLE `manga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `manga_has_chapter`
--
ALTER TABLE `manga_has_chapter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `manga_has_genre`
--
ALTER TABLE `manga_has_genre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user_favorites_manga`
--
ALTER TABLE `user_favorites_manga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user_likes_manga`
--
ALTER TABLE `user_likes_manga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chapter_has_images`
--
ALTER TABLE `chapter_has_images`
  ADD CONSTRAINT `chapter_has_images_ibfk_1` FOREIGN KEY (`id_chapter`) REFERENCES `manga_has_chapter` (`id`);

--
-- Constraints for table `manga_has_chapter`
--
ALTER TABLE `manga_has_chapter`
  ADD CONSTRAINT `manga_has_chapter_ibfk_1` FOREIGN KEY (`id_manga`) REFERENCES `manga` (`id`);

--
-- Constraints for table `manga_has_genre`
--
ALTER TABLE `manga_has_genre`
  ADD CONSTRAINT `manga_has_genre_ibfk_1` FOREIGN KEY (`id_manga`) REFERENCES `manga` (`id`),
  ADD CONSTRAINT `manga_has_genre_ibfk_2` FOREIGN KEY (`id_genre`) REFERENCES `genre` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
