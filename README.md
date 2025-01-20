# Proyecto: Modelo de Cuenta Bancaria

Este proyecto consiste en el desarrollo de un programa que modela una cuenta bancaria con sus diferentes tipos, atributos y métodos asociados, según los requisitos establecidos. El sistema está compuesto por una clase base llamada `Cuenta` y dos clases hijas: `CuentaAhorros` y `CuentaCorriente`. Además, se implementan pruebas unitarias para garantizar la cobertura del código.

## Descripción del Proyecto

### Clases Principales

#### 1. **Cuenta (Clase Base)**:
- **Atributos**:
    - `saldo`: Saldo de la cuenta (tipo `float`).
    - `numero_consignaciones`: Número de consignaciones realizadas (inicializado a 0, tipo `int`).
    - `numero_retiros`: Número de retiros realizados (inicializado a 0, tipo `int`).
    - `tasa_anual`: Tasa anual de la cuenta (tipo `float`).
    - `comision_mensual`: Comisión mensual aplicada a la cuenta (inicializado a 0, tipo `float`).

- **Métodos**:
    - `consignar(cantidad)`: Realiza una consignación y actualiza el saldo.
    - `retirar(cantidad)`: Realiza un retiro, asegurándose de que no exceda el saldo.
    - `calcular_interes_mensual()`: Calcula el interés mensual de la cuenta.
    - `extracto_mensual()`: Actualiza el saldo restando la comisión mensual y calculando el interés mensual.
    - `imprimir()`: Devuelve los valores actuales de los atributos.

#### 2. **CuentaAhorros (Clase Hija de Cuenta)**:
- **Atributos**:
    - `activa`: Indica si la cuenta está activa (tipo `bool`).

- **Métodos Redefinidos**:
    - `consignar(cantidad)`: Solo permite consignar si la cuenta está activa.
    - `retirar(cantidad)`: Solo permite retirar si la cuenta está activa.
    - `extracto_mensual()`: Si el número de retiros es mayor a 4, se aplica una comisión adicional de $1000 por cada retiro extra.
    - `imprimir()`: Imprime el saldo, la comisión mensual y el número total de transacciones.

#### 3. **CuentaCorriente (Clase Hija de Cuenta)**:
- **Atributos**:
    - `sobregiro`: Sobregiro de la cuenta (inicializado a 0).

- **Métodos Redefinidos**:
    - `retirar(cantidad)`: Permite retirar más dinero del saldo disponible, generando un sobregiro.
    - `consignar(cantidad)`: Reduce el sobregiro con la consignación realizada.
    - `extracto_mensual()`: Calcula el extracto mensual de acuerdo con las reglas específicas.
    - `imprimir()`: Imprime el saldo, la comisión mensual, el número de transacciones y el valor del sobregiro.

### Diagrama UML

El diagrama UML describe la estructura de clases del proyecto. Puedes ver o descargar el diagrama de clases a través del siguiente enlace:

[Enlace al Diagrama UML (diagrams.net)](https://app.diagrams.net/?src=about#G1wdFbeMQJClLsiEoPic0AgOeqXAj3H5D2#%7B%22pageId%22%3A%22AWppU-QAVICE3YoMNzq4%22%7D)

### Pruebas Unitarias

Las pruebas unitarias están implementadas para asegurar la funcionalidad del programa y garantizar que se cumpla con la cobertura mínima de 70%. El marco de pruebas utilizado es `unittest`, y se verifican las operaciones de consignación, retiro, cálculo de intereses y extractos mensuales.

Las pruebas aseguran que los métodos se comporten correctamente bajo diferentes condiciones y casos límite.

### Instalación

1. Clona este repositorio en tu máquina local:
    ```bash
    git clone https://github.com/FranGarciaga/Cuenta-Bancaria
    ```

2. Navega al directorio del proyecto:
    ```bash
    cd cuenta-bancaria
    ```

3. Ejecuta las pruebas unitarias para verificar que todo esté funcionando correctamente:
    ```bash
    python -m unittest discover
    ```


