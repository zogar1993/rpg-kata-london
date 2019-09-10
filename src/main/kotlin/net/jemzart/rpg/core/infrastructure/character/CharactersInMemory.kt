package net.jemzart.rpg.core.infrastructure.character

import net.jemzart.rpg.core.models.character.GameCharacter
import net.jemzart.rpg.core.models.character.Characters

class CharactersInMemory : Characters {
    private val characters = mutableMapOf<String, Map<String, Int>>()

    override fun search(name: String): GameCharacter {
        val entity = characters.getValue(name)
        return GameCharacter(name, entity.getValue("health"), entity.getValue("level"))
    }

    override fun put(character: GameCharacter) {
        characters[character.name] = mapOf("health" to character.health, "level" to character.level)
    }
}