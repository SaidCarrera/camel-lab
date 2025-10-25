# Taller 1 - Integración por transferencia de archivos con Apache Camel

**Universidad de las Américas (UDLA)**  
**Materia:** Integración de Sistemas Web  
**Proyecto:** camel-lab  
**Lenguaje:** Java 21  
**Framework:** Apache Camel 4.10.4  
**Build Tool:** Maven  

---

## Descripción del Proyecto

Este taller implementa una integración básica **por transferencia de archivos** utilizando **Apache Camel**.  
El flujo desarrollado permite **leer archivos CSV desde un directorio de entrada**, **transformar su contenido**, y luego **moverlos a un directorio de salida y de archivado**, demostrando el funcionamiento de un proceso de integración ETL (Extract, Transform, Load).

---

## Estructura del Proyecto

<img width="694" height="225" alt="image" src="https://github.com/user-attachments/assets/20967561-2a8d-4966-87b6-6a82ea87b47a" />

---

## Ejecución del Proyecto

### Compilar el proyecto

```bash
cd ~/camel-lab/camel-lab
mvn clean compile

## Ejecutar la aplicación Camel
mvn exec:java -Dexec.mainClass=edu.udla.isw.App

## Logs esperados en la terminal
Durante la ejecución, Camel mostrará mensajes similares a:
[edu.udla.isw.App.main()] INFO org.apache.camel.main.MainSupport - Apache Camel (Main) 4.10.4 is starting
[Camel (camel-1) thread #2 - file://input] INFO route1 - Procesando archivo: ventas.csv
[Camel (camel-1) thread #2 - file://input] INFO route1 - Archivo ventas.csv transformado y movido a output.
[2025-10-24 22:16:36] Archivo ventas.csv procesado y archivado correctamente.

## Flujo de Integración Camel

El flujo principal definido en App.java sigue esta lógica:
	1.	Lectura: Apache Camel monitorea la carpeta input/ en busca de archivos .csv.
	2.	Procesamiento: El contenido de cada archivo se transforma a mayúsculas.
	3.	Salida: El archivo transformado se guarda en la carpeta output/.
	4.	Archivado: El archivo original se mueve a la carpeta archived/.
	5.	Log: Se imprime en consola el resultado del proceso.
