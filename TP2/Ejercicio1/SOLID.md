# 1. Design principles and Design Patterns.

### El Principio Abierto-Cerrado (Open-Closed Principle).
El principio de apertura y cierre exige que **las clases deban estar abiertas a la extensión y cerradas a la modificación**.  
Esto significa que deberíamos poder agregar nuevas funcionalidades a nuestro código sin modificar el código existente, evitando así posibles errores al alterar comportamientos previos.

En este ejemplo, si quisiéramos agregar más figuras geométricas como un triángulo o un cuadrado, tendríamos que modificar el método ```calculateArea``` para manejar estos nuevos tipos, lo que **rompe** el principio de abierto/cerrado, 
ya que estamos modificando el código existente en lugar de extenderlo. 
```
public class AreaCalculator {
    // Rompe el Open-Closed Principle
    public double calculateArea(Object shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * Math.pow(circle.getRadius(), 2);
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.getWidth() * rectangle.getHeight();
        }
        return 0;
    }
}

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
```

Para resolver este problema siguiendo el principio **Open-Closed Principle** utilizamos polimorfismo, creando una interfaz común para todas las figuras geométricas. 
De esta manera, cuando queramos agregar una nueva figura, solo necesitamos extender la clase sin modificar el código existente.
```
// Interfaz Figura.
public interface Figure {
    double calculateArea();
}

// Círculo.
public class Circle implements Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

// Rectangulo.
public class Rectangle implements Figure {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

// Ahora AreaCalculator no necesita conocer figuras específicas
class AreaCalculator {
    public double calculateArea(Figure figure) {
        return figure.calculateArea();
    }
}
```

### El Principio de segregación de interfaz (Interface Segregation Principle)
Este principio establece que **los clientes no deben depender de interfaces que no utilizan**. En otras palabras, es mejor tener interfaces pequeñas y específicas, en lugar de una interfaz grande que obligue a los clientes a implementar métodos que no les interesan.
En este ejemplo, el ```RobotWorker``` está obligado a implementar el método ```eat```, aunque no tiene sentido para un robot. Esto viola el principio de segregación de interfaces, ya que la interfaz ```Worker``` no está adecuadamente dividida y obliga al ```Robot``` a implementar un método innecesario.
```
public interface Worker {
    void work();
    void eat();
}

public class Human implements Worker {
    @Override
    public void work() {
        System.out.println("Human working...");
    }

    @Override
    public void eat() {
        System.out.println("Human eating...");
    }
}

public class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Robot working...");
    }

    // El robot no come, pero se ve obligado a implementar el método de comer
    @Override
    public void eat() {
        throw new UnsupportedOperationException("Robots do not eat");
    }
}
```

Para solucionar este problema, podemos **segregar la interfaz** en dos interfaces más pequeñas y específicas: ```Workable``` y ```Eatable```.
```
public interface Workable {
    void work();
}

public interface Eatable {
    void eat();
}

public class Human implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Human working...");
    }

    @Override
    public void eat() {
        System.out.println("Human eating...");
    }
}

public class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Robot working...");
    }
    // No es necesario implementar el método eat, porque los robots no comen.
}
```
