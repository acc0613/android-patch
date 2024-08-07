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
    fun capitalizeFirstLetter_emptyString_returnsString() {
        val result = stringUtils.capitalizeFirstLetter("abcd")
        assertEquals("Abcd", result)
    }

    @Test
    fun countVowels_returnVowelsCount() {
        val result = stringUtils.countVowels("abcd")
        assertEquals(1, result)
    }

    @Test
    fun removeWhitespace_returnString() {
        val result = stringUtils.removeWhitespace("test str")
        assertEquals("testastr", result)
    }

    @Test
    fun removeWhitespace1_returnString() {
        val result = stringUtils.removeWhitespace1("test str")
        assertEquals("teststr", result)
    }
}