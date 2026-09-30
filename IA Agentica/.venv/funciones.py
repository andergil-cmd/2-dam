#FUNCIONES

def saludar(nombre = input("Nombre: ")):
    print("Hola {nombre}")

saludar("Jon")

def sumar(a , b ):
    return a + b

sumar(8,10)

def saludo(nombre = "invitado"):
    print(f"Hola {nombre}")

saludo()
saludo("Jon")

def analizar(lista):
    return sum(lista), max(lista), min(lista)
print(analizar(1, 5, 3))

suma, mayor, menor = analizar([1, 5, 3])

print(f"Suma: {suma}")
print(f"Mayor: {mayor}")
print(f"Menor: {menor}")