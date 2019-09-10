package net.jemzart.rpgkatalondon.acceptance

import net.jemzart.rpg.core.actions.CreateCharacter
import net.jemzart.rpg.core.actions.GetCharacter
import net.jemzart.rpg.core.infrastructure.character.CharactersInMemory
import net.jemzart.rpg.core.models.character.CharacterService
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test

class ANewlyCreatedCharacterShould {
    @Test
    fun `have default stats`(){
        createCharacter("linuar")

        val character = getCharacter("linuar")
        character.health.shouldEqual(1000)
        character.level.shouldEqual(1)
    }

    private lateinit var getCharacter: GetCharacter
    private lateinit var createCharacter: CreateCharacter
    @Before
    fun setUp(){
        val characters = CharactersInMemory()
        val characterService = CharacterService()
        getCharacter = GetCharacter(characters, characterService)
        createCharacter = CreateCharacter(characters, characterService)
    }
}