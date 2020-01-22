#fonction qui donne si un nombre est premier ou pas
#def est_premier(N):
#     p = N//2
#     s =  0
#     for k in range(1,p+1):
#         if N%k==0:
#             s=s+1
#     if s==1:
#        return True
#     else:
#        return False

#programme principale:
def fac(n):
     if (n==0) or (n==1):
          return 1
     else:
          p = 2
          for k in range(3,n+1,1):
               p = p*k
          return p
def est_prime(n):
     if ((fac(n-1))%n+1)%n==0:
          return True
     else:
          return False
liste_factor = list()
for i in range(3,775143,2):
        if est_premier(i)==True:
            print("bien")
            if 600851475143%i == 0:
                print("i=",i)
                liste_factor.append(i)
for element in liste_factor:
     print(element)
#liste_factor_trier = sort(liste_factor)
#print("the largest prime factor is:",liste_factor_trier[-1])
###########################################################

     
     


        
