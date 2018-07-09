#language:ru

Функционал: Проверка Яндекс.почты

  Предыстория:
    Пусть совершен переход на страницу "Яндекс" по ссылке из property файла "yandexMainPage"
    Когда выполнено нажатие на кнопку "Войти"
    И в поле "Логин" введено значение "login"
    И в поле "Пароль" введено значение "password"
    И выполнено нажатие на кнопку "Войти в почту"
    Тогда страница "Яндекс.Почта" загрузилась

  Сценарий: Отправка письма с темой
    Когда выполнено нажатие на кнопку "Написать"
    Тогда форма "Создание письма" загрузилась
    Когда выполнено нажатие на кнопку "Себе"
    И в поле "Тема" введено 5 случайных символов на кириллице
    И в поле "Текст письма" введено 10 случайных символов на латинице
    Тогда поле "Кому" содержит значение "t357t357"
    Когда выполнено нажатие на кнопку "Отправить"
    Тогда элемент "Уведомление" отображается на странице
    И выполнено ожидание в течение 1 секунды
    И элемент "Уведомление" содержит внутренний текст "Письмо отправлено"
    Когда страница "Яндекс.Почта" загрузилась
    И выполнено нажатие на кнопку "Входящие"