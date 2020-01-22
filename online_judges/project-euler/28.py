s = 1 #somme_diagonal
numero_spiral = 1
numero_formant_spiral = 3  # 2*numero_spiral+1
x = 3 #point_pour_au_spiral_suivante
while numero_formant_spiral<=5:
    s = s+4*x+6*2*numero_spiral
    x = x+3*2*numero_spiral+2*(numero_spiral+1)
    numero_spiral = numero_spiral+1
    numero_formant_spiral = 2*numero_spiral+1

print("spiral de:",numero_formant_spiral)
print("la somme :",s)


