package net.jemzart.rpgkatalondon.unit

import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import net.jemzart.rpg.core.models.character.CharacterDTO
import net.jemzart.rpg.core.actions.CreateCharacter
import net.jemzart.rpg.core.models.character.GameCharacter
import net.jemzart.rpg.core.actions.GetCharacter
import net.jemzart.rpg.core.models.character.CharacterService
import net.jemzart.rpg.core.models.character.Characters
import org.amshove.kluent.shouldBe
import org.junit.Before
import org.junit.Test

class GetCharacterShould {
    @Test
    fun `return a dto crafted from the character domain model`(){
        every { characters.search(NAME) } returns CHARACTER_MODEL
        every { characterService.craftDTO(CHARACTER_MODEL) } returns CHARACTER_DTO

        val character = getCharacter(NAME)

        verify { characterService.craftDTO(CHARACTER_MODEL) }
        character.shouldBe(CHARACTER_DTO)
    }

    val NAME = "linuar"
    val CHARACTER_MODEL = GameCharacter(NAME)
    val CHARACTER_DTO = CharacterDTO(CHARACTER_MODEL.name, CHARACTER_MODEL.health, CHARACTER_MODEL.level)
    private lateinit var characters: Characters
    private lateinit var characterService: CharacterService
    private lateinit var getCharacter: GetCharacter
    @Before
    fun setUp(){
        characters = mockk(relaxed = true)
        characterService = spyk(CharacterService())
        getCharacter = GetCharacter(characters, characterService)
    }
}