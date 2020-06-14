# postgres起動
docker run -d -p 55432:5432 -e POSTGRES_USER=user -e POSTGRES_PASSWORD=password -e POSTGRES_DB=clothes-house postgres:12
