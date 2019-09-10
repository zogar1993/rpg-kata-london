package net.jemzart.rpg.core.models.character

class GameCharacter(val name: String, health: Int = 1000, level: Int = 1) {
    fun receiveDamage(amount: Int) {
        health -= amount
    }

    var health = health; private set
    var level = level; private set
}