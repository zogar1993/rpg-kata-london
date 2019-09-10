package net.jemzart.rpg.core.actions

import net.jemzart.rpg.core.models.character.CharacterDTO
import net.jemzart.rpg.core.models.character.CharacterService
import net.jemzart.rpg.core.models.character.Characters

class GetCharacter(
    private val characters: Characters,
    private val characterService: CharacterService) {
    operator fun invoke(name: String): CharacterDTO {
        val character = characters.search(name)
        return characterService.craftDTO(character)
    }
}