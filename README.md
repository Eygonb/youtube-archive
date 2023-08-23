Самый удобный и человечный сервис для скачивания с ютуба - в облако или на диск

## Build
`your_backend_image_name=ugpt/yt_archiver:backend`

`your_frontend_image_name=ugpt/yt_archiver:frontend`
### Backend
Для сборки образа:
```
cd backend
gradle buildDocker
```
Либо
```
cd backend
gradle bootJar
docker build -t *your_backend_image_name* .
```
### Frontend
Для сборки образа:
```
cd frontend
docker build -t *your_frontend_image_name* .
```

## Deploy
Для деплоя собранных образов на сервер:
```
docker login
docker push *your_frontend_image_name*
docker push *your_backend_image_name*
ssh `user`@`server ip`
cd /yt_archiver
docker pull *your_frontend_image_name*
docker pull *your_backend_image_name*
docker-compose up
```