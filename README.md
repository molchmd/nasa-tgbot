# Telegram-бот, отправляющий картинку дня из NASA

### Использование
Найдите в telegram бота по следующему имени: `@nasaim_bot`. \
Напишите `картинка` и он ответит url-картинкой.

### Как запустить
Скачайте проект, создайте в пути `src/main/java/ru/molchmd` класс `Settings.java`. \
Пример `Settings.java`:
```java
package ru.molchmd;

public class Settings {
    public final static String TG_TOKEN = "Your TG-Token";
    public final static String NASA_API_KEY = "Your NASA API Key";
    private Settings() {}
}
```
`TG_TOKEN` - регистрируете своего бота и вставляете сюда свой токен. \
`NASA_API_KEY` - регистрируетесь на сайте NASA и вставляете сюда свой `API Key`. \
##### Можно запускать!