power grant @a[distance=..256] server:unbreakablel/getorigin
origin set @a[distance=..256] origins:origin hideandseek:hider
execute as @r[distance=..256] run function hideandseek:hunter
effect give @s xaerominimap:no_minimap infinite
effect give @s xaeroworldmap:no_world_map infinite
tp @a[distance=..20] 1521 64 -8728
spawnpoint @a[distance=..256] 1521 64 -8728
team join Hiding @s
summon armor_stand 1521 76.00 -8663 {Tags:["hideandseek_armorstand"]}
power grant @e[tag=hideandseek_armorstand] hideandseek:armor_stand