import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class Class1Test {
    @Test
    fun class1GetName() {
        val class1 = mockk<Class1>(relaxed = true)
        every { class1.getName() }.returns("B")
        val name = class1.getName()
        val score = class1.getScore()
    }
}