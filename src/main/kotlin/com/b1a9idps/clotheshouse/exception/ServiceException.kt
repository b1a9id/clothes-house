package com.b1a9idps.clotheshouse.exception

open class ServiceException : RuntimeException {
    constructor() : super()
    constructor(message : String) : super(message)
    constructor(throwable: Throwable) : super(throwable)
    constructor(message: String, throwable: Throwable) : super(message, throwable)
}
