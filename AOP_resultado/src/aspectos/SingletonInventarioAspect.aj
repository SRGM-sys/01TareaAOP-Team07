package aspectos;

import gestion.Inventario;

/**
 * Sección C - Patrón Singleton implementado con AOP.
 * Intercepta cualquier instanciación de Inventario y garantiza una única instancia global.
 */
public aspect SingletonInventarioAspect {

    // Única instancia almacenada dentro del aspecto
    private Inventario instancia = null;

    // Pointcut: captura cualquier llamada al constructor de Inventario fuera de este aspecto
    pointcut llamadaConstructorInventario(): 
        call(public Inventario.new(..)) && !within(SingletonInventarioAspect);

    // Advice Around: controla si se ejecuta el constructor real o se devuelve la instancia existente
    Inventario around(): llamadaConstructorInventario() {
        synchronized (this) {
            if (instancia == null) {
                instancia = proceed(); // Ejecuta new Inventario() solo la primera vez
            }
            return instancia;
        }
    }
}
