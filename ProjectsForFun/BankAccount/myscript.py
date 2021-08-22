from bankaccount import BankAccount, MinimalBalanceAccount

konto = BankAccount(500)

amount = 300

accountMin = MinimalBalanceAccount(1500, 1000)

result = accountMin.withdraw(400)

if(result.is_ok()):
    print(result.message)
else:
    print(result.message,"zle")
