# 1. TestNegativeAmountException**

NegativeDepositAmountTest(): Перевіряє, що виняток NegativeAmountException генерується при спробі внести від'ємну суму.
NegativeAmountWithdrawTest(): Тестує, чи генерується NegativeAmountException при спробі зняти від'ємну суму.
NegativeAmountDepositTest(): Забезпечує, що NegativeAmountException генерується при спробі внести від'ємну суму.
NegativeAmountTransferTest(): Перевіряє, що NegativeAmountException генерується під час переказу, якщо сума є від'ємною.

# 2. Тестовий Клас: TestAccountNotFoundException**

searchNotExisingAccount(): Перевіряє, що AccountNotFoundException генерується при спробі знайти неіснуючий рахунок.
sendMoneyToNotExistingAccount(): Забезпечує, що AccountNotFoundException генерується при спробі переказати кошти на неіснуючий рахунок.
sendMoneyFromNotExistingAccount(): Перевіряє, що AccountNotFoundException генерується при спробі переказати кошти з неіснуючого рахунку.

# 3. TestInsufficientFundsException

InsufficientFundsTransfer(): Тестує, чи генерується InsufficientFundsException при спробі переказати більше коштів, ніж доступно на рахунку.
InsufficientFundsWithdraw(): Забезпечує, що InsufficientFundsException генерується при спробі зняти більше коштів, ніж доступно на рахунку.

## Співпраця між Bank і BankAccount
Тести також охоплюють сценарії, де методи Bank і BankAccount використовуються разом, симулюючи взаємодію та обробку помилок у банківській системі.