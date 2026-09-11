<div align="center">
  <h1>Prueba Práctica de Lógica de Programación</h1>
  <p><strong>Fundamentos de Programación</strong></p>
</div>

---

## 👤 Datos del Estudiante

<table>
  <tr>
    <td><strong>Nombre del Estudiante:</strong></td>
    <td>Leyber Smith Peñafiel Solórzano</td>
  </tr>
  <tr>
    <td><strong>Paralelo:</strong></td>
    <td>B</td>
  </tr>
  <tr>
    <td><strong>Repositorio:</strong></td>
    <td><code>prueba-practica-logica-Leyber-Peñafiel</code></td>
  </tr>
</table>

---

## 📁 Estructura del Repositorio

La organización del proyecto sigue el estándar solicitado:

```text
├── README.md
├── ejercicio-1/
│   └── Ejercicio1.java
├── ejercicio-2/
│   └── Ejercicio2.java
├── evidencia-manual/
│   └── [Evidencias manuscritas / PDF]
└── capturas-ejecucion/
    ├── captura-ejercicio1.png
    └── captura-ejercicio2.png
```

---

## 📝 Descripción de los Ejercicios

### 🔹 Ejercicio 1: Competencia de programación por niveles
* **Descripción:** Determina el nivel y desempeño de un participante en una competencia académica evaluando los puntajes obtenidos en tres retos, penalizaciones por errores y bonificaciones por tiempo y retos extra.
* **Entradas:** 
  * Puntajes numéricos: Reto 1, Reto 2, Reto 3, número de errores y tiempo total en minutos.
  * Respuestas lógicas (`S`/`N`): Desafío extra resuelto y descalificación por copia.
* **Reglas y Proceso:**
  * **Puntaje Base:** Suma de los tres retos.
  * **Penalización:** $-4$ puntos por cada error cometido.
  * **Bonificaciones:** $+15$ puntos si resolvió el desafío extra y $+10$ puntos si el tiempo es menor a 30 minutos.
  * **Puntaje Final:** $\text{Base} - \text{Penalización} + \text{Bonificaciones}$ (limitado a un mínimo de 0).
  * **Nivel:** 0–29 Principiante; 30–49 Básico; 50–69 Intermedio; 70–89 Avanzado; 90 o más Experto.
  * **Condiciones especiales:** Si existió copia, el estado final es **"Descalificado"**. Si el puntaje es alto ($\ge 70$) con demasiados errores ($\ge 5$), se emite la observación: *"Resultado inconsistente: revisar calidad de resolución"*.
* **Salidas:** Puntaje base, penalización, bonificación, puntaje final, nivel asignado y observaciones.

### 🔹 Ejercicio 2: Evaluación de calidad de un proyecto de software
* **Descripción:** Evalúa el resultado final de un proyecto de software considerando el rendimiento técnico del estudiante, penalizaciones por fallos, formalidades de entrega y restricciones de avance.
* **Entradas:** 
  * Notas técnicas (0 a 10): Análisis, diseño y codificación.
  * Porcentaje de avance real (0 a 100) y cantidad de errores detectados.
  * Respuestas lógicas (`S`/`N`): Presentación de documentación completa y realización de exposición final.
* **Reglas y Proceso:**
  * **Promedio Técnico:** Media aritmética simple de las tres notas.
  * **Ajustes:** $-0.5$ puntos por error detectado, $+0.5$ por documentación completa y $+0.5$ por exposición final.
  * **Nota Final:** Limitada estrictamente dentro del intervalo $[0.00, 10.00]$.
  * **Estado:** 9.00 a 10.00 Excelente; 7.00 a 8.99 Aprobado; 5.00 a 6.99 Recuperación; menor a 5.00 Reprobado.
  * **Condiciones especiales:** Si el avance real es menor al 60%, la calificación máxima permitida se degrada a **Aprobado** (no puede ser Excelente). Si la nota final es $\ge 7$ sin documentación entregada, se genera la observación: *"Buen producto, pero mala formalidad"*.
* **Salidas:** Promedio técnico, detalle de ajustes aplicados, nota final, estado y observación.

---

## 🚀 Instrucciones para Compilar y Ejecutar

Los programas fueron desarrollados en **Java** bajo el entorno de **Visual Studio Code**.

### 🛠️ Requisitos Previos
* Tener instalado el **Java Development Kit (JDK 17 o superior)**.
* Terminal de comandos (PowerShell, Bash o CMD) posicionada en la raíz del repositorio.

---

### 💻 Ejercicio 1

1. **Compilar:**
   ```bash
   javac ejercicio-1/Ejercicio1.java
   ```
2. **Ejecutar:**
   ```bash
   java -cp ejercicio-1 Ejercicio1
   ```

---

### 💻 Ejercicio 2

1. **Compilar:**
   ```bash
   javac ejercicio-2/Ejercicio2.java
   ```
2. **Ejecutar:**
   ```bash
   java -cp ejercicio-2 Ejercicio2
   ```
