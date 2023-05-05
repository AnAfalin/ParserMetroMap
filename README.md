# Parser Metro Map

### Описание
Основное назначение приложение - сбор информации из разных источников и сохранение собранной и преобразованной информации в собственный файл.

### Технические особенности
+ Парсинг веб-страницы (https://skillbox-java.github.io/).
+ Парсинг csv файлов с дополнительной информацией о станциях.
+ Обработка собранной информации.
+ Запись в файл с json-расширением.

### Особенности
+ С веб-страницы приложение получает следующую информацию о станциях:
    + имя и номер линии московского метро
    + имя станции и номер линии, на которой она находится
+ С найденных csv файлов приложение сохраняет следующую дополнительную информацию:
    + название станции
    + название линии
    + дата открытия в формате "dd.mm.yyyy"
    + глубина залегания станции 
    + имеет ли станция переход на другие ветки
+ Считанная информация сохраняется в объекты, которые записываются в файл с json-расширением.

### Технологии
+ OpenJDK 17 
+ Jsoup Java HTML Parser (1.15.3) - для работы с HTML страницами
+ Jackson Core (2.13.4) - для работы c json файлами
+ Apache Commons CSV (1.9.0) - для чтения и записи csv файлов