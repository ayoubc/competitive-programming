s=1
p=3
liste_of_primes=[2]
while s<=10001:
     n=len(liste_of_primes)
     i=n
     for k in liste_of_primes:
          if p%k==0:
               i=i-1
               break
     if i==n:
          liste_of_primes=liste_of_primes+[p]
          s=s+1
          p=p+2
     else:
          p=p+2


print("the 10001th prime:",liste_of_primes[10000])
