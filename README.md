# RSS-парсер

## Описание

Приложение обращается к RSS-каналу каждые 20 минут, парсит список новостей и актуализирует список новостей на удаленном хранилище.

## Технологии

- Java
- Spring Boot
- OpenFeign
- Docker Compose

## Запуск

1. Клонирование репозитория  
   `git clone https://github.com/sharphurt/cron-rss-reader`


2. Запуск приложения с помощью Docker Compose  
   ``docker-compose up --build``

   <hr>
   
   ### Важно

   В репозитории хранилища [sharphurt/news-storage](https://github.com/sharphurt/news-storage) содержится файл `compose.yaml`, который запускает хранилище, базу данных и приложение парсера одновременно. Отдельно ничего запускать не нужно!
   
   <hr>


## Функциональность

- **Парсинг новостей с RSS канала**: Система автоматически парсит новости с указанного RSS канала и обрабатывает их содержимое.
- **Сохранение новостей в удаленное хранилище**: После обработки новостей система сохраняет их в указанное удаленное хранилище.
