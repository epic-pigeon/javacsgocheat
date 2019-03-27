/*
 *    Copyright 2016 Jonathan Beaudoin
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.xena.cs


/**
 * Created by Jonathan on 7/24/2016.
 */
enum class Weapons(val id: Int, val skin: Int = -1, val weaponName: String = "hz", val canShoot: Boolean = true, val customSkin: Boolean = (skin != -1)) {
	
	DESERT_EAGLE(1, CRIMSON_WEB, "Desert Eagle"),
	FIVE_SEVEN(3, MONKEY_BUSINESS, "Five-Seven"),
	GLOCK(4, FADE, "Glock"),
	CZ75A(63, CRIMSON_WEB, "CZ-75A"),
	DUAL_BERRETA(2, URBAN_SHOCK, "Dual Beretta"),
	P2000(32, IMPERIAL_DRAGON, "P2000"),
	P250(36, ASIIMOV_2, "p250"),
	R8_REVOLVER(6, REBOOT, "R8 Revolver"),
	TEC9(30, AVALANCHE, "TEC-9"),
	USP_SILENCER(61, KILL_CONFIRMED, "USP-S"),
	
	AK47(7, FRONTSIDE_MISTY, "AK-47"),
	AUG(8, AKIHABARA_ACCEPT, "AUG"),
	AWP(9, DRAGON_LORE, "AWP"),
	FAMAS(10, AFTERIMAGE, "Famas"),
	M4A1_SILENCER(60, MECHA_INDUSTRIES, "M4A1-S"),
	M4A4(16, HOWL, "M4A4"),
	SSG08(40, DETOUR, "SSG08"),
	
	
	PP_BIZON(26, JUDGEMENT_OF_ANUBIS, "PP-Bizon"),
	P90(19, DEATH_BY_KITTY, "P90"),
	UMP45(24, PRIMAL_SABER, "UMP-45"),
	
	G3SG1(11, -1, "G3SG1"),
	GALIL(13, -1, "Galil"),
	M249(14, -1, "M249"),
	MAC10(17, -1, "MAC-10"),
	XM1014(25, -1, "XM1014"),
	MAG7(27, -1, "MAG-7"),
	NEGEV(28, -1, "Negev"),
	SAWED_OFF(29, -1, "Sawed-Off"),
	ZEUS_X27(31, -1, "Zeus", false),
	MP7(33, -1, "MP7"),
	MP9(34, -1, "MP9"),
	NOVA(35, -1, "Nova"),
	SCAR20(38, -1, "SCAR20"),
	SG556(39, -1, "SSG556"),
	KNIFE(42, -1, "Knife", false),
	FLASH_GRENADE(43, -1, "Flashbang", false),
	EXPLOSIVE_GRENADE(44, -1, "HE grenage", false),
	SMOKE_GRENADE(45, -1, "Smoke grenade", false),
	MOLOTOV(46, -1, "Molotov", false),
	DECOY_GRENADE(47, -1, "Decoy", false),
	INCENDIARY_GRENADE(48, -1, "Incendiary", false),
	C4(49, -1, "C4", false),
	KNIFE_T(59, MARBLE_FADE, "T knife", false),
	KNIFE_CT(41, MARBLE_FADE, "CT knife", false),
	KNIFE_BAYONET(500, -1, "Bayonet", false),
	KNIFE_FLIP(505, canShoot = false),
	KNIFE_GUT(506, canShoot = false),
	KNIFE_KARAMBIT(507, MARBLE_FADE, canShoot = false),
	KNIFE_M9_BAYONET(508, MARBLE_FADE, canShoot = false),
	KNIFE_TACTICAL(509, canShoot = false),
	KNIFE_TALCHION(512, canShoot = false),
	KNIFE_BOWIE(514, canShoot = false),
	KNIFE_BUTTERFLY(515, canShoot = false),
	KNIFE_PUSH(516, canShoot = false),
	FISTS(69, canShoot = false),
	MEDISHOT(57, canShoot = false),
	TABLET(72, canShoot = false),
	DIVERSION_DEVICE(82, canShoot = false),
	FIRE_BOMB(81, canShoot = false),
	CHARGE(70, canShoot = false),
	HAMMER(76, canShoot = false);
	
	companion object {
		
		private val cachedValues = values()
		
		@JvmStatic
		fun byID(id: Int) = cachedValues.firstOrNull { it.id == id }
		
	}
	
}