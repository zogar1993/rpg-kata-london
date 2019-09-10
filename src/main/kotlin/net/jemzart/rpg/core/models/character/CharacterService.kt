package net.jemzart.rpg.core.models.character

class CharacterService {
    fun newCharacter(name: String): GameCharacter {
        return GameCharacter(name)
    }

    fun craftDTO(character: GameCharacter): CharacterDTO {
        return CharacterDTO(character.name, character.health, character.level)
    }

    fun dealDamage(attacker: GameCharacter, target: GameCharacter, damageAmount: Int) {
        target.receiveDamage(damageAmount)
    }
}