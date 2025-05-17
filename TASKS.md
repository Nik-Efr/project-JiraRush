Список выполненных задач:

1) Изучил Spring Modulith, Swagger, Caffeine,
   ,поднял 2 базы в докере, поднял проект с профилем prod, прогнал тесты,
   накатил тестовые данные из data4dev/data.sql, изучил структуру бд по Show Diagram,
   liquibase лежит тут db/changelog.sql, логи в консоль или в файл logs/jirarush.log выводятся в зависимости от профиля,
   просмотрел структуры сущностей, в основном каждая в своей папке вместе с dto, repository, service, controller,
   все общие интерфейсы и базовые классы вынесены в common, все с юзером и авторизацией в login, mail для хранения
   писем,
   profIle для профиля и контакта, ref для всех возможных ссылок, изучил API через Swagger
2) Удалил два класса из src/main/java/com/javarush/jira/login/internal/sociallogin/handler связанные с vk и yandex,
   удалил их из application.yaml (registration),убрал лишние кнопки login.html, заново прогнал все тесты
3) Вынес чувствительные данные в secret.yaml и импортировал его в application.yaml, добавил все нужные переменные
   окружения и протестировал
4) Переписал application-test.yaml, data.sql под H2 и чуть подправил changelog.sql и название колонки Contact,
   проходит все тесты, создал DataSourceConfig и определил два бина + добавил необходимые префиксы во все проперти
5) Написал 4 теста, сваливаются 2 из 4 при первом запуске из-за того что инициализация мапы в ReferenceService
   происходит раньше чем накатывается бд в H2 из-за @PostConstruct...
   на накатанной тестовой бд postgres проходит все тесты ;)
6) Сделал рефакторинг через Path и Files, протестировал
7) Написал TaskTagController c get post delete, дописал в TaskService getTags addTag removeTag,
   также добавил AlreadyExistsException и исправил сущность Task (tags на EAGER)
8) Добавил два эндпоинта в TaskController и реализовал вычисление времени с обработкой ошибок в TaskService с помощью
   Duration
9) Написал Dockerfile для основного сервера, все переменные окружения задал там же,
   образ собирается, но контейнер не поднимается, так как нет подключения к бд 