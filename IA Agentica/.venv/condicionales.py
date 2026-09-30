#CONDICIONALES

n = int(input("Numero:"))

if n > 0:
    print("positivo")
elif n < 0:
    print("negativo")
else: 
    print("Cero")

numero = int(input("Numero:"))

if numero < 10:
    print("pequeño")
elif numero < 100:
    print("medio")
else:
    print ("grande")

numeroParInpar = int(input("Numero: "))

print("Par" if n % 2 == 0 else "Impar")

palabra = input("Palabra: ")

if palabra.lower() == "python":
    print("La palabra es python")

nombres = ["Jon", "Luis", "Franco"]