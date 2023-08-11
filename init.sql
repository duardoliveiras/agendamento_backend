CREATE DATABASE agendamento;
CREATE USER eduardo WITH PASSWORD '12345';
ALTER ROLE eduardo SET client_encoding TO 'utf';
ALTER ROLE eduardo set timezone TO 'UTC-4';
GRANT ALL PRIVILEGES ON DATABASE agendamento TO eduardo;