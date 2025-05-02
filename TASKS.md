Список выполненных задач:
1) Изучил Spring Modulith, Swagger, Caffeine,
,поднял 2 базы в докере, поднял проект с профилем prod, прогнал тесты,
накатил тестовые данные из data4dev/data.sql, изучил структуру бд по Show Diagram,
liquibase лежит тут db/changelog.sql, логи в консоль или в файл logs/jirarush.log выводятся в зависимости от профиля,
просмотрел структуры сущностей, в основном каждая в своей папке вместе с dto, repository, service, controller,
все общие интерфейсы и базовые классы вынесены в common, все с юзером и авторизацией в login, mail для хранения писем,
profIle для профиля и контакта, ref для всех возможных ссылок, изучил API через Swagger 
2) удалил два класса из src/main/java/com/javarush/jira/login/internal/sociallogin/handler связанные с vk и yandex,
удалил их из application.yaml (registration),убрал лишние кнопки login.html, заново прогнал все тесты 
3) 
