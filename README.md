# final-control-work
# Информация о проекте
Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.

 # Задание
1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).
2. Создать директорию, переместить файл туда.
   <image src="images/img.png" alt="Текст с описанием картинки">
   <image src="images/img_1.png" alt="Текст с описанием картинки">

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.
   <image src="images/img_2.png" alt="Текст с описанием картинки">
   Устанавливаем mysql-server:
   <image src="images/img_3.png" alt="Текст с описанием картинки">
4. Установить и удалить deb-пакет с помощью dpkg.
   <image src="images/img_5.png" alt="Текст с описанием картинки">
   <image src="images/img_6.png" alt="Текст с описанием картинки">
   <image src="images/img_9.png" alt="Текст с описанием картинки">
5. Выложить историю команд в терминале ubuntu
   <image src="images/img_4.png" alt="Текст с описанием картинки">
   <image src="images/img_7.png" alt="Текст с описанием картинки">
   <image src="images/img_8.png" alt="Текст с описанием картинки">
   <image src="images/img_10.png" alt="Текст с описанием картинки">
   <image src="images/img_11.png" alt="Текст с описанием картинки">
6. Нарисовать диаграмму, в которой есть родительский класс, домашние
животные и вьючные животные, в состав класса домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы. Каждый тип животных будет характеризоваться 
(например, имена, даты рождения, выполняемые команды и т.д)
   <image src="images/Flowchart.png" alt="Текст с описанием картинки">
 

7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”
8. Создать таблицы с иерархией из диаграммы в БД
9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
11. Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.

 [Cкрипт 7-12 заданий](sql_file.sql)
  

13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
14. Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:
 * 14.1 Завести новое животное
* 14.2 определять животное в правильный класс
* 14.3 увидеть список команд, которое выполняет животное
* 14.4 обучить животное новым командам
* 14.5 Реализовать навигацию по меню
15. Создать механизм, который позволяет вывести на экран общее количество 
созданных животных любого типа (Как домашних, так и вьючных), то есть при 
создании каждого нового животного счетчик увеличивается на “1” 
    
16. (дополнение к 15)  
    Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
    значение внутренней̆ int переменной̆ на 1 при нажатии “Завести новое
    животное” Сделайте так, чтобы с объектом такого типа можно было работать в
    блоке try-with-resources. Нужно бросить исключение, если работа с объектом
    типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
    считать в ресурсе try, если при заведении животного заполнены все поля. 

    [Исполнительный файл 13-16 заданий](java/gb/RegistryAnimals.java)