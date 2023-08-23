Самый удобный и человечный сервис для скачивания с ютуба - в облако или на диск

## Build
### Backend
Для сборки образа с названием ugpt/yt_archiver:backend :
```
cd backend
gradle buildDocker
```
Для сборки образа со своим названием:
```
cd backend
gradle bootJar
docker build -t *your_image_name* .
```
### Frontend
Для сборки образа:
```
cd frontend
docker build -t *your_image_name* .
```

## Deploy
Для деплоя собственно собранных образов:
<br>
В файле docker-compose.yaml заменить строчки
```
  frontend:
    image: ugpt/yt_archiver:frontend
```
на<br>
```
  frontend:
    image: *your_image_name*
```
и<br>
```
  backend:
    image: ugpt/yt_archiver:backend
```
на<br>
```
  backend:
    image: *your_image_name*
```