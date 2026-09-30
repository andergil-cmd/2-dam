#EJERCICIOS AVANZADOS

#A1. Validacion Robusta

"""
while True:
    try:
        numero = int(input("Numero: "))
        break
    except ValueError:
        print("Error, introduce de nuevo")

print("Correcto: ", numero)

#A2. Estadisticas de una lista

numeros = []

while True:
        fin = input("Numero (Fin para terminar:)")

        if fin == "fin":
            break
        numeros.append(float(fin))

print("Media: " , sum(numeros) / len(numeros))
print("Maximo: ", max(numeros))
print("Minimo: ", min(numeros))

#A3. Diccionario dinamico

personas = {}

while True:
     nombre = input("Nombre (Fin para terminar)")

     if nombre == "fin":
          break
     edad = int(input("Edad: "))
     personas[nombre] = edad

print(personas)

#A4. Mini-agente reactivo

def decidir(temp):
     if temp < 18:
          return "Encender la calefaccion"
     elif temp > 24:
          return "Apagar la calefaccion"
     else:
          return "Mantener la calefaccion"

print(decidir(20));

#A5. Normalizacion del texto
import string

print(string.punctuation)

frase = input("Frase: ")

frase = frase.strip().lower()

for p in string.punctuation:
         frase = frase.replace(p, "")

frase = " ".join(frase.split())

print(frase)

#A6. Frecuencia de palabras

frase = input("FRASE: ").lower()

palabras = frase.split()

frecuencias = {}

for p in palabras:
     frecuencias[p] = frecuencias.get(p, 0) + 1

print(frecuencias)

#A7. Filtrar datos

numeros = {3,6,9,12,15,18,21,1,24}

resultado = [n for n in numeros if n %2 == 0 and n >10]

print(resultado)

#A8. Simulacion de sensores

import random

lecturas = [random.uniform(15,30) for _ in range(20)]

media = sum(lecturas) / len(lecturas)

mayores = [t for t in lecturas if t > media]

print("Media: ", media)
print("Lecturas por encima: ", mayores)

#A9. Validacion de menu

while True:
     try:
          opcion = int(input("Elige opcion(1-3): "))
          if opcion in (1,2,3):
               break
          else:
               print("Opcion invalida")
     except ValueError:
          print("Debes introducir un numero")
print("Has elegido la opcion: " ,opcion)


#A10. Diccionario por comprension

celsius = [0,10,20,25,30]

fahrenheit = {c: (c * 9/5) + 32 for c in celsius}

print(fahrenheit)

#A11. Deteccion de picos

numeros = [1,3,2,4,5,7,6]
picos = []

for i in range(1, len(numeros) - 1):
     if numeros[i] > numeros[i - 1] and numeros[i] > numeros[i + 1]:
          picos.append(numeros[i])

print("Picos: " , picos)


#A12. Mini-agente de clasificacion

import random

def clasificacion(numero):
     if numero < 20:
         return "bajo"
     elif numero <= 50:
         return "medio"
     else:
         return "alto"

numeros = [random.randint(0, 100) for _ in range(10)]

clasificados = [(numero, clasificacion(numero)) for numero in numeros]

print(clasificados)

for numero, categoria in clasificados:
     print(f"Numero: {numero} -> Clasificacion: {categoria}")

for numero, categoria in sorted(clasificados):
     print(f"Numero: {numero} -> Clasificacion: {categoria}")


#A13. Limpieza de datos numericos

entrada = input("Valores separados por comas: ")

valores = entrada.split(",")

limpios = []

for v in valores:
    try:
          limpios.append(float(v.strip()))
    except ValueError:
          pass

print("Valores limpios: ", limpios)


#A14. Deteccion de tendencias con all()

numeros = [10,9,8,7,6,5,4,3,2,1]

creciente = all(numeros[i] < numeros[i+1] for i in range(len(numeros) - 1))
decreciente = all(numeros[i] > numeros[i+1] for i in range(len(numeros) - 1))

if creciente:
    print("La secuencia es creciente")
elif decreciente:
    print("La secuencia es decreciente")
else:
    print("La secuencia no es ni creciente ni decreciente")

#A14b. 

numeros = [1,2,3,4,5,6,7,8,9,10]

#all 
print("¿Son todos los numeros positivos? ", all(n > 0 for n in numeros))
#any
print("¿Hay alguno mayor que 10? ", any(n > 10 for n in numeros))

#pares y cuanto suman

print("Cantidad de números pares:", sum(n % 2 == 0 for n in numeros))
print("Suma de numeros pares: ", sum(n for n in numeros if n % 2 == 0))

#max() y min()

print("¿Cual es el maximo? ", max(numeros))
print("¿Cual es el minimo? ", min(numeros))

#ordenado

print("Lista ordenada: ", sorted(numeros))

#cuadrados

print("¿Cuales son sus cuadrados? ", [x**2 for x in numeros])

#mayores que 5

print("Mayores que 5: ", [x for x in numeros if x > 5])

#recorrer la lista

for i in range(len(numeros)):
     print(f"Posicion: {i} - datos: {numeros[i]}")

#A15. Notas de alumnos

notas = [8,4,6,1,10,7]

#aprobada todas(all())

print("Todas aprobadas: ", all(nota >= 5 for nota in notas))

#suspendidas(any())

print("Suspendidas: ", any(nota < 5 for nota in notas))

#aprobadas(sum())

print("¿Cuantas tiene aprobadas? ", sum(nota >= 5 for nota in notas))

#mejor(max()) y peor(min()) nota

print("Mejor nota: ", max(notas))
print("Peor nota: ", min(notas))

#notas ordenadas(sorted())

print("Notas ordenadas: ", sorted(notas))

#solo suspensas

print("Suspensas", sum(nota for nota in notas if nota < 5))

#asignaturas

asignaturas = ["IA Agentica", "PSP", "Acceso a datos", "SI", "DI", "Moviles"]

for n in range(len(notas)):
    print(f"{asignaturas} : {notas}")

#A16. Clasificador por reglas multiples

import random

def clasificador(numero):
    if numero < 10:
        return "muy bajo"
    elif numero <= 19:
        return "bajo"
    elif numero <= 49:
        return "medio"
    elif numero <= 79:
        return "alto"
    elif numero > 80:
        return "muy alto"

numeros = [random.randint(0, 100) for _ in range(15)]
ordenados = sorted((n, clasificador(n)) for n in numeros)

print("Numero | Clasificacion")
print("-----------------------")
for n, categoria in ordenados:
    print(f"{n:6} | {categoria}")

#A16. Valores extremos con percentiles

numeros = [12, 15, 7, 30, 22, 5, 100, 105, 3, 18, 25]

ordenados = sorted(numeros)

p10 = int(len(ordenados) * 0.1)
p90 = int(len(ordenados) * 0.9)

percentil10 = ordenados[p10]
percentil90 = ordenados[p90]

extremos_bajos = [x for x in numeros if x < percentil10]
extremos_altos = [x for x in numeros if x > percentil90]


print("Datos ordenados: ", ordenados)
print("Percentil 10: ", percentil10)
print("Percentil 90: ", percentil90)
print("Extremos bajos: ",extremos_bajos)
print("Extremos altos: ", extremos_altos)

"""

#A18. Mini-parser de comandos

entrada = input("Comando: ")
partes = entrada.split()

try:
    # Mover esto dentro del try protege tu programa de elementos faltantes
    op = partes[0]
    a = float(partes[1])
    b = float(partes[2])

    if op == "sumar":
        print(a + b)
    elif op == "restar":
        print(a - b)
    elif op == "multiplicar":
        print(a * b) 
    else:
        print("Comando no reconocido")

# Evita que el programa falle si faltan los números (ej. escribir solo "multiplicar")
except IndexError:
    print("Error: Formato incorrecto. Debes escribir: comando número1 número2 (Ej: multiplicar 5 4)")

# Evita que el programa falle si escriben letras en vez de números (ej. "multiplicar casa 4")
except ValueError:
    print("Error: Los argumentos después del comando deben ser números.")








