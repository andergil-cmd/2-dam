#COLECCIONES

arrayNum = [2, 4 , 6]

arrayNum.append(8)

print(arrayNum)

#Opcion 1 recorriendo la lista
for n in arrayNum:
    print(n)

#Opcion 2: Desempaquetando con separador

print(*arrayNum, sep="\n")

#Opcion 3: Imprimiendo una a una

print(arrayNum[0])
print(arrayNum[1])
print(arrayNum[2])
print(arrayNum[3])

alumno = {
    "nombre": "Ander",
    "edad" : 23,
    "curso" : "2º"
}

print(alumno)

#Clave y valor

for clave, valor in alumno.items():
    print(clave , ":" , valor)


#Solo los valores

for valor in alumno.values():
    print(valor)

#Desempaquetando con separador

print(*alumno, sep = "\n")

#Acceso directo por clave

print("Nombre: " , alumno["nombre"])
print("Edad: " , alumno["edad"])
print("Curso: " , alumno["curso"])

#Version automatica

for clave, valor in alumno.items():
    print(f"{clave.capitalize()}: {valor}")


numerosRepetidos = {1,2,2,3,3,3}

print(numerosRepetidos)

colores = {"rojo", "azul", "azul", "verde", "verde"}

colores.add("amarillo")

print(colores)

#6.4

futbol = {"Jon", "Luis", "Ander"}
baloncesto = {"Aritz", "Cristian", "Ibai"}

print("Ambos: " , futbol & baloncesto)
print("Solo futbol: " , futbol - baloncesto)
print("Al menos uno: " , futbol | baloncesto)

#6.5

lunes = {"Ana", "Luis", "Marta", "Sofía"}
martes = {"Marta", "Carlos", "Ana", "Julia"}

solo_un_dia = lunes ^ martes
print("Solo un dia: " , solo_un_dia)

total_distintos = lunes | martes
print("Total distintos: " , len(total_distintos))

print("Julia vino el lunes? " ,"Julia" in lunes)

# 6.6

numeros = [2, 4 , 6]

cuadrados = [n*n for i in numeros]

print(cuadrados)

for c in cuadrados:
    print(c)

print(*cuadrados, sep="\n")

