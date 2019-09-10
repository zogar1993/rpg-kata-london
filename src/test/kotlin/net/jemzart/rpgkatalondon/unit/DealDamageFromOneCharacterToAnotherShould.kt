package net.jemzart.rpgkatalondon.unit

import io.mockk.*
import net.jemzart.rpg.core.actions.DealDamageFromOneCharacterToAnother
import net.jemzart.rpg.core.models.character.CharacterService
import net.jemzart.rpg.core.models.character.Characters
import net.jemzart.rpg.core.models.character.GameCharacter
import org.junit.Before
import org.junit.Test

class DealDamageFromOneCharacterToAnotherShould {
    @Test
    fun `persist the new character retrieved from the character service`(){
        every { characters.search(ATTACKER_NAME) } returns ATTACKER
        every { characters.search(TARGET_NAME) } returns TARGET
        every { characterService.dealDamage(ATTACKER, TARGET, DAMAGE_AMOUNT) } returns Unit

        dealDamageFromOneCharacterToAnother(ATTACKER_NAME, TARGET_NAME, DAMAGE_AMOUNT)

        verifyOrder {
            characterService.dealDamage(ATTACKER, TARGET, DAMAGE_AMOUNT)
            characters.put(TARGET)
        }
    }

    val DAMAGE_AMOUNT = 200
    val ATTACKER_NAME = "linuar"
    val TARGET_NAME = "carrie"
    val ATTACKER = GameCharacter(ATTACKER_NAME)
    val TARGET = GameCharacter(TARGET_NAME)
    private lateinit var characters: Characters
    private lateinit var characterService: CharacterService
    private lateinit var dealDamageFromOneCharacterToAnother: DealDamageFromOneCharacterToAnother
    @Before
    fun setUp(){
        characters = mockk(relaxed = true)
        characterService = spyk(CharacterService())
        dealDamageFromOneCharacterToAnother = DealDamageFromOneCharacterToAnother(characters, characterService)
    }
}