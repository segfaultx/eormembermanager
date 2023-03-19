package com.example.membermanagerbackend.members.model

import java.lang.IllegalArgumentException

enum class XIVClass(private val classNames: Set<String>) {
    PALADIN(setOf("Paladin", "Gladiator")),
    WARRIOR(setOf("Warrior", "Marauder")),
    DARK_KNIGHT(setOf("Dark Knight")),
    GUNBREAKER(setOf("Gunbreaker")),
    WHITE_MAGE(setOf("White Mage", "Conjurer")),
    SCHOLAR(setOf("Scholar")),
    ASTROLOGIAN(setOf("Astrologian")),
    SAGE(setOf("Sage")),
    MONK(setOf("Monk", "Pugilist")),
    DRAGOON(setOf("Dragoon", "Lancer")),
    NINJA(setOf("Ninja", "Rogue")),
    SAMURAI(setOf("Samurai")),
    REAPER(setOf("Reaper")),
    BARD(setOf("Bard", "Archer")),
    MACHINIST(setOf("Machinist")),
    DANCER(setOf("Dancer")),
    BLACK_MAGE(setOf("Black Mage", "Thaumaturge")),
    SUMMONER(setOf("Summoner", "Arcanist")),
    RED_MAGE(setOf("Red Mage")),
    BLUE_MAGE(setOf("Blue Mage (Limited Job)")),
    CARPENTER(setOf("Carpenter")),
    BLACKSMITH(setOf("Blacksmith")),
    ARMORER(setOf("Armorer")),
    GOLDSMITH(setOf("Goldsmith")),
    LEATHERWORKER(setOf("Leatherworker")),
    WEAVER(setOf("Weaver")),
    ALCHEMIST(setOf("Alchemist")),
    CULINARIAN(setOf("Culinarian")),
    MINER(setOf("Miner")),
    BOTANIST(setOf("Botanist")),
    FISHER(setOf("Fisher"));

    companion object {
        fun fromString(toConvert: String): XIVClass {
            for (xivClass in values()) {
                if (xivClass.classNames.contains(toConvert)) return xivClass
            }

            throw IllegalArgumentException("Unknown class: %s".format(toConvert))
        }
    }
}