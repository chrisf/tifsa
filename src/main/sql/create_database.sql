CREATE DATABASE Tista;

USE Tista;

CREATE TABLE tempdb.dbo.Customer (
  customer_id INT PRIMARY KEY NOT NULL,
  first_name NVARCHAR NOT NULL,
  last_name NVARCHAR NOT NULL
);