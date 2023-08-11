FROM postgres:alpine

ENV POSTGRES_DB agendamento
ENV POSTGRES_USER eduardo
ENV POSTGRES_PASSWORD 12345

COPY init.sql /docker-entrypoint-initdb.d/