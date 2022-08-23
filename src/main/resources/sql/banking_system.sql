-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Час створення: Сер 23 2022 р., 16:11
-- Версія сервера: 10.4.21-MariaDB
-- Версія PHP: 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База даних: `banking_system`
--

-- --------------------------------------------------------

--
-- Структура таблиці `cards`
--

CREATE TABLE `cards` (
  `id_card` bigint(10) UNSIGNED NOT NULL,
  `number_card` varchar(16) DEFAULT NULL,
  `card_end_data_month` int(2) DEFAULT NULL,
  `card_end_data_year` int(4) DEFAULT NULL,
  `cvc2` varchar(3) DEFAULT NULL,
  `id_user` bigint(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблиці `loan`
--

CREATE TABLE `loan` (
  `id_loan` bigint(10) UNSIGNED NOT NULL,
  `sum_loan` decimal(10,2) DEFAULT NULL,
  `remained` decimal(10,2) DEFAULT NULL,
  `percent_loan` varchar(10) DEFAULT NULL,
  `deadline_loan` varchar(10) DEFAULT NULL,
  `currency_loan` varchar(10) DEFAULT NULL,
  `start_loan` varchar(10) DEFAULT NULL,
  `end_loan` varchar(10) DEFAULT NULL,
  `id_user` bigint(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблиці `money_card`
--

CREATE TABLE `money_card` (
  `id_card_money` bigint(10) UNSIGNED NOT NULL,
  `amount_card` decimal(10,2) DEFAULT NULL,
  `currency_card` varchar(10) DEFAULT NULL,
  `id_card` bigint(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблиці `money_phone`
--

CREATE TABLE `money_phone` (
  `id_phone_money` bigint(10) UNSIGNED NOT NULL,
  `amount_phone` decimal(10,2) DEFAULT NULL,
  `currency_phone` varchar(10) DEFAULT NULL,
  `id_phone` bigint(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблиці `phone`
--

CREATE TABLE `phone` (
  `id_phone` bigint(10) UNSIGNED NOT NULL,
  `phone_number` varchar(60) DEFAULT NULL,
  `id_user` bigint(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблиці `users`
--

CREATE TABLE `users` (
  `id_user` bigint(10) UNSIGNED NOT NULL,
  `first_name` varchar(60) DEFAULT NULL,
  `last_name` varchar(60) DEFAULT NULL,
  `login_user` varchar(120) DEFAULT NULL,
  `password_user` varchar(120) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Індекси збережених таблиць
--

--
-- Індекси таблиці `cards`
--
ALTER TABLE `cards`
  ADD PRIMARY KEY (`id_card`),
  ADD KEY `id_user` (`id_user`);

--
-- Індекси таблиці `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`id_loan`),
  ADD KEY `id_user` (`id_user`);

--
-- Індекси таблиці `money_card`
--
ALTER TABLE `money_card`
  ADD PRIMARY KEY (`id_card_money`),
  ADD KEY `id_card` (`id_card`);

--
-- Індекси таблиці `money_phone`
--
ALTER TABLE `money_phone`
  ADD PRIMARY KEY (`id_phone_money`),
  ADD KEY `id_phone` (`id_phone`);

--
-- Індекси таблиці `phone`
--
ALTER TABLE `phone`
  ADD PRIMARY KEY (`id_phone`),
  ADD KEY `id_user` (`id_user`);

--
-- Індекси таблиці `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT для збережених таблиць
--

--
-- AUTO_INCREMENT для таблиці `cards`
--
ALTER TABLE `cards`
  MODIFY `id_card` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT для таблиці `loan`
--
ALTER TABLE `loan`
  MODIFY `id_loan` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблиці `money_card`
--
ALTER TABLE `money_card`
  MODIFY `id_card_money` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT для таблиці `money_phone`
--
ALTER TABLE `money_phone`
  MODIFY `id_phone_money` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT для таблиці `phone`
--
ALTER TABLE `phone`
  MODIFY `id_phone` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT для таблиці `users`
--
ALTER TABLE `users`
  MODIFY `id_user` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- Обмеження зовнішнього ключа збережених таблиць
--

--
-- Обмеження зовнішнього ключа таблиці `cards`
--
ALTER TABLE `cards`
  ADD CONSTRAINT `cards_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Обмеження зовнішнього ключа таблиці `loan`
--
ALTER TABLE `loan`
  ADD CONSTRAINT `loan_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Обмеження зовнішнього ключа таблиці `money_card`
--
ALTER TABLE `money_card`
  ADD CONSTRAINT `money_card_ibfk_1` FOREIGN KEY (`id_card`) REFERENCES `cards` (`id_card`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Обмеження зовнішнього ключа таблиці `money_phone`
--
ALTER TABLE `money_phone`
  ADD CONSTRAINT `money_phone_ibfk_1` FOREIGN KEY (`id_phone`) REFERENCES `phone` (`id_phone`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Обмеження зовнішнього ключа таблиці `phone`
--
ALTER TABLE `phone`
  ADD CONSTRAINT `phone_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
