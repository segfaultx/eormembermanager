package com.example.membermanagerbackend.validation

import jakarta.validation.ValidationException
import jakarta.validation.Validator
import org.springframework.stereotype.Service

@Service
class MembersValidator(private val validator: Validator) {

    @Throws(ValidationException::class)
    fun <T> validate(toValidate: T) {
        val validationResult = validator.validate(toValidate)

        if (validationResult.isNotEmpty()) throw ValidationException(validationResult.toString())
    }
}