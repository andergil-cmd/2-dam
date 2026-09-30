# INTRODUCCION

print("Hola Python")

x = 5
if x > 0:
    print("Positivo")


x = int(x)
y = 7

resultado = x + y 

print(resultado)

nombre = "Ander"


#VARIABLES Y TIPOS BASICOS

#Este programa imprime tu nombre
#Lo imprimimos con print
print(nombre)

x = 10
print(type(x))

y = "Ander"
print(type(y))

numero = input("Introduce un numero: ")

print(int(numero))
print(float(numero))

nombre = input("Introduce un nombre: ")
edad = int(input("Introduce la edad: "))

print(f"Hola {nombre} , este año tienes {edad} años")

numeroRaiz = float(input("Numero: "))

print(numeroRaiz**2, numeroRaiz**3, math.sqrt(numeroRaiz))