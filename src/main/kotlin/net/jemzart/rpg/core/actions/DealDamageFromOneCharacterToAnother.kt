package net.jemzart.rpg.core.actions

import net.jemzart.rpg.core.models.character.CharacterService
import net.jemzart.rpg.core.models.character.Characters

class DealDamageFromOneCharacterToAnother(
    private val characters: Characters,
    private val characterService: CharacterService) {
    operator fun invoke(attackerName: String, targetName: String, amount: Int) {
        val attacker = characters.search(attackerName)
        val target = characters.search(targetName)

        characterService.dealDamage(attacker, target, amount)

        characters.put(target)
    }
}