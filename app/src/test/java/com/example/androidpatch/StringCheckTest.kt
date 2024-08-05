package com.example.androidpatch

import com.example.androidpatch.StringCheck
import org.junit.Assert.assertEquals
import org.junit.Test

class StringCheckTest {
    private val stringUtils = StringCheck()

    @Test
    fun reverseString_simpleString_reversedCorrectly() {
        val result = stringUtils.reverseString("hello")
        assertEquals("olleh", result)
    }

    @Test
    fun isPalindrome_palindrome_returnsTrue() {
        val result = stringUtils.isPalindrome("madam")
        assertEquals(true, result)
    }

    @Test
    fun capitalizeFirstLetter_emptyString_returnsEmptyString() {
        val result = stringUtils.capitalizeFirstLetter("")
        assertEquals("", result)
    }

    @Test
    fun removeWhitespace_returnString() {
        val result = stringUtils.removeWhitespace("test str")
        assertEquals("teststr", result)
    }
}