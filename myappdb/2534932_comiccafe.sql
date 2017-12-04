-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2017 at 03:55 PM
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
(231, 23, 'http://1.bp.blogspot.com/-2ZdhfxiFPoI/WDUYTfehzXI/AAAAAAFpHEM/DxA2NHfc63s/w1900/MR-6983-62293-24.jpg'),
(232, 24, 'http://3.bp.blogspot.com/-2PVNGjSlzZo/WAI7u2MaTNI/AAAAAADibEQ/fk-Stx1unes/w1900/MR-29161-502100-2.jpg'),
(233, 24, 'http://4.bp.blogspot.com/-uV1v_VmpdCE/WAI7tyWDCuI/AAAAAADibD4/N7efMv3vQlk/w1900/MR-29161-502100-3.jpg'),
(234, 24, 'http://1.bp.blogspot.com/-xzhy6vsMl7U/WAI7tRa58RI/AAAAAADibDY/VSWbKrJ54gE/w1900/MR-29161-502100-4.jpg'),
(235, 24, 'http://2.bp.blogspot.com/-nGtV90Ey1wY/WAI7shCHQ1I/AAAAAADibDA/-b6Ag8DWWnU/w1900/MR-29161-502100-5.jpg'),
(236, 24, 'http://3.bp.blogspot.com/-N8WIAyXo-FQ/WAI7r7wr5wI/AAAAAADibCU/lA8MaZ_zH9s/w1900/MR-29161-502100-6.jpg'),
(237, 24, 'http://4.bp.blogspot.com/-sie4jzKQsfo/WAI7rdJztUI/AAAAAADibB4/hr_Zy-gP3cQ/w1900/MR-29161-502100-7.jpg'),
(238, 24, 'http://1.bp.blogspot.com/-YV--yBeFj8o/WAI7q4jxE0I/AAAAAADibBo/Pi-KCcE1YKI/w1900/MR-29161-502100-8.jpg'),
(239, 24, 'http://2.bp.blogspot.com/-BiZxewfkwHo/WAI7p7iaHsI/AAAAAADibBM/2yz67DorN_o/w1900/MR-29161-502100-9.jpg'),
(240, 24, 'http://3.bp.blogspot.com/-qhazCloIzEE/WAI7pRaZp5I/AAAAAADibAg/5XXd-cVC8AY/w1900/MR-29161-502100-10.jpg'),
(241, 24, 'http://4.bp.blogspot.com/-XfMEt8jKKJg/WAI7nFmlzeI/AAAAAADibAM/lfsPcp_6b8c/w1900/MR-29161-502100-11.jpg'),
(242, 24, 'http://1.bp.blogspot.com/-SyCLoQHo9GM/WAI7lbGopGI/AAAAAADia_E/xvLbu6IaNMQ/w1900/MR-29161-502100-12.jpg'),
(243, 24, 'http://2.bp.blogspot.com/-pU7822bowDM/WAI5AqYAUtI/AAAAAADiZTY/qtq0Qqi2pBQ/w1900/MR-29161-502100-13.jpg'),
(244, 24, 'http://3.bp.blogspot.com/-Q9fVPG--gWE/WAI5AEnFGsI/AAAAAADiZS4/hVIRRuCIeyA/w1900/MR-29161-502100-14.jpg'),
(245, 24, 'http://4.bp.blogspot.com/-2ABCNluOrpk/WAI4_g4QDpI/AAAAAADiZSY/e0W8bsMDLsk/w1900/MR-29161-502100-15.jpg'),
(246, 24, 'http://1.bp.blogspot.com/-U9DsbxFxdWw/WAI4-PuCrQI/AAAAAADiZR8/S8vz7q6fMO4/w1900/MR-29161-502100-16.jpg'),
(247, 24, 'http://2.bp.blogspot.com/-FUnU2MqXIXo/WAI49bipoPI/AAAAAADiZRI/vxVpL4veKuY/w1900/MR-29161-502100-17.jpg'),
(248, 24, 'http://3.bp.blogspot.com/-VoGcR9Lgt_s/WAI48V2Wo6I/AAAAAADiZQs/Hs0MT6UpnZ8/w1900/MR-29161-502100-18.jpg'),
(249, 24, 'http://4.bp.blogspot.com/-Vo1OxVPS_UE/WAI47_QqSGI/AAAAAADiZQY/QEvmyjCe9Do/w1900/MR-29161-502100-19.jpg'),
(250, 24, 'http://1.bp.blogspot.com/-5w_oHULT4oc/WAI47cvch1I/AAAAAADiZQA/N8_W92peKMQ/w1900/MR-29161-502100-20.jpg'),
(251, 24, 'http://2.bp.blogspot.com/-j5u2UYdEh2s/WAI46lxRTRI/AAAAAADiZP0/iy3SLHBT_MA/w1900/MR-29161-502100-21.jpg'),
(252, 24, 'http://3.bp.blogspot.com/-GUlBwgTCosM/WAI45wozgYI/AAAAAADiZPg/pbgv8CSjdkQ/w1900/MR-29161-502100-22.jpg'),
(253, 24, 'http://4.bp.blogspot.com/-BiBZemD7l_k/WAI45WjtiaI/AAAAAADiZPQ/jhEoZgfnxnM/w1900/MR-29161-502100-23.jpg'),
(254, 24, 'http://1.bp.blogspot.com/-X9IQeyQKXTg/WAI447Qi4_I/AAAAAADiZO0/tkYwOS6_xzg/w1900/MR-29161-502100-24.jpg'),
(255, 24, 'http://2.bp.blogspot.com/-NnfeA79qDvo/WAI44AfQNpI/AAAAAADiZOg/cGidm3XhikA/w1900/MR-29161-502100-25.jpg'),
(256, 24, 'http://3.bp.blogspot.com/-lB7Bh94WbrE/WAI43hvUDDI/AAAAAADiZOQ/Z8CtuQCLTeY/w1900/MR-29161-502100-26.jpg'),
(257, 24, 'http://4.bp.blogspot.com/-7sUDWwUvn60/WAI43HWhm9I/AAAAAADiZNw/sLj_xldLgks/w1900/MR-29161-502100-27.jpg'),
(258, 24, 'http://1.bp.blogspot.com/-WOq1qDDBoeo/WAI42e6Mg_I/AAAAAADiZNY/1JTZD34t3og/w1900/MR-29161-502100-28.jpg'),
(259, 24, 'http://2.bp.blogspot.com/-syqaJ966Cyc/WAI410yTg6I/AAAAAADiZM4/Z5EcODBu4M4/w1900/MR-29161-502100-29.jpg'),
(260, 24, 'http://3.bp.blogspot.com/-DnGbePQahzM/WAI41JnCxFI/AAAAAADiZMY/WXpO2FkKSjg/w1900/MR-29161-502100-30.jpg'),
(261, 24, 'http://4.bp.blogspot.com/-ZEfWBUCJyrg/WAI40TUNkbI/AAAAAADiZL8/0xf6YI6Hpr0/w1900/MR-29161-502100-31.jpg'),
(262, 24, 'http://1.bp.blogspot.com/-x-uKKiFj4Z0/WAI4z6ws1JI/AAAAAADiZLk/5dX36Klxhrc/w1900/MR-29161-502100-32.jpg'),
(263, 24, 'http://2.bp.blogspot.com/-vq6dmP-KLBM/WAI2VP-RUXI/AAAAAADiXi8/oKwBNElxM2I/w1900/MR-29161-502100-33.jpg'),
(264, 24, 'http://3.bp.blogspot.com/-mZIAQ7UV_h0/WAI2UjdLfbI/AAAAAADiXig/eOC-uXFW_7I/w1900/MR-29161-502100-34.jpg'),
(265, 24, 'http://4.bp.blogspot.com/-tdxwd0Ahjlg/WAI2TiJEFJI/AAAAAADiXiA/NGFsZtLdTvw/w1900/MR-29161-502100-35.jpg'),
(266, 24, 'http://1.bp.blogspot.com/-7lW7tpN8U2E/WAI2TFVaiQI/AAAAAADiXhw/LGNaf_oiWJ0/w1900/MR-29161-502100-36.jpg'),
(267, 24, 'http://2.bp.blogspot.com/-RbwHvhnZRqI/WAI2SsjLKfI/AAAAAADiXhY/JCMubB2Axik/w1900/MR-29161-502100-37.jpg'),
(268, 24, 'http://3.bp.blogspot.com/-sBc7DXT91C0/WAI2RwbnPvI/AAAAAADiXhE/tulSDFu4tNM/w1900/MR-29161-502100-38.jpg'),
(269, 24, 'http://4.bp.blogspot.com/-x_13Z7g0PdM/WAI2MQfm_EI/AAAAAADiXdk/_mqEUYDKMMA/w1900/MR-29161-502100-39.jpg'),
(270, 24, 'http://1.bp.blogspot.com/-WS2-zXzGMeI/WAI2LvqcWUI/AAAAAADiXdE/2e-cNPzpohA/w1900/MR-29161-502100-40.jpg'),
(271, 24, 'http://2.bp.blogspot.com/-oudEgV340Vw/WAI2LJ20JBI/AAAAAADiXcg/sKrCR7FbKIs/w1900/MR-29161-502100-41.jpg'),
(272, 24, 'http://3.bp.blogspot.com/-xsycz9hPbFA/WAI2KVRpApI/AAAAAADiXcE/wgjNo1uJw9U/w1900/MR-29161-502100-42.jpg'),
(273, 24, 'http://4.bp.blogspot.com/-nKiAx2PKHQU/WAI2JoJm9fI/AAAAAADiXbU/rbapRLcYyoc/w1900/MR-29161-502100-43.jpg'),
(274, 24, 'http://1.bp.blogspot.com/-tnSleUnDGm0/WAI2JDpBSCI/AAAAAADiXbA/oF_duaWMaDY/w1900/MR-29161-502100-44.jpg'),
(275, 24, 'http://2.bp.blogspot.com/-yuA2IYqUPb4/WAI2InnksTI/AAAAAADiXak/nVh6A8vlLKA/w1900/MR-29161-502100-45.jpg'),
(276, 24, 'http://3.bp.blogspot.com/-XyVBeVbct-A/WAI2HynEY-I/AAAAAADiXaI/4RLgsmqHOEM/w1900/MR-29161-502100-46.jpg'),
(277, 24, 'http://4.bp.blogspot.com/-lmPHpjHTAJk/WAI2HUdoqVI/AAAAAADiXZw/IJMhBnG37kk/w1900/MR-29161-502100-47.jpg'),
(278, 24, 'http://1.bp.blogspot.com/-AwKrsYGoqlI/WAI2G7VlaDI/AAAAAADiXZU/cD9bCs_rxck/w1900/MR-29161-502100-48.jpg'),
(279, 24, 'http://2.bp.blogspot.com/-Ba5b9Z6aPgI/WAI2GCSar9I/AAAAAADiXY4/AndBCANiyuY/w1900/MR-29161-502100-49.jpg'),
(280, 24, 'http://3.bp.blogspot.com/-bnf_zMHX8Bs/WAI2Fp_SVlI/AAAAAADiXYg/LBcAk9EJG6w/w1900/MR-29161-502100-50.jpg'),
(281, 24, 'http://4.bp.blogspot.com/-ljTpW9L7sUw/WAI2E7puMZI/AAAAAADiXYA/L8FRQyOf9ME/w1900/MR-29161-502100-51.jpg'),
(282, 24, 'http://1.bp.blogspot.com/-zlSaKLzuiz0/WAI2EONjMBI/AAAAAADiXXg/HNRHt4Hynsw/w1900/MR-29161-502100-52.jpg'),
(283, 24, 'http://2.bp.blogspot.com/-1PuQo5aJbhM/WAIz_p7IYEI/AAAAAADiV1U/Lhib-hDHykw/w1900/MR-29161-502100-53.jpg'),
(284, 24, 'http://3.bp.blogspot.com/-1WPOrWTlVpc/WAIz-49ieBI/AAAAAADiV0w/K0F4QfilGNU/w1900/MR-29161-502100-54.jpg'),
(285, 24, 'http://4.bp.blogspot.com/-q0OS-IrQAqA/WAIz-Tma5GI/AAAAAADiV0Q/gmlYZwd-NFg/w1900/MR-29161-502100-55.jpg'),
(286, 24, 'http://1.bp.blogspot.com/-MCdOvsKFcGo/WAIz9cILT5I/AAAAAADiVzs/gpsd6L7nCP0/w1900/MR-29161-502100-56.jpg'),
(287, 24, 'http://2.bp.blogspot.com/-ypStOKWfC1w/WAIz83uyL2I/AAAAAADiVzE/fq9reinLAcc/w1900/MR-29161-502100-57.jpg'),
(288, 24, 'http://3.bp.blogspot.com/-NpffnCSGmG8/WAIz8b0hOwI/AAAAAADiVyo/iR9NzFCLids/w1900/MR-29161-502100-58.jpg'),
(289, 24, 'http://4.bp.blogspot.com/-npOUc5pIacI/WAIz7vcBsNI/AAAAAADiVyE/rIrlIxc6MSY/w1900/MR-29161-502100-59.jpg'),
(290, 25, 'http://4.bp.blogspot.com/-1eNwvCUsi-M/WACpxqOn2jI/AAAAAADeGYk/yav1L01AaqQ/w1900/MR-29161-517238-3.jpg'),
(291, 25, 'http://1.bp.blogspot.com/-0Oj2eG6xVaY/WACpxG-mgmI/AAAAAADeGYI/Dd093_37o8s/w1900/MR-29161-517238-4.jpg'),
(292, 25, 'http://2.bp.blogspot.com/-8aK0igLur5A/WACpwbGUhAI/AAAAAADeGXk/bvD6cvG8tiw/w1900/MR-29161-517238-5.jpg'),
(293, 25, 'http://3.bp.blogspot.com/-Ac75Wownfdk/WACpvx32FUI/AAAAAADeGXM/RukKSGuxIUc/w1900/MR-29161-517238-6.jpg'),
(294, 25, 'http://4.bp.blogspot.com/-euEO7TGBhYU/WACpvEd0-SI/AAAAAADeGWs/m7t7jh20lBM/w1900/MR-29161-517238-7.jpg'),
(295, 25, 'http://1.bp.blogspot.com/-IqcxKOVZtBg/WACpuerY7jI/AAAAAADeGWQ/38MhRhXKH6E/w1900/MR-29161-517238-8.jpg'),
(296, 25, 'http://2.bp.blogspot.com/-qv95oofMbUg/WACpt5r04mI/AAAAAADeGVc/ao0CdRAMbiQ/w1900/MR-29161-517238-9.jpg'),
(297, 25, 'http://3.bp.blogspot.com/-ccwZ5DhkO9U/WACptAvGkAI/AAAAAADeGU8/e-X2LUJSwGc/w1900/MR-29161-517238-10.jpg'),
(298, 25, 'http://4.bp.blogspot.com/-gMkx1fQ2yJk/WACpsnAUiqI/AAAAAADeGUc/Tbnrctvks4E/w1900/MR-29161-517238-11.jpg'),
(299, 25, 'http://1.bp.blogspot.com/-ulKEOQofqxQ/WACpsDYWGHI/AAAAAADeGUE/lJzY7ZhCE-Y/w1900/MR-29161-517238-12.jpg'),
(300, 25, 'http://2.bp.blogspot.com/-jbk7OlW00WY/WACprTio0kI/AAAAAADeGTk/c-qGVB30wJw/w1900/MR-29161-517238-13.jpg'),
(301, 25, 'http://3.bp.blogspot.com/-Na0jtfTVMKc/WACpq5lu7OI/AAAAAADeGTI/-pAKj4231j0/w1900/MR-29161-517238-14.jpg'),
(302, 25, 'http://4.bp.blogspot.com/-mmACPxhvVMQ/WACpqMVN_UI/AAAAAADeGSg/PmkPDRFVceU/w1900/MR-29161-517238-15.jpg'),
(303, 25, 'http://1.bp.blogspot.com/-fHvQRXPzgNU/WACppRrYPzI/AAAAAADeGSA/H_CrKeN1M4w/w1900/MR-29161-517238-16.jpg'),
(304, 25, 'http://2.bp.blogspot.com/-r2MS5H5rL1g/WACpowCLrbI/AAAAAADeGRo/cVbNmgFWWBM/w1900/MR-29161-517238-17.jpg'),
(305, 25, 'http://3.bp.blogspot.com/-V6To4eMegjs/WACpoEX-6nI/AAAAAADeGRE/TC-3uu-db0o/w1900/MR-29161-517238-18.jpg'),
(306, 25, 'http://4.bp.blogspot.com/-whK0gC1g6Sw/WACpnadLhDI/AAAAAADeGQo/8ttPxwckYyM/w1900/MR-29161-517238-19.jpg'),
(307, 25, 'http://1.bp.blogspot.com/-bryCwIQduzY/WACnaRBUurI/AAAAAADeEm0/nfp57V44n8U/w1900/MR-29161-517238-20.jpg'),
(308, 25, 'http://2.bp.blogspot.com/-kqhlO03KHkM/WACnZkQwCEI/AAAAAADeEmI/NZYL4VlvuJs/w1900/MR-29161-517238-21.jpg'),
(309, 25, 'http://3.bp.blogspot.com/-XAPNUH44120/WACnYocU5qI/AAAAAADeElk/6xXfyVF2xB0/w1900/MR-29161-517238-22.jpg'),
(310, 25, 'http://4.bp.blogspot.com/-iT4npwkg5Ls/WACnX_G8UAI/AAAAAADeEks/qz6EQvC5DZU/w1900/MR-29161-517238-23.jpg'),
(311, 25, 'http://1.bp.blogspot.com/-x8IKgsv2J1Q/WACnXEioj8I/AAAAAADeEkQ/HusI8NoG_qY/w1900/MR-29161-517238-24.jpg'),
(312, 25, 'http://2.bp.blogspot.com/-u3rr60CrqRM/WACnWVwPTsI/AAAAAADeEjY/T70vdodAHGM/w1900/MR-29161-517238-25.jpg'),
(313, 25, 'http://3.bp.blogspot.com/-wZLJRPiVASs/WACnVnbAkHI/AAAAAADeEi0/E0RfuaYs-YY/w1900/MR-29161-517238-26.jpg'),
(314, 25, 'http://4.bp.blogspot.com/-ny0EBCQmBZI/WACnVCwnNzI/AAAAAADeEiQ/BbvXDC3HALc/w1900/MR-29161-517238-27.jpg'),
(315, 25, 'http://1.bp.blogspot.com/-Gv2GqdBh9cg/WACnUT5AJdI/AAAAAADeEhw/Cye2aVo3cr0/w1900/MR-29161-517238-28.jpg'),
(316, 25, 'http://2.bp.blogspot.com/-fO2B1NzlRnU/WACnT65wJtI/AAAAAADeEhE/mPz5HjVkwJs/w1900/MR-29161-517238-29.jpg'),
(317, 25, 'http://3.bp.blogspot.com/-7xnpbFN-XtQ/WACnS1wDZdI/AAAAAADeEgQ/7EfK_ZLi8zo/w1900/MR-29161-517238-30.jpg'),
(318, 25, 'http://4.bp.blogspot.com/-ZMoq3b8s5Wg/WACnR9rfAkI/AAAAAADeEfk/tJijnIREcV0/w1900/MR-29161-517238-31.jpg'),
(319, 25, 'http://1.bp.blogspot.com/-975nMV_NQg8/WACnRZQ2HiI/AAAAAADeEfI/wE-TYbGIlyM/w1900/MR-29161-517238-32.jpg'),
(320, 25, 'http://2.bp.blogspot.com/-vbuW9FHH6sQ/WACnQ3slmkI/AAAAAADeEeo/g9bCLy3h3hk/w1900/MR-29161-517238-33.jpg'),
(321, 25, 'http://3.bp.blogspot.com/-TtXJXsWKjq4/WACnQAbVScI/AAAAAADeEeM/AiN-HRPP9cE/w1900/MR-29161-517238-34.jpg'),
(322, 25, 'http://4.bp.blogspot.com/-gzorTL8mrEs/WACnPRh9cII/AAAAAADeEdw/al46pVIdmRo/w1900/MR-29161-517238-35.jpg'),
(323, 25, 'http://1.bp.blogspot.com/-B50yRv9hLqw/WACnOnPnWdI/AAAAAADeEdY/vS8LLoQLUxU/w1900/MR-29161-517238-36.jpg'),
(324, 25, 'http://2.bp.blogspot.com/-EbViC_DTbYM/WACnOHdjY9I/AAAAAADeEc8/0cyJbeAfong/w1900/MR-29161-517238-37.jpg'),
(325, 25, 'http://3.bp.blogspot.com/-xWdsa05jSJQ/WACnNl8bLFI/AAAAAADeEcg/OfN1rUCUfS4/w1900/MR-29161-517238-38.jpg'),
(326, 25, 'http://4.bp.blogspot.com/-weYNABr0pvA/WACnM7LzdMI/AAAAAADeEcI/gYd0jZjw1kY/w1900/MR-29161-517238-39.jpg'),
(327, 25, 'http://1.bp.blogspot.com/-DrEiMCn3VF8/WAClGp0oH9I/AAAAAADeC78/UAkV2hDJh5o/w1900/MR-29161-517238-40.jpg'),
(328, 25, 'http://2.bp.blogspot.com/-x0G5F-ZdaLk/WAClGHGu2bI/AAAAAADeC7c/2D-ykv3wqA8/w1900/MR-29161-517238-41.jpg'),
(329, 25, 'http://3.bp.blogspot.com/-qF6xifjmkbE/WAClFgs1UpI/AAAAAADeC7E/dGwY51ermxA/w1900/MR-29161-517238-42.jpg'),
(330, 25, 'http://4.bp.blogspot.com/-e93k402cHEA/WAClEnXZK_I/AAAAAADeC6s/-5pyFA-CGW0/w1900/MR-29161-517238-43.jpg'),
(331, 25, 'http://1.bp.blogspot.com/-xHDIXM7wX6o/WAClD6AMf5I/AAAAAADeC6A/Ug019HMdDVo/w1900/MR-29161-517238-44.jpg'),
(332, 26, 'http://2.bp.blogspot.com/-QR0M8Bw8jI0/WAClDSoeRVI/AAAAAADeC5g/j8IC6jgJxFk/w1900/MR-29161-517240-1.jpg'),
(333, 26, 'http://3.bp.blogspot.com/-iCPiqB-9ZSA/WAClCmhOPeI/AAAAAADeC5I/b6MZBDz7_zQ/w1900/MR-29161-517240-2.jpg'),
(334, 26, 'http://4.bp.blogspot.com/-jhWj8OIjPOg/WAClCGTC0fI/AAAAAADeC4s/M-a6B5K4VSU/w1900/MR-29161-517240-3.jpg'),
(335, 26, 'http://1.bp.blogspot.com/-hKFwnvZPSfQ/WAClBpK_5KI/AAAAAADeC4Q/fuV8Egwudi0/w1900/MR-29161-517240-4.jpg'),
(336, 26, 'http://2.bp.blogspot.com/-VOzTSs1IWqo/WAClAzD8E0I/AAAAAADeC3w/XyHJEDKBia0/w1900/MR-29161-517240-5.jpg'),
(337, 26, 'http://3.bp.blogspot.com/-Ic3_fPqUNEc/WAClAWCMPRI/AAAAAADeC3Y/p1hogVCj_pA/w1900/MR-29161-517240-6.jpg'),
(338, 26, 'http://4.bp.blogspot.com/-CctX33nOQME/WACk_yXIm4I/AAAAAADeC28/m1Zo5jcUOjA/w1900/MR-29161-517240-7.jpg'),
(339, 26, 'http://1.bp.blogspot.com/-SOwoRjXHQww/WACk_HkeFoI/AAAAAADeC2g/ea0YzAbVtGQ/w1900/MR-29161-517240-8.jpg'),
(340, 26, 'http://2.bp.blogspot.com/-LnSKpyZxJLk/WACk-qvVUjI/AAAAAADeC2A/Mcc0mNOB7QQ/w1900/MR-29161-517240-9.jpg'),
(341, 26, 'http://3.bp.blogspot.com/-pZWWfo3R6rc/WACk-POVyWI/AAAAAADeC1o/EaoaW6S61NE/w1900/MR-29161-517240-10.jpg'),
(342, 26, 'http://4.bp.blogspot.com/-fBne_1KyOWA/WACk9VG7svI/AAAAAADeC1A/SetdWnqKpvw/w1900/MR-29161-517240-11.jpg'),
(343, 26, 'http://1.bp.blogspot.com/-QXrVzRrhuQ0/WACk8RrtHjI/AAAAAADeC0c/wE1poko-22Y/w1900/MR-29161-517240-12.jpg'),
(344, 26, 'http://2.bp.blogspot.com/-hWwT8JXAiKQ/WACk7wHcGoI/AAAAAADeCzw/shVpRW8c9RE/w1900/MR-29161-517240-13.jpg'),
(345, 26, 'http://3.bp.blogspot.com/-OXlSY72s36o/WACk65WiDyI/AAAAAADeCzM/7JB5PMSnd68/w1900/MR-29161-517240-14.jpg'),
(346, 26, 'http://4.bp.blogspot.com/-_e1XDPO-uBg/WACk6GJcKhI/AAAAAADeCyo/ouun4bV6r7E/w1900/MR-29161-517240-15.jpg'),
(347, 26, 'http://1.bp.blogspot.com/-962_hU4XXJA/WACix5grVYI/AAAAAADeBQE/QDZQwDfYSRA/w1900/MR-29161-517240-16.jpg'),
(348, 26, 'http://2.bp.blogspot.com/-io_T8Lxz_o0/WACixFi_cCI/AAAAAADeBPk/U9yBxUvGFWk/w1900/MR-29161-517240-17.jpg'),
(349, 26, 'http://3.bp.blogspot.com/-Oymx0WuxmnE/WACiv06uLsI/AAAAAADeBO4/yf1kGTYcnsA/w1900/MR-29161-517240-18.jpg'),
(350, 26, 'http://4.bp.blogspot.com/-stYrASBAgio/WACivQwdmnI/AAAAAADeBOM/coSpU2Bw5jI/w1900/MR-29161-517240-19.jpg'),
(351, 26, 'http://1.bp.blogspot.com/-e3Kai29QrOs/WACiuRFpqzI/AAAAAADeBNs/t9-dz-NkoNY/w1900/MR-29161-517240-20.jpg'),
(352, 26, 'http://2.bp.blogspot.com/-MoIGUjLo34w/WACitkAPm8I/AAAAAADeBNU/nriAp6ZOoL4/w1900/MR-29161-517240-21.jpg'),
(353, 26, 'http://3.bp.blogspot.com/-4IEeSlYn_bM/WACitOjEBLI/AAAAAADeBNE/rk2KzzJFSKI/w1900/MR-29161-517240-22.jpg'),
(354, 26, 'http://4.bp.blogspot.com/-HAV31I-ydnE/WACisccNZyI/AAAAAADeBMk/g92eCCNfBKA/w1900/MR-29161-517240-23.jpg'),
(355, 26, 'http://1.bp.blogspot.com/-eyG5DRQGblY/WACirQGc9TI/AAAAAADeBL8/fmeYSOKMXJA/w1900/MR-29161-517240-24.jpg'),
(356, 26, 'http://2.bp.blogspot.com/-vj1gn-OSGfM/WACiq3WnxeI/AAAAAADeBLQ/BrdjQetHYa8/w1900/MR-29161-517240-25.jpg'),
(357, 26, 'http://3.bp.blogspot.com/-H5GTp7Ao95M/WACiqCZ1mrI/AAAAAADeBKw/tCWbp1rriOo/w1900/MR-29161-517240-26.jpg'),
(358, 26, 'http://4.bp.blogspot.com/-s1sRzoJ4iUc/WACipe4AkpI/AAAAAADeBKQ/8bWhu_ubLZk/w1900/MR-29161-517240-27.jpg'),
(359, 26, 'http://1.bp.blogspot.com/-DV7jUr8ZrFs/WACioxiGEkI/AAAAAADeBJ4/zqUppTYArHE/w1900/MR-29161-517240-28.jpg'),
(360, 26, 'http://2.bp.blogspot.com/-2yqV0f_EEhw/WACin-6FUhI/AAAAAADeBJk/9_TUvewTvec/w1900/MR-29161-517240-29.jpg'),
(361, 26, 'http://3.bp.blogspot.com/-OPuvYg0DG6k/WACim9xv2lI/AAAAAADeBIo/4bxKZCVI3rY/w1900/MR-29161-517240-30.jpg'),
(362, 26, 'http://4.bp.blogspot.com/-ythtFGId3eo/WACilw5QsWI/AAAAAADeBH4/j-A4k8NqTk8/w1900/MR-29161-517240-31.jpg'),
(363, 26, 'http://1.bp.blogspot.com/-gS5TQlQQn10/WACilAjVkaI/AAAAAADeBHQ/l-8v3ZNPFJg/w1900/MR-29161-517240-32.jpg'),
(364, 27, 'http://4.bp.blogspot.com/-hFmdGhk5o5U/V_-MiyqjJaI/AAAAAADav3I/hPM6vvlJ-Go/w1900/MR-29161-525022-3.jpg'),
(365, 27, 'http://1.bp.blogspot.com/-7ZHlx-ftCJU/V_-MiemJ4NI/AAAAAADav2k/C77AnwdHMQ0/w1900/MR-29161-525022-4.jpg'),
(366, 27, 'http://2.bp.blogspot.com/-roXy0whgPSA/V_-MhvCcilI/AAAAAADav2I/-iGJHYQ2rWE/w1900/MR-29161-525022-5.jpg'),
(367, 27, 'http://3.bp.blogspot.com/-bNEiHcKH7dc/V_-MhI34vsI/AAAAAADav1s/nP8dM2AW1yI/w1900/MR-29161-525022-6.jpg'),
(368, 27, 'http://4.bp.blogspot.com/-M7X9x5AZXyo/V_-MgclqwPI/AAAAAADav1I/Adun4TjB9j0/w1900/MR-29161-525022-7.jpg'),
(369, 27, 'http://1.bp.blogspot.com/-cBHopE6Gk4U/V_-Mf2PyqRI/AAAAAADav0k/k_hpLHt02RU/w1900/MR-29161-525022-8.jpg'),
(370, 27, 'http://2.bp.blogspot.com/-_-DhTeZvhdg/V_-MfCeKHtI/AAAAAADav0A/-B4VnEbDY_c/w1900/MR-29161-525022-9.jpg'),
(371, 27, 'http://3.bp.blogspot.com/-YFcwu___22g/V_-Meky60qI/AAAAAADavzk/AvWMI6bVrOs/w1900/MR-29161-525022-10.jpg'),
(372, 27, 'http://4.bp.blogspot.com/-GOLZbZCTCG8/V_-MeGjVUMI/AAAAAADavzE/z9x2Ai3EwzE/w1900/MR-29161-525022-11.jpg'),
(373, 27, 'http://1.bp.blogspot.com/-CTpofPMeFzA/V_-MdkmIpHI/AAAAAADavyk/fwza118DWGs/w1900/MR-29161-525022-12.jpg'),
(374, 27, 'http://2.bp.blogspot.com/-zI8zQrKW6y0/V_-Ki46Hx7I/AAAAAADauTA/rpQpmqY4SnU/w1900/MR-29161-525022-13.jpg'),
(375, 27, 'http://3.bp.blogspot.com/-UVf3bRDokwc/V_-KiJkSOII/AAAAAADauSk/U38eTY1LuOg/w1900/MR-29161-525022-14.jpg'),
(376, 27, 'http://4.bp.blogspot.com/-t7ePE40DHgs/V_-Kgy6z5AI/AAAAAADauSA/oz7NyRnz8sg/w1900/MR-29161-525022-15.jpg'),
(377, 27, 'http://1.bp.blogspot.com/-__BINSC1OBU/V_-KgSqav6I/AAAAAADauQ8/3_Zqgc3jvL0/w1900/MR-29161-525022-16.jpg'),
(378, 27, 'http://2.bp.blogspot.com/-D8OcZRG3KAM/V_-Kf4xhmvI/AAAAAADauQY/IYZDoQSNGjI/w1900/MR-29161-525022-17.jpg'),
(379, 27, 'http://3.bp.blogspot.com/-S-Hc6Rngtic/V_-KfdF29tI/AAAAAADauP8/jlb3YZFTqS4/w1900/MR-29161-525022-18.jpg'),
(380, 27, 'http://4.bp.blogspot.com/-XsQne8wuHR4/V_-KegeuZ6I/AAAAAADauPs/dAk2oRmr9qE/w1900/MR-29161-525022-19.jpg'),
(381, 27, 'http://1.bp.blogspot.com/-ZXG4wNHm5fo/V_-KeCIC7ZI/AAAAAADauPE/PY2nQb_TFf4/w1900/MR-29161-525022-20.jpg'),
(382, 27, 'http://2.bp.blogspot.com/-uyQvQKSV5rA/V_-KdX0XjnI/AAAAAADauOk/YK97oA9KUxA/w1900/MR-29161-525022-21.jpg'),
(383, 27, 'http://3.bp.blogspot.com/-i7Kal3FYWQA/V_-KczCGgBI/AAAAAADauOM/A1SFZGrmbe4/w1900/MR-29161-525022-22.jpg'),
(384, 27, 'http://4.bp.blogspot.com/-h_AbFtLbl_k/V_-KcRqeOII/AAAAAADauNs/d5XUu-AM1gc/w1900/MR-29161-525022-23.jpg'),
(385, 27, 'http://1.bp.blogspot.com/-JVe6M3lvjzs/V_-Kbx7luFI/AAAAAADauNQ/_b8YiJHYWpg/w1900/MR-29161-525022-24.jpg'),
(386, 27, 'http://2.bp.blogspot.com/-8YR1w8titW0/V_-KbHLTvDI/AAAAAADauMs/iO11g3ESIno/w1900/MR-29161-525022-25.jpg'),
(387, 27, 'http://3.bp.blogspot.com/-VyANV5MIpZA/V_-KamNpzOI/AAAAAADauMM/gbaVHpRW_zM/w1900/MR-29161-525022-26.jpg'),
(388, 27, 'http://4.bp.blogspot.com/-q2YJD3q2usQ/V_-KaBz_a3I/AAAAAADauLo/ObGDmjY5SYY/w1900/MR-29161-525022-27.jpg'),
(389, 27, 'http://1.bp.blogspot.com/-8G_4nBwKMd8/V_-KZapff4I/AAAAAADauLE/tTWFpctkZ5U/w1900/MR-29161-525022-28.jpg'),
(390, 27, 'http://2.bp.blogspot.com/-PFhz0lfrPPc/V_-KY3uD6II/AAAAAADauKo/crrsvI1RDfs/w1900/MR-29161-525022-29.jpg'),
(391, 27, 'http://3.bp.blogspot.com/-bd8foeIZDlk/V_-KYd4jAtI/AAAAAADauKE/noEZ_VcHeU0/w1900/MR-29161-525022-30.jpg'),
(392, 27, 'http://4.bp.blogspot.com/-nMZXwWLMyhw/V_-KXpWJYEI/AAAAAADauJk/2VF2bPiGPDQ/w1900/MR-29161-525022-31.jpg'),
(393, 27, 'http://1.bp.blogspot.com/-oJoO8lvNA4M/V_-KWyhJ3II/AAAAAADauJA/cunG24l722s/w1900/MR-29161-525022-32.jpg'),
(394, 28, 'http://3.bp.blogspot.com/-Z8HOGIVbXLs/V_6XmNuSN2I/AAAAAADX1B4/K8fcEEDntg8/w1900/MR-29161-533869-2.jpg'),
(395, 28, 'http://4.bp.blogspot.com/-pYss6HOwl8o/V_6XlgjtIiI/AAAAAADX1BY/TLVbBHxCq4k/w1900/MR-29161-533869-3.jpg'),
(396, 28, 'http://1.bp.blogspot.com/-pAjrG9rpq_Y/V_6XlBRRdlI/AAAAAADX1A4/xSZNrqZrTUI/w1900/MR-29161-533869-4.jpg'),
(397, 28, 'http://2.bp.blogspot.com/-8CDaxCIKfqM/V_6XkpdEAVI/AAAAAADX1AU/soSZdsYuvhM/w1900/MR-29161-533869-5.jpg'),
(398, 28, 'http://3.bp.blogspot.com/-P5L5mqMTb64/V_6XkPkPBWI/AAAAAADX0_s/MdxG7RH9d8c/w1900/MR-29161-533869-6.jpg'),
(399, 28, 'http://4.bp.blogspot.com/-dWLx-sVwdkk/V_6XjtCkyUI/AAAAAADX0_Q/2NN6hM4R_7I/w1900/MR-29161-533869-7.jpg'),
(400, 28, 'http://1.bp.blogspot.com/-Fz9cSzcnnR0/V_6XegTWafI/AAAAAADX064/756ya0OOnWs/w1900/MR-29161-533869-8.jpg'),
(401, 28, 'http://2.bp.blogspot.com/-5DCg8QSsmSA/V_6XeC4JxuI/AAAAAADX06Y/p1__8SRVtVA/w1900/MR-29161-533869-9.jpg'),
(402, 28, 'http://3.bp.blogspot.com/-R7xAaOKz2Bc/V_6XdjSQncI/AAAAAADX06A/UXY6PFAkMf4/w1900/MR-29161-533869-10.jpg'),
(403, 28, 'http://4.bp.blogspot.com/-Ybglfm5l1Wk/V_6XdCS-fgI/AAAAAADX05g/fQ1c5sQ6Twc/w1900/MR-29161-533869-11.jpg'),
(404, 28, 'http://1.bp.blogspot.com/-kkzWtWZ0Q4s/V_6Xcodr-wI/AAAAAADX05A/USi6s5PK0Oo/w1900/MR-29161-533869-12.jpg'),
(405, 28, 'http://2.bp.blogspot.com/-nwaPNiWRGvc/V_6XbxvkQZI/AAAAAADX04c/TaPGPYjkqMM/w1900/MR-29161-533869-13.jpg'),
(406, 28, 'http://3.bp.blogspot.com/-rN-HnOQhB0A/V_6XbR7bpOI/AAAAAADX038/Ybjysn8TTls/w1900/MR-29161-533869-14.jpg'),
(407, 28, 'http://4.bp.blogspot.com/-BV3P9gN0YlE/V_6Xa2ielOI/AAAAAADX03Y/6n9uDxq7LpU/w1900/MR-29161-533869-15.jpg'),
(408, 28, 'http://1.bp.blogspot.com/-t4gTqGl43d4/V_6XadmN53I/AAAAAADX024/LOhY0gvjuzQ/w1900/MR-29161-533869-16.jpg'),
(409, 28, 'http://2.bp.blogspot.com/-nQaZzhjhmLQ/V_6XZm-MztI/AAAAAADX02c/OySzXAOTKzk/w1900/MR-29161-533869-17.jpg'),
(410, 28, 'http://3.bp.blogspot.com/-qqDCt9YSwnw/V_6VdeCL5rI/AAAAAADXzUE/u1quzvC8_OM/w1900/MR-29161-533869-18.jpg'),
(411, 28, 'http://4.bp.blogspot.com/-QNgHPnqIX4A/V_6Vc9K2S1I/AAAAAADXzTg/qQ_KpO2957w/w1900/MR-29161-533869-19.jpg'),
(412, 28, 'http://1.bp.blogspot.com/-pd5qRtVRYCQ/V_6Vcdi5UFI/AAAAAADXzS8/p3mncNBK780/w1900/MR-29161-533869-20.jpg'),
(413, 28, 'http://2.bp.blogspot.com/-OhosD44_abw/V_6Vb601ufI/AAAAAADXzSc/PwnvowpBAiQ/w1900/MR-29161-533869-21.jpg'),
(414, 28, 'http://3.bp.blogspot.com/-0AxSmiU2h6I/V_6VbB5jKJI/AAAAAADXzRw/3L1ZM0DVpjE/w1900/MR-29161-533869-22.jpg'),
(415, 28, 'http://4.bp.blogspot.com/-DFBFPugfn4o/V_6Vai8ZqHI/AAAAAADXzRQ/702cmiz2PSw/w1900/MR-29161-533869-23.jpg'),
(416, 28, 'http://1.bp.blogspot.com/-rRUI7amTQrs/V_6VZ8RDDRI/AAAAAADXzQ0/mx_q8e-Kbto/w1900/MR-29161-533869-24.jpg'),
(417, 28, 'http://2.bp.blogspot.com/-uXvwt0okGaA/V_6VZWzSx5I/AAAAAADXzQI/CO5-z2CtNdM/w1900/MR-29161-533869-25.jpg'),
(418, 28, 'http://3.bp.blogspot.com/-v-4fixL7x6g/V_6VY8iGERI/AAAAAADXzPk/-aLPT-sgFe8/w1900/MR-29161-533869-26.jpg'),
(419, 28, 'http://4.bp.blogspot.com/-AFQqUCeAy1w/V_6VYV6_JGI/AAAAAADXzPE/iHmFvwjZ9v4/w1900/MR-29161-533869-27.jpg'),
(420, 28, 'http://1.bp.blogspot.com/-8yWfeg7EJxw/V_6VXl35mCI/AAAAAADXzOg/0dstwdRKJDM/w1900/MR-29161-533869-28.jpg'),
(421, 28, 'http://2.bp.blogspot.com/-zltsMUap2gU/V_6VXKX0HBI/AAAAAADXzOA/rTXRfkUmS-8/w1900/MR-29161-533869-29.jpg'),
(422, 28, 'http://3.bp.blogspot.com/-6MFwsHnK9Gs/V_6VWQ-wQXI/AAAAAADXzNU/onsrQ6VzpDc/w1900/MR-29161-533869-30.jpg'),
(423, 28, 'http://4.bp.blogspot.com/-HBVi1afeGzk/V_6VV1dmDlI/AAAAAADXzM0/hkW958sEaJI/w1900/MR-29161-533869-31.jpg'),
(424, 28, 'http://1.bp.blogspot.com/-RNWjkkmGsPQ/V_6VVZoMD9I/AAAAAADXzMU/8m8zToyBt3U/w1900/MR-29161-533869-32.jpg'),
(425, 28, 'http://2.bp.blogspot.com/-6h-6xMvYQ7Q/V_6VUrspZzI/AAAAAADXzL0/RRW5yu6owqE/w1900/MR-29161-533869-33.jpg'),
(426, 28, 'http://3.bp.blogspot.com/-BwU-eWuqcOs/V_6VUC4eAWI/AAAAAADXzLY/OO9DSO7LovA/w1900/MR-29161-533869-34.jpg'),
(427, 28, 'http://4.bp.blogspot.com/-L-Pkaeqb32o/V_6VTikCnwI/AAAAAADXzK0/1onAMWIkfq8/w1900/MR-29161-533869-35.jpg'),
(428, 29, 'http://2.bp.blogspot.com/-rmHa4eViL7g/VnhZtQEzvsI/AAAAAAAvtlQ/nVxU9UwHEKo/w1900/1.jpg'),
(429, 29, 'http://3.bp.blogspot.com/-N9R_s53BAOM/VnhZuFt8SiI/AAAAAAAvtls/YrWN0R9w-rA/w1900/2.jpg'),
(430, 29, 'http://4.bp.blogspot.com/-SS6vFfaHQ5U/VnhZvPMT3aI/AAAAAAAvtl8/qgesx3nwovU/w1900/3.jpg'),
(431, 29, 'http://1.bp.blogspot.com/-rILP72GK4Rk/VnhZvwciv7I/AAAAAAAvtms/Au-u4PpatpQ/w1900/4.jpg'),
(432, 29, 'http://2.bp.blogspot.com/-ojGOsDfR_Eo/VnhZxMogy5I/AAAAAAAvtnE/qAOtuV8ftt0/w1900/5.jpg'),
(433, 29, 'http://3.bp.blogspot.com/-5xe4nbF74dU/VnhZyIYDTfI/AAAAAAAvtnc/3UHnEsTkvoE/w1900/6.jpg'),
(434, 29, 'http://4.bp.blogspot.com/-q2OQESXJ5DY/VnhZylyX0eI/AAAAAAAvtn0/9fjzZaf3s0E/w1900/7.jpg'),
(435, 29, 'http://1.bp.blogspot.com/-2w9A9D-rxAU/VnhZzovOdLI/AAAAAAAvtoc/KngVZdoTPMk/w1900/8.jpg'),
(436, 29, 'http://2.bp.blogspot.com/-WsjMYg4ooek/VnhZ0YSrIbI/AAAAAAAvtpU/Rp_cvUItDS0/w1900/9.jpg'),
(437, 29, 'http://3.bp.blogspot.com/-cab89gFjSe0/VnhZ2IHZGEI/AAAAAAAvtpo/u_zCL8AcuYI/w1900/10.jpg'),
(438, 29, 'http://4.bp.blogspot.com/-hIIU_llJk_s/VnhZ2saU4wI/AAAAAAAvtqU/TUUZ1fpaFfo/w1900/11.jpg'),
(439, 29, 'http://1.bp.blogspot.com/-Zp26XnO74tA/VnhZ31vJLsI/AAAAAAAvtq0/dDb4V503nIM/w1900/12.jpg'),
(440, 29, 'http://2.bp.blogspot.com/-e2immSh0lH8/VnhZ6VI5gaI/AAAAAAAvtr8/A7wxg6-UAVE/w1900/13.jpg'),
(441, 29, 'http://3.bp.blogspot.com/-ha57aZDI2HU/VnhZ7N_nU7I/AAAAAAAvtsU/aqx98dDRWRY/w1900/14.jpg'),
(442, 29, 'http://4.bp.blogspot.com/-JyIpDWm77pQ/VnhZ74T5QDI/AAAAAAAvtss/ImlF1lNJAos/w1900/15.jpg'),
(443, 29, 'http://1.bp.blogspot.com/-sdFPU4BHUYA/VnhZ8ljQ2OI/AAAAAAAvttE/p_imsOBlw4o/w1900/16.jpg'),
(444, 29, 'http://2.bp.blogspot.com/-lLjljzzBBSk/VnhZ9JXcRjI/AAAAAAAvttk/6n_5iqdfII8/w1900/17.jpg'),
(445, 29, 'http://3.bp.blogspot.com/-l5wQ1s5H3cc/VnhZ-fmCWaI/AAAAAAAvtus/MAnuiBqRwpA/w1900/18.jpg'),
(446, 29, 'http://4.bp.blogspot.com/-qcVHEodA4o4/VnhaA3sE1BI/AAAAAAAvtvY/LtU9DFKSbtk/w1900/19.jpg'),
(447, 29, 'http://1.bp.blogspot.com/-ZdK6ylFQOLE/VnhaCHKZyJI/AAAAAAAvtv0/CBEuYxd5PoI/w1900/20.jpg'),
(448, 29, 'http://2.bp.blogspot.com/-5_4bU98_aPE/VnhaC_VvFWI/AAAAAAAvtwM/6L-3IMuCFKc/w1900/21.jpg'),
(449, 29, 'http://3.bp.blogspot.com/-5pUzP7zV-DI/VnhaDTgPR0I/AAAAAAAvtwo/ORKTpeSq6Es/w1900/22.jpg'),
(450, 30, 'http://2.bp.blogspot.com/-HSJU8FD5d6s/WAGolXMqpHI/AAAAAADhAAA/aeA8HVpUaLo/w1900/MR-26116-449694-1.jpg'),
(451, 30, 'http://3.bp.blogspot.com/--0Wr3ZgYWCg/WAGokwX881I/AAAAAADg__g/gLYZId33_6Y/w1900/MR-26116-449694-2.jpg'),
(452, 30, 'http://4.bp.blogspot.com/-XqoK7BSfMXQ/WAGoj5W-u_I/AAAAAADg__A/5cpEnCK9sBU/w1900/MR-26116-449694-3.jpg'),
(453, 30, 'http://1.bp.blogspot.com/-CSe_Tblgy7M/WAGojU9tPHI/AAAAAADg_-g/NkK0F3tiwA0/w1900/MR-26116-449694-4.jpg'),
(454, 30, 'http://2.bp.blogspot.com/-p772PJV09Q0/WAGoihdWS4I/AAAAAADg_98/TPoLYMP9ww8/w1900/MR-26116-449694-5.jpg'),
(455, 30, 'http://3.bp.blogspot.com/-_7IL--dTci4/WAGoiDtWZnI/AAAAAADg_9U/cJGXlhf4UYI/w1900/MR-26116-449694-6.jpg'),
(456, 30, 'http://4.bp.blogspot.com/-jEOhFg4PwvU/WAGohHawyqI/AAAAAADg_80/kf3V7yNOwgE/w1900/MR-26116-449694-7.jpg'),
(457, 30, 'http://1.bp.blogspot.com/-V-HJ_a9UTvU/WAGogWaWwcI/AAAAAADg_8M/R6VwGwWvhNM/w1900/MR-26116-449694-8.jpg'),
(458, 30, 'http://2.bp.blogspot.com/-ajphtalmrH0/WAGoftcmr2I/AAAAAADg_7U/9012-b9RU88/w1900/MR-26116-449694-9.jpg'),
(459, 30, 'http://3.bp.blogspot.com/-xSflz7UCC3w/WAGoexKmQOI/AAAAAADg_6o/w2-MPhIFX4U/w1900/MR-26116-449694-10.jpg'),
(460, 30, 'http://4.bp.blogspot.com/-kb_r8H_Fb_I/WAGoeFbZjDI/AAAAAADg_6A/5JdZTwmastU/w1900/MR-26116-449694-11.jpg'),
(461, 30, 'http://1.bp.blogspot.com/-0OwUOJeY6WU/WAGodbtAgmI/AAAAAADg_5g/bqSsF5hLwPw/w1900/MR-26116-449694-12.jpg'),
(462, 30, 'http://2.bp.blogspot.com/-vjgE2eJL3jM/WAGochTqf8I/AAAAAADg_48/mTDqDuosvhQ/w1900/MR-26116-449694-13.jpg'),
(463, 30, 'http://3.bp.blogspot.com/-TNm-nZtfXLQ/WAGocMbhttI/AAAAAADg_4Y/R161bIf06Zs/w1900/MR-26116-449694-14.jpg'),
(464, 30, 'http://4.bp.blogspot.com/-4UnKYILEnE0/WAGobIxG61I/AAAAAADg_3k/3A-SO2KtGDI/w1900/MR-26116-449694-15.jpg'),
(465, 30, 'http://1.bp.blogspot.com/-9LrQzHRacz8/WAGmUDmYd5I/AAAAAADg-M8/4mUbsoJwDuo/w1900/MR-26116-449694-16.jpg'),
(466, 30, 'http://2.bp.blogspot.com/-BpIckp5kkjc/WAGmTdTZn4I/AAAAAADg-MY/TkKALix4IRA/w1900/MR-26116-449694-17.jpg'),
(467, 30, 'http://3.bp.blogspot.com/-0szPD6FKFD4/WAGmSk1rC7I/AAAAAADg-Lw/HUho2wxmALI/w1900/MR-26116-449694-18.jpg'),
(468, 30, 'http://4.bp.blogspot.com/-L9EefC13YHA/WAGmR8Y0x0I/AAAAAADg-LI/ltS-qp9VGks/w1900/MR-26116-449694-19.jpg'),
(469, 30, 'http://1.bp.blogspot.com/-sfQaxF8pEJo/WAGmRHXWIzI/AAAAAADg-Ko/dbl2P1aCJIk/w1900/MR-26116-449694-20.jpg'),
(470, 30, 'http://2.bp.blogspot.com/-OKnWbmoXnvM/WAGmQkl9JLI/AAAAAADg-KA/pi5xSMqJeAA/w1900/MR-26116-449694-21.jpg'),
(471, 30, 'http://3.bp.blogspot.com/-2Z0geO2X218/WAGmP5_ucDI/AAAAAADg-Jw/EJYlrPZOYso/w1900/MR-26116-449694-22.jpg'),
(472, 30, 'http://4.bp.blogspot.com/-FRJa5hRg2sw/WAGmPY0unpI/AAAAAADg-JY/UxPvF33ggL4/w1900/MR-26116-449694-23.jpg'),
(473, 30, 'http://1.bp.blogspot.com/-RAtWi6dfywY/WAGmO_d5yYI/AAAAAADg-I4/S-OGHz7fNqs/w1900/MR-26116-449694-24.jpg'),
(474, 30, 'http://2.bp.blogspot.com/-7mqLXXxM5p4/WAGmOFg24DI/AAAAAADg-IU/lA559Q9xgvY/w1900/MR-26116-449694-25.jpg'),
(475, 30, 'http://3.bp.blogspot.com/-dvscQcskvM8/WAGmNiL9TzI/AAAAAADg-H0/1d9x4j1bBlQ/w1900/MR-26116-449694-26.jpg'),
(476, 31, 'http://2.bp.blogspot.com/-QRcf5sQ7ctE/V97HQn4f13I/AAAAAAB_Als/b3kTcHiX0Go/w1900/MR-354213-663034-1.jpg'),
(477, 31, 'http://4.bp.blogspot.com/-QEkG8mwuXEw/V97HPkaE5xI/AAAAAAB_AlE/nXdDSYtbKr8/w1900/MR-354213-663034-3.jpg'),
(478, 31, 'http://1.bp.blogspot.com/-q0ISe7jiyCY/V97HPAAfqxI/AAAAAAB_Aks/nZA-uC3jZ_8/w1900/MR-354213-663034-4.jpg'),
(479, 31, 'http://2.bp.blogspot.com/-zmqo6jOcHnU/V97HMBJ0seI/AAAAAAB_Akc/iwprx9GqbzA/w1900/MR-354213-663034-5.jpg'),
(480, 31, 'http://3.bp.blogspot.com/-Wi1cAiDMZUo/V97HLgEsISI/AAAAAAB_Ai0/4JAEAdTehos/w1900/MR-354213-663034-6.jpg'),
(481, 31, 'http://4.bp.blogspot.com/-LLRU-OeEHf4/V97EbLelCBI/AAAAAAB--5E/kohjWnZLb98/w1900/MR-354213-663034-7.jpg'),
(482, 31, 'http://1.bp.blogspot.com/-WodwB_8sXHc/V97EaQQ_tgI/AAAAAAB--4o/WTUkNc6ABKU/w1900/MR-354213-663034-8.jpg'),
(483, 31, 'http://2.bp.blogspot.com/-vJe_n4_a6CU/V97EZ5uaUrI/AAAAAAB--4U/yEs5qPAHwAk/w1900/MR-354213-663034-9.jpg'),
(484, 31, 'http://3.bp.blogspot.com/-y7x8ghGvPFk/V97EZPi0u2I/AAAAAAB--4A/cwbBODlPNgg/w1900/MR-354213-663034-10.jpg');
INSERT INTO `chapter_has_images` (`id`, `id_chapter`, `url`) VALUES
(485, 31, 'http://4.bp.blogspot.com/-iQAyKO-Cq1Y/V97EYPTKQFI/AAAAAAB--3c/O4WpuHS4xu4/w1900/MR-354213-663034-11.jpg'),
(486, 31, 'http://1.bp.blogspot.com/-raAeImK2jic/V97EXggMLnI/AAAAAAB--3I/7MYEMw2KkSg/w1900/MR-354213-663034-12.jpg'),
(487, 31, 'http://2.bp.blogspot.com/-1CWC50UiNZs/V97EW0WIfII/AAAAAAB--20/UVQBNJbhby8/w1900/MR-354213-663034-13.jpg'),
(488, 31, 'http://3.bp.blogspot.com/-jbh8FcDfggA/V97EWTs2ztI/AAAAAAB--2g/X5jL6BG7fO0/w1900/MR-354213-663034-14.jpg'),
(489, 31, 'http://4.bp.blogspot.com/-3DbO--5ZaG8/V97EVKFPg0I/AAAAAAB--2I/zESW3gT3ve0/w1900/MR-354213-663034-15.jpg'),
(490, 31, 'http://1.bp.blogspot.com/-F7KiGjlDLAg/V97EUV3f0MI/AAAAAAB--1U/iLOOIdz7pgE/w1900/MR-354213-663034-16.jpg'),
(491, 31, 'http://2.bp.blogspot.com/-XLLKwu8lP-Q/V97ET0DsSiI/AAAAAAB--1A/Ju1UHe752iw/w1900/MR-354213-663034-17.jpg'),
(492, 31, 'http://3.bp.blogspot.com/-TYV-PzznoAQ/V97ETP_SnQI/AAAAAAB--0s/t6TwtXvPrBg/w1900/MR-354213-663034-18.jpg'),
(493, 31, 'http://4.bp.blogspot.com/-jUZl3ploULw/V97ESW4Rt7I/AAAAAAB--0U/4Vri8Db2LLQ/w1900/MR-354213-663034-19.jpg'),
(494, 31, 'http://1.bp.blogspot.com/-YWjmmzPx4xA/V97ERxP4UCI/AAAAAAB--z8/Eh72wwyEMNQ/w1900/MR-354213-663034-20.jpg'),
(495, 31, 'http://2.bp.blogspot.com/-ovdY5s7ab3s/V97EQ235CII/AAAAAAB--zg/u4hBhm2jAso/w1900/MR-354213-663034-21.jpg'),
(496, 31, 'http://3.bp.blogspot.com/-R8DEtRYdNKE/V97EPxkyEjI/AAAAAAB--zM/4VkSeiSdjwc/w1900/MR-354213-663034-22.jpg'),
(497, 31, 'http://4.bp.blogspot.com/-QvCULSe95y8/V97EPTV6giI/AAAAAAB--ys/A1JmG8EscTI/w1900/MR-354213-663034-23.jpg'),
(498, 31, 'http://1.bp.blogspot.com/-_4_6Tmd6_xM/V97EO20gKbI/AAAAAAB--yY/8DbKu0KcBL0/w1900/MR-354213-663034-24.jpg'),
(499, 31, 'http://2.bp.blogspot.com/-96rtmtdR5U0/V97EODwzLeI/AAAAAAB--yE/QiqoMVE-WAo/w1900/MR-354213-663034-25.jpg'),
(500, 31, 'http://3.bp.blogspot.com/-gRwyJueuZy0/WCjHPbPkMbI/AAAAAAFLm2Q/k0G_sobSHz4/w1900/MR-354213-663034-26.jpg'),
(501, 31, 'http://4.bp.blogspot.com/-iDIlN22FcbY/V97CWgQYVjI/AAAAAAB-9w8/qZfwchqguBY/w1900/MR-354213-663034-27.jpg'),
(502, 32, 'http://2.bp.blogspot.com/-YK9U30L-tGM/V-hfY1O3DsI/AAAAAACUvbY/FEr815Bdv-0/w1900/MR-352374-629780-1.jpg'),
(503, 32, 'http://3.bp.blogspot.com/-gEmzDBLbCos/V-hfXm9mjEI/AAAAAACUvaw/3pgYlD-Xr2g/w1900/MR-352374-629780-2.jpg'),
(504, 32, 'http://4.bp.blogspot.com/-_a5C1EljXGo/V-hfW7b1U-I/AAAAAACUvaU/5YdHQno_2W4/w1900/MR-352374-629780-3.jpg'),
(505, 32, 'http://1.bp.blogspot.com/-0UJU5kTGIzI/V-hfV-WpenI/AAAAAACUvZ8/hSl3Gr9sE1g/w1900/MR-352374-629780-4.jpg'),
(506, 32, 'http://2.bp.blogspot.com/-IQnfMFTf8SQ/V-hfVCz421I/AAAAAACUvZk/sKJwHX8LlMM/w1900/MR-352374-629780-5.jpg'),
(507, 32, 'http://3.bp.blogspot.com/-9bDXSc8gnro/V-hfUckI_MI/AAAAAACUvZM/q17-1CQK3tc/w1900/MR-352374-629780-6.jpg'),
(508, 32, 'http://4.bp.blogspot.com/-rqszBuz3w0E/V-hfTSc_xKI/AAAAAACUvY0/IwziggfS5tY/w1900/MR-352374-629780-7.jpg'),
(509, 32, 'http://1.bp.blogspot.com/-_dCsYNi6H7Q/V-hcQtGJJVI/AAAAAACUt1A/agTUbP38ki4/w1900/MR-352374-629780-8.jpg'),
(510, 32, 'http://2.bp.blogspot.com/-UOwCgC2gFLk/V-hcP5U80aI/AAAAAACUtzA/7JkQo_q2ASY/w1900/MR-352374-629780-9.jpg'),
(511, 32, 'http://3.bp.blogspot.com/-kN7CC69ZlDg/V-hcPGJ17VI/AAAAAACUtys/OUMkRLvdjDM/w1900/MR-352374-629780-10.jpg'),
(512, 32, 'http://4.bp.blogspot.com/-MCf6q0kOObE/V-hcOQ5G_AI/AAAAAACUtyU/uYuc0uKXsPE/w1900/MR-352374-629780-11.jpg'),
(513, 33, 'http://2.bp.blogspot.com/-pzhxkdazEAU/WAlYBrxcDmI/AAAAAAD0kfY/CgUr6l4CNFw/w1900/MR-362905-823651-1.jpg'),
(514, 33, 'http://3.bp.blogspot.com/-xMszbpVpd-4/WAlYA4O7y4I/AAAAAAD0ke0/rlLuMT04Jj0/w1900/MR-362905-823651-2.jpg'),
(515, 33, 'http://4.bp.blogspot.com/-a0B4NxMkBmY/WAlYANcIkcI/AAAAAAD0keE/QkhbvA2lz0g/w1900/MR-362905-823651-3.jpg'),
(516, 33, 'http://1.bp.blogspot.com/-CFvsvPwUCVE/WAlX_SQ_xVI/AAAAAAD0kdg/mnHEG83O3Jo/w1900/MR-362905-823651-4.jpg'),
(517, 33, 'http://2.bp.blogspot.com/-z2phdO5Y8C0/WAlX-1eIVHI/AAAAAAD0kc0/lSFq6bVno6Y/w1900/MR-362905-823651-5.jpg'),
(518, 33, 'http://3.bp.blogspot.com/-PEsctNuaGns/WAlX-L4ldhI/AAAAAAD0kcQ/EKPrJBlgnik/w1900/MR-362905-823651-6.jpg'),
(519, 33, 'http://4.bp.blogspot.com/-T3HFXWn__CY/WAlX9pPbYsI/AAAAAAD0kbs/Cv9b0fFsVVU/w1900/MR-362905-823651-7.jpg'),
(520, 33, 'http://1.bp.blogspot.com/-6UG8aZNzJno/WAlX86XaUfI/AAAAAAD0kbI/4-n3VHRSorc/w1900/MR-362905-823651-8.jpg'),
(521, 33, 'http://2.bp.blogspot.com/-TYya8-62D6s/WAlX8afQCjI/AAAAAAD0kak/a4kJKmC34EA/w1900/MR-362905-823651-9.jpg'),
(522, 33, 'http://3.bp.blogspot.com/-vyF_Mup1W_8/WAlX78B1AeI/AAAAAAD0kaM/7aNCYdq7w8I/w1900/MR-362905-823651-10.jpg'),
(523, 33, 'http://4.bp.blogspot.com/-FqTh8j28jCI/WAlX66diACI/AAAAAAD0kZg/3RwWKhbfudY/w1900/MR-362905-823651-11.jpg'),
(524, 33, 'http://1.bp.blogspot.com/-XFkCFP3OwJ0/WAlX6RrlyPI/AAAAAAD0kZE/v-yZ_4HcHfY/w1900/MR-362905-823651-12.jpg'),
(525, 51, 'http://2.bp.blogspot.com/-MOQANCdgNoE/WAndhnNMaJI/AAAAAAD2NRo/LAlbH_9RZjY/w1900/MR-25032-429643-1.jpg'),
(526, 51, 'http://3.bp.blogspot.com/-v7jg-CiLNmI/WAndeE6qT6I/AAAAAAD2NOw/hsYYEI3DmZM/w1900/MR-25032-429643-2.jpg'),
(527, 51, 'http://4.bp.blogspot.com/-vQzBDJSE6qw/WAnddSMdokI/AAAAAAD2NOM/sfECQWE46YI/w1900/MR-25032-429643-3.jpg'),
(528, 51, 'http://1.bp.blogspot.com/-35iHcuH1rnI/WAndcubOGgI/AAAAAAD2NNk/2mGhwJll64w/w1900/MR-25032-429643-4.jpg'),
(529, 51, 'http://2.bp.blogspot.com/-I68XR1i5m_M/WAndbmzfpeI/AAAAAAD2NNA/efofgQhZ7Qw/w1900/MR-25032-429643-5.jpg'),
(530, 51, 'http://3.bp.blogspot.com/-CWiWC7BNgQ0/WAndbHPQ2GI/AAAAAAD2NMI/Fg9_jH-n_2k/w1900/MR-25032-429643-6.jpg'),
(531, 51, 'http://4.bp.blogspot.com/-NT4YOlNKaJU/WAndaab44II/AAAAAAD2NLc/X43DLaGZbfQ/w1900/MR-25032-429643-7.jpg'),
(532, 51, 'http://1.bp.blogspot.com/-xy7YYMbiXuM/WAndZoaqcrI/AAAAAAD2NK0/SyhXDTPwwX0/w1900/MR-25032-429643-8.jpg'),
(533, 51, 'http://2.bp.blogspot.com/-xCxWn8KdPrE/WAndZFCyesI/AAAAAAD2NKc/vhZv7SlHEtk/w1900/MR-25032-429643-9.jpg'),
(534, 51, 'http://3.bp.blogspot.com/-GYqj8PvNhO8/WAndX6dEWSI/AAAAAAD2NJw/7bEKgxh3eBw/w1900/MR-25032-429643-10.jpg'),
(535, 51, 'http://4.bp.blogspot.com/-VxBeo6MENog/WAndWz0x61I/AAAAAAD2NI8/tDpaX6WXZEI/w1900/MR-25032-429643-11.jpg'),
(536, 51, 'http://1.bp.blogspot.com/-Q0ymnRIM4ZY/WAndWE1MzKI/AAAAAAD2NIE/Z9ycxPRfveE/w1900/MR-25032-429643-12.jpg'),
(537, 51, 'http://2.bp.blogspot.com/-M2tefxeJ3sw/WAndVUGXyWI/AAAAAAD2NHg/PAuIXTr6mg4/w1900/MR-25032-429643-13.jpg'),
(538, 51, 'http://3.bp.blogspot.com/-J1WhgHcJNV4/WAndUiYahcI/AAAAAAD2NG8/CqMsjhfxOzk/w1900/MR-25032-429643-14.jpg'),
(539, 51, 'http://4.bp.blogspot.com/-J0AWo1szoyI/WAndTa2JuRI/AAAAAAD2NF0/HGqRZ8uOQ64/w1900/MR-25032-429643-15.jpg'),
(540, 51, 'http://1.bp.blogspot.com/-2Ja4CgROwVI/WAnbLMZ8BbI/AAAAAAD2LYI/CIAltdY52qA/w1900/MR-25032-429643-16.jpg'),
(541, 51, 'http://2.bp.blogspot.com/-aCGxExnhVkQ/WAnbKcqyNEI/AAAAAAD2LXk/3NKu9YsCKCg/w1900/MR-25032-429643-17.jpg');

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
(5, 'Touhou - Akizakura', 'Dr Vermillion', 'Complete', 'http://3.c.mpcdn.net/18316/1/180.jpg', 'A flower has bloom out of season at Hakugyokuro. Furthermore it is under Saigyou Ayakashi tree. Is it just a simple flower? or there is more to it?'),
(6, 'Touhou - After Gold', 'Vivit Gray (Circle) ; Shinoasa', 'Complete', 'http://3.c.mpcdn.net/25788/1/180.jpg', 'Friendship between Mokou an Keine'),
(7, 'Touhou - Across The Ocean', 'Sora Freebird', 'Complete', 'http://3.c.mpcdn.net/22103/1/180.jpg', 'Sanae is visiting Patchy to kill time, but she still feel bored. Sanae starts talking about how she spent time in the outside world. the small talk turn into planning how to cross the Hakurei border.'),
(8, 'Overlord', 'Kugane Maruyama', 'On Going', 'http://3.c.mpcdn.net/29252/5/180.jpg', 'The story begins with Yggdrasil, a popular online game which is quietly shut down on its last day. Our protagonist Momonga decided to stay until the last moment in his beloved game and wait for the force logout. Unexpectedly, the server did not shut down and Momonga is stuck in his skeleton body and got transferred to another world. \"The powerful Overlord\" needs now to discover a new world and face the continuous challenges.\r\nHaving no parents, friends, or place in society, this ordinary man strives to take over the new world the game has become.'),
(9, '09Summer', 'Apricot Plus (Circle) ; Aoki Ume', 'Complete', 'http://3.c.mpcdn.net/6807/1/180.jpg', ''),
(10, 'Touhou - Touhou Dokidoki Shintai Kensa', 'Tamagoyaki ; Yudokuya', 'Complete', 'http://3.c.mpcdn.net/26219/1/180.jpg', 'There are few things Japanese boys fantasize more than what goes in a girls health examination, so it comes as no surprise that there’s a Touhou doujin about it. (And a little on the naughty side, obviously.)'),
(11, 'Sakamoto desu ga?', 'Sano Nami', 'On Going', 'http://3.c.mpcdn.net/8499/3/180.jpg', 'First-year high-school student Sakamoto isn\'t just cool, he\'s the coolest! Almost immediately after starting school, he began attracting everyone\'s attention. The girls love him, and most of the boys resent him. There\'s even a boy in the class who works as a model, but who is constantly upstaged by Sakamoto! No matter what tricks the other boys try to play on him, Sakamoto always manages to foil them with ease and grace. Though Sakamoto may seem cool and aloof, he helps others when asked, such as in the case of the boy in his class who was being constantly bullied. No matter what difficulties Sakamoto encounters, he moves through his high-school life with confidence and class!'),
(12, 'Because She Is a Little Girl, I Am Excited', 'YUZUKI Ryouta', 'On Going', 'http://3.c.mpcdn.net/34486/1/180.jpg', ''),
(13, 'Granblue Fantasy - Uncle Cali 4koma', 'Namuru', 'Complete', 'http://3.c.mpcdn.net/44595/1/180.jpg', ''),
(14, 'Melty Blood - Dead On Time', 'Yuunagi Zakkaten (Circle) ; Minazuki No-mu', 'Complete', 'http://3.c.mpcdn.net/25137/1/180.jpg', 'Two endearing sets of 4koma, one centered on the Rens\' relationship with Shiki, the other revolving around Warrachia\'s mischievous shenanigans.');

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
(23, 3, 'The National Bird Won\'t Stop Calling', 3),
(24, 8, 'Chapter 1', 1),
(25, 8, 'Chapter 2', 2),
(26, 8, 'Chapter 3', 3),
(27, 8, 'Chapter 4', 4),
(28, 8, 'Chapter 5', 5),
(29, 9, 'Oneshot', 1),
(30, 10, 'Special Oneshot', 1),
(31, 11, 'Sakamoto of Class 1-2', 1),
(32, 12, 'Chapter 1', 1),
(33, 13, 'Granblue Fantasy - Uncle Cali', 1),
(51, 14, 'Dead On Time', 1);

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
(28, 7, 8),
(29, 8, 33),
(30, 8, 1),
(31, 8, 4),
(32, 8, 8),
(33, 9, 5),
(34, 9, 30),
(35, 10, 4),
(36, 10, 5),
(37, 10, 7),
(38, 10, 8),
(39, 10, 37),
(40, 11, 4),
(41, 11, 23),
(42, 11, 25),
(43, 12, 4),
(44, 12, 28),
(45, 13, 4),
(46, 13, 9),
(47, 14, 4),
(48, 14, 5);

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
(4, 'jepe', '1234', 'jepe@gmail.com', 2131165290),
(5, 'aaaa', 'aaaa', 'a@gmail.com', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_do_backup`
--

CREATE TABLE `user_do_backup` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_favorites_manga`
--

CREATE TABLE `user_favorites_manga` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_manga` int(11) NOT NULL,
  `id_backup` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_favorites_manga`
--

INSERT INTO `user_favorites_manga` (`id`, `id_user`, `id_manga`, `id_backup`) VALUES
(1, 1, 1, 0),
(2, 1, 2, 0);

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
-- Indexes for table `user_do_backup`
--
ALTER TABLE `user_do_backup`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `user_do_backup`
--
ALTER TABLE `user_do_backup`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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

--
-- Constraints for table `user_do_backup`
--
ALTER TABLE `user_do_backup`
  ADD CONSTRAINT `user_do_backup_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
