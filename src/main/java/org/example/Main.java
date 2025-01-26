package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("2.1.1 ");
        /*
        2.1.1 Запретная Дробь. Измените сущность Дробь, полученную в задаче 1.6.4.
        Гарантируйте, что невозможно создать такой подвид дроби, который позволял
        бы создавать Дроби с изменяемым состоянием.
         */
        System.out.println("----------------");

        System.out.println("2.1.2 ");
        /*
        2.1.2 Замкнутая ломаная. Создайте такой подвид сущности Ломанная, полученной в задаче 1.5.7, которая
        будет представлять собой замкнутую ломанную линию, то есть последовательность точек,
        начинающихся и заканчивающихся на одной и той же точке (см. рисунок 2.9).
        Данная сущность во всех отношениях совпадает с обычной Ломаной, кроме расчета длины
        (по очевидным причинам).
         */
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(1, 1),
                new Point(0, 1)
        };

        Polyline polyline = new Polyline(points);
        System.out.println("Обычная ломаная: " + polyline);
        System.out.println("Длина обычной ломаной: " + polyline.getLength());

        ClosedPolyline closedPolyline = new ClosedPolyline(points);
        System.out.println("Замкнутая ломаная: " + closedPolyline);
        System.out.println("Длина замкнутой ломаной: " + closedPolyline.getLength());
        System.out.println("----------------");

        System.out.println("2.1.3");
        /*
        2.1.3 Двусторонняя дорога. Создайте такой подвид сущности Город,
        полученной в задаче 1.6.9, которая будет гарантировать, что при добавлении
        дороги из одного города в другой, одновременно будет добавляться и обратная дорога.
         */
        BidirectionalCity cityA = new BidirectionalCity("Город A");
        BidirectionalCity cityB = new BidirectionalCity("Город B");
        cityA.addRoute(cityB, 10);
        System.out.println(cityA);
        System.out.println(cityB);
        System.out.println("----------------");

        System.out.println("2.1.4");
        /*
        2.1.4 Автомат. Создайте такой подвид сущности Пистолет из задачи 1.6.5, которая будет
        совпадать с ней во всех отношениях, кроме следующего:
        • Имеет скорострельность (целое число, неизменяемое) которое обозначает количество
        выстрелов в секунду, поддерживаемое данным автоматом. Скорострельность всегда положительное число.
        • При вызове Стрелять количество выстрелов соответствует скорострельности (например,
        при скорострельности 3 выводится три строки с текстом выстрела).
        • Умеет Стрелять N секунд, что приводит к количеству выстрелов равному N умноженное на скорострельность.
        • Инициализация может быть выполнены следующими способами:
        a. Без параметров. Скорострельность 30, вместимость 30.
        b. С указанием максимального числа патронов. Скорострельность будет равна половине обоймы
        c. С указанием максимального количества патронов в обойме и скорострельности.
         */
        AutomaticGun automaticGun = new AutomaticGun(30, 10);
        automaticGun.reload(20);
        System.out.println("Стреляем один раз:");
        automaticGun.shoot();
        System.out.println("\nСтреляем 2 секунды:");
        automaticGun.shootForSeconds(2);
        System.out.println("\nАвтомат заряжен? " + automaticGun.isLoaded());
        System.out.println("----------------");

        System.out.println("2.1.5");
        /*
        2.1.5 Трехмерная точка. Создайте такой подвид сущности Точка из задачи 1.4.1,
        которая будет иметь не две, а три координаты на плоскости: X,Y,Z. Гарантируйте,
        что у Точки не может быть других наследников, кроме созданного в этой задаче класса.
         */
        Point3D point3D = new Point3D(1, 2, 3);
        System.out.println("Трёхмерная точка: " + point3D.getTextRepresentation());
        System.out.println("X: " + point3D.getX());
        System.out.println("Y: " + point3D.getY());
        System.out.println("Z: " + point3D.getZ());
        System.out.println("----------------");

        /*
        2.2.1 Оружие. Измените сущность Пистолет, полученную в задаче
        1.6.5 таким образом, чтобы она наследовалась от класса Weapon описанного на рисунке 2.10.
         */
        System.out.println("2.2.1 ");
        Gun pistol = new Gun(10);
        System.out.println("Пистолет заряжен? " + pistol.isLoaded());
        pistol.shoot();
        System.out.println("Патронов: " + pistol.ammo());

        int excess = pistol.reload(15);
        System.out.println("Лишние патроны: " + excess);
        System.out.println("Патронов: " + pistol.ammo());

        pistol.shoot();
        System.out.println("Патронов: " + pistol.ammo());

        int unloaded = pistol.unload();
        System.out.println("Извлечено патронов: " + unloaded);
        System.out.println("Патронов: " + pistol.ammo());
        System.out.println("----------------");

         /*
        2.2.2 Дробь — это число. Измените сущность Дробь, полученную в задаче 1.6.4. Дробь
        должна быть подтипом класса Number. Данный класс входит в стандартную редакцию языка Java.
          */
        System.out.println("2.2.2 ");
        Fraction fraction = new Fraction(3, 4);

        System.out.println("Дробь: " + fraction);
        System.out.println("intValue: " + fraction.intValue());
        System.out.println("longValue: " + fraction.longValue());
        System.out.println("floatValue: " + fraction.floatValue());
        System.out.println("doubleValue: " + fraction.doubleValue());

        Fraction sum = fraction.add(new Fraction(1, 2));
        System.out.println("Сумма: " + sum);
        System.out.println("----------------");

         /*
        2.2.3 Птицы. Создайте сущность Птица, которая будет являться корнем иерархии для всех, кто является подвидом птицы. В разработанную сущность необходимо вынести все, что будет общим для птиц. Для того чтобы определить необходимые члены класса, проанализируйте три примера птиц:
        • Воробей. Умеет петь. При пении на экран выводится строка “чирик”.
        • Кукушка. Умеет петь. При пении на экран выводится текст “ку-ку”, причем текст выводится случайное количество раз в диапазоне от 1 до 10.
        • Попугай. Имеет текст и умеет петь этот текст. При инициализации обязательно необходимо указать текст, который будет исполняться. При пении текст выводится не весь, а первые N символов (не менее одного и не более всех символов текста), где N определяется случайно.
        Вместе с Птицей реализуйте также Воробья, Кукушку и Попугая.
          */
        System.out.println("2.2.3 ");
        Bird sparrow = new Sparrow();
        Bird cuckoo = new Cuckoo();
        Bird Kesha = new Parrot("Прилетаю я на Таити...А вы не были на Таити?");

        System.out.println("Воробей поёт:");
        sparrow.sing();
        System.out.println("\nКукушка поёт:");
        cuckoo.sing();
        System.out.println("\nПопугай поёт:");
        Kesha.sing();
        System.out.println("----------------");

         /*
    2.2.4. Необходимо продумать структуру и организацию следующих геометрических фигур:
        1. Круг.
        2. Квадрат.
        3. Прямоугольник.
        4. Треугольник.
    Все фигуры должны быть встроены в иерархию. Корень иерархии должен определять общее для
    всех классов поведение и структуру. У каждой фигуры должна быть возможность рассчитать её площадь.
    Продумайте структуру всех необходимых классов и реализуйте её.
    Класс для квадрата из задачи 1.6.3 использовать не рекомендуется
          */
        System.out.println("2.2.4 ");
        Shape circle = new Circle(5);
        Shape square = new Square(4);
        Shape rectangle = new Rectangle(6, 3);
        Shape triangle = new Triangle(4, 5);

        System.out.println("Площадь круга: " + circle.calculateArea());
        System.out.println("Площадь квадрата: " + square.calculateArea());
        System.out.println("Площадь прямоугольника: " + rectangle.calculateArea());
        System.out.println("Площадь треугольника: " + triangle.calculateArea());
        System.out.println("----------------");

        System.out.println("2.2.5");
        /*
        2.2.5 Точки. Необходимо разработать сущности, которые позволят создавать
        Точки координат с разными характеристиками. Например, мы можем иметь точки координат
        со следующими характеристиками:
    • Одна, две или три координаты в пространстве (X,Y,Z: целые числа)
    • Цвет точки (строка)
    • Размер точки (число)
    Обратите внимание, что эти характеристики не составляют исчерпывающий список (так как в будущем могут появиться новые характеристики) и могут составлять любые комбинации, например:
    • Точка в координате 3, красного цвета
    • Точка в координате {4,2,5} размером 20
    • Точка в координате {7,7} желтого цвета, с красным ободком в форме котенка.
    С целью совместимости с последующими задачами, сохраните Двухмерную и Трёхмерную точки из задачи 2.1.5 без изменений.
          */
        Point point = new Point(3, 4);
        System.out.println(point.getDescription());
        // точка с координатами (1, 2, 3)
        Point3D point_3D = new Point3D(1, 2, 3);
        System.out.println(point_3D.getDescription());
        // точка с координатами (5, 6) и цветом "красный"
        ColoredPoint coloredPoint = new ColoredPoint(new Point(5, 6), "красный");
        System.out.println(coloredPoint.getDescription());
        // точка с координатами (7, 8, 9), размером 20
        SizedPoint sizedPoint = new SizedPoint(new Point3D(7, 8, 9), 20);
        System.out.println(sizedPoint.getDescription());
        // точка с координатами (10, 11), цветом "желтый" и размером 15
        ColoredPoint coloredSizedPoint = new ColoredPoint(new SizedPoint(new Point(10, 11), 15), "желтый");
        System.out.println(coloredSizedPoint.getDescription());
        System.out.println("----------------");

        /*
        2.3.1 Сложение. Разработайте метод, который принимает набор числовых значений и возвращает их сумму в вещественной форме. С использованием данного метода выполните следующие сложения:
        • (сложение значений, относящихся к типам Integer, Дробь (2.2.2), Double)
        • (сложение значений типов Double, Дробь (2.2.2), Integer, Дробь)
        • (сложение значений, относящихся к типам Дробь (2.2.2), Integer)
          */
        System.out.println("2.3.1 ");
        double result1 = MathUtils.sum(2, new Fraction(3, 5), 2.3);
        System.out.println("Результат 1: " + result1);
        //  3.6 + 49/12 + 3 + 3/2
        double result2 = MathUtils.sum(3.6, new Fraction(49, 12), 3, new Fraction(3, 2));
        System.out.println("Результат 2: " + result2);
        // 1/3 + 1
        double result3 = MathUtils.sum(new Fraction(1, 3), 1);
        System.out.println("Результат 3: " + result3);
        System.out.println("----------------");

        /*
        2.3.2 Птичий рынок. Разработайте метод, который принимает набор птиц из задачи 2.2.3 и
        вызывает метод пения у каждой из них.
        Продемонстрируйте работоспособность метода, передав в него несколько воробьев,
        кукушек и попугаев.
          */
        System.out.println("2.3.2 ");
        Bird sparrow1 = new Sparrow();
        Bird sparrow2 = new Sparrow();
        Bird cuckooKesha = new Cuckoo();
        Bird parrot1 = new Parrot("Привет, я попугай!");
        Bird parrot2 = new Parrot("Кто тут?");
        BirdMarket.makeBirdsSing(sparrow1, sparrow2, cuckooKesha, parrot1, parrot2);
        System.out.println("----------------");

        /*
        2.3.3 Общая площадь. Разработайте метод, который принимает набор фигур из
        задачи 2.2.4 и считает их общую площадь (без учета возможного перекрытия фигурами
        друг друга). Продемонстрируйте работоспособность метода, передав туда несколько
        кругов и квадратов.
          */
        System.out.println("2.3.3");
        Shape circle2 = new Circle(5);
        Shape square2 = new Square(4);
        Shape rectangle2 = new Rectangle(6, 3);
        Shape triangle2 = new Triangle(4, 5);

        double totalArea = ShapeUtils.calculateTotalArea(circle2, square2, rectangle2, triangle2);
        System.out.println("Общая площадь: " + totalArea);
        System.out.println("----------------");

         /*
        2.3.4 Мяуканье. Разработайте метод, который принимает набор объектов способных мяукать
        и вызывает мяуканье у каждого объекта. Мяукающие объекты должны иметь метод со следующей
        сигнатурой:
public void meow();
Дополните решение задачи 1.5.2 (Кот) так, чтобы иметь возможность передать Кота в написанный
вами метод и протестируйте работоспособность решения передав в него нескольких котов,
а также создайте любой другой произвольный класс и передайте в написанный метод его объекты.
          */
        System.out.println("2.3.4 ");
        Cat barsik = new Cat("Барсик");
        barsik.meow();
        barsik.meow(3);
        Cat murzik = new Cat("Мурзик");
        TeslaCat teslaMeow = new TeslaCat("TeslaCat-ModelX");
        MeowUtil.makeThemMeow(List.of(barsik, murzik, teslaMeow));
        System.out.println("----------------");

         /*
        2.3.5 Измерение длины. Разработайте метод, который принимает набор объектов у которых
        можно посчитать длину, и возвращает сумму длин принятых объектов. Измените сущности
        полученные в задачах 1.5.7 (Ломаная линия) и 1.6.6 (Линия) таким образом, что бы их можно
        было передать в этот метод. Продемонстрируйте работоспособность метода на примерах.
          */
        System.out.println("2.3.5 ");
        Line line1 = new Line(new Point(1, 1), new Point(4, 5));
        Line line2 = new Line(1, 1, 4, 5);
        line1.setStart(2, 2);
        line2.setEnd(6, 6);

        Polyline polyline3 = new Polyline(new Point[]{
                new Point(0, 0),
                new Point(3, 4),
                new Point(6, 8)
        });

        System.out.println("Ломаная: " + polyline3);
        System.out.println("Длина ломаной: " + polyline3.getLength());
        double totalLength = LengthCalculator.calculateTotalLength(List.of(line1, line2, polyline3));
        System.out.println("Общая длина всех объектов: " + totalLength);
        System.out.println("----------------");

           /*
        2.3.6 Замкнутый квадрат. Измените сущность Квадрат из задачи
        1.6.3 таким образом что бы она возвращала не обычную ломаную линию,
        а замкнутую ломаную линию из задачи 2.1.2. При этом сигнатура метода,
        возвращающую Ломаную, должна остаться без изменений.
          */
        System.out.println("2.3.6 ");
        Square square7 = new Square(5);
        Polyline polyline7 = square7.toPolyline();
        System.out.println("Замкнутая ломаная квадрата: " + polyline7);
        System.out.println("Длина замкнутой ломаной квадрата: " + polyline7.getLength());
        System.out.println("----------------");

   /*
        2.3.7 Поломки. Разработайте метод, который принимает такой набор объектов,
         у которых можно получить ломаную линию, и возвращает их объединение в виде
          одного объекта типа Ломаная. Передаваемые в метод объекты должны обладать
          методом со следующей сигнатурой:
public Polyline getPolyline();
В описанной сигнатуре PolygonalChain это название класса разработанного в задаче 1.5.7.
Таким образом, сущность Квадрат из задачи 2.3.6 должна подходить
для передачи в разрабатываемый метод.
          */
        System.out.println("2.3.7 ");
        Square square9 = new Square(5);
        Square square8 = new Square(3);
        List<HasPolyline> shapes = List.of(square9, square8);
        Polyline mergedPolyline = PolylineMerger.mergePolylines(shapes);

        System.out.println("Объединённая ломаная: " + mergedPolyline);
        System.out.println("Длина объединённой ломаной: " + mergedPolyline.getLength());
        System.out.println("----------------");

         /*
        2.3.8 Лучший стрелок. Создайте сущность Стрелок, которая описывается:
Имя, строка
Оружие, из задачи 2.2.1.
При создании объекта необходимо указать ему имя
Имя и оружие можно поменять и получить в любой момент без ограничения.
Основная способность Стрелка - умение стрелять. Если оружие есть, то выстрел происходит по правилам оружия, если его нет – то выводится текст “не могу участвовать в перестрелке”.
Создайте трех стрелков: одного без оружия, одного с пистолетом и одного с автоматом, и пусть каждый из них выстрелит.

          */
        System.out.println("2.3.8 ");
        Shooter shooter1 = new Shooter("без оружия");
        Shooter shooter2 = new Shooter("с пистолетом", new Gun(10));
        Shooter shooter3 = new Shooter("с автоматом", new AutomaticGun(30, 3));
        shooter1.shoot();
        shooter2.shoot();
        shooter3.shoot();
        System.out.println("----------------");


         /*
        2.3.9 Правильные оценки. Внесите изменения в класс Студент (задача 1.6.8).
Ранее было поставлено требование, что оценки студента должны быть только в диапазоне от 2 до 5. Для повышения гибкости класса замените это требование на возможность во время создания объекта Студента указывать требования на корректность оценки. Таким образом, новые требования включают:
Убрать проверку оценок на диапазон от 2 до 5
Добавить возможность в конструкторе указать правило проверки оценки на корректность
Если в конструкторе не указано правило – то все оценки считаются допустимыми.
Создайте двух студентов со следующими характеристиками:
Вася, у которого в качестве оценок либо 1, либо 0
Петя, у которого в качестве оценки может быть любое четное число

          */
        System.out.println("2.3.9 ");
        Student vasya = new Student("Вася", grade -> grade == 1 || grade == 0);
        vasya.addGrade(1);
        vasya.addGrade(0);
        System.out.println(vasya);
        try {
            vasya.addGrade(2);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        Student petya = new Student("Петя", grade -> grade % 2 == 0);
        petya.addGrade(2);
        petya.addGrade(4);
        System.out.println(petya);
        try {
            petya.addGrade(3);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        Student ivan = new Student("Иван");
        ivan.addGrade(3);
        ivan.addGrade(5);
        System.out.println(ivan);
        System.out.println("----------------");
    }
}