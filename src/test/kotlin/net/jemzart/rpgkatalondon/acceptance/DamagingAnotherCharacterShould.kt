package net.jemzart.rpgkatalondon.acceptance

import net.jemzart.rpg.core.actions.CreateCharacter
import net.jemzart.rpg.core.actions.DealDamageFromOneCharacterToAnother
import net.jemzart.rpg.core.actions.GetCharacter
import net.jemzart.rpg.core.infrastructure.character.CharactersInMemory
import net.jemzart.rpg.core.models.character.CharacterService
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test

class DamagingAnotherCharacterShould {
    @Test
    fun `lower his health by a fixed amount`(){
        createCharacter("linuar")
        createCharacter("carrie")

        dealDamageFromOneCharacterToAnother("linuar", "carrie", 200)

        val target = getCharacter("carrie")
        target.health.shouldEqual(800)
    }

    private lateinit var getCharacter: GetCharacter
    private lateinit var dealDamageFromOneCharacterToAnother: DealDamageFromOneCharacterToAnother
    private lateinit var createCharacter: CreateCharacter
    @Before
    fun setUp(){
        val characters = CharactersInMemory()
        val characterService = CharacterService()
        getCharacter = GetCharacter(characters, characterService)
        createCharacter = CreateCharacter(characters, characterService)
        dealDamageFromOneCharacterToAnother = DealDamageFromOneCharacterToAnother(characters, characterService)
    }
}