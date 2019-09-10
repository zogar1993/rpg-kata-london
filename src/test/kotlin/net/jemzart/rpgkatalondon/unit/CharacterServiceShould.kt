package net.jemzart.rpgkatalondon.unit

import net.jemzart.rpg.core.models.character.CharacterService
import net.jemzart.rpg.core.models.character.GameCharacter
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test

class CharacterServiceShould {
    @Test
    fun `return a lvl 1 character with 1000 health when asked for a new character`(){
        val character = characterService.newCharacter(NAME)

        character.name.shouldBe(NAME)
        character.level.shouldEqual(1)
        character.health.shouldEqual(1000)
    }

    @Test
    fun `a dto crafted from a character domain model retains its name, level and health`(){
        val model = GameCharacter(NAME)
        val dto = characterService.craftDTO(model)

        model.name.shouldBe(dto.name)
        model.level.shouldEqual(dto.level)
        model.health.shouldEqual(dto.health)
    }

    @Test
    fun `lower the health of the target by the designated amount when it is dealt damage`(){
        val attacker = GameCharacter("linuar")
        val target = GameCharacter("carrie")
        characterService.dealDamage(attacker, target, 200)

        target.health.shouldEqual(800)
    }

    val NAME = "linuar"
    private lateinit var characterService: CharacterService
    @Before
    fun setUp(){
        characterService = CharacterService()
    }
}