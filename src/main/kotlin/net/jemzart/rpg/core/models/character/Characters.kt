package net.jemzart.rpg.core.models.character

interface Characters {
    fun put(character: GameCharacter)
    fun search(name: String): GameCharacter
}