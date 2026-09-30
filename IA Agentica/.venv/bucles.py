#BUCLES
nombres = ["Jon", "Luis", "Franco"]

for n in nombres:
    print(n)

numeros = [1,2,3,4,5,6,7,8,9,10]

for n in numeros:
    print(n)

suma = 0
n = int(input("Número: "))

while n != 0:
    suma += n
    n = int(input("Número: "))

print(f"suma: {suma}") 

for i in range(1,21):
    if i % 3 == 0:
        continue
    print(i)

for i in range(1,21):
    if i % 7 == 0:
        break
    print(i)