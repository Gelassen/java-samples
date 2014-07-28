@echo off
..\..\bin\openssl genrsa -out privkey.pem 512
..\..\bin\openssl req -new -key privkey.pem -out server.csr
..\..\bin\openssl x509 -req -days 10000 -in server.csr -signkey privkey.pem -out server.crt



