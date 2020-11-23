# Моделирование получения баланса на банкомате
##  Основные объекты: клиент, банкомат, карта
##  Основной сценарий:
1. Клиент вставляет в банкомат карту.
1. Банкомат считывает карту.
1. Банкомат проверяет дату, до которой она действительна. Карта действительна.
1. Банкомат проверяет блокировку карты. Карта не заблокирована.
1. Клиент вводит пин-код. 
1. Банкомат проверяет пин-код. Пин-код корректный.
1. Банкомат отображает меню действий с картой.
1. Клиент выбирает пункт меню "Получить баланс".
1. Клиент выбирает валюту для получения баланса.
1. Банкомат отправляет в базу банка запрос на получение баланса с параметрами "номер карты", "валюта".
1. Банкомат получает ответ из банка с суммой баланса.
1. Банкомат выводит баланс на экран.
1. Клиент выбирает пункт меню "Вернуть карту"
1. Банкомат возвращает карту.