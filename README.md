# Криптоанализ
## В данном репозитории реализована программа, которая работает с шифром Цезаря.
Шифр Цезаря — это шифр подстановки: в нем каждый символ в открытом тексте заменяется на символ, который находится на некотором постоянном числе позиций левее или правее него в алфавите.
### Режимы работы программы: 
Программа может работать в двух режимах: 
* Шифрование 
* Расшифровка 
  * Расшифровка по ключу
  * Расшифровка методом Brute Force
  * Расшифровка методом Статистический анализ
### Запуск программы:
Программа запускается стандартным образом: запуск статического метода **main**.

После запуска программы, будет выведено консольное меню программы:  
Программа может работать в двух режимах: Шифрование / Расшифровка   
Чтобы выбрать режим Шифрование, введите 1  
Чтобы выбрать режим Расшифровка по ключу, введите 2   
Чтобы выбрать режим Расшифровка Brute Force, введите 3   
Чтобы выбрать режим Расшифровка Статистический анализ, введите 4  

После чего программа попросить ввести:
* ключ *(при необходимости)*
* файл с текстом, который необходимо зашифровать
* файл, в который будет записан результат шифрования / расшифровки
### Информация о программе: 
Структура репозитория:
* каталог alphabets содержит все методы для работы с алфавитом
* каталог decryptions содержит все методы для расшифровки текста
* каталог encryptions содержит все методы для шифрования текста
* каталог handlers содержит все обработчики (алфавитный и файловый обработчик)
* файл ConsoleRunner.java содержит меню программы
* файл Main.java содержит консольный запуск программы 