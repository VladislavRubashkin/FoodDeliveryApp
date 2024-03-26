package com.example.fooddeliveryapp.domain

/**
 * Базовый класс ошибки, приложения.
 */
open class AppException : RuntimeException {
    constructor() : super()
    constructor(message: String) : super(message)
    constructor(cause: Throwable) : super(cause)
}

/**
 * Ошибка обращения к элементам View когда/уже их не существует.
 */
class BindingException(
    val exception: String
): AppException()

/**
 * Ошибка ввода пустых полей, при входе в аккаунт.
 */
class EmptyFieldException(
    val field: Field
) : AppException()

/**
 * Ошибка, несовпадения паролей при регистрации.
 */
class PasswordMismatchException : AppException()

/**
 * Ошибка, 'Аккаунт уже существует', при регистрации.
 */
class AccountAlreadyExistsException(cause: Throwable) : AppException(cause = cause)

// todo 1
/**
 *  account has been deleted = session expired = AuthException
 */
class AuthException(cause: Throwable) : AppException(cause = cause)

class InvalidCredentialsException(cause: Exception) : AppException(cause = cause)

class ConnectionException(cause: Throwable) : AppException(cause = cause)

open class BackendException(val code: Int, message: String) : AppException(message)

class ParseBackendResponseException(cause: Throwable) : AppException(cause = cause)

/**
 * Обёртка backend для ошибок.
 */
//internal suspend fun <T> wrapBackendExceptions(block: suspend () -> T): T {
//    try {
//      return block.invoke()
//    } catch (e: BackendException) {
//        if(e.code == 401) {
//            throw AuthException(e)
//        } else {
//            throw e
//        }
//    }
//}