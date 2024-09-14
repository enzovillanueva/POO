
# 1. Design principles and Design Patterns.
El patrón de diseño **Dependency Injection** (DI) es una técnica para gestionar las dependencias entre objetos en un sistema de manera 
que se desacoplen las clases y se mejore la flexibilidad, la mantenibilidad y la capacidad de prueba del código.
## Concepto Básico.
En lugar de que una clase cree o busque sus propias dependencias (por ejemplo, otras clases o servicios que necesita para funcionar), el patrón de **Dependency Injection** permite que 
estas dependencias sean proporcionadas o "inyectadas" desde el exterior. Esto se hace típicamente a través de:
* **Inyección de constructor**: Las dependencias se pasan al objeto a través de su constructor.
* **Inyección de Setter**: Las dependencias se establecen a través de métodos setter públicos después de que el objeto ha sido creado.
* **Inyección de Interfaz**: Las dependencias se proporcionan a través de métodos definidos en una interfaz que el objeto implementa.

Ejemplo: Supongamos que tenemos una clase ```Service``` que depende de una clase ```Repository```. 
```
public class Repository {
    // Implementación de Repository...
}
```
Sin **Dependency Injection**, ```Service``` podría crear una instancia de Repository internamente:
```
public class Service {
    private Repository repository;

    public Service() {
        this.repository = new Repository(); // Dependencia creada internamente
    }

    // Métodos de Service...
}
```
Con **Dependency Injection**, la Repository se pasa al Service a través:
* **Inyección de constructor**
```
public class Service {
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository; // Dependencia inyectada
    }

    // Métodos de Service...
}
```
* **Inyección de Setter**
```
public class Service {
    private Repository repository;

    // Constructor vacío
    public Service() {
    }

    // Setter para la inyección de la dependencia
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    // Métodos de Service que utilizan repository...
}
```
* **Inyección de Interfaz**
```
public interface RepositorySetter {
    void setRepository(Repository repository);
}

public class Service implements RepositorySetter {
    private Repository repository;

    // Implementación del método de la interfaz
    @Override
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    // Métodos de Service que utilizan repository...
}
```

## ¿Cuál es la diferencia entre Dependency Inversion y Dependency Injection?

**Dependency Inversion** y **Dependency Injection** son conceptos relacionados, pero tienen significados y propósitos diferentes en el contexto del diseño de software. 
Aquí te explico las diferencias clave:
### Dependency Inversion
1. Los módulos de alto nivel no deben depender de los módulos de bajo nivel. Ambos deben depender de abstracciones.
2. Las abstracciones no deben depender de los detalles. Los detalles deben depender de las abstracciones.

Su objetivo es reducir el acoplamiento entre módulos de alto y bajo nivel, promoviendo el uso de interfaces y abstracciones para que los cambios en las implementaciones no afecten a las partes del sistema que dependen de ellas.
Se centra en la estructura del código y en cómo las clases interactúan entre sí a través de abstracciones.

En este ejemplo, ```Service``` no depende directamente de una implementación concreta de ```Repository```, sino de la abstracción ```Repository```. Esto cumple con el principio de inversión de dependencias.
```
// Abstracción
public interface Repository {
    void saveData(String data);
}

// Implementación concreta
public class FileRepository implements Repository {
    @Override
    public void saveData(String data) {
        // Guardar datos en un archivo
    }
}

// Clase de alto nivel que depende de la abstracción
public class Service {
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public void processData(String data) {
        repository.saveData(data);
    }
}
```
### Diferencias claves.
* **Dependency Inversion (DIP)**: Es un principio de diseño que se enfoca en las relaciones entre módulos de alto y bajo nivel, sugiriendo que ambos deben depender de abstracciones. DIP define cómo deberían ser las relaciones entre diferentes módulos para lograr un diseño desacoplado.
* **Dependency Injection (DI)**: Es un patrón que implementa la idea de DIP proporcionando un mecanismo práctico para inyectar las dependencias en un objeto desde el exterior. DI se centra en cómo las dependencias se pasan a un objeto, facilitando la implementación del principio de inversión de dependencias en la práctica.