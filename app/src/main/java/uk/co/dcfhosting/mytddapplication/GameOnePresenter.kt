package uk.co.dcfhosting.mytddapplication

import kotlin.random.Random


class GameOnePresenter {

    fun generateNumber(random: Random) : Int {
        return random.nextInt(1,10)
    }

    fun isSelectedNumberCorrect(selectedNumber: Int, otherNumber: Int): Boolean {
        if(selectedNumber > otherNumber) {
            return true
        }
        return false
    }
}
