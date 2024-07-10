power remove @s extraorigins:bite_sized
power grant @s ashley:moves/double_edge
execute at @s run playsound minecraft:entity.player.attack.crit player @a[distance=..10] ~ ~ ~ 1 0
particle dust_color_transition 0.957 0.357 0.180 2 1.000 0.984 1.000 ~ ~ ~ 1 1 1 1 100 force
resource set @s command:warrior/switcher_mode_resource 0