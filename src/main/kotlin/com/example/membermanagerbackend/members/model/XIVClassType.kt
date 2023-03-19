package com.example.membermanagerbackend.members.model

import java.lang.IllegalArgumentException

enum class XIVClassType {
    TANK,
    HEALER,
    MELEE,
    MAGICAL,
    RANGED,
    GATHERER,
    CRAFTER,
    RESTRICTED;

    companion object {
        private val TANK_CLASSES: Set<XIVClass> = setOf(XIVClass.PALADIN, XIVClass.WARRIOR, XIVClass.DARK_KNIGHT, XIVClass.GUNBREAKER)
        private val HEALER_CLASSES: Set<XIVClass> = setOf(XIVClass.WHITE_MAGE, XIVClass.SCHOLAR, XIVClass.ASTROLOGIAN, XIVClass.SAGE)
        private val MELEE_CLASSES: Set<XIVClass> = setOf(XIVClass.MONK, XIVClass.DRAGOON, XIVClass.NINJA, XIVClass.SAMURAI, XIVClass.REAPER)
        private val PHYSICAL_RANGED_CLASSES: Set<XIVClass> = setOf(XIVClass.BARD, XIVClass.MACHINIST, XIVClass.DANCER)
        private val MAGICAL_RANGED_CLASSES: Set<XIVClass> = setOf(XIVClass.BLACK_MAGE, XIVClass.SUMMONER, XIVClass.RED_MAGE)
        private val CRAFTER_CLASSES: Set<XIVClass> = setOf(XIVClass.CARPENTER, XIVClass.BLACKSMITH, XIVClass.ARMORER, XIVClass.GOLDSMITH, XIVClass.LEATHERWORKER, XIVClass.WEAVER, XIVClass.ALCHEMIST, XIVClass.CULINARIAN)
        private val GATHERER_CLASSES: Set<XIVClass> = setOf(XIVClass.MINER, XIVClass.BOTANIST, XIVClass.FISHER)

        fun fromXIVClass(xivClass: XIVClass): XIVClassType {
            if (TANK_CLASSES.contains(xivClass)) return TANK
            if (HEALER_CLASSES.contains(xivClass)) return HEALER
            if (MELEE_CLASSES.contains(xivClass)) return MELEE
            if (PHYSICAL_RANGED_CLASSES.contains(xivClass)) return RANGED
            if (MAGICAL_RANGED_CLASSES.contains(xivClass)) return MAGICAL
            if (CRAFTER_CLASSES.contains(xivClass)) return CRAFTER
            if (GATHERER_CLASSES.contains(xivClass)) return GATHERER
            if (xivClass == XIVClass.BLUE_MAGE) return RESTRICTED

            throw IllegalArgumentException("Unknown class type for class: %s".format(xivClass))
        }
    }
}