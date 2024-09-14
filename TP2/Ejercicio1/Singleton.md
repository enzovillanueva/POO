# 1. Design principles and Design Patterns.

### ¿Por qué se puede considerar que no cumple con el principio de Single Responsibility?
El patrón **Singleton** puede considerarse que no cumple completamente con el principio de **Single Responsibility** (SRP) del principio SOLID debido a las siguientes razones:
1. **Responsabilidad de Controlar la Instancia Única y Lógica de Negocio**: El patrón **Singleton** no solo se encarga de garantizar que una clase tenga una única instancia, sino que a menudo también incluye lógica de negocio. Esto significa que la clase está asumiendo dos responsabilidades: gestionar la instancia y realizar operaciones específicas.
2. **Dificultad en la Prueba y Mantenimiento**: Al tener una única instancia global, las pruebas unitarias se complican, ya que las pruebas pueden depender del estado de esa instancia única. Esto puede llevar a efectos secundarios y a una falta de aislamiento en las pruebas.
3. **Cambio de Estado Global**: Al ser una instancia única, cualquier cambio en el estado de un **Singleton** afecta a todos los que utilizan esa instancia, lo que puede llevar a comportamientos inesperados y a una dificultad en el seguimiento de la lógica del programa.
4. **Responsabilidad de Inicialización**: A menudo, los **Singletons** manejan su propia inicialización, lo que significa que están asumiendo la responsabilidad de su ciclo de vida, en lugar de delegar esa responsabilidad a otra clase.

### ¿Por qué se considera que dificulta realizar tests de unidad?
El patrón **Singleton** se considera que dificulta la realización de pruebas unitarias por varias razones:
1. **Estado Global Compartido**: Dado que un **Singleton** tiene una única instancia compartida en toda la aplicación, cualquier cambio en su estado afectará a todas las pruebas que dependen de esa instancia. Esto puede llevar a resultados inconsistentes y difíciles de rastrear en las pruebas.
2. **Acoplamiento Fuerte**: Las clases que dependen de un **Singleton** están fuertemente acopladas a él, lo que dificulta la inyección de dependencias y la creación de mocks o stubs para pruebas. Esto limita la flexibilidad y la capacidad de probar diferentes comportamientos.
3. **Imposibilidad de Reiniciar el Estado**: Una vez que se ha modificado el estado de un **Singleton** durante una prueba, es difícil restablecerlo para otras pruebas. Esto puede llevar a que las pruebas fallen de manera intermitente, dependiendo del orden en que se ejecuten.