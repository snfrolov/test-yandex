## Предварительные настройки

**1. Проверить,что установлена Java 8**

**2. Необходимо установить следующие плагины для Intellij IDEA:**

* Cucumber for Java
* Gherkin
* Lombok

**3. Настроить плагин Lombok:**

* в разделе *Build, Execution, Deployment -> Compiler -> Annotation Processors* требуется поставить галочку *Enable annotation processing*
* в разделе *Other settings -> Lombok plugin* требуется поставить галочку *Enable lombok plugin for this project*

**4. Скачать webdriver нужной версии**

Важно, чтобы версия драйвера соответствовала версии браузера.
Узнать о том, какая версия нужна тебе для браузера Chrome, и скачать ее можно с ресурса https://sites.google.com/a/chromium.org/chromedriver/downloads

**5. Прописать путь в переменную PATH до папки с драйверами**

В зависимости от ОС выполни
```
  echo %PATH%
  или
  echo $PATH
```

 Для *Windows* выполни в папке, где сохранен драйвер, команду:
```
    setx PATH "%PATH%;%CD%"
 ```

 Для *Linux* и *Mac OS*  просто скачай драйверы для Chrome или Safari и пропиши путь до папки при необходимости:
 ```
  > gedit .bash_profile
  > PATH = /usr/local/bin/drivers:$PATH
  > source .bash_profile
 ```

#### Запуск тестов
Скачанный проект с тестами нужно открыть как gradle-проект, далее ты можешь запускать тесты одним
из удобных тебе способов
* gradle задачи:  **Clean**, **Test**, **GenerateCucumberReport**
* контекстное меню для конкретного feature-файла, где следует не забывать про установку VM Properties.
  -Dbrowser=chrome
* из терминала
 ```
   > gradlew clean test -i
   > gradlew clean generateCucumberReport --debug
   > gradlew clean test -Pbrowser=chrome -Pprofile=local -PremoteHub=http://remote/wd/hub
   > gradlew clean test -Dbrowser=chrome -Ptag=@test
  ```

  Для проектов предусмотрен параллельный запуск всех feature-файлов (для каждого feature-файла создается свой runner), запуск тестов на удаленной машине (-PremoteHub), смена бразера (-Pbrowser=chrome), запуск тестов согласно выставленным на сценариях тегам (-Ptag).
   
### Отчет о тестировании
   Akita позволяет генерировать красивые отчеты о прошедщем тестировании.
   Генерация отчета осуществляется запуском команды
   ```
   gradlew generateCucumberReport        или gradlew gCR
   ```

Отчет создается в папке  **build/reports**.  Основным является файл **"overview-features.html"**.