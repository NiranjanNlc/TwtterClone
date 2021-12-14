package com.example.twtterclone.util

object RegistrationUtil
{

    private val existingUser = listOf("niranjannlc","sushmitaslc")

    /*
    * username is not already taken
    * password and confirmpasword matches
    * username and password not less than 6 digit
    * */
    fun validateUserNamePassword( username: String,
                                  passeword: String,
                                  confirmedPassword: String) :Boolean
    {
        if(username.length<6 ||
            username.length<6 ||
            username in existingUser ||
            !passeword.equals(confirmedPassword))
        {
            return false
        }
        else
        {
            return true

        }
    }
}