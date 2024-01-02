# 1. testAddToCartSufficientStock:

Цей тест перевіряє, чи метод addToCart класу User додає продукт до кошика користувача з необхідною кількістю товару, якщо товару на складі достатньо.


# 2. testAddToCartInsufficientStock:

 Цей тест перевіряє, чи метод addToCart класу User генерує виняток OutOfStockException, якщо товару на складі недостатньо для заданої кількості.


# 3. testRemoveFromCartExistingProduct:

Цей тест перевіряє, чи метод removeFromCart класу User правильно видаляє продукт із кошика користувача, якщо він там присутній.


# 4. testRemoveFromCartNonExistingProduct:

Цей тест перевіряє, чи метод removeFromCart класу User коректно відпрацьовує, якщо користувач намагається видалити продукт із кошика, якого там немає.


# 5. testCreateOrder:

Цей тест перевіряє, чи метод createOrder класу ECommercePlatform правильно формує замовлення, зменшуючи залишок товару на складі та очищаючи кошик користувача.


# 6. testUpdateProductStock:

Цей тест перевіряє, чи метод updateProductStock класу ECommercePlatform правильно оновлює залишок товару на складі для заданого продукту.


# 7. testUpdateProductStockNegativeQuantity:

Цей тест перевіряє, чи метод updateProductStock генерує виняток IllegalArgumentException та не змінює залишок товару на складі, якщо передана від'ємна кількість.


# 8. testUpdateProductStockNonExistingProduct:

Цей тест перевіряє, чи метод updateProductStock генерує виняток IllegalArgumentException, якщо намагається оновити залишок для неіснуючого продукту.