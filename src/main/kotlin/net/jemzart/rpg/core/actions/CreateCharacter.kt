package net.jemzart.rpg.core.actions

import net.jemzart.rpg.core.models.character.CharacterService
import net.jemzart.rpg.core.models.character.Characters

class CreateCharacter(
    private val characters: Characters,
    private val characterService: CharacterService) {
    operator fun invoke(name: String) {
        val character = characterService.newCharacter(name)
        characters.put(character)
    }
}