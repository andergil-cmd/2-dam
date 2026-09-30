#MANEJO DE ERRORES

#Try / Except basico

try:
    numero = int(input("Numero: "))
    print("El numero es valido")
except ValueError:
    print("El numero no es valido")

#Varios except

try:
    numero1 = 8
    numero2 = 2
    print(numero1 / numero2)
except ValueError:
    print("No se puede dividir por cero")
except ValueError:
    print("La entrada no es numerica")

#Finally

try:
    numero1 = 8
    numero2 = 2
    print(numero1 / numero2)
except Exception:
    print("Error")
finally:
    print("Fin del programa")

#Raise

def numeroNegativo(x):
    if(x < 0):
       raise IndexError("Error, el numero es negativo")
    return x

print(numeroNegativo(-5))