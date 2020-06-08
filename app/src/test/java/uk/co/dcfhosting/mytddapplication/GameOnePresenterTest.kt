package uk.co.dcfhosting.mytddapplication

import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import kotlin.random.Random


class GameOnePresenterTest {

 @Test
 fun checkANumberIsGenerated() {

     //arrange
     val mockRandom: Random = mock(Random::class.java)
     `when`(mockRandom.nextInt(1,10)).thenReturn(1)
     val gameOnePresenter = GameOnePresenter();

     //act
     val number = gameOnePresenter.generateNumber(mockRandom)
     println("randomNum1 ${number}")
     //assert
     Assert.assertEquals(1, number)
 }

   @Test
    fun checkFirstNumberGeneratedIsDifferentToSecondNumber() {
        val mockRandom = mock(Random::class.java)
       `when`(mockRandom.nextInt(1,10)).thenReturn(5).thenReturn(9)

        val gameOnePresenter = GameOnePresenter()
        val num1 = gameOnePresenter.generateNumber(mockRandom)
        val num2 = gameOnePresenter.generateNumber(mockRandom)
        println("randomNum1 ${num1}")
        println("randomNum2 ${num2}")
        Assert.assertTrue(num1 != num2)
    }

    @Test
    fun checkIfSelectedNumberIsCorrect(){

        //arrange
        val gameOnePresenter = GameOnePresenter();
        val selectedNumber = 5;
        val otherNumber = 3;

        //act
        val isSelectedNumberCorrect = gameOnePresenter.isSelectedNumberCorrect(selectedNumber, otherNumber)

        //assert
        Assert.assertTrue(isSelectedNumberCorrect)
    }

    @Test
    fun checkIfSelectedNumberIsIncorrect() {
        //arrange
        val gameOnePresenter = GameOnePresenter();
        val selectedNumber = 2
        val otherNumber = 8

        //act
        val isSelectedNumberCorrect = gameOnePresenter.isSelectedNumberCorrect(selectedNumber, otherNumber)

        //assert
        Assert.assertFalse(isSelectedNumberCorrect)
    }
}