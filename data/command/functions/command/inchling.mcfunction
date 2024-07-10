power remove @s scorch:scorch
power grant @s extraorigins:bite_sized
execute at @s run playsound minecraft:block.anvil.fall player @a[distance=..10] ~ ~ ~ 1 0
particle minecraft:composter ~ ~ ~ 1 1 1 1 200 force
resource set @s command:warrior/switcher_mode_resource 3