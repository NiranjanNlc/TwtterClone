package com.example.twtterclone.util

import org.junit.Assert.*

import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `taken  username return false`()
    {
        val result = RegistrationUtil.validateUserNamePassword(
            "niranjannlc",
            "444",
            "5656"
        )
        assert(false) { result }
    }
    @Test
    fun `password not match  return false`()
    {
        val result = RegistrationUtil.validateUserNamePassword(
            "333",
            "444",
            "5656"
        )
        assert(false, { result })
    }
    @Test
    fun `length less than 6 return false `()
    {
        val result = RegistrationUtil.validateUserNamePassword(
            "333",
            "444",
            "4448"
        )
        assert(false, { result })
    }

}