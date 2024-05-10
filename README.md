# Telegram-бот, отправляющий картинку дня из NASA

### Как запустить
1. Склонировать проект:
```gitexclude
git clone https://github.com/molchmd/nasa-tgbot
```
2. Открыть проект в любой IDEA | *временно*.
3. В пути `src/main/java/ru/molchmd` создать файл `Settings.java` и вписать свои значения. \
Пример `Settings.java`:
```java
package ru.molchmd;

public class Settings {
    public final static String BOT_NAME = "nasaim_bot";
    public final static String TG_TOKEN = "Your TG-Token";
    public final static String NASA_API_KEY = "Your NASA API Key";
    private Settings() {}
}
```
<details><summary>Откуда взять <code>BOT_NAME</code></summary>
В телеграме ищем <i>BotFather</i>, пишем <code>/start</code>. 
По инструкции создаем бота и назначаем ему имя. <br>
Пример: <code>@nasaim_bot</code>
</details>
<details><summary>Откуда взять <code>TG_TOKEN</code></summary>
В телеграме ищем <i>BotFather</i>, пишем <code>/start</code>. 
По инструкции создаем бота и получаем токен.
</details>
<details><summary>Откуда взять <code>NASA_API_KEY</code></summary>
Регестрируемся на сайте NASA, на почту придет <code>API Key</code>.
</details>

4. Запустить через IDEA | *временно*
#### Готово!

### Использование
1. Найти telegram-бота по следующему имени: `BOT_NAME`.
2. Написать `картинка`.
3. Бот пришлет картинку дня.

---

*Release 1*