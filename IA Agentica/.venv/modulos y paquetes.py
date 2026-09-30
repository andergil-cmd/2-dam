#MODULOS Y PAQUETES

#Import basico

import random


print(random.randint(1,10))

#Alias
import math as m

print(m.sqrt(25))

#Import selectivo

from math import pi, sin

print(pi, sin(pi/2))

#Modulo propio

import util

print(util.doble(5))