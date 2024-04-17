power grant @a[distance=..200] server:unbreakablel/getorigin
origin set @a[distance=..200] origins:origin hideandseek:hider
execute as @r[distance=..256] run function hideandseek:hunter
effect give @s xaerominimap:no_minimap infinite
effect give @s xaeroworldmap:no_world_map infinite
tp @a[distance=..20] 1521 64 -8728
spawnpoint @a[distance=..200] 1521 64 -8728
team join Hiding @s