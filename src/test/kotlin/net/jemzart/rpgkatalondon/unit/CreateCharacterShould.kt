package net.jemzart.rpgkatalondon.unit

import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import net.jemzart.rpg.core.actions.CreateCharacter
import net.jemzart.rpg.core.models.character.GameCharacter
import net.jemzart.rpg.core.models.character.CharacterService
import net.jemzart.rpg.core.models.character.Characters
import org.junit.Before
import org.junit.Test

class CreateCharacterShould {
    @Test
    fun `persist the new character retrieved from the character service`(){
        every { characterService.newCharacter(NAME) } returns DUMMY_CHARACTER

        createCharacter(NAME)

        verify { characters.put(DUMMY_CHARACTER) }
    }

    val NAME = "linuar"
    val DUMMY_CHARACTER = GameCharacter(NAME)
    private lateinit var characters: Characters
    private lateinit var characterService: CharacterService
    private lateinit var createCharacter: CreateCharacter
    @Before
    fun setUp(){
        characters = mockk(relaxed = true)
        characterService = spyk(CharacterService())
        createCharacter = CreateCharacter(characters, characterService)
    }
}