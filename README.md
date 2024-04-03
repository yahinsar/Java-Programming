# Задание 2
 
## Подзадание 1

Выбрать объект из реального мира и реализовать его в виде класса (ООП). У него будут поля (хранимые состояния) и методы (регулирующие поведение объекта).

Класс реализует интерфейсы (прилагательные, которыми можно описать объект) и от него наследуются классы, расширяющие поведение объекта.

Т.е. сделать свой класс, который расширяет другой класс, в котором реализуется один из интерфейсов.

Пример:

```
interface 2DFigure {getPerimeter(); getSquare();}

abstract class AbstractFigure {abstract String getNameOfFigure();}

class Line extends AbstractFigure implements 2DFigure
class Circle extends AbstractFigure implements 2DFigure
class Triangle extends AbstractFigure implements 2DFigure
class Rectangle extends AbstractFigure implements 2DFigure
```

## Подзадание 2 

В своем классе реализовать методы equals(), hashCode(), compareTo(), toString(), поверхностной и глубокой копии. Разобраться, зачем они нужны.

## Подзадание 3

Продемонстрировать работу полиморфизма на реализованных классах. В примере классы Line, Circle, Rectangle, Triangle должны реализовать методы getPerimeter() и getSquare() для подсчета периметра и площади соответственно. 

Соответственно, если сложить их в контейнер List<2DFigure> list и для каждого элемента figure вызвать figure.getPerimeter() и figure.getSquare(), получатся разные результаты.

