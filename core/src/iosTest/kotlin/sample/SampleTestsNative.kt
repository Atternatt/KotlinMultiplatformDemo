package sample

import com.m2f.IMDB.core.hello
import kotlin.test.Test
import kotlin.test.assertTrue

class SampleTestsNative {
    @Test
    fun testHello() {
        assertTrue("iOS" in hello())
    }
}